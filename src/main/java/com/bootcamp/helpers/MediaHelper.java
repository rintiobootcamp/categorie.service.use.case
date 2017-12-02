package com.bootcamp.helpers;

import com.bootcamp.client.MediaClient;
import com.bootcamp.commons.ws.usecases.pivotone.AxeWS;
import com.bootcamp.commons.ws.usecases.pivotone.MediaWs;
import com.bootcamp.commons.ws.usecases.pivotone.SecteurWS;
import com.bootcamp.entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */
public class MediaHelper {

    public static List<MediaWs> buildMediaWsObject(List<Media> medias) {
        List<MediaWs> mediaWss = new ArrayList<>();

        for(Media media: medias){
            MediaWs mediaWs = new MediaWs();

            mediaWs.setId(media.getId());
            mediaWs.setLien(media.getLien());
            mediaWs.setType(media.getType());

            mediaWss.add(mediaWs);
        }

        return mediaWss;
    }


    public static List<MediaWs> addMedia(int entityId, String entityType) throws IOException {
        MediaClient mediaClient = new MediaClient();
        List<Media> medias = mediaClient.getByEntityTypeAndEntityId(entityId, entityType);

        return MediaHelper.buildMediaWsObject(medias);

    }



}
