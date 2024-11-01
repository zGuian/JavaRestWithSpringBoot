package com.estudos.JavaRestWithSpringBoot.Controllers;

import com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.BookVO;
import com.estudos.JavaRestWithSpringBoot.Services.BookServices;
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
@RequestMapping("api/v1/books")
@Tag(name = "Books", description = "Endpoint for books")
public class BooksController {

    @Autowired
    private BookServices services;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Find a book", description = "find a book", tags = {"Books"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BookVO.class)))}),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Not found", responseCode = "404", content = {@Content}),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
    })
    public List<BookVO> findAll() {
        return services.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Find a book", description = "find a book", tags = {"Books"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = BookVO.class)) }),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Not found", responseCode = "404", content = {@Content}),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
    })
    public BookVO findById(@PathVariable(value = "id") int id){
        return services.findById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "create a book", description = "create a book", tags = {"Books"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = BookVO.class))}),
            @ApiResponse(description = "No content", responseCode = "204", content = {@Content}),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
    })
    public BookVO createBook(BookVO bookVO) {
        return services.createBook(bookVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "delete a book", description = "delete a book", tags = {"Books"}, responses = {
            @ApiResponse(description = "No content", responseCode = "204",
                    content = {@Content(schema = @Schema(implementation = BookVO.class))}),
            @ApiResponse(description = "No content", responseCode = "204", content = {@Content}),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
    })
    public BookVO updateBook(BookVO bookVO) {
        return services.updateBook(bookVO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "create a book", description = "create a book", tags = {"Books"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = BookVO.class))}),
            @ApiResponse(description = "No content", responseCode = "204", content = {@Content}),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
    })
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") int id) {
        services.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
