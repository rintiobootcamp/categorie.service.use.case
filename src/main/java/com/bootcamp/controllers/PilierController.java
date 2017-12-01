package com.bootcamp.controllers;

import com.bootcamp.commons.ws.models.AxeUWs;
import com.bootcamp.commons.ws.usecases.pivotone.PilierWS;
import com.bootcamp.services.AxeService;
import com.bootcamp.services.PilierService;
import com.bootcamp.version.ApiVersions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */
@RestController("PilierController")
@RequestMapping("/piliers")
@Api(value = "Pilier API", description = "Pilier API")
public class PilierController {

    @Autowired
    PilierService pilierService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiVersions({"1.0"})
    @ApiOperation(value = "get list of pilier", notes = "get list of pilier")
    public ResponseEntity<List<PilierWS>> getPilierList() throws IOException {
        List<PilierWS> pilierWSS = pilierService.getPiliers();
        return new ResponseEntity<List<PilierWS>>(pilierWSS, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiVersions({"1.0"})
    @ApiOperation(value = "One pilier", notes = "pilier by id")
    public ResponseEntity<PilierWS> getPilier(@PathVariable int id) throws IOException {
        PilierWS pilierWS = pilierService.getPilier(id);
        return new ResponseEntity<PilierWS>(pilierWS, HttpStatus.OK);
    }
}
