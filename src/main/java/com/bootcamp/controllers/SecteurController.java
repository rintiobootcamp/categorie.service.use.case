package com.bootcamp.controllers;

/**
 * Created by darextossa on 11/29/17.
 */

import com.bootcamp.commons.ws.usecases.pivotone.SecteurWS;
import com.bootcamp.services.SecteurService;
import com.bootcamp.version.ApiVersions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController("SecteurController")
@RequestMapping("/secteurs")
@CrossOrigin(origins = "*")
@Api(value = "Secteur API", description = "Secteur API")
public class SecteurController {

    @Autowired
    SecteurService secteurService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiVersions({"1.0"})
    @ApiOperation(value = "get list of pilier", notes = "get list of pilier")
    public ResponseEntity<List<SecteurWS>> getSecteurs() throws IOException {
        List<SecteurWS> secteurWSS = secteurService.getSecteur();
        return new ResponseEntity<List<SecteurWS>>(secteurWSS, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiVersions({"1.0"})
    @ApiOperation(value = "One pilier", notes = "pilier by id")
    public ResponseEntity<SecteurWS> getSecteur(@PathVariable int id) throws IOException {
        SecteurWS secteurWS = secteurService.getSecteur(id);
        return new ResponseEntity<SecteurWS>(secteurWS, HttpStatus.OK);
    }
}
