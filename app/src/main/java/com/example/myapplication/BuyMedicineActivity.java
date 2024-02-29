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

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Panadol (acetaminophen)","","","","10"},
                    {"PAmoxicillin (kháng sinh)","","","","10"},
                    {"Omeprazole (thuốc ức chế bơm proton)","","","","10"},
                    {"Losartan (thuốc chẹn beta)","","","","10"},
                    {"Metformin (thuốc trị đái tháo đường)","","","","10"},
                    {"Simvastatin (statin)","","","","10"},

            };
    private String[] package_details = {
            "Có thể dùng để điều trị các triệu chứng đau đầu, đau nhức cơ bắp, đau bụng kinh, sốt...\n"+
            "Dùng để điều trị các bệnh như viêm phổi, viêm xoang, viêm tai giữa, nhiễm trùng đường tiết niệu...\n"+
            "Giảm tiết axit dạ dày, điều trị trào ngược axit, loét dạ dày, tá tràng.\n"+
            "Giúp hạ huyết áp hiệu quả, thường dùng cho bệnh nhân cao huyết áp.\n"+
            "Giúp kiểm soát lượng đường trong máu ở bệnh nhân đái tháo đường type 2.\n"+
            "Giảm cholesterol xấu (LDL), giúp dự phòng các bệnh tim mạch.\n"+
            "Giảm triệu chứng dị ứng như hắt hơi, chảy nước mũi, ngứa mắt, ngứa da..."
    };
    HashMap <String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGotoCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        lst = findViewById(R.id.TextforDetailsMedicine);
        btnBack = findViewById(R.id.buttonbuyMDetailBack);
        btnGotoCart = findViewById(R.id.buttonBuyMDetail);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0; i < packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailActivity.class);
                it.putExtra("text1",packages[position][0]);
                it.putExtra("text1",package_details[position]);
                it.putExtra("text1",packages[position][4]);
                startActivity(it);
            }
        });

    }
}