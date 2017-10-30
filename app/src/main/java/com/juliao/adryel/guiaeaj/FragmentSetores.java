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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADRYEL on 15/10/2017.
 */

public class FragmentSetores extends Fragment {

    //ArrayLis para criar os objetos a serem inflados
    private List<SetorEAJ> listaSetores = new ArrayList<>();
    private TextView nomeSetorMap;
    private ViewPager viewPager;
    private boolean flag = false;
    private TextView descricao;
    private ImageView imageView;
    private TextView nomesetor;
    private TextView horario;
    private TextView responsavel;
    private TextView email;
    private TextView telefone;
    private Button localizaRecycler;
    private Button localiza;
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



//        localiza = (Button) view.findViewById(R.id.localizaMap);
//        localiza.setVisibility(View.INVISIBLE);
        recyclerView.addOnItemTouchListener(new MyRecyclerView(getActivity(), recyclerView, new MyRecyclerView.ItemTouch() {
            @Override
            public void clickSimples(View view, final int position) {
                findIdWidgets();
                localiza.setVisibility(View.GONE);
                localizaRecycler.setVisibility(View.VISIBLE);
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        if(position == 0){
                            nomeSetorMap = getActivity().findViewById(R.id.nomeSetorMap);

                            localiza.setVisibility(View.VISIBLE);
                            localizaRecycler.setVisibility(View.GONE);
                            imageView.setImageResource(R.drawable.eaj);
                            nomesetor.setText("Escola Agrícola de Jundiaí - UFRN");
                            nomeSetorMap.setText(nomesetor.toString());
                            telefone.setText("(84) 99256-5566");
                            descricao.setText(R.string.descricaoEAJ);
                            responsavel.setText("Coordenação");
                            horario.setText("Horario: 6h - 22h");
                            email.setText("eaj.ufrn@gov.com.br");
                            //nomeSetor.setText("Escola Agricola");
                            MainActivity.mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-5.885447,-35.364310)).title(
                                    "Escola Agrícola de Jundiaí"));
                            CameraPosition escola = CameraPosition.builder().target(new LatLng(-5.8857457,-35.3664876)).zoom(16).bearing(0).build();
                            MainActivity.mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(escola));
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

                localizaRecycler.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        localizaRecycler.setVisibility(View.GONE);
//                        localiza.setVisibility(View.VISIBLE);
                        //setando o marcador no mapa
                        nomeSetorMap = getActivity().findViewById(R.id.nomeSetorMap);
                        nomeSetorMap.setText(listaSetores.get(position).getNomeSetor());
                        MainActivity.mGoogleMap.addMarker(new MarkerOptions().position(
                                new LatLng(listaSetores.get(position).getLatitude(), listaSetores.get(position).getLongetude()))
                                .title(listaSetores.get(position).getNomeSetor()));
                        //visao do mapa
                        CameraPosition liberty = CameraPosition.builder().target(
                                new LatLng(listaSetores.get(position).getLatitude(), listaSetores.get(position).getLongetude()))
                                .zoom(16).bearing(0).build();
                        //visao no mapa
                        MainActivity.mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty));
                        viewPager.setCurrentItem(2);
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

        localizaRecycler = getActivity().findViewById(R.id.localizaRecyclerMap);
        localiza = getActivity().findViewById(R.id.localizaMap);
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

        listaSetores.add(new SetorEAJ("Informática", "Horario: 8h - 17h", "eajInformatica@eaj.urfn.br", "Leonardo Teixeira", R.drawable.informatica, "O setor de Informatica é onde o curso de mesmo nome é ministrado por professores exepcionais "+"e um curso recente na escola comparado com os outros cursos", "(84)98115-5569",  -5.885786, -35.365748));

        listaSetores.add(new SetorEAJ("Biblioteca", "Horario: 8h - 17h", "eajBiblioteca@eaj.ufrn.br", "Petunia Dolores", R.drawable.biblioteca, "Biclioteca da ufrn para que os alunos alocados da EAJ possam cunsultar a literatura para aprender"  +
                "novos conhecimentos, ou passar o tempo no ar-condicionado e wi-fi ja que é o vicio " + "da nova geração", "(84)98115-5569", -5.885911, -35.366131));

        listaSetores.add(new SetorEAJ("CVT", "Horario: 8h - 17h", "eajcvt@eaj.ufrn.br", "André Stuwart", R.drawable.cvt, "Centro Vocacional Tecnologico, o setor com laboratorios " + "preparados para o ensino de graduação e Ensino Médio, Quimica, fisica, biologia e Agroidustria sã oalguns dos laboratorios " +
                "encontrados nele", "(84)98115-5569", -5.884567, -35.364924));

        listaSetores.add(new SetorEAJ("Apicultura", "Horario: 8h - 17h", "eajavicultura@eaj.ufrn.br", "Jean Carlos", R.drawable.apicultura, "O setor de Apicultura é onde o curso de "  +
                       "mesmo nome é ministrado por professores exepcionais e uma das melhores fabricas de mel caseiro da escola", "(84)98115-5569", 5.885880, -35.362644));

        listaSetores.add(new SetorEAJ("Diretoria", "Horario: 8h - 17h", "eajdiretoria@eaj.ufrn.br", "Julio César", R.drawable.diretoria, "A diretoria da escola onde todo o processo burocratico" + "academico passa, reunioes constantemente acontencem o que não é raro de não ver carros estacionados na frente "
                , "(84)98115-5569", -5.886449, -35.362213));

        listaSetores.add(new SetorEAJ("Avicultura", "Horario: 8h - 17h", "eajdiretoria@eaj.ufrn.br", "Patricia Melo", R.drawable.avicultura, "O setor de Avicultura é onde o curso de " +
                "mesmo nome é ministrado por professores exepcionais e uma das mais produtora de aves de corte em Macaíba", "(84)98115-5569", -5.886712, -35.363297));

        listaSetores.add(new SetorEAJ("Capela", "Horario: 8h - 17h", "eajCapela@eaj.ufrn.br", "Padre Anastacio", R.drawable.capela, "A capela da EAJ é para aqueles que buscam iluminação " +
                "espiritual e acalmar os abalos da vida de um estudante, tambem serve para pedir força à divindade suprema para " +
                "as dificeis provas de recuperação", "(84)98115-5569", -5.885117, -35.366293));

        listaSetores.add(new SetorEAJ("Lanchonete", "Horario: 8h - 17h", "lanchonete@eaj.ufrn.br", "Seu zé", R.drawable.lanchonet, "Um dos melhores setores da EAJ, a lanchonete do seu zé" +
                ". Aqui você poderá comprar salgadinhos de qualidade, além de também poder saborear o maravilhoso almoço de mei dia pras quatro", "(84)98115-5569", -5.884967, -35.363785));

        listaSetores.add(new SetorEAJ("Predio e-Tec", "Horario: 8h - 17h", "eajEtec@eaj.ufrn.br", "Max Lacerda", R.drawable.predio_etec, "A direção do E-tec onde é realizado toda a parte burocratica e " +
                "administrativa desse projeto social, localiza-se no antigo prédio da direção e antigo casarão do dono da EAJ que " +
                "um dia foi-se um fazenda de engenho", "(84)98115-5569", -5.885260, -35.366496));

        listaSetores.add(new SetorEAJ("Complexo poliesportivo", "Horario: 8h - 17h", "email.responsavel@gmai.com", "Raimundo Faria", R.drawable.ginasio, "Complexo poliesportivo onde é realizada inúmeras atividades" +
                "fisicas, palestra e entre outras.", "(84)98115-5569", -5.885377, -35.363820));

        listaSetores.add(new SetorEAJ("Restaurante Universitário", "Horario: 8h - 17h", "restaurante.u@gmail.com", "Raimundo Faria", R.drawable.ginasio, "Com fome? Passe no Restaurante Universitário(RU), onde os alunos da graduação," +
                " Ensino Médio, funcionários terceirizados, Professores e etc vão almoçar, porem se vc nao tiver  auxilio esteja sabendo" +
                " que a entrada é 7R$", "(84)98115-5569", -5.885471, -35.362908));

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