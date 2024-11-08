package com.example.calory_counter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private List <String> ingredients;
    private String name;
    private int imageResource;
    // 4 calories per 1 gram of protein
    private int protein;
    // 9 calories per 1 gram of fat
    private int fat;
    // 4 calories per 1 gram of carbohydrate
    private int carbohydrates;

    private int calories;

    public Recipe(String name, int imageResource,int protein, int fat, int carbohydrates, List<String> ingredients) {

        this.name = name;
        this.imageResource = imageResource;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.calories = this.getCalories();
        this.ingredients=ingredients;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setIngredients(ArrayList ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getCalories() {
         calories = protein * 4 + fat * 9 + carbohydrates * 4;
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFat() {
            return fat;
    }

    public int getCarbohydrates() {
            return carbohydrates;
    }

    public int getProtein() {
        return protein;
    }

    public String printingredients (){
        return "the Recipe has  "+ getProtein()+" "+getFat()+" " +getCarbohydrates();
    }



    @NonNull
    @Override
    public String toString() {
        return " this \n" +printingredients();
    }
}

