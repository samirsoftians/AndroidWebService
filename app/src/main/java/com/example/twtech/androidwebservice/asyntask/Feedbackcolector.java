package com.example.twtech.androidwebservice.asyntask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.twtech.androidwebservice.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Feedbackcolector extends AppCompatActivity{

String url="https://api.androidhive.info/contacts";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley);


        volley();
    }






    public void volley()
    {
        StringRequest stringRequest = new StringRequest(url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {


                showJSON(response);
              //  Log.e("Response",response);
               // showJSON(response);

            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                        if (error instanceof NetworkError)
                        {
                            Toast.makeText(Feedbackcolector.this,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof ServerError)
                        {
                            Toast.makeText(Feedbackcolector.this,"The server could not be found. Please try again after some time!!",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof AuthFailureError)
                        {
                            Toast.makeText(Feedbackcolector.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof ParseError)
                        {
                            Toast.makeText(Feedbackcolector.this,"Parsing error! Please try again after some time !!",Toast.LENGTH_LONG ).show();

                        }
                        else if (error instanceof NoConnectionError)
                        {
                            Toast.makeText(Feedbackcolector.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof TimeoutError)
                        {
                            Toast.makeText(Feedbackcolector.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }




                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        //**************************************
    }


    private void showJSON(String json){




///home/twtech/Mytest/.git/

        try {
            JSONObject jsonObj = new JSONObject(json);

            // Getting JSON Array node
            JSONArray contacts = jsonObj.getJSONArray("contacts");

            // looping through All Contacts
            for (int i = 0; i < contacts.length(); i++) {


                JSONObject c = contacts.getJSONObject(i);
                String id = c.getString("id");
                String name = c.getString("name");
                String email = c.getString("email");
                String address = c.getString("address");
                String gender = c.getString("gender");

                Log.e("DATA",id + name +email );

                JSONObject phone = c.getJSONObject("phone");
                String mobile = phone.getString("mobile");
                String home = phone.getString("home");
                String office = phone.getString("office");
                Log.e("Complex",mobile +"-"+home);


            }
        } catch (final JSONException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),
                            "Json parsing error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            });

        }














       /* Parsing pj = new Parsing(json);
        pj.parseJSON();*/
        //Toast.makeText(this, ParseJSON.names, Toast.LENGTH_SHORT).show();
        /*CustomList cl = new CustomList(this, ParseJSON.ids,ParseJSON.names,ParseJSON.emails,ParseJSON.ratings);
        listView.setAdapter(cl);
*/

    }


    public void parsing()
    {

    }

}
