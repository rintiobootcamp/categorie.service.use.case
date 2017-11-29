package com.bootcamp.helpers;

import com.bootcamp.commons.ws.models.AxeUWs;
import com.bootcamp.commons.ws.models.ProjetUWs;
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

    public static AxeUWs buildAxeUwsObject(Axe axe, List<Projet> projets) {
        AxeUWs axeUWs = new AxeUWs();
        ArrayList<ProjetUWs> projetsUws = new ArrayList<ProjetUWs>();

        for (Projet projet : projets) {
            projetsUws.add(ProjetHelpers.buildProjetUWsObject(projet));
        }

        axeUWs.setProjets(projetsUws);
        axeUWs.setNom(axe.getNom());
        axeUWs.setTitre(axe.getTitre());
        axeUWs.setTitreFocus(axe.getTitreFocus());
        axeUWs.setDescriptionFocus(axe.getDescriptionFocus());
        axeUWs.setDescription(axe.getDescription());
        axeUWs.setDateCreation(axe.getDateCreation());
        axeUWs.setDateMiseAJour(axe.getDateMiseAJour());
        return axeUWs;
    }

    public static List<Projet> getProjectsOfAxe(Axe axe, Projet[] projets) {
        //Recuperation des id des secteurs d'un axe
        List<Integer> secteurs = new ArrayList<Integer>();
        for (Secteur secteur : axe.getSecteurs()) {
            secteurs.add(secteur.getId());
        }

        //Liste de projets a renvoyer
        List<Projet> projetsByAxe = new ArrayList<Projet>();

        for (int secteur : secteurs) {
            for (Projet projet : projets) {
                //Verification : Si un des secteurs contients le projet, on l'ajoute à la liste de retour
                if (projet.getIdSecteurs().contains(secteur)) {
                    projetsByAxe.add(projet);
                }
            }
        }
        return projetsByAxe;
    }
}
