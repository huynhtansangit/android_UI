package com.example.uitest;


import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_fragment extends Fragment implements  EditDialogListener {
private TextView tv_address,tv_phone,tv_gender,tv_face_add,tv_nameinProfileFrag,tv_mailInProfileFrag;
private ImageView iv_avt_pro_frag;
private Button btnEdit;

    public Profile_fragment() {
        // Required empty public constructor
    }

    @Override
    public void sendInput(String address) {
        tv_address.setText(address);
        //Glide.with(this).load(imPath).apply(RequestOptions.circleCropTransform()).into(iv_avt_pro_frag);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view= inflater.inflate(R.layout.fragment_profile_fragment, container, false);
        tv_address= view.findViewById(R.id.tv_youraddress);
        tv_face_add= view.findViewById(R.id.tv_faceaddress);
        tv_gender= view.findViewById(R.id.tv_gender);
        tv_phone= view.findViewById(R.id.tv_yourphone);
        iv_avt_pro_frag=view.findViewById(R.id.im_Avt_profile);
        btnEdit=view.findViewById(R.id.btn_edit_profile);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        return view;
    }
    public void openDialog()
    {
        dialog_edit_info dialogEditInfo=new dialog_edit_info();
        dialogEditInfo.show(getFragmentManager(),"Edit_dialog");
    }


}
