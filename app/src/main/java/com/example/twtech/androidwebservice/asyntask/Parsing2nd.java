package com.example.twtech.androidwebservice.asyntask;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parsing2nd {




    public static String[] ids;
    public static String[] names;
    public static String[] mobile;
    public static String[] home;

    public static final String JSON_ARRAY = "contacts";

    public static final String JSON_ARRAY2 = "phone";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "phone";
  /*  public static final String KEY_EMAIL = "feedback";
    public static final String KEY_RATING = "rating";*/

    private JSONArray users = null;

    private String json;

    public Parsing2nd(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            ids = new String[users.length()];
            names = new String[users.length()];
           /* emails = new String[users.length()];
            ratings = new String[users.length()];*/

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);
                Log.e("DATA",ids[i]);
                Log.e("DATA2",names[i]);


                //  parseJSON2(names[i]);

               /* emails[i] = jo.getString(KEY_EMAIL);
                ratings[i] = jo.getString(KEY_RATING);*/

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
