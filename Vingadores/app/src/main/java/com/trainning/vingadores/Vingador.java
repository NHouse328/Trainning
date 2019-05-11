package com.trainning.vingadores;

public class Vingador {

    private int foto;
    private String titulo;
    private String descricao;

    public Vingador(int foto, String titulo, String descricao) {
        this.foto = foto;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Vingador(){}

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
