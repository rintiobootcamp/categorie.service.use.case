package com.bootcamp.clientTest;

import com.bootcamp.entities.Axe;

import java.util.ArrayList;
import java.util.List;

public class AxeClient {
    public static Axe getById(int id){
        Axe axe = new Axe();
        axe.setId(1);
        axe.setNom("axe 1");
        axe.setDescription("descrition 1");
        return axe;
    }

    public List<Axe> findAll(){
        return new ArrayList<>();
    }
}
