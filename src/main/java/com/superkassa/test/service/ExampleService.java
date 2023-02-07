package com.superkassa.test.service;

import com.superkassa.test.controller.dto.ExampleRequestDTO;
import com.superkassa.test.controller.dto.ExampleResponseDTO;
import com.superkassa.test.entity.Example;
import com.superkassa.test.entity.MyJson;
import com.superkassa.test.exception.ExampleNotFoundException;
import com.superkassa.test.repository.ExampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ExampleService {

    private final ExampleRepository exampleRepository;

    @Autowired
    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @Transactional
    public ExampleResponseDTO modify(ExampleRequestDTO exampleRequestDTO) {
        log.info("Request body with id {} and add value {}", exampleRequestDTO.getId(), exampleRequestDTO.getAdd());
        Example example = exampleRepository.findById(exampleRequestDTO.getId())
                .orElseThrow(() -> new ExampleNotFoundException("Unable to find example by id:" + exampleRequestDTO.getId()));
        MyJson myJson = new MyJson(example.getObj().getCurrent() + exampleRequestDTO.getAdd());
        example.setObj(myJson);
        exampleRepository.save(example);
        return new ExampleResponseDTO(myJson.getCurrent());
    }
}
