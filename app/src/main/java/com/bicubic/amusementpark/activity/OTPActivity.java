package com.bicubic.amusementpark.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bicubic.amusementpark.R;

public class OTPActivity extends AppCompatActivity implements View.OnClickListener{

    View bt_submit;
    EditText et_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        et_otp = (EditText) findViewById(R.id.et_otp);
        bt_submit = findViewById(R.id.bt_submit);
        MaterialRippleLayout.on(bt_submit)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        bt_submit.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.bt_submit){

            if (!TextUtils.isEmpty(et_otp.getText().toString())) {
                startActivity(new Intent(this,MainActivity.class));
            }else {
                et_otp.setError("OTP ?");
            }
        }

    }

}
