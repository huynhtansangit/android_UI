package com.example.uitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

public class register extends AppCompatActivity {
ImageButton Ibtn_back;
Button  btn_Create;
EditText et_yourname,et_password,et_email,et_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Ibtn_back=(ImageButton)findViewById(R.id.Ibtn_back);
        btn_Create=(Button)findViewById(R.id.btn_create);
        et_yourname=(EditText)findViewById(R.id.et_register_name);
        et_password=(EditText)findViewById(R.id.et_regis_password);
        et_email=(EditText)findViewById(R.id.et_regis_email);
        et_phone=(EditText)findViewById(R.id.et_regis_phone);

        Ibtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
        btn_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Successfull_intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Successfull_intent);
            }
        });


    }
    public void dummyCLick (View view)
    {
        // set visible for text click event
    }
}
