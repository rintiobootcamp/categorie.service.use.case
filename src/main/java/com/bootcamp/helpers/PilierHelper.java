/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.helpers;

import com.bootcamp.commons.ws.usecases.pivotone.AxeWS;
import com.bootcamp.commons.ws.usecases.pivotone.PilierWS;
import com.bootcamp.commons.ws.usecases.pivotone.ProjetWS;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Pilier;
import com.bootcamp.entities.Projet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public class PilierHelper {

    public static PilierWS buildPilierWsObject(Pilier pilier, List<Projet> projets) {
        PilierWS pilierWS = new PilierWS();
        pilierWS.setDescription(pilier.getDescription());
        pilierWS.setDateMiseAJour(pilier.getDateMiseAJour());
        pilierWS.setDateCreation(pilier.getDateCreation());
        pilierWS.setNom(pilier.getNom());
        pilierWS.setId(pilier.getId());
        List<AxeWS> axeWSS = new ArrayList<>();
        for(Axe axe: pilier.getAxes()){
            AxeWS axeWS = AxeHelper.buildAxewsObject(axe, projets, false);
            axeWSS.add(axeWS);
        }
        pilierWS.setAxes(axeWSS);
        return pilierWS;
    }

    public static List<PilierWS> buildProjet(List<Pilier> pilierList, List<Projet> projetList) {
        List<PilierWS> pilierWSS = new ArrayList<>();
       for(Pilier pilier: pilierList){
           PilierWS pilierWS = PilierHelper.buildPilierWsObject(pilier, projetList);
           pilierWSS.add(pilierWS);
       }
       return pilierWSS;
    }
}
