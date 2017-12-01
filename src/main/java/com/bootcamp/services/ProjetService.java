package com.bootcamp.services;

//import com.bootcamp.client.AxeClient;
//import com.bootcamp.client.ProjetClient;
import com.bootcamp.client.ProjetClient;
import com.bootcamp.commons.ws.usecases.pivotone.ProjetWS;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Secteur;
import com.bootcamp.helpers.AxeHelper;
import com.bootcamp.helpers.ProjetHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */

@Component
public class ProjetService {
    ProjetClient projetClient = new ProjetClient();
    List<Projet> projets;

    public List<ProjetWS> getAll() throws IOException {
        projets = projetClient.findAll();
        List<ProjetWS> result = new ArrayList<>();
        for (Projet current : projets) {
            ProjetWS projetWS = new ProjetWS();
            projetWS = ProjetHelper.buildProjetWsObject(current);
            result.add(projetWS);
        }
            return result;
    }
}
