package com.fizzbuzz.backend.api.controllers;

import com.fizzbuzz.backend.api.core.FizzBuzz;
import com.fizzbuzz.backend.model.objects.Entry;
import com.fizzbuzz.backend.model.services.interfaces.IEntryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Controller for fizz requests
 * - getFizz computes the fizzbuzz and stores entry in db
 * - getFizzStats returns the most occured fizz entry asked
 */
@RestController
@Component
@Api(value = "FizzController", description = "Provides routes for computing fizz and stats")
public class FizzController {

    @ApiOperation(value = "Computes fizz", response = Stream.class)
    @GetMapping("/v1/getFizz")
    public Stream<String> getFizz(
            @ApiParam(value = "First int to match", required = true) @RequestParam(value = "int1") int int1,
            @ApiParam(value = "Second int to match", required = true) @RequestParam(value = "int2") int int2,
            @ApiParam(value = "Limit of fizz", required = true) @RequestParam(value = "limit") int limit,
            @ApiParam(value = "String to put for first int", required = true) @RequestParam(value = "str1") String str1,
            @ApiParam(value = "String to put for second int", required = true) @RequestParam(value = "str2") String str2
    ) {
        //save asked fizz in db
        Entry entry = entryService.save(int1, int2, limit, str1, str2);
        logger.info("asking fizz for entry : " + entry.getName());
        return FizzBuzz.getFizzBuzz(int1, int2, limit, str1, str2);
    }

    @ApiOperation(value = "Get fizz stats", response = Stream.class)
    @GetMapping("/v1/getFizzStats")
    public Entry getFizzStats() {
        Entry entry = entryService.getMostOccured();
        logger.info("asking for most occured fizz : " + entry.getName());
        return entry;
    }

    @Autowired
    private IEntryService entryService;

    private Logger logger = LoggerFactory.getLogger(FizzController.class);
}
