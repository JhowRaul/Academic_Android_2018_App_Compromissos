package com.agenda.compromissos.Factory;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.agenda.compromissos.DAO.CompromissoDAO;
import com.agenda.compromissos.Model.Compromisso;

/*@Database indica que esta classe dá acesso aos recursos de banco de dados do aplicativo*/
@Database(entities = {Compromisso.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract CompromissoDAO compromissoDAO();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "compromisso-db").fallbackToDestructiveMigration().allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void setINSTANCE(AppDatabase INSTANCE) {
        AppDatabase.INSTANCE = INSTANCE;
    }
}
