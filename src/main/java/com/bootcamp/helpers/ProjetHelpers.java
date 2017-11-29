/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.helpers;

import com.bootcamp.commons.ws.models.ProjetUWs;
import com.bootcamp.entities.Projet;

/**
 *
 * @author Bello
 */
public class ProjetHelpers {

    public static ProjetUWs buildProjetUWsObject(Projet projet) {
        ProjetUWs projetUws = new ProjetUWs();

        projetUws.setId(projet.getId());
        projetUws.setNom(projet.getNom());
        projetUws.setReference(projet.getReference());
        projetUws.setDescription(projet.getDescription());
        projetUws.setDateDebutReel(projet.getDateDebutReel());
        projetUws.setDateFinReel(projet.getDateFinReel());
        projetUws.setDateDebutPrevisionnel(projet.getDateDebutPrevisionnel());
        projetUws.setDateFinPrevisionnel(projet.getDateFinPrevisionnel());
        projetUws.setBudgetPrevisionnel(projet.getBudgetPrevisionnel());
        projetUws.setBudgetReel(projet.getBudgetReel());
        projetUws.setCoutReel(projet.getCoutReel());
        
        return projetUws;
    }
}
