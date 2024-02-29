package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyMedicineDetailActivity extends AppCompatActivity {

    TextView tvPackageName,tvTotalCost;
    EditText edDetails;
    Button btnBack,btnAddtoCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_detail);

        tvPackageName = findViewById(R.id.textViewLapTestPackageName);
        edDetails = findViewById(R.id.TextforDetailsMedicine);
        edDetails.setKeyListener(null);
        tvTotalCost = findViewById(R.id.TotalCost_MDetail);

        btnBack = findViewById(R.id.buttonbuyMDetailBack);
        btnAddtoCart = findViewById(R.id.buttonBuyMDetail);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost: "+intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineDetailActivity.this,BuyMedicineActivity.class));
            }
        });

        btnAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Toast.makeText(getApplicationContext(),"Đơn thuốc đã được ghi lại",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicineDetailActivity.this,BuyMedicineActivity.class));
            }
        });

    }
}