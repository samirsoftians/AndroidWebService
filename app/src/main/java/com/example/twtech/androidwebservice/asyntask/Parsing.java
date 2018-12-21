package com.example.twtech.androidwebservice.asyntask;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parsing {

    JSONObject jsonObject2=null;
    RequestQueue requestQueue;


    public static String[] ids;
    public static String[] names;
    public static String[] mobiles;
    public static String[] home;

    public static final String JSON_ARRAY = "contacts";

    public static final String JSON_ARRAY2 = "phone";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "phone";
  /*  public static final String KEY_EMAIL = "feedback";
    public static final String KEY_RATING = "rating";*/

    private JSONArray users = null;
    private JSONArray users2 = null;

    private String json;



    public Parsing(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        JSONObject jsonObject2=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            names = new String[users.length()];
            mobiles = new String[users.length()];
           /* emails = new String[users.length()];
            ratings = new String[users.length()];*/

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);


                Log.e("DATA",ids[i]);
                Log.e("DATA2",names[i]);












            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("excep", String.valueOf(e));
        }
    }

//********************************************************************

    protected void parseJSON2(String m){
        JSONObject jsonObject2=null;
        try {
            jsonObject2 = new JSONObject(m);
            users2 = jsonObject2.getJSONArray("");

Log.e("u", String.valueOf(users2));
            mobiles = new String[users.length()];


            for(int i=0;i<users2.length();i++){
                JSONObject jo = users.getJSONObject(i);
                mobiles[i] = jo.getString("mobile");
               // names[i] = jo.getString(KEY_NAME);
                Log.e("DATA13",mobiles[i]);













            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
