package com.bootcamp.clientTest;

import com.bootcamp.commons.ws.usecases.pivotone.SecteurWS;
import com.bootcamp.entities.Secteur;

import java.util.ArrayList;
import java.util.List;

public class SecteurClient {
    public static Secteur getById(int id){
        Secteur secteur = new Secteur();
        secteur.setNom("secteur 1");
        secteur.setId(1);
        secteur.setIcone("icone 1");
        secteur.setDescription("description 1");
        return secteur;
    }

    public static List<Secteur> findAll(){
        return new ArrayList<>();

    }
}
