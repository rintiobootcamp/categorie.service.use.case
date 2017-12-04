package com.bootcamp.clientTest;

import com.bootcamp.entities.Projet;

import java.util.ArrayList;
import java.util.List;

public class ProjetClient {

    public List<Projet> findAll(){
        return new ArrayList<>();
    }

    public static Projet findById(int id){
        Projet projet = new Projet();
        projet.setId(1);
        projet.setNom("pilier 1");
        projet.setDescription("Description 1");
        return projet;
    }
}
