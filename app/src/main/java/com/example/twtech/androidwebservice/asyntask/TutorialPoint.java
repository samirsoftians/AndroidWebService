package com.example.twtech.androidwebservice.asyntask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.twtech.androidwebservice.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TutorialPoint extends AppCompatActivity {

    TextView results;
    // URL of object to be parsed
    String JsonURL = "https://api.androidhive.info/contacts";
    // This string will hold the results
    String data = "";
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley);
        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(this);

        // Casts results into the TextView found within the main layout XML with id jsonData
        results = (TextView) findViewById(R.id.jsonData);

        // Creating the JsonArrayRequest class called arrayreq, passing the required parameters
        //JsonURL is the URL to be fetched from
        JsonArrayRequest arrayreq = new JsonArrayRequest(JsonURL,
                // The second parameter Listener overrides the method onResponse() and passes
                //JSONArray as a parameter
                new Response.Listener<JSONArray>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // Retrieves first JSON object in outer array
                            JSONObject colorObj = response.getJSONObject(0);
                            // Retrieves "colorArray" from the JSON object
                            JSONArray colorArry = colorObj.getJSONArray("contacts");
                            // Iterates through the JSON Array getting objects and adding them
                            //to the list view until there are no more objects in colorArray
                            for (int i = 0; i < colorArry.length(); i++) {
                                //gets each JSON object within the JSON array
                                JSONObject jsonObject = colorArry.getJSONObject(i);

                                // Retrieves the string labeled "colorName" and "hexValue",
                                // and converts them into javascript objects
                                String color = jsonObject.getString("name");
                                String hex = jsonObject.getString("email");

                                // Adds strings from the current object to the data string
                                //spacing is included at the end to separate the results from
                                //one another
                                data += "Color Number " + (i + 1) + "nColor Name: " + color +
                                        "nHex Value : " + hex + "nnn";
                            }
                            // Adds the data string to the TextView "results"
                            results.setText(data);
                        }
                        // Try and catch are included to handle any errors due to JSON
                        catch (JSONException e) {
                            // If an error occurs, this prints the error to the log
                            e.printStackTrace();
                        }
                    }
                },
                // The final parameter overrides the method onErrorResponse() and passes VolleyError
                //as a parameter
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        // Adds the JSON array request "arrayreq" to the request queue
        requestQueue.add(arrayreq);
    }
}
