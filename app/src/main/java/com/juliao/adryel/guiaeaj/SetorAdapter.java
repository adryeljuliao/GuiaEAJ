package com.juliao.adryel.guiaeaj;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADRYEL on 22/10/2017.
 */

public class SetorAdapter extends RecyclerView.Adapter {
    private List<SetorEAJ> listaSetores = new ArrayList<>();
    private Context context;

    public SetorAdapter(List<SetorEAJ> listaSetores, Context context) {
        this.listaSetores = listaSetores;
        this.context = context;
    }
    //metodo que infla um layout
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_setores, parent, false);
        SetorViewHolder setorViewHolder = new SetorViewHolder(view);

        return setorViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        SetorViewHolder setorViewHolder = (SetorViewHolder) holder;
        SetorEAJ setorEscolhido = listaSetores.get(position);

        setorViewHolder.nome.setText(setorEscolhido.getNomeSetor());
        setorViewHolder.horario.setText(setorEscolhido.getHorarioFuncionamento());

    }
    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return listaSetores != null ? listaSetores.size() : 0;
    }

    public class SetorViewHolder extends RecyclerView.ViewHolder{
        final TextView nome;
        final TextView horario;

        public SetorViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomeSetorCard);
            horario = itemView.findViewById(R.id.horarioSetorCard);

        }
    }


}
