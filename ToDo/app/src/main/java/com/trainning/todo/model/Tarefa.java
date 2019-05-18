package com.trainning.todo.model;

public class Tarefa {

    private String titulo, data, hora, anotacoes, tarefaID;

    public Tarefa(){

    }

    public Tarefa(String titulo, String data, String hora, String anotacoes, String tarefaID) {
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.anotacoes = anotacoes;
        this.tarefaID = tarefaID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public String getTarefaID() {
        return tarefaID;
    }

    public void setTarefaID(String tarefaID) {
        this.tarefaID = tarefaID;
    }
}
