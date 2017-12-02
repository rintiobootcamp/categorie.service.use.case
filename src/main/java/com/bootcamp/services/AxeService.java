package com.bootcamp.services;

//import com.bootcamp.client.AxeClient;
//import com.bootcamp.client.ProjetClient;
import com.bootcamp.client.AxeClient;
import com.bootcamp.client.PilierClient;
import com.bootcamp.client.ProjetClient;
import com.bootcamp.commons.ws.usecases.pivotone.AxeWS;
import com.bootcamp.commons.ws.usecases.pivotone.PilierWS;
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

    AxeClient axeClient;
    ProjetClient projetClient;

    @PostConstruct
    public void init(){
        axeClient = new AxeClient();
        projetClient = new ProjetClient();
    }

    public List<AxeWS> getAxes() throws IOException {
        List<Axe> axeList = axeClient.findAll();
        List<Projet> projetList = projetClient.findAll();
        List<AxeWS> axeWSS = AxeHelper.buildAxes(axeList, projetList);

        return axeWSS;
    }

    public AxeWS getAxe(int axeId) throws IOException{
        Axe axe= axeClient.getById(axeId);
        List<Projet> projetList = projetClient.findAll();
        AxeWS axeWS = AxeHelper.buildAxewsObject(axe,projetList);
        return axeWS;
    }



}
