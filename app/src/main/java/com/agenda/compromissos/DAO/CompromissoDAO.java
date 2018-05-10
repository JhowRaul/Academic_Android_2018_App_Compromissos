package com.agenda.compromissos.DAO;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.support.annotation.NonNull;

import com.agenda.compromissos.Model.Compromisso;

import java.util.List;

/*A anotação @DAO indica que esta interface disponibiliza métodos de acesso abstratos na database*/
@Dao
public interface CompromissoDAO {

    @Query("SELECT * from Compromisso")
    List<Compromisso> getAll();

    @Query("SELECT * from Compromisso WHERE ID LIKE :id")
    Compromisso findByCompromisso(int id);

    @Insert
    void insertAllCompromissos(@NonNull Compromisso... compromissos);

    @Insert
    long insertCompromisso(Compromisso compromisso);

    @Delete
    int deleteCompromisso(Compromisso compromisso);

    @Update
    int updateCompromisso(Compromisso compromisso);
}
