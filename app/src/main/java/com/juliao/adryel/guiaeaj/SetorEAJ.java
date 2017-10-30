package com.juliao.adryel.guiaeaj;

/**
 * Created by ADRYEL on 22/10/2017.
 */

public class SetorEAJ {
    private double latitude;
    private double longetude;
    private String nomeSetor;
    private String horarioFuncionamento;
    private String emailResponsavel;
    private String nomeResponsavel;
    private int image;
    private String descricao;
    private int textao;
    private String telefone;






    public SetorEAJ(String s3, String s2, String s1, String s, int alojamento_m, String nomeSetor, String horarioFuncionamento, double v, int textao) {
        this.nomeSetor = nomeSetor;
        this.horarioFuncionamento = horarioFuncionamento;
        this.textao = textao;
    }

    public SetorEAJ(String nomeSetor, String horario, String email, String nomeResponsavel, int image, String descricao, String telefone, double latitude, double longetude) {
        this.nomeSetor = nomeSetor;
        this.horarioFuncionamento = horario;
        this.descricao = descricao;
        this.emailResponsavel = email;
        this.nomeResponsavel = nomeResponsavel;
        this.image = image;
        this.telefone = telefone;
        this.latitude = latitude;
        this.longetude = longetude;
    }

    public void setTextao(int textao) {
        this.textao = textao;
    }

    public int getTextao() {

        return textao;
    }

    public SetorEAJ( String nomeSetor, String horarioFuncionamento, String emailResponsavel, String nomeResponsavel, int image, String descricao, int textao, String telefone, double latitude, double longetude) {
        this.latitude = latitude;
        this.longetude = longetude;
        this.nomeSetor = nomeSetor;
        this.horarioFuncionamento = horarioFuncionamento;
        this.emailResponsavel = emailResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        this.image = image;
        this.descricao = descricao;
        this.textao = textao;
        this.telefone = telefone;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongetude(double longetude) {
        this.longetude = longetude;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongetude() {
        return longetude;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public int getImage() {
        return image;
    }
}
