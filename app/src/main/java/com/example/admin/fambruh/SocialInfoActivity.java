package com.example.admin.fambruh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SocialInfoActivity extends AppCompatActivity {

    Button next;
    public final String TAG = "Social Info Activity";
    EditText sc_username,fb_username,ig_username,tt_username,tw_username;
    RequestQueue requestQueue;
    Context context = this;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_info);

        requestQueue = Volley.newRequestQueue(SocialInfoActivity.this);

        next = (Button)findViewById(R.id.next);
        next.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                sc_username = (EditText)findViewById ( R.id.snapchatText );
                fb_username = (EditText)findViewById ( R.id.fbText );
                ig_username = (EditText)findViewById ( R.id.instaText );
                tt_username = (EditText)findViewById ( R.id.tiktoktext );
                tw_username = (EditText)findViewById ( R.id.twitterText );

                Intent intent = getIntent();

                final String name = intent.getStringExtra("name");
                final String username = intent.getStringExtra("username");
                final String mobile = intent.getStringExtra("mobile");
                final String password = intent.getStringExtra("password");
                final String sc =  (sc_username.getText().toString());
                final String fb =  (fb_username.getText().toString());
                final String ig =  (ig_username.getText().toString());
                final String tt =  (tt_username.getText().toString());
                final String tw =  (tw_username.getText().toString());

                registerUser(name, username, mobile, password, sc, fb, ig, tt, tw);
            }
        });
    }

    private void registerUser(final String name, final String username, final String mobile,final String password, final String snapchat_username, final String facebook_username, final String instagram_username, final String tiktok_username, final String twitter_username) {
        Log.d (TAG, "registerUser called");
        HashMap<String, String> params = new HashMap<> ();
        params.put("name", name);
        params.put("uname", username);
        params.put("password", password);
        params.put("mobile",mobile);
        params.put("snapchat_username",snapchat_username);
        params.put("facebook_username",facebook_username);
        params.put("instagram_username",instagram_username);
        params.put("tiktok_username",tiktok_username);
        params.put("twitter_username",twitter_username);

        JsonObjectRequest request_json = new JsonObjectRequest(Constants.registerUrl, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(final JSONObject response) {
                        try {
                            Log.i("qwerty", "onResponse: " + response);
                            //Process os success response
                            String error = response.get("Error").toString();
                            if (error.equals("true")) {
                                Toast.makeText ( context,"Some Error Occurred.", Toast.LENGTH_SHORT ).show ();
                            } else if (error.equals("false")) {
                                JSONObject jsonObject = null;
                                try {
                                    jsonObject = (JSONObject) response.get("User");

                                    final int userId = (Integer) jsonObject.get("id");
                                    final String name = jsonObject.get("name").toString();
                                    final String userName = jsonObject.get("uname").toString();
                                    final String userLocation = jsonObject.get("location").toString();
                                    final String userMobileNo = jsonObject.get("mobile").toString();
                                    final String wa_link = jsonObject.get("wa_link").toString();
                                    final String fb_link = jsonObject.get("fb_link").toString();
                                    final String profile_pic = jsonObject.get("profile_pic").toString();
                                    final int age = (Integer) jsonObject.get("age");
                                    editor = getSharedPreferences(Constants.userDetails, MODE_PRIVATE).edit();
                                    editor.putInt("User_Id", userId);
                                    editor.putString("Name", name);
                                    editor.putString("Username", userName);
                                    editor.putString("Location", userLocation);
                                    editor.putString("Mobile", userMobileNo);
                                    editor.putString("Whatsapp_Link", wa_link);
                                    editor.putString("Facebook_Link", fb_link);
                                    editor.putString("Avatar", profile_pic);
                                    editor.putInt("Age", age);
                                    editor.putBoolean("Logged_in", true);
                                    editor.apply();
                                    Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent (SocialInfoActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Please try again later", Toast.LENGTH_SHORT).show();
                VolleyLog.e("Error: ", error.getMessage());
            }
        });
        request_json.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(request_json);
    }
}
