/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.helpers;

import com.bootcamp.commons.ws.usecases.pivotone.PhaseWS;
import com.bootcamp.commons.ws.usecases.pivotone.ProjetWS;
import com.bootcamp.commons.ws.usecases.pivotone.RegionWS;
import com.bootcamp.entities.Phase;
import com.bootcamp.entities.Pilier;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Region;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bello
 */
public class ProjetHelper {

    public static ProjetWS buildProjetWsObject(Projet projet) {
        ProjetWS projetws = new ProjetWS();
        projetws.setId(projet.getId());
        projetws.setReference(projet.getReference());
        projetws.setDateFinReel(projet.getDateFinReel());
        projetws.setNom(projet.getNom());
        projetws.setDescription(projet.getDescription());
        projetws.setDateDebutReel(projet.getDateDebutReel());
        projetws.setDateDebutPrevisionnel(projet.getDateDebutPrevisionnel());
        projetws.setDateFinPrevisionnel(projet.getDateFinPrevisionnel());
        projetws.setBudgetPrevisionnel(projet.getBudgetPrevisionnel());
        projetws.setBudgetReel(projet.getBudgetReel());
        projetws.setCoutReel(projet.getCoutReel());
        projetws.setObjectif(projet.getObjectif());
        projetws.setSecteurId(projet.getIdSecteur());



        List<RegionWS> regionWSS = new ArrayList<>();
        for(Region region: projet.getRegions()){
            RegionWS regionWS = RegionHelper.buildRegionWSObject(region);
            regionWSS.add(regionWS);
        }
        projetws.setRegions(regionWSS);

        List<PhaseWS> phaseWSS = new ArrayList<>();
        for(Phase phase: projet.getPhases()){
            PhaseWS phaseWS = PhaseHelper.buildPhaseWSObject(phase);
            phaseWSS.add(phaseWS);
        }
        projetws.setPhases(phaseWSS);

        return projetws;
    }


}
