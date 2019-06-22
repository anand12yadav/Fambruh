package com.example.admin.fambruh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    TextView login;
    Button signup;
    EditText username,password,name,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        login=findViewById(R.id.login);

        signup = (Button)findViewById(R.id.signup);

        name = (EditText)findViewById(R.id.name);

        mobile = (EditText)findViewById(R.id.phoneNumber);

        username = (EditText)findViewById(R.id.username);

        password = (EditText)findViewById(R.id.password);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(SignupActivity.this,SocialInfoActivity.class);
                Intent intent = new Intent (SignupActivity.this, OtpVerification.class );
                int randomNumber = 123456;
                intent.putExtra ( "name", name.getText ().toString());
                intent.putExtra ( "username", username.getText ().toString());
                intent.putExtra ( "mobile", mobile.getText ().toString());
                intent.putExtra ( "password", password.getText ().toString());
                intent.putExtra ( "otp", Integer.toString(randomNumber));


              startActivity(intent);
         //       finish();
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
           startActivity(intent);
        finish();
            }
        });
    }
}
