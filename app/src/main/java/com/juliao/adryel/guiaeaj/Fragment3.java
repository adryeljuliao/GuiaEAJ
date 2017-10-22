package com.juliao.adryel.guiaeaj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ADRYEL on 15/10/2017.
 */

public class Fragment3 extends Fragment {

    /*
    * para navegar entre as abas é necessário fazer esse procedimento
    * */
    Button bot;
    ViewPager viewPage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tres, container, false);
        bot = v.findViewById(R.id.testeDetalhes);
        viewPage = (ViewPager) getActivity().findViewById(R.id.viewPageMain);
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPage.setCurrentItem(1);

            }
        });
        //logica do fragment
        return v;
    }
}