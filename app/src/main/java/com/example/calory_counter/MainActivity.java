package com.example.calory_counter;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainpage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            Recipe   recipe1 = new Recipe("Pizza", R.drawable.pizza, 10, 20, 30 , List.of("Pepperoni","Cheese", "Dough","Tomato"));
            Recipe recipe2 = new Recipe("Burger", R.drawable.burger, 30, 20, 20,List.of("BEEF","Cheese", "Potato Buns","BEEF","Pickles"));
           Recipe recipe3 = new Recipe("Salad", R.drawable.salad, 35, 5, 15,List.of("Tomato","Onions", "Lettuce","Chicken Strips","Cucumber"));
            List<Recipe> RecipeList = List.of(recipe1, recipe2,recipe3);


            RecyclerView RV = findViewById(R.id.recycler);
            RV.setLayoutManager(new GridLayoutManager(this,2));
            CaloryReviewAdapter adapter = new CaloryReviewAdapter(RecipeList);
            RV.setAdapter(adapter);






            adapter.set(( i ) -> {


                Recipe recipe = RecipeList.get(i);

                String name = recipe.getName();
                int image = recipe.getImageResource();
                int protein = recipe.getProtein();
                int fat = recipe.getFat();
                int carbohydrates = recipe.getCarbohydrates();


                Intent intent = new Intent(MainActivity.this, calculate_calories.class);

                intent.putExtra("Name",name);
                intent.putExtra("protein",protein);
                intent.putExtra("fat",fat);
                intent.putExtra("carbohydrates",carbohydrates);
                intent.putExtra("image",image);

                startActivity(intent);
                finish();
            });



            return insets;



        });


    }
}