/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.helpers;

import com.bootcamp.client.LikeClient;
import com.bootcamp.client.NoteClient;
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

    public PilierWS buildPilierWsObject(Pilier pilier, List<Projet> projets) throws IOException{
        PilierWS pilierWS = new PilierWS();
        pilierWS.setDescription(pilier.getDescription());
        pilierWS.setDateMiseAJour(pilier.getDateMiseAJour());
        pilierWS.setDateCreation(pilier.getDateCreation());
        pilierWS.setNom(pilier.getNom());
        pilierWS.setId(pilier.getId());
        pilierWS = setPilierLikes(pilierWS);
        pilierWS = setProjetNote(pilierWS);
        List<AxeWS> axeWSS = new ArrayList<>();
        AxeHelper axeHelper = new AxeHelper();
        for(Axe axe: pilier.getAxes()){
            
            AxeWS axeWS = axeHelper.buildAxewsObject(axe, projets, false);
            axeWSS.add(axeWS);
        }
        pilierWS.setAxes(axeWSS);
        return pilierWS;
    }

    public List<PilierWS> buildProjet(List<Pilier> pilierList, List<Projet> projetList) throws IOException{
        List<PilierWS> pilierWSS = new ArrayList<>();
       for(Pilier pilier: pilierList){
           PilierWS pilierWS = this.buildPilierWsObject(pilier, projetList);
           pilierWSS.add(pilierWS);
       }
       return pilierWSS;
    }

    public PilierWS setPilierLikes(PilierWS pilierWS) throws IOException{
        LikeClient likeClient = new LikeClient();
        LikeWS likeWS = likeClient.getClient(EntityType.PILIER.name(),pilierWS.getId());
        pilierWS.setLikeWS(likeWS);
        return pilierWS;
    }

    public PilierWS setProjetNote(PilierWS pilierWS) throws IOException{
        NoteClient noteClient = new NoteClient();
        NoteWS noteWS = noteClient.getNote(EntityType.PILIER.name(),pilierWS.getId());
        pilierWS.setNoteWS(noteWS);
        return pilierWS;
    }
}
