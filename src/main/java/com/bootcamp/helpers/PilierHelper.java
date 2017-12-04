/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.helpers;

import com.bootcamp.clientTest.LikeClient;
import com.bootcamp.clientTest.NoteClient;
import com.bootcamp.commons.enums.EntityType;
import com.bootcamp.commons.ws.usecases.pivotone.*;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Pilier;
import com.bootcamp.entities.Projet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public class PilierHelper {

    public static PilierWS buildPilierWsObject(Pilier pilier, List<Projet> projets) throws IOException{
        PilierWS pilierWS = new PilierWS();
        pilierWS.setDescription(pilier.getDescription());
        pilierWS.setDateMiseAJour(pilier.getDateMiseAJour());
        pilierWS.setDateCreation(pilier.getDateCreation());
        pilierWS.setNom(pilier.getNom());
        pilierWS.setId(pilier.getId());
        pilierWS = setPilierLikes(pilierWS);
        pilierWS = setProjetNote(pilierWS);
        List<AxeWS> axeWSS = new ArrayList<>();
        for(Axe axe: pilier.getAxes()){
            AxeWS axeWS = AxeHelper.buildAxewsObject(axe, projets, false);
            axeWSS.add(axeWS);
        }
        pilierWS.setAxes(axeWSS);
        return pilierWS;
    }

    public static List<PilierWS> buildProjet(List<Pilier> pilierList, List<Projet> projetList) throws IOException{
        List<PilierWS> pilierWSS = new ArrayList<>();
       for(Pilier pilier: pilierList){
           PilierWS pilierWS = PilierHelper.buildPilierWsObject(pilier, projetList);
           pilierWSS.add(pilierWS);
       }
       return pilierWSS;
    }

    public static PilierWS setPilierLikes(PilierWS pilierWS){

        LikeWS likeWS = LikeClient.getLike(EntityType.PILIER,pilierWS.getId());
        pilierWS.setLikeWS(likeWS);
        return pilierWS;
    }

    public static PilierWS setProjetNote(PilierWS pilierWS){
        NoteWS noteWS = NoteClient.getNote(EntityType.PILIER,pilierWS.getId());
        pilierWS.setNoteWS(noteWS);
        return pilierWS;
    }
}
