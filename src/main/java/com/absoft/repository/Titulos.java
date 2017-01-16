package com.absoft.repository;

import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Repository;
import com.absoft.infra.MongoDBHelper;
import com.absoft.model.Titulo;

@Repository
public class Titulos extends BaseRepository<Titulo> {

    Datastore datastore = MongoDBHelper.INSTANCE.getDatastore();

    public Titulos() {
        super(Titulo.class);
    }

    @Override
    public Datastore getDatastore() {
        return datastore;
    }
}
