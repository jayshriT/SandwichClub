package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String NAME = "name";
    public static final String MAIN_NAME = "mainName";
    public static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "image";
    public static final String ALSO_KNOWN_AS = "alsoKnownAs";
    public static final String INGREDIENTS = "ingredients";



    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject nameJsonObject = jsonObject.getJSONObject(NAME);
            String mainName = nameJsonObject.getString(MAIN_NAME);
            JSONArray alsoKnownAsArray = nameJsonObject.getJSONArray(ALSO_KNOWN_AS);
            String placeOfOrigin = jsonObject.getString(PLACE_OF_ORIGIN);
            String description = jsonObject.getString(DESCRIPTION);
            String image = jsonObject.getString(IMAGE);
            JSONArray ingredientsArray = jsonObject.getJSONArray(INGREDIENTS);
            List<String> alsoKnownAs= new ArrayList<>();
            List<String> ingredients = new ArrayList<>();
            for(int i=0;i<alsoKnownAsArray.length();i++){
                alsoKnownAs.add(alsoKnownAsArray.getString(i));
            }
            for(int i=0;i<ingredientsArray.length();i++){
                ingredients.add(ingredientsArray.getString(i));
            }

            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setDescription(description);
            sandwich.setImage(image);
            sandwich.setIngredients(ingredients);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setMainName(mainName);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }


}
