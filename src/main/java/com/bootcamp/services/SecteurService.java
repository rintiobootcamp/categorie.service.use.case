package com.bootcamp.services;

import com.bootcamp.client.ProjetClient;
import com.bootcamp.client.SecteurClient;
import com.bootcamp.commons.ws.usecases.pivotone.SecteurWS;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Secteur;
import com.bootcamp.helpers.SecteurHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */

@Component
public class SecteurService {

    SecteurClient secteurClient;
    ProjetClient projetClient;

    @PostConstruct
    public void init(){
        secteurClient = new SecteurClient();
        projetClient = new ProjetClient();
    }

    public List<SecteurWS> getSecteur() throws IOException {
        List<Secteur> secteurList = secteurClient.findAll();
        List<Projet> projetList = projetClient.findAll();
        List<SecteurWS> secteurWSS = SecteurHelper.buildSecteur(secteurList, projetList);

        return secteurWSS;
    }

    public SecteurWS getSecteur(int axeId) throws IOException{
        Secteur secteur= secteurClient.getById(axeId);
        List<Projet> projetList = projetClient.findAll();
        SecteurWS secteurWS = SecteurHelper.buildSecteurWsObject(secteur,projetList);
        return secteurWS;
    }
}
