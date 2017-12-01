package com.bootcamp.services;

//import com.bootcamp.client.AxeClient;
//import com.bootcamp.client.ProjetClient;
import com.bootcamp.commons.ws.models.AxeUWs;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Projet;
import com.bootcamp.helpers.AxeHelper;
import java.io.IOException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 * Created by darextossa on 11/29/17.
 */

@Component
public class AxeService {

//    AxeClient axeClient;
//    ProjetClient projetClient;
//
//    @PostConstruct
//    public void init(){
//        axeClient = new AxeClient();
//        projetClient = new ProjetClient();
//    }

    public List<AxeUWs> getProjectByAxes() throws IOException {
//        Axe[] axes = axeClient.findAll();
//        Projet[] projets = projetClient.findAll();

        //Liste formater d'axes a renvoyer
        List<AxeUWs> axesUWs = new ArrayList<AxeUWs>();
        
//        for (Axe axe : axes) {
//            List<Projet> projetsByAxe = new ArrayList<Projet>();
//            projetsByAxe = AxeHelper.getProjectsOfAxe(axe, projets);
//
//            //Formater l'axe actuel
//            AxeUWs axeUWs = new AxeUWs();
//            axeUWs = AxeHelper.buildAxeUwsObject(axe, projetsByAxe);
//            axesUWs.add(axeUWs);
//        }
        
        return new ArrayList<>();
    }
}
