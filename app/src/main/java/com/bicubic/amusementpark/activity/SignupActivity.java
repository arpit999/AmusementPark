package com.bicubic.amusementpark.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.model.Signup;
import com.bicubic.amusementpark.utils.ApiClient;
import com.bicubic.amusementpark.utils.ApiInterface;
import com.bicubic.amusementpark.utils.ImageFilePath;
import com.mukesh.permissions.AppPermissions;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bicubic.amusementpark.utils.ApiClient.BASE_URL;

/**
 * Created by admin on 21-Nov-16.
 */

public class SignupActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final String TAG = SignupActivity.class.getSimpleName();
    View bt_upload_image, bt_signup;
    EditText et_name, et_mobile, et_email, et_dob;

    private static final int ALL_REQUEST_CODE = 0;

    private static final String[] ALL_PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_CONTACTS
    };
    private static final int READ_STORAGE_CODE = 2;
    private static final String READ_STORAGE_PERMISSION = Manifest.permission.READ_EXTERNAL_STORAGE;

    private AppPermissions mRuntimePermission;
    ApiInterface apiInterface;
    static String realPath = "";
    String IMEI = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences("preference", 0);
//Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);

        if (hasLoggedIn) {
            startActivity(new Intent(SignupActivity.this, MainActivity.class));
            return;
        }
        setContentView(R.layout.signin_activity);
        mRuntimePermission = new AppPermissions(this);
        ToolbarBack();
        FindIDs();

    }

    private void ToolbarBack() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        mTitle.setText("Sign Up");


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void FindIDs() {

        bt_signup = findViewById(R.id.bt_signup);
        bt_upload_image = findViewById(R.id.bt_upload_image);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_dob = (EditText) findViewById(R.id.et_dob);
        et_mobile = (EditText) findViewById(R.id.et_mobile);

        MaterialRippleLayout.on(bt_signup)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        MaterialRippleLayout.on(bt_upload_image)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        bt_upload_image.setOnClickListener(this);
        bt_signup.setOnClickListener(this);
        et_dob.setOnClickListener(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case ALL_REQUEST_CODE:
                List<Integer> permissionResults = new ArrayList<>();
                for (int grantResult : grantResults) {
                    permissionResults.add(grantResult);
                }
                if (permissionResults.contains(PackageManager.PERMISSION_DENIED)) {
                    showPermissionDialog();
                    Toast.makeText(this, "Enable All permission  goto appinfo->permission->enable all permission", Toast.LENGTH_SHORT).show();
                } else {
                    SignupButtonProcess();
                }
                break;

            case READ_STORAGE_CODE:

                List<Integer> permissionResults1 = new ArrayList<>();
                for (int grantResult : grantResults) {
                    permissionResults1.add(grantResult);
                }
                if (permissionResults1.contains(PackageManager.PERMISSION_DENIED)) {
                    showPermissionDialog();
                    Toast.makeText(this, "Enable  permission  goto appinfo->permission->enable all permission", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    // Show only images, no videos or anything else
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    // Always show the chooser (if there are multiple options available)
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                }


                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

          /*  // SDK < API11
            if (Build.VERSION.SDK_INT < 11)
                realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, data.getData());

                // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
                realPath = RealPathUtil.getRealPathFromURI_API11to18(this, data.getData());

                // SDK > 19 (Android 4.4)
            else*/
            realPath = ImageFilePath.getPath(SignupActivity.this,data.getData());
//                realPath = RealPathUtil.getRealPathFromURI_API19(this, data.getData());

            Log.i(TAG, "onActivityResult: file path : " + realPath);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.img_profile);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_upload_image:

                if (mRuntimePermission.hasPermission(READ_STORAGE_PERMISSION)) {
                    Intent intent = new Intent();
                    // Show only images, no videos or anything else
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    // Always show the chooser (if there are multiple options available)
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                } else {
                    mRuntimePermission.requestPermission(READ_STORAGE_PERMISSION, READ_STORAGE_CODE);
                }

                break;

            case R.id.bt_signup:

                if (mRuntimePermission.hasPermission(ALL_PERMISSIONS)) {

                    SignupButtonProcess();

                   /* Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                    while (phones.moveToNext()) {
                        String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        Toast.makeText(getApplicationContext(),name, Toast.LENGTH_LONG).show();
                        Log.i(TAG, "onClick: name : " + name);
                        Log.i(TAG, "onClick: number : " + phoneNumber);
                    }
                    phones.close();*/

                } else {
                    mRuntimePermission.requestPermission(ALL_PERMISSIONS, ALL_REQUEST_CODE);
                }

                break;

            case R.id.et_dob:

                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        SignupActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.isThemeDark();
                dpd.setAccentColor(Color.parseColor("#23AED0"));
                dpd.show(getFragmentManager(), "Datepickerdialog");

                Toast.makeText(this, "date picker", Toast.LENGTH_SHORT).show();

                break;
            default:

                break;
        }

    }


    public void SignupButtonProcess() {

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        IMEI = telephonyManager.getDeviceId();
        IMEI = "88199667785338";

        if (TextUtils.isEmpty(et_name.getText().toString())) {
            et_name.setError("name?");
        } else if (TextUtils.isEmpty(et_email.getText().toString())) {
            et_email.setError("Enter valid email");
        } else if (!isValidMail(et_email.getText().toString())) {
            et_email.setError("Enter valid email");
        } else if (TextUtils.isEmpty(et_dob.getText().toString())) {
            et_dob.setError("Date of birth");
        } else if (TextUtils.isEmpty(et_mobile.getText().toString())) {
            et_mobile.setError("Enter mobile no");
        } else if (et_mobile.getText().toString().length() != 10) {
            et_mobile.setError("Enter 10 digit mobile no");
        } else if (TextUtils.isEmpty(IMEI)) {
            Toast.makeText(this, "IMEI number missing", Toast.LENGTH_SHORT).show();
        } else {

            if (realPath.equals("")) {
                SignupWithText();
            } else {
                SignupWithImage();
            }

        }

    }

    public void SignupWithText() {

//        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        IMEI = telephonyManager.getDeviceId();

        Call<Signup> responseCall = apiInterface.SignupWithText(et_name.getText().toString(), et_email.getText().toString(), et_dob.getText().toString(), et_mobile.getText().toString(), IMEI);

        responseCall.enqueue(new Callback<Signup>() {
            @Override
            public void onResponse(Call<Signup> call, Response<Signup> response) {

                Signup s = response.body();
                Log.i(TAG, "onResponse: message :" + s.getMessage());

                Log.i(TAG, "onResponse: " + response.body().toString());

                if (s.getMessage().equals("success")) {

                    SharedPreferences settings = getSharedPreferences("preference", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("name", s.getData().getName());
                    editor.putString("userid", s.getData().getId());
                    editor.putBoolean("hasLoggedIn", true);
                    editor.apply();

                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(SignupActivity.this, "" + s.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Signup> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());

            }
        });


    }


    public class SignupWithImageTask extends AsyncTask<String, Integer, String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(SignupActivity.this);
            progressDialog.setMessage("Please Wait....");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... str) {

            String res = null;
            try {
//                String ImagePath = str[0];
                String name = str[0], email = str[1], dob = str[2], IMEI = str[3], phone = str[4], ImagePath = str[5];

                File sourceFile = new File(ImagePath);

                Log.d("TAG", "File...::::" + sourceFile + " : " + sourceFile.exists());

                final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*");

                String filename = ImagePath.substring(ImagePath.lastIndexOf("/") + 1);

                /**
                 * OKHTTP2
                 */
//            RequestBody requestBody = new MultipartBuilder()
//                    .type(MultipartBuilder.FORM)
//                    .addFormDataPart("member_id", memberId)
//                    .addFormDataPart("file", "profile.png", RequestBody.create(MEDIA_TYPE_PNG, sourceFile))
//                    .build();

                /**
                 * OKHTTP3
                 */
                RequestBody requestBody = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("image", filename, RequestBody.create(MEDIA_TYPE_PNG, sourceFile))
                        .addFormDataPart("result", "my_image")
                        .addFormDataPart("name", name)
                        .addFormDataPart("email", email)
                        .addFormDataPart("dob", dob)
                        .addFormDataPart("IMEI", IMEI)
                        .addFormDataPart("phone", phone)
                        .build();

                Request request = new Request.Builder()
                        .url(BASE_URL + "signup")
                        .post(requestBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                okhttp3.Response response = client.newCall(request).execute();
                res = response.body().string();
                Log.e("TAG", "Response : " + res);
                return res;

            } catch (UnknownHostException | UnsupportedEncodingException e) {
                Log.e("TAG", "Error: " + e.getLocalizedMessage());
            } catch (Exception e) {
                Log.e("TAG", "Other Error: " + e.getLocalizedMessage());
            }


            return res;

        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            if (progressDialog != null)
                progressDialog.dismiss();

            if (response!=null) {
                try {

                    JSONObject jsonObject = new JSONObject(response);


                    if (jsonObject.getString("message").equals("success")) {

                        JSONObject jsonObject1 =jsonObject.getJSONObject("data");

                        SharedPreferences settings = getSharedPreferences("preference", 0); // 0 - for private mode
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("name", jsonObject1.getString("name"));
                        editor.putString("userid", jsonObject1.getString("id"));
                        editor.putBoolean("hasLoggedIn", true);
                        editor.apply();

                        startActivity(new Intent(SignupActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(SignupActivity.this, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(SignupActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void SignupWithImage() {

        if (!realPath.equals("")) {

            new SignupWithImageTask().execute(et_name.getText().toString(), et_email.getText().toString(), et_dob.getText().toString(), IMEI, et_mobile.getText().toString(), realPath);

        } else {
            Toast.makeText(this, "Profile Picture not found", Toast.LENGTH_SHORT).show();
        }


    }


    private void showPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.permission_message));

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        et_dob.setText(dayOfMonth + "/" + monthOfYear + "/" + year);

    }

    private boolean isValidMail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidMobile(String phone2) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", et_mobile.getText().toString())) {
            if (phone2.length() != 10) {
                check = false;
                et_mobile.setError("Not Valid Number");
            } else {
                check = true;
            }
        } else {
            check = false;
        }
        return check;
    }


}
