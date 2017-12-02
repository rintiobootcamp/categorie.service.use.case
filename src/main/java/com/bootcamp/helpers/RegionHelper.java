package com.bootcamp.helpers;

import com.bootcamp.commons.ws.usecases.pivotone.RegionWS;
import com.bootcamp.commons.ws.usecases.pivotone.SecteurWS;
import com.bootcamp.entities.Region;
import com.bootcamp.entities.Secteur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */
public class RegionHelper {

    public static RegionWS buildRegionWSObject(Region region) {
        RegionWS regionWS = new RegionWS();
        regionWS.setLatitude(region.getLatitude());
        regionWS.setLongitude(region.getLongitude());
        regionWS.setType(region.getType());
        regionWS.setNom(region.getNom());
        regionWS.setId(region.getId());

        return regionWS;
    }

    public static List<RegionWS> buildRegionWSList(List<Region> regions){
        List<RegionWS> result = new ArrayList<>();
        for(Region region:regions){
            result.add(buildRegionWSObject(region));
        }
        return result;
    }

}
