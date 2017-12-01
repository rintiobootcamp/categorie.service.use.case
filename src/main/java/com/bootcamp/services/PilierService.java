package com.bootcamp.services;

import com.bootcamp.client.PilierClient;
import com.bootcamp.client.ProjetClient;
import com.bootcamp.commons.ws.usecases.pivotone.PilierWS;
import com.bootcamp.commons.ws.usecases.pivotone.ProjetWS;
import com.bootcamp.entities.Pilier;
import com.bootcamp.entities.Projet;
import com.bootcamp.helpers.PilierHelper;
import com.bootcamp.helpers.ProjetHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */

@Component
public class PilierService {

    PilierClient pilierClient;
    ProjetClient projetClient;

    @PostConstruct
    public void init(){

    }

    public List<PilierWS> getPiliers() throws IOException {
      List<Pilier> pilierList = pilierClient.findAll();
      List<Projet> projetList = projetClient.findAll();

      List<PilierWS> pilierWSS = PilierHelper.buildProjet(pilierList, projetList);

      return pilierWSS;
    }
}
