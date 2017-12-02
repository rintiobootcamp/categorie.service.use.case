package com.bootcamp.helpers;

import com.bootcamp.commons.ws.usecases.pivotone.AxeWS;
import com.bootcamp.commons.ws.usecases.pivotone.ProjetWS;
import com.bootcamp.commons.ws.usecases.pivotone.SecteurWS;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Secteur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */
public class SecteurHelper {

    public static SecteurWS buildSecteurWsObject(Secteur secteur, List<Projet> projets) {
        SecteurWS secteurWS = new SecteurWS();



        List<ProjetWS> projetWSS = new ArrayList<>();
        projets = getListProjets(secteur.getId(), projets);
        for(Projet projet: projets){
            ProjetWS projetWS = ProjetHelper.buildProjetWsObject(projet);
            projetWSS.add(projetWS);
        }
        return secteurWS;
    }

    private static List<Projet> getListProjets(int secteurId, List<Projet> projets){
        List<Projet> selectedProjets = new ArrayList<>();
        for(Projet projet: projets){
            if(secteurId == projet.getIdSecteur())
                selectedProjets.add(projet);
        }

        return selectedProjets;
    }


    public static List<SecteurWS> buildSecteur(List<Secteur> secteurs, List<Projet> projetList) {
        List<SecteurWS> secteurWSS = new ArrayList<>();
        for(Secteur secteur: secteurs){
            SecteurWS secteurWS = buildSecteurWsObject(secteur, projetList);
            secteurWSS.add(secteurWS);
        }
        return secteurWSS;
    }

}
