package com.estudos.JavaRestWithSpringBoot.Controllers;


import com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.PersonVO;
import com.estudos.JavaRestWithSpringBoot.Data.Vo.V2.PersonVOV2;
import com.estudos.JavaRestWithSpringBoot.Services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
@Tag(name = "People", description = "Endpoints for managing People")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds all people", description = "Finds all people", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonVO.class)))}),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Not found", responseCode = "404", content = {@Content}),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
    })
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds a person", description = "Finds a person", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = PersonVO.class)) }),
            @ApiResponse(description = "No Content", responseCode = "204", content = {@Content}),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Not found", responseCode = "404", content = {@Content}),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
    })
    public PersonVO findById(@PathVariable(value = "id") Long id ) throws  Exception {
        return service.findById(id);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Adds a new person", description = "adds a new person", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = PersonVO.class)) }),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
    })
    public PersonVO createPerson(@RequestBody PersonVO person) {
        return service.createPerson(person);
    }

    @PostMapping(value = "/v2", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Adds a new person", description = "adds a new person with birthDay",
            tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = PersonVO.class)) }),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
    })
    public PersonVOV2 createPersonV2(@RequestBody PersonVOV2 person) {
        return service.createPersonV2(person);
    }

    @PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Update a person", description = "Updated a person", tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = { @Content(schema = @Schema(implementation = PersonVO.class)) }),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            })
    public PersonVO updatePerson(@RequestBody PersonVO person) {
        return service.updatePerson(person);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "deletes a person", description = "deletes a person", tags = {"People"},
            responses = {
                    @ApiResponse(description = "No content", responseCode = "204", content = {@Content}),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            })
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id) {
        service.deletePerson(id);
        return  ResponseEntity.noContent().build();
    }
}
