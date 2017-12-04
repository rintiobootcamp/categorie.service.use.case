package com.bootcamp.clientTest;

import com.bootcamp.commons.enums.EntityType;
import com.bootcamp.commons.ws.usecases.pivotone.NoteWS;

public class NoteClient {
    public static NoteWS getNote(EntityType type,int id){
        NoteWS noteWS = new NoteWS();
        noteWS.setEntityId(1);
        noteWS.setEntityType(type);
        noteWS.setNoteFiveCounts(2);
        noteWS.setNoteTwoCounts(3);
        noteWS.setNoteThreeCounts(2);
        noteWS.setNoteOneCounts(5);
        noteWS.setNoteOneCounts(4);
        noteWS.setNoteTwoCounts(5);
        noteWS.setMoyenne(9);
        return noteWS;
    }
}
