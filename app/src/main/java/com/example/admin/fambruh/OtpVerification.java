package com.example.admin.fambruh;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtpVerification extends AppCompatActivity {

    public final String TAG = "OTP VERIFICATION";

    EditText otp_code;
    Button verify;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.otp_activity);
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
    final String name = intent.getStringExtra("name");
    final String username = intent.getStringExtra("username");
    final String mobile = intent.getStringExtra("mobile");
    final String password = intent.getStringExtra("password");
    final String otp = intent.getStringExtra("otp");

    verify = (Button)findViewById (R.id.verify);

        verify.setOnClickListener ( new View.OnClickListener () {
        @Override
        public void onClick(View v) {
            otp_code = (EditText)findViewById(R.id.otp);

            if(otp.equals(otp_code.getText().toString())){
                Intent intent = new Intent(getApplicationContext(), SocialInfoActivity.class);
                intent.putExtra ( "name", name);
                intent.putExtra ( "username", username);
                intent.putExtra ( "mobile", mobile);
                intent.putExtra ( "password", password);
                startActivity(intent);
            }else{
                Toast.makeText ( getApplicationContext (), "Wrong OTP.", Toast.LENGTH_LONG ).show ();
            }
        }
    } );


}
}
