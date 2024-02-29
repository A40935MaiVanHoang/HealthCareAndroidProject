package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name: Nguyen Van A","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","600"}
,                   {"Doctor Name: Nguyen Van B","Hospital Address:Benh Vien Da Lieu Ha Noi","Exp: 7 nam","Mobile NO: 0868193244","900"},
                    {"Doctor Name: Nguyen Van C","Hospital Address:Dai Hoc y Ha Noi","Exp: 6 nam","Mobile NO: 0868193244","300"},
                    {"Doctor Name: Nguyen Van D","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","500"},
                    {"Doctor Name: Nguyen Van E","Hospital Address:Benh Vien Thai Binh","Exp: 4 nam","Mobile NO: 0868193244","800"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name: Nguyen Van A","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","600"}
                    ,                   {"Doctor Name: Nguyen Van B","Hospital Address:Benh Vien Da Lieu Ha Noi","Exp: 7 nam","Mobile NO: 0868193244","900"},
                    {"Doctor Name: Nguyen Van C","Hospital Address:Dai Hoc y Ha Noi","Exp: 6 nam","Mobile NO: 0868193244","300"},
                    {"Doctor Name: Nguyen Van D","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","500"},
                    {"Doctor Name: Nguyen Van E","Hospital Address:Benh Vien Thai Binh","Exp: 4 nam","Mobile NO: 0868193244","800"},
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name: Nguyen Van A","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","600"}
                    ,                   {"Doctor Name: Nguyen Van B","Hospital Address:Benh Vien Da Lieu Ha Noi","Exp: 7 nam","Mobile NO: 0868193244","900"},
                    {"Doctor Name: Nguyen Van C","Hospital Address:Dai Hoc y Ha Noi","Exp: 6 nam","Mobile NO: 0868193244","300"},
                    {"Doctor Name: Nguyen Van D","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","500"},
                    {"Doctor Name: Nguyen Van E","Hospital Address:Benh Vien Thai Binh","Exp: 4 nam","Mobile NO: 0868193244","800"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name: Nguyen Van A","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","600"}
                    ,                   {"Doctor Name: Nguyen Van B","Hospital Address:Benh Vien Da Lieu Ha Noi","Exp: 7 nam","Mobile NO: 0868193244","900"},
                    {"Doctor Name: Nguyen Van C","Hospital Address:Dai Hoc y Ha Noi","Exp: 6 nam","Mobile NO: 0868193244","300"},
                    {"Doctor Name: Nguyen Van D","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","500"},
                    {"Doctor Name: Nguyen Van E","Hospital Address:Benh Vien Thai Binh","Exp: 4 nam","Mobile NO: 0868193244","800"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name: Nguyen Van A","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","600"}
                    ,                   {"Doctor Name: Nguyen Van B","Hospital Address:Benh Vien Da Lieu Ha Noi","Exp: 7 nam","Mobile NO: 0868193244","900"},
                    {"Doctor Name: Nguyen Van C","Hospital Address:Dai Hoc y Ha Noi","Exp: 6 nam","Mobile NO: 0868193244","300"},
                    {"Doctor Name: Nguyen Van D","Hospital Address:Dai Hoc y Ha Noi","Exp: 5 nam","Mobile NO: 0868193244","500"},
                    {"Doctor Name: Nguyen Van E","Hospital Address:Benh Vien Thai Binh","Exp: 4 nam","Mobile NO: 0868193244","800"},
            };
    TextView tv;
    Button btn;

    String[][] doctor_details = {};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.BuyMDetailTitle);
        btn = findViewById(R.id.buttonbuyMDetailBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0) {
            doctor_details = doctor_details1;
        }
        else
        if(title.compareTo("Dietician")==0) {
            doctor_details = doctor_details2;
        }
        else
        if(title.compareTo("Dentist")==0) {
            doctor_details = doctor_details3;
        }
        else
        if(title.compareTo("Surgeon")==0) {
            doctor_details = doctor_details4;
        }
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0; i < doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.TextforDetailsMedicine);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[position][0]);
                it.putExtra("text3",doctor_details[position][1]);
                it.putExtra("text4",doctor_details[position][3]);
                it.putExtra("text5",doctor_details[position][4]);

                startActivity(it);

            }
        });
    }
}