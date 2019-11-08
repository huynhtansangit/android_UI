package com.example.uitest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import static android.app.Activity.RESULT_OK;

public class dialog_edit_info extends AppCompatDialogFragment {
    public  EditText et_add,et_phone,et_faceadd;
    public TextView tv_gender,tv_path_avt;
    public Button btn_getPath;
    public RadioButton rbtnmale,rbtnFemale,rbtnOther;
    public RadioGroup radioGroup;
    public Intent getPathIntent;
    public String pathAvt;

    private EditDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.edit_dialog,null);

        builder.setView(view).setTitle("Edit Infomation").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).setPositiveButton("Apply", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        et_faceadd=view.findViewById(R.id.et_faceadd);
        et_add =view.findViewById(R.id.et_youraddress);
        et_phone=view.findViewById(R.id.et_phoneprofile);
        tv_gender =view.findViewById(R.id.tv_gender_dialog);
        rbtnmale =view.findViewById(R.id.rbtn_male);
        rbtnFemale =view.findViewById(R.id.rbtn_female);
        rbtnOther =view.findViewById(R.id.rbtn_other);
        btn_getPath=view.findViewById(R.id.btn_pickImage);
        tv_path_avt=view.findViewById(R.id.tv_pathImage);
        radioGroup=view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkid) {
                if(checkid==rbtnmale.getId())
                {
                    tv_gender.setText("Male");
                }
                if(checkid==rbtnFemale.getId())
                {
                    tv_gender.setText("Female");
                }
                if(checkid==rbtnOther.getId())
                {
                    tv_gender.setText("3rd");
                }
            }
        });
        btn_getPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPathIntent=new Intent(Intent.ACTION_GET_CONTENT);
                getPathIntent.setType("*/*");
                startActivityForResult(getPathIntent,10);
            }
        });
        return builder.create();
    }
    // to push data



    // override for get path
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 10:
                if(resultCode==RESULT_OK){
                    pathAvt=data.getData().getPath();
                    tv_path_avt.setText(pathAvt);
                }
        }
    }
}
