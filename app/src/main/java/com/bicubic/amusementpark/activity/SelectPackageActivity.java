package com.bicubic.amusementpark.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bicubic.amusementpark.R;

public class SelectPackageActivity extends AppCompatActivity implements View.OnClickListener {

    View bt_continue_ticket, bt_continue_package, bt_ticket, bt_package;
    RelativeLayout rel_ticket, rel_package;
    ScrollView scr_ticket, scr_package;
    Spinner spin_ticket_child, spin_ticket_adult, spin_package_child, spin_package_adult;
    TextView tv_ticket_subtotal, tv_package_subtotal;
    int Subtotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_package);

        scr_ticket = (ScrollView) findViewById(R.id.scroll_ticket);
        scr_package = (ScrollView) findViewById(R.id.scroll_package);
        rel_ticket = (RelativeLayout) findViewById(R.id.rel_ticket);
        rel_package = (RelativeLayout) findViewById(R.id.rel_package);
        bt_continue_ticket = findViewById(R.id.bt_continue_ticket);
        bt_continue_package = findViewById(R.id.bt_continue_package);

        spin_ticket_child = (Spinner) findViewById(R.id.spin_ticket_child);
        spin_ticket_adult = (Spinner) findViewById(R.id.spin_ticket_adult);

        spin_package_child = (Spinner) findViewById(R.id.spin_package_child);
        spin_package_adult = (Spinner) findViewById(R.id.spin_package_adult);

        tv_ticket_subtotal = (TextView) findViewById(R.id.tv_ticket_subtotal);
        tv_package_subtotal = (TextView) findViewById(R.id.tv_package_subtotal);

        bt_ticket = findViewById(R.id.bt_ticket);
        bt_package = findViewById(R.id.bt_package);

        ToolbarBack();

        rel_package.setBackgroundResource(R.color.colorPrimary);
        rel_ticket.setBackgroundResource(R.color.colorAccent);
        scr_ticket.setVisibility(View.VISIBLE);
        scr_package.setVisibility(View.GONE);

        MaterialRippleLayout.on(bt_continue_ticket)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        MaterialRippleLayout.on(bt_continue_package)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        MaterialRippleLayout.on(bt_ticket)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        MaterialRippleLayout.on(bt_package)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        bt_ticket.setOnClickListener(this);
        bt_package.setOnClickListener(this);
        bt_continue_package.setOnClickListener(this);
        bt_continue_ticket.setOnClickListener(this);


        spin_ticket_child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                /*String selecteditem = parent.getItemAtPosition(position).toString();
                Subtotal = Subtotal + Integer.parseInt(selecteditem) * 250;
                tv_ticket_subtotal.setText("Subtotal : " + String.valueOf(Subtotal));
                tv_package_subtotal.setText("Subtotal : " + String.valueOf(Subtotal));*/

                getSubtotal();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spin_ticket_adult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               /* String selecteditem = parent.getItemAtPosition(position).toString();
                Subtotal = Subtotal + Integer.parseInt(selecteditem) * 350;
                tv_ticket_subtotal.setText("Subtotal : " + String.valueOf(Subtotal));
                tv_package_subtotal.setText("Subtotal : " + String.valueOf(Subtotal));*/

                getSubtotal();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin_package_child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               /* String selecteditem = parent.getItemAtPosition(position).toString();
                Subtotal = Subtotal + Integer.parseInt(selecteditem) * 350;
                tv_ticket_subtotal.setText("Subtotal : " + String.valueOf(Subtotal));
                tv_package_subtotal.setText("Subtotal : " + String.valueOf(Subtotal));*/

                getSubtotal();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spin_package_adult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                /*String selecteditem = parent.getItemAtPosition(position).toString();
                Subtotal = Subtotal + Integer.parseInt(selecteditem) * 450;
                tv_ticket_subtotal.setText("Subtotal : " + String.valueOf(Subtotal));
                tv_package_subtotal.setText("Subtotal : " + String.valueOf(Subtotal));*/

                getSubtotal();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void getSubtotal() {

        Subtotal = 0;
        int Qty1 = Integer.parseInt(spin_ticket_child.getSelectedItem().toString());
        int Qty2 = Integer.parseInt(spin_ticket_adult.getSelectedItem().toString());
        int Qty3 = Integer.parseInt(spin_package_child.getSelectedItem().toString());
        int Qty4 = Integer.parseInt(spin_package_adult.getSelectedItem().toString());

        Subtotal = Subtotal + (Qty1 * 250) + (Qty2 * 350) + (Qty3 * 350) + (Qty4 * 450);

        tv_package_subtotal.setText("Subtotal : "+Subtotal+".00");
        tv_ticket_subtotal.setText("Subtotal : "+Subtotal+".00");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_continue_package:

                Intent intent1 = new Intent(SelectPackageActivity.this, PaymentFormActivity.class);
                intent1.putExtra("total", String.valueOf(Subtotal));
                startActivity(intent1);

                break;

            case R.id.bt_continue_ticket:

                Intent intent = new Intent(SelectPackageActivity.this, PaymentFormActivity.class);
                intent.putExtra("total", String.valueOf(Subtotal));
                startActivity(intent);

                break;

            case R.id.bt_ticket:

                rel_package.setBackgroundResource(R.color.colorPrimary);
                rel_ticket.setBackgroundResource(R.color.colorAccent);
                scr_ticket.setVisibility(View.VISIBLE);
                scr_package.setVisibility(View.GONE);

                Animation RightSwipe = AnimationUtils.loadAnimation(SelectPackageActivity.this, R.anim.right_side);
                scr_ticket.startAnimation(RightSwipe);

                break;

            case R.id.bt_package:

                rel_package.setBackgroundResource(R.color.colorAccent);
                rel_ticket.setBackgroundResource(R.color.colorPrimary);
                scr_ticket.setVisibility(View.GONE);
                scr_package.setVisibility(View.VISIBLE);

                Animation LeftSide = AnimationUtils.loadAnimation(SelectPackageActivity.this, R.anim.left_side);
                scr_package.startAnimation(LeftSide);

                break;

        }

    }


    private void ToolbarBack() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        mTitle.setText("Book Ticket");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
