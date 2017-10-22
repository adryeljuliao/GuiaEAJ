package com.juliao.adryel.guiaeaj;



        import android.os.Bundle;
import android.support.v4.app.Fragment;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by ADRYEL on 15/10/2017.
 */

public class FragmentSetores extends Fragment {
    //ArrayLis para criar os objetos a serem inflados
    private List<SetorEAJ> listaSetores = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //essa view infla o fragment_um, pois o mesmo possui um recycleView
        View view = inflater.inflate(R.layout.fragment_um, container, false);
        //carregaSetores é o metodo responsavel por criar novo Objetos de setor e add na lista de setores
        carregarSetores();

        //cria-se um recycler view para setar o adapter
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        //cria-se um adapter
        SetorAdapter adapter = new SetorAdapter(listaSetores, getContext());
        //seta o adapter no recycler view
        recyclerView.setAdapter(adapter);
        //Layout na qual define se os layouts inflados serão ou em grid ou em forma de lista
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        return view;
    }


    public void carregarSetores(){
        listaSetores.add(new SetorEAJ("PREDIO DE INFORMÁTICA", "Horario: 07h - 18h"));
        listaSetores.add(new SetorEAJ("COORDENAÇÃO ENSINO MÉDIO/TÉCNICO", "Horario: 07h - 18h"));
        listaSetores.add(new SetorEAJ("COORDENAÇÃO TADS", "Horario: 07h - 18h"));
    }


}