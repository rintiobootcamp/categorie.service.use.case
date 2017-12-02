package com.bootcamp.helpers;

import com.bootcamp.commons.ws.usecases.pivotone.PhaseWS;
import com.bootcamp.commons.ws.usecases.pivotone.RegionWS;
import com.bootcamp.entities.Phase;
import com.bootcamp.entities.Region;

/**
 * Created by darextossa on 11/29/17.
 */
public class PhaseHelper {

    public static PhaseWS buildPhaseWSObject(Phase phase) {
        PhaseWS phaseWS = new PhaseWS();
        phaseWS.setDateFin(phase.getDateFin());
        phaseWS.setDateDebut(phase.getDateDebut());
        phaseWS.setNom(phase.getNom());
        phaseWS.setId(phase.getId());
        phaseWS.setActif(phase.isActif());
        return phaseWS;
    }

}
