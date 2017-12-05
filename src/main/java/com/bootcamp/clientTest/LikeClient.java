package com.bootcamp.clientTest;

import com.bootcamp.commons.enums.EntityType;
import com.bootcamp.commons.ws.usecases.pivotone.LikeWS;

public class LikeClient {
    public static LikeWS getLike(EntityType type,int id){
        LikeWS likeWS =  new LikeWS();
        likeWS.setLike(2);
        likeWS.setUnlike(3);
        return likeWS;
    }
}
