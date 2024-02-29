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

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView a40935,tvTotalCost;
    EditText maivanhoang;
    Button btnAddtoCart,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        a40935 = findViewById(R.id.textViewLapTestPackageName);
        tvTotalCost = findViewById(R.id.TotalCost_MDetail);
        maivanhoang = findViewById(R.id.TextforDetailsMedicine);
        btnAddtoCart=findViewById(R.id.buttonBuyMDetail);
        btnBack = findViewById(R.id.buttonbuyMDetailBack);

        maivanhoang.setKeyListener(null);
        Intent it = getIntent();
        a40935.setText(it.getStringExtra("text1"));
        maivanhoang.setText(it.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost:"+it.getStringExtra("text3") + "/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }
        });

        btnAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = a40935.getText().toString();
                float price = Float.parseFloat(it.getStringExtra("text3").toString());

//                Database db = new Database(getApplicationContext(),"healthcare",null,1);
//                if(db.checkCard(username,product)==1){
//                    Toast.makeText(getApplicationContext(),"Product Already Added",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    db.addCard(username,product,price,"lab");
//                    Toast.makeText(getApplicationContext(),"Bản ghi đã được thêm vào Giỏ ",Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
//                }
                Toast.makeText(getApplicationContext(),"Bản ghi đã được thêm vào Giỏ ",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }
        });

    }
}