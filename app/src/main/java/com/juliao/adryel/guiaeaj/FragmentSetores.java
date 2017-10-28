package com.juliao.adryel.guiaeaj;



        import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
    private ViewPager viewPager;
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

                findIdWidgets();

                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        if(position == 0){

                            imageView.setImageResource(R.drawable.eaj);
                            nomesetor.setText("Escola Agrícola de Jundiaí - UFRN");
                            telefone.setText("(84) 99256-5566");
                            descricao.setText(R.string.descricaoEAJ);
                            responsavel.setText("Coordenação");
                            horario.setText("Horario: 6h - 22h");
                            email.setText("eaj.ufrn@gov.com.br");
                            //nomeSetor.setText("Escola Agricola");

                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

                descricao.setText(listaSetores.get(position).getDescricao());
                responsavel.setText(listaSetores.get(position).getNomeResponsavel());
                nomesetor.setText(listaSetores.get(position).getNomeSetor());
                horario.setText(listaSetores.get(position).getHorarioFuncionamento());
                telefone.setText(listaSetores.get(position).getTelefone());
                email.setText(listaSetores.get(position).getEmailResponsavel());
                //imageView.setBackgroundResource(R.drawable.informatica);

                imageView.setImageResource(listaSetores.get(position).getImage());
                viewPager.setCurrentItem(1);
            }
        }));


        return view;
    }


    public void findIdWidgets(){
        viewPager = getActivity().findViewById(R.id.viewPageMain);
        imageView = getActivity().findViewById(R.id.image_header);
        descricao = getActivity().findViewById(R.id.descricaoSetorDetalhes);
        horario = getActivity().findViewById(R.id.horarioSetorDetalhes);
        nomesetor = getActivity().findViewById(R.id.nomeSetorDetalhes);
        responsavel = getActivity().findViewById(R.id.responsavelSetorDetalhes);
        email = getActivity().findViewById(R.id.emailSetorDetalhes);
        telefone = getActivity().findViewById(R.id.telefoneSetorDetalhes);
    }


    public List<SetorEAJ> carregarSetores(){
        List<SetorEAJ> listaSetores = new ArrayList<>();

        listaSetores.add(new SetorEAJ("Informática", "Horario: 8h - 17h", "email.responsavel@gmai.com", "Responsável: Taniro Chacon", R.drawable.informatica, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Biblioteca", "Horario: 8h - 17h", "email.responsavel@gmai.com", "Adriano Dricão", R.drawable.biblioteca, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("CVT", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.cvt, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Apicultura", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.apicultura, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Alojamento feminino", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.aloja_femino, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Alojamento masculino", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.alojamento_m, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Diretoria", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.diretoria, "[DESCRIÇÃO]", "(84)98115-5569"));

        listaSetores.add(new SetorEAJ("Avicultura", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.avicultura, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Auditorio Santos Dumont", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.auditorio_sd, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Capela", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.capela, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Lanchonete", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.lanchonet, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Predio e-Tec", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.predio_etec, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Restaurante universitário", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.restaurante, "[DESCRIÇÃO]", "(84)98115-5569"));
        listaSetores.add(new SetorEAJ("Complexo poliesportivo", "Horario: 8h - 17h", "email.responsavel@gmai.com", "[RESPONSÁVEL]", R.drawable.ginasio, "[DESCRIÇÃO]", "(84)98115-5569"));

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