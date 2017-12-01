package com.bootcamp.helpers;

import com.bootcamp.commons.ws.usecases.pivotone.RegionWS;
import com.bootcamp.commons.ws.usecases.pivotone.SecteurWS;
import com.bootcamp.entities.Region;
import com.bootcamp.entities.Secteur;

/**
 * Created by darextossa on 11/29/17.
 */
public class RegionHelper {

    public static RegionWS buildRegionWSObject(Region region) {
        RegionWS regionWS = new RegionWS();


        return regionWS;
    }

}
