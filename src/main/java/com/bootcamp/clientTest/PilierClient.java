package com.bootcamp.clientTest;

import com.bootcamp.entities.Pilier;

import java.util.ArrayList;
import java.util.List;

public class PilierClient {
    public static Pilier getById(int id){
        Pilier pilier = new Pilier();
        pilier.setId(1);
        pilier.setNom("pilier 1");
        pilier.setDateCreation(1230000);
        pilier.setDescription("Pilier 1 des kffefefe");
        return pilier;
    }

    public static List<Pilier> findAll(){
        return new ArrayList<>();
    }

}
