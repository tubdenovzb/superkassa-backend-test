package com.superkassa.test.controller;

import com.superkassa.test.controller.dto.ExampleRequestDTO;
import com.superkassa.test.controller.dto.ExampleResponseDTO;
import com.superkassa.test.service.ExampleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping("/modify")
    @ApiOperation("Modifying 'current' field")
    public ExampleResponseDTO modify(@RequestBody ExampleRequestDTO exampleRequestDTO) {
        return exampleService.modify(exampleRequestDTO);
    }
}
