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
    private TabLayout tabLayout;
    private boolean flag = false;
    private TextView descricao;
    private ImageView imageView;
    private TextView nomesetor;
    private TextView horario;
    private TextView responsavel;
    private TextView email;
    private TextView telefone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //essa view infla o fragment_um, pois o mesmo possui um recycleView
        View view = inflater.inflate(R.layout.fragment_um, container, false);
        //carregaSetores é o metodo responsavel por criar novo Objetos de setor e add na lista de setores

        if (!flag){
            listaSetores = carregarSetores();
        }





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




                descricao.setText(listaSetores.get(position).getDescricao());
                //imageView.setBackgroundResource(R.drawable.informatica);
                tabLayout.getTabAt(1).select();
                imageView.setImageResource(listaSetores.get(position).getImage());

            }
        }));


        return view;
    }


    public void iniciarWidgets(){
        imageView = (ImageView) getActivity().findViewById(R.id.image_header);


    }

    public List<SetorEAJ> carregarSetores(){
        List<SetorEAJ> listaSetores = new ArrayList<>();

        listaSetores.add(new SetorEAJ("Informática", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.informatica, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Biblioteca", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.biblioteca, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("CVT", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.cvt, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Apicultura", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.apicultura, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Alojamento feminino", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.aloja_femino, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Alojamento masculino", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.alojamento_m, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Diretoria", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.diretoria, "[DESCRIÇÃO]"));

        listaSetores.add(new SetorEAJ("Avicultura", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.avicultura, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Auditorio Santos Dumont", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.auditorio_sd, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Capela", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.capela, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Lanchonete", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.lanchonet, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Predio e-Tec", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.predio_etec, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Restaurante universitário", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.restaurante, "[DESCRIÇÃO]"));
        listaSetores.add(new SetorEAJ("Complexo poliesportivo", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.ginasio, "[DESCRIÇÃO]"));

        flag = true;
        return listaSetores;

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