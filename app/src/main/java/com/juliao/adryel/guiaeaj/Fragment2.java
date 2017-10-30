package com.juliao.adryel.guiaeaj;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by ADRYEL on 15/10/2017.
 */

public class Fragment2 extends Fragment {
   private Button localizaRecycler;
   private Button localiza;
   private TextView nomeSetorMap;
    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_dois, container, false);
        localiza = (Button) v.findViewById(R.id.localizaMap);
        localizaRecycler = (Button) v.findViewById(R.id.localizaRecyclerMap);
        viewPager = getActivity().findViewById(R.id.viewPageMain);
        localizaRecycler.setVisibility(View.GONE);
        localiza.setVisibility(View.VISIBLE);
        localiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-5.885447,-35.364310)).title(
                        "Escola Agrícola de Jundiaí"));
                CameraPosition escola = CameraPosition.builder().target(new LatLng(-5.8857457,-35.3664876)).zoom(16).bearing(0).build();
                MainActivity.mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(escola));

                nomeSetorMap = getActivity().findViewById(R.id.nomeSetorMap);
                nomeSetorMap.setText("Escola Agricola de Jundiaí");

                viewPager.setCurrentItem(2);
            }
        });
        //logica do fragment
        return v;
    }

    public void click(View v){
        localizaRecycler.setVisibility(View.VISIBLE);
        localiza.setVisibility(View.GONE);
    }
}