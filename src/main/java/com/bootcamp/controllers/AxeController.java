package com.bootcamp.controllers;

import com.bootcamp.commons.ws.usecases.pivotone.AxeWS;
import com.bootcamp.services.AxeService;
import com.bootcamp.version.ApiVersions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */
@RestController("AxeController")
@RequestMapping("/axes")
@Api(value = "Axe API", description = "Axe API")
@CrossOrigin(origins = "*")
public class AxeController {

    @Autowired
    AxeService axeService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiVersions({"1.0"})
    @ApiOperation(value = "get list of projects by Axe", notes = "get list of projects by Axe")
    public ResponseEntity<List<AxeWS>> getProjectsByAxes() throws IOException {
        List<AxeWS> axeWs = axeService.getAxes();
        return new ResponseEntity<List<AxeWS>>(axeWs, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiVersions({"1.0"})
    @ApiOperation(value = "One pilier", notes = "pilier by id")
    public ResponseEntity<AxeWS> getPilier(@PathVariable int id) throws IOException {
        AxeWS pilierWS = axeService.getAxe(id);
        return new ResponseEntity<AxeWS>(pilierWS, HttpStatus.OK);
    }
}
