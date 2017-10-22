package com.juliao.adryel.guiaeaj;



        import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADRYEL on 15/10/2017.
 */

public class FragmentSetores extends Fragment {

    //ArrayLis para criar os objetos a serem inflados
    private List<SetorEAJ> listaSetores = new ArrayList<>();
    TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //essa view infla o fragment_um, pois o mesmo possui um recycleView
        View view = inflater.inflate(R.layout.fragment_um, container, false);
        //carregaSetores é o metodo responsavel por criar novo Objetos de setor e add na lista de setores
        carregarSetores();

        //cria-se um recycler view para setar o adapter
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        //pega a viewpage da activity main
        tabLayout = (TabLayout) getActivity().findViewById(R.id.tabMain);

        //cria-se um adapter
        SetorAdapter adapter = new SetorAdapter(listaSetores, getContext());
        //seta o adapter no recycler view
        recyclerView.setAdapter(adapter);
        //Layout na qual define se os layouts inflados serão ou em grid ou em forma de lista
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        recyclerView.addOnItemTouchListener(new MyRecyclerView(getActivity(), recyclerView, new MyRecyclerView.ItemTouch() {
            @Override
            public void clickSimples(View view, int position) {
                TextView descricao;
                ImageView imageView;
                descricao = (TextView) getActivity().findViewById(R.id.descricaoSetorDetalhes);
                imageView = (ImageView) getActivity().findViewById(R.id.image_header);
                Log.i("stringEnt", ""+listaSetores.get(position).getTextao());
                descricao.setText(listaSetores.get(position).getTextao());
                //imageView.setBackgroundResource(R.drawable.informatica);
                tabLayout.getTabAt(1).select();


            }
        }));


        return view;
    }


    public void carregarSetores(){
        listaSetores.add(new SetorEAJ("Informática", "Horario: 07h - 18h", R.string.descricao_informatica));
        listaSetores.add(new SetorEAJ("Ensino Médio", "Horario: 07h - 18h", R.string.descricao_informatica));
        listaSetores.add(new SetorEAJ("Aquicultura", "Horario: 07h - 18h", "kkkw3"));
        listaSetores.add(new SetorEAJ("Avicultura", "Horario: 07h - 18h", "kkkw3"));
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("DESTROY", "DESTRUIU a view");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("FRAG", "DESTRUIU a view");
    }
}