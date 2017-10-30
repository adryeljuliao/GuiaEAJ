package com.juliao.adryel.guiaeaj;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView nomeSetor;
    private TextView descricao;
    private TextView horario;
    private TextView email;
    private TextView responsavel;
    private TextView telefone;
    private ImageView imageView;
    public static GoogleMap mGoogleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewPageMain);
        tabLayout = (TabLayout) findViewById(R.id.tabMain);
        PagerAdapter pagerAdapter = new FixedTabsPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);



    }

    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem() != 0){
            viewPager.setCurrentItem(0);
        }else{
                super.onBackPressed();
        }
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
////        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
