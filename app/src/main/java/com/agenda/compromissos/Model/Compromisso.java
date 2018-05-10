package com.agenda.compromissos.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/*Para o Room, a anotação @Entity inidica que a classe é mapeada para uma tabela em banco de dados*/
@Entity
public class Compromisso {

    /*A anotação Primary Key indica que este atributo é chave primaria na tabela Compromisso*/
    @PrimaryKey(autoGenerate = true)
    private long ID;
    private String titulo;
    private String descricao;
    /*@ColumnInfo é utilizada para indicar que este atributo será renomeado na tabela Nota*/
    @ColumnInfo(name = "data_compromisso")
    private String dataCompromisso;
    private int importancia;
    private int realizado;

    /* Métodos de acesso */
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    public String getDataCompromisso() {
        return dataCompromisso;
    }

    public void setDataCompromisso(String dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public int getRealizado() {
        return realizado;
    }

    public void setRealizado(int realizado) {
        this.realizado = realizado;
    }

    public Compromisso() {

    }

    public Compromisso(long ID, String titulo, String descricao, String dataCompromisso, int importancia, int realizado) {
        this.ID = ID;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCompromisso = dataCompromisso;
        this.importancia = importancia;
        this.realizado = realizado;
    }

}
