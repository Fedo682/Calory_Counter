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

            // Image
            ImageView imageView = findViewById(R.id.Counter_img);
            int imgRes = intent2.getIntExtra("image", 0);
            imageView.setImageResource(imgRes);

            // Title
            TextView titleTextView = findViewById(R.id.Counter_Tittleview);
            titleTextView.setText(intent2.getStringExtra("Name"));

            // Calculate total calories
            int protein = intent2.getIntExtra("protein", 0);
            int fat = intent2.getIntExtra("fat", 0);
            int carbohydrates = intent2.getIntExtra("carbohydrates", 0);
            int totalCalories = protein + fat + carbohydrates;

            TextView caloryTextView = findViewById(R.id.Calory_Result);
            caloryTextView.setText("Total Calories: " + totalCalories);

            // Display protein, fat, and carbohydrates in the ListView
            List<String> nutritionList = List.of("Protein: " + protein, "Fat: " + fat, "Carbohydrates: " + carbohydrates);
            ListView listView = findViewById(R.id.listView_Counter);
            listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nutritionList));

            // Display the ingredients if needed
            List<String> ingredients = intent2.getStringArrayListExtra("ingredients");
            if (ingredients != null) {
                TextView descriptionTextView = findViewById(R.id.Discreption_counter);
                descriptionTextView.setText("Ingredients: " + String.join(", ", ingredients));
            }

            // Back button functionality
            Button backButton = findViewById(R.id.Back_button_Counter);
            backButton.setOnClickListener(v1 -> finish());

            return insets;
        });
    }
}
