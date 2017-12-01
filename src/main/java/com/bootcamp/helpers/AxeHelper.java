package com.bootcamp.helpers;

import com.bootcamp.commons.ws.models.AxeUWs;
import com.bootcamp.commons.ws.models.ProjetUWs;
import com.bootcamp.commons.ws.usecases.pivotone.AxeWS;
import com.bootcamp.commons.ws.usecases.pivotone.SecteurWS;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Secteur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */
public class AxeHelper {

    public static AxeWS buildAxewsObject(Axe axe, List<Projet> projets) {
        AxeWS axeWS = new AxeWS();

        axeWS.setId(axe.getId());
        axeWS.setDateCreation(axe.getDateCreation());
        axeWS.setNom(axe.getNom());
        axeWS.setDescription(axe.getDescription());
        axeWS.setDescriptionFocus(axe.getDescriptionFocus());
        axeWS.setPilierId(axe.getPilier().getId());
        axeWS.setTitre(axe.getTitre());
        axeWS.setTitreFocus(axe.getTitreFocus());
        axeWS.setDateMiseAJour(axe.getDateMiseAJour());

        List<SecteurWS> secteurWSS = new ArrayList<>();
        for(Secteur secteur: axe.getSecteurs()){
            SecteurWS secteurWS = SecteurHelper.buildSecteurWsObject(secteur, projets);
            secteurWSS.add(secteurWS);
        }

        return axeWS;
    }

}
