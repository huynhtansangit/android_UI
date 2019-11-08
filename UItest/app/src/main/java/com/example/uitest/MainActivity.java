package com.example.uitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn_login,btn_face,btn_google;
TextView tv_forgotpass,tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_face=(Button)findViewById(R.id.btn_face);
        btn_google=(Button)findViewById(R.id.btn_google);
        tv_forgotpass=(TextView)findViewById(R.id.tv_forgotpass);
        tv_register=(TextView)findViewById(R.id.tx_register);
        // remove status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_intent=new Intent(getApplicationContext(),register.class);
                startActivity(register_intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu_intent=new Intent (getApplicationContext(),menu_activity.class);
                startActivity(menu_intent);
            }
        });
    }
    public void dummyCLick (View view)
    {
        // set visible for text click event
    }

}
