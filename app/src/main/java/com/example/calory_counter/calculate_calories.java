package com.example.calory_counter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class calculate_calories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate_calories);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Intent intent2 = getIntent();

            //img
            ImageView imageView = findViewById(R.id.Counter_img);
            int imgsrs=intent2.getIntExtra("image",0);
            imageView.setImageResource(imgsrs);
            //tittle
            TextView TittleTextView = findViewById(R.id.Counter_Tittleview);
            TittleTextView.setText(intent2.getStringExtra("Name"));
            //calory Result
            TextView CaloryTextView = findViewById(R.id.Calory_Result);
            CaloryTextView.setText(intent2.getIntExtra("protein",0)+intent2.getIntExtra("fat",0)+intent2.getIntExtra("carbohydrates",0));


            int protein=intent2.getIntExtra("protein",0);
            int fat=intent2.getIntExtra("fat",0);
            int carbohydrates=intent2.getIntExtra("carbohydrates",0);

            List<String >Strlist =  List.of(protein+"",fat+"",carbohydrates+"");
            ListView LV = findViewById(R.id.listView_Counter);
            LV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,Strlist));

            TextView DiscreptionTextView = findViewById(R.id.Discreption_counter);



            Button BackButton = findViewById(R.id.Back_button_Counter);
            BackButton.setOnClickListener(v1 -> {
                finish();
            });


            return insets;
        });
    }
}