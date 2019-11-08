package com.example.uitest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.navigation.NavigationView;


public class menu_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView imageAvatar;
    private TextView tv_navi_name,tv_navi_email;
    private NavigationView navigationView;
    private LinearLayout linearLayout;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    // Fragment
    private Dashboard_Fragment dashboardFragment;
    private contact_fragment contactFragment;
    private Profile_fragment profileFragment;
    private  support_fragment supportFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        navigationView=(NavigationView)findViewById(R.id.navigattionview);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        linearLayout=(LinearLayout)headerView.findViewById(R.id.linearLayout) ;
        drawerLayout =(DrawerLayout)findViewById(R.id.Drawer_layout) ;
        imageAvatar=(ImageView)headerView.findViewById(R.id.im_avatar);
        tv_navi_name=(TextView)headerView.findViewById(R.id.navigation_username);
        tv_navi_email=(TextView)headerView.findViewById(R.id.navigation_email);
        tv_navi_name.setText("Kim Tỏa");
        tv_navi_email.setText("kim.toa.99");
        initActionBar();
        String image_link1="https://scontent.fsgn2-4.fna.fbcdn.net/v/t1.0-9/s960x960/70925032_913368639036312_5347607945674752_o.jpg?_nc_cat=111&cachebreaker=hd&_nc_oc=AQnMjSIXy377KDw3GiUcSw4EoG4sAYiX9gMca6UhMrXQZWcjXVKGJ4dYZe1NjXWM2fI&_nc_ht=scontent.fsgn2-4.fna&oh=1ef13813289992478b70e5191dd647b4&oe=5E5C0D20";
        String image_link2="https://scontent.fsgn2-3.fna.fbcdn.net/v/t1.0-9/48398653_736565250049986_1196351475169624064_n.jpg?_nc_cat=108&cachebreaker=hd&_nc_oc=AQmyXFLRt4WJZM9PAVX1HxwjDQ976ZNG6LeqrBNW5hREo7Nw4G8Cjnw2Ki5enATbCrU&_nc_ht=scontent.fsgn2-3.fna&oh=350cbdfb426222af51c2a03d24d1cd8a&oe=5E4FFFD8";
        String image_link3="https://i.pinimg.com/originals/39/98/ef/3998efdc4d9bf178709a24341b429208.jpg";
        int idResource=R.mipmap.ic_launcher;
        // loading image into avatar and wall
        loadImageintoWall(image_link2,linearLayout);
        loadImageintoAvatar(image_link1,imageAvatar);
        //loadImageintoDrawer(image_link3,drawerLayout);
        //Create fragments
        if (savedInstanceState==null)
        {
            profileFragment=new Profile_fragment();
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.include_fragment,profileFragment,"Profile");
            transaction.commit();
            navigationView.setCheckedItem(R.id.item_profile);
        }
        //

    }

    // load hình địa chỉ ảnh trên internet lên tường
    private void loadImageintoDrawer (String link,final DrawerLayout drawerLayout )
    {
        Glide.with(this).load(link).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                drawerLayout.setBackground(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
            }

        });
    }
    private void loadImageintoWall (String link,final LinearLayout linearLayout )
    {
        Glide.with(this).load(link).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                linearLayout.setBackground(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
            }

        });
    }
    // load hình địa chỉ ảnh trên internet lên avatar
    private void loadImageintoAvatar (String link,final ImageView imageView )
    {
        Glide.with(this).load(link).apply(RequestOptions.circleCropTransform()).into(imageView);
    }

    public void dummyCLick(View view) {
    }
    private void initActionBar()
    {
        Toolbar toolbar= (Toolbar) findViewById(R.id.action_toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    //implement onNavigationItemSeleted
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        if(id==R.id.item_Dashboard)
        {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.include_fragment,new Dashboard_Fragment(),"Dashboard");
            transaction.commit();
        }
        if(id==R.id.item_Contact)
        {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.include_fragment,new contact_fragment(),"Contact");
            transaction.commit();
        }
        if(id==R.id.item_Help)
        {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.include_fragment,new support_fragment(),"Help");
            transaction.commit();
        }
        if(id==R.id.item_profile)
        {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.include_fragment,new Profile_fragment(),"Profile");
            transaction.commit();
        }
        if(id==R.id.item_Logout)
        {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
    @Override
    public  void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);

        }else {
            super.onBackPressed();
        }
    }
}
