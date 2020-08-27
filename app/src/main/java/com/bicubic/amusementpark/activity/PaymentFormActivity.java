package com.bicubic.amusementpark.activity;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.utils.SharedPreferenceManager;

public class PaymentFormActivity extends AppCompatActivity implements View.OnClickListener {

    View bt_proceed_payment;
    EditText et_name, et_mobile, et_email, et_address, et_city, et_state, et_country, et_pincode;
    TextView tv_subtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_form);

        bt_proceed_payment = findViewById(R.id.bt_proceed_payment);
        et_name = (EditText) findViewById(R.id.et_name);
        et_mobile = (EditText) findViewById(R.id.et_mobile);
        et_email = (EditText) findViewById(R.id.et_email);
        et_address = (EditText) findViewById(R.id.et_address);
        et_city = (EditText) findViewById(R.id.et_city);
        et_state = (EditText) findViewById(R.id.et_state);
        et_country = (EditText) findViewById(R.id.et_country);
        et_pincode = (EditText) findViewById(R.id.et_pincode);

        tv_subtotal = (TextView)findViewById(R.id.tv_subtotal);

        ToolbarBack();

        tv_subtotal.setText(getIntent().getExtras().getString("total","00.00"));

        MaterialRippleLayout.on(bt_proceed_payment)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        et_name.setText(SharedPreferenceManager.getDefaults("name",PaymentFormActivity.this));
        et_mobile.setText(SharedPreferenceManager.getDefaults("mobile",PaymentFormActivity.this));
        et_email.setText(SharedPreferenceManager.getDefaults("email",PaymentFormActivity.this));
        et_address.setText(SharedPreferenceManager.getDefaults("address",PaymentFormActivity.this));
        et_city.setText(SharedPreferenceManager.getDefaults("city",PaymentFormActivity.this));
        et_state.setText(SharedPreferenceManager.getDefaults("state",PaymentFormActivity.this));
        et_country.setText(SharedPreferenceManager.getDefaults("country",PaymentFormActivity.this));
        et_pincode.setText(SharedPreferenceManager.getDefaults("pincode",PaymentFormActivity.this));


        bt_proceed_payment.setOnClickListener(this);
    }

    private void ToolbarBack() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        mTitle.setText("Your Details");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bt_proceed_payment) {

            if (TextUtils.isEmpty(et_name.getText().toString())) {
                et_name.setError("name?");
                et_name.requestFocus();
            } else if (TextUtils.isEmpty(et_mobile.getText().toString())) {
                et_mobile.setError("Enter 10 digit mobile no");
                et_mobile.requestFocus();
            } else if (TextUtils.isEmpty(et_email.getText().toString())) {
                et_email.setError("Enter email");
                et_email.requestFocus();
            } else if (TextUtils.isEmpty(et_address.getText().toString())) {
                et_address.setError("Enter Address");
                et_address.requestFocus();
            } else if (TextUtils.isEmpty(et_city.getText().toString())) {
                et_city.setError("Enter City");
                et_city.requestFocus();
            } else if (TextUtils.isEmpty(et_state.getText().toString())) {
                et_state.setError("Enter state");
                et_state.requestFocus();
            } else if (TextUtils.isEmpty(et_pincode.getText().toString())) {
                et_pincode.setError("Enter pincode");
                et_pincode.requestFocus();
            } else {

                SharedPreferenceManager.setDefaults("name",et_name.getText().toString(),PaymentFormActivity.this);
                SharedPreferenceManager.setDefaults("mobile",et_mobile.getText().toString(),PaymentFormActivity.this);
                SharedPreferenceManager.setDefaults("email",et_email.getText().toString(),PaymentFormActivity.this);
                SharedPreferenceManager.setDefaults("address",et_address.getText().toString(),PaymentFormActivity.this);
                SharedPreferenceManager.setDefaults("city",et_city.getText().toString(),PaymentFormActivity.this);
                SharedPreferenceManager.setDefaults("state",et_state.getText().toString(),PaymentFormActivity.this);
                SharedPreferenceManager.setDefaults("pincode",et_pincode.getText().toString(),PaymentFormActivity.this);
                SharedPreferenceManager.setDefaults("country",et_country.getText().toString(),PaymentFormActivity.this);

                Toast.makeText(this, "Payment Process", Toast.LENGTH_SHORT).show();
            }

        }

    }


}
