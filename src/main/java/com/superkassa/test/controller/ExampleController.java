package com.superkassa.test.controller;

import com.superkassa.test.controller.dto.ExampleRequestDTO;
import com.superkassa.test.controller.dto.ExampleResponseDTO;
import com.superkassa.test.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping("/modify")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ExampleResponseDTO modify(@RequestBody ExampleRequestDTO exampleRequestDTO) {
        return exampleService.modify(exampleRequestDTO);
    }
}
