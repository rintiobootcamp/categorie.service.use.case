/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.helpers;

import com.bootcamp.commons.ws.usecases.pivotone.*;
import com.bootcamp.entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public class ProjetHelper {

    public static ProjetWS buildProjetWsObject(Projet projet) throws IOException{
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
        projetws.setPhases(PhaseHelper.buildPhaseWsList(projet.getPhases()));
        projetws.setPhaseActuelle(getProjetActualPhase(projet.getPhases()));
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
        projetws.setSecteurId(projet.getIdSecteur());
        return projetws;
    }

    public static PhaseWS getProjetActualPhase(List<Phase> phases){
        PhaseWS result = new PhaseWS();
        for(Phase phase:phases){
            if(phase.isActif())
                result = PhaseHelper.buildPhaseWSObject(phase);
        }
        return result;
    }


    public static List<ProjetWS> buildProjetWSList(List<Projet> projets) throws IOException{
        List<ProjetWS> projetWSs = new ArrayList<>();
        for(Projet projet:projets){
            projetWSs.add(buildProjetWsObject(projet));
        }
        return projetWSs;
    }


}
