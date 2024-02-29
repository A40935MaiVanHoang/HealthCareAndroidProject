package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Pakage 1: Khám Toàn Thân","","","","999"},
                    {"Pakage 2: Kiểm tra Đường Huyết","","","","299"},
                    {"Pakage 3: Test Covid-19","","","","899"},
                    {"Pakage 4: Khám Nội Khoa","","","","499"},
                    {"Pakage 5: Khám Ngoại Khoa","","","","699"},
            };

    private String[] package_details = {
            "Lượng đường trong máu \n"+
                    "Hoàn thành Hemogan\n"+
                    "HbA1c\n"+
                    "Iron Studies\n"+
                    "Kidney Funtion Test\n"+
                    "LDH Lactate Dehydrogenase,Serum\n"+
                    "Thông tin lượng mỡ thừa\n"+
                    "Liver Function Test",
            "Blood Glucose Fasting",
            "Covid-19",
            "Thyroid Profile-Total(T3,T4 & TSH Ultra-sensitive)",
            "Complete hemogram\n"+
                    "CRP (C Reactive Protein) Quantitative,Serum \n"+
                    "Iron Stuies\n"+
                    "Kidney Function Test\n"+
                    "Vitamin D Total-25 Hydroxy\n"+
                    "Liver Funtion Test\n"+
                    "Lipid Profile"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    Button btnGoToCart,btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonBuyMDetail);
        btnBack = findViewById(R.id.buttonbuyMDetailBack);
        listView = findViewById(R.id.TextforDetailsMedicine);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0; i < packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[position][0]);
                it.putExtra("text2",package_details[position]);
                it.putExtra("text3",packages[position][4]);
                startActivity(it);
            }
        });


    }
}