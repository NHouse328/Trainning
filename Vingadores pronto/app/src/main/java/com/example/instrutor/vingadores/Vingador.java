package com.example.instrutor.vingadores;

import android.os.Parcel;
import android.os.Parcelable;

public class Vingador implements Parcelable {

    public int foto;
    public String nome;
    public String detalhe;

    public Vingador(int foto, String nome, String detalhe) {
        this.foto = foto;
        this.nome = nome;
        this.detalhe = detalhe;
    }

    public Vingador() {
    }

    protected Vingador(Parcel in) {
        foto = in.readInt();
        nome = in.readString();
        detalhe = in.readString();
    }

    public static final Creator<Vingador> CREATOR = new Creator<Vingador>() {
        @Override
        public Vingador createFromParcel(Parcel in) {
            return new Vingador(in);
        }

        @Override
        public Vingador[] newArray(int size) {
            return new Vingador[size];
        }
    };

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(foto);
        dest.writeString(nome);
        dest.writeString(detalhe);
    }
}
