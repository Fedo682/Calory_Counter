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


import java.util.ArrayList;
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

            // Creating recipes
            Recipe recipe1 = new Recipe("Pizza", R.drawable.pizza, 10, 20, 30, List.of("Pepperoni", "Cheese", "Dough", "Tomato"));
            Recipe recipe2 = new Recipe("Burger", R.drawable.burger, 30, 20, 20, List.of("Beef", "Cheese", "Potato Buns", "Pickles"));
            Recipe recipe3 = new Recipe("Salad", R.drawable.salad, 35, 5, 15, List.of("Tomato", "Onions", "Lettuce", "Chicken Strips", "Cucumber"));
            List<Recipe> recipeList = List.of(recipe1, recipe2, recipe3);

            RecyclerView recyclerView = findViewById(R.id.recycler);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

            CaloryReviewAdapter adapter = new CaloryReviewAdapter(recipeList);
            recyclerView.setAdapter(adapter);

            // Set the click listener on the adapter
            adapter.setOnItemClickListener(position -> {
                Recipe recipe = recipeList.get(position);

                // Send all the necessary data to the calculate_calories activity
                Intent intent = new Intent(MainActivity.this, calculate_calories.class);
                intent.putExtra("Name", recipe.getName());
                intent.putExtra("image", recipe.getImageResource());
                intent.putExtra("protein", recipe.getProtein());
                intent.putExtra("fat", recipe.getFat());
                intent.putExtra("carbohydrates", recipe.getCarbohydrates());
                intent.putStringArrayListExtra("ingredients", new ArrayList<>(recipe.getIngredients()));

                startActivity(intent);
            });

            return insets;
        });
    }
}
