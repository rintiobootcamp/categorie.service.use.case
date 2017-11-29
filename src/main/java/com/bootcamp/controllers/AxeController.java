package com.bootcamp.controllers;

import com.bootcamp.commons.ws.models.AxeUWs;
import com.bootcamp.services.AxeService;
import com.bootcamp.version.ApiVersions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by darextossa on 11/29/17.
 */
@RestController("AxeController")
@RequestMapping("/axe")
@Api(value = "Axe API", description = "Axe API")
public class AxeController {

    @Autowired
    AxeService axeService;

    @RequestMapping(method = RequestMethod.GET, value = "/projects")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "get list of projects by Axe", notes = "get list of projects by Axe")
    public ResponseEntity<List<AxeUWs>> getProjectsByAxes() throws IOException {
        List<AxeUWs> axeUWs = axeService.getProjectByAxes();
        return new ResponseEntity<List<AxeUWs>>(axeUWs, HttpStatus.OK);
    }
}
