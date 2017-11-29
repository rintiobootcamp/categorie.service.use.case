package com.bootcamp.services;

import com.bootcamp.client.AxeClient;
import com.bootcamp.client.ProjetClient;
import com.bootcamp.commons.ws.models.usecase.AxeUWs;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Secteur;
import com.bootcamp.helpers.AxeHelper;
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

    AxeClient axeClient;
    ProjetClient projetClient;

    @PostConstruct
    public void init(){
        axeClient = new AxeClient();
        projetClient = new ProjetClient();
    }

    public List<AxeUWs> getProjectByAxes() throws IOException {
        Axe[] axes = axeClient.findAll();
        Projet[] projets = projetClient.findAll();

        List<AxeUWs> axeUWss = AxeHelper.buildAxeUwsObject(axes, projets);

        return axeUWss;
    }
}
