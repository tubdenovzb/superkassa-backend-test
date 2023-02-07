package com.superkassa.test;

import com.superkassa.test.controller.dto.ExampleRequestDTO;
import com.superkassa.test.controller.dto.ExampleResponseDTO;
import com.superkassa.test.entity.Example;
import com.superkassa.test.entity.MyJson;
import com.superkassa.test.exception.ExampleNotFoundException;
import com.superkassa.test.repository.ExampleRepository;
import com.superkassa.test.service.ExampleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ExampleServiceTest {

    private static final Integer ID = 1;

    private static final MyJson OBJ = new MyJson(17);

    Example example = new Example(ID, OBJ);

    @Mock
    private ExampleRepository exampleRepository;

    @InjectMocks
    private ExampleService exampleService;

    @Test
    public void exampleServiceTest_withAdd() {
        ExampleRequestDTO exampleRequestDTO = ExampleRequestDTO.builder().id(ID).add(3).build();
        Mockito.when(exampleRepository.findById(exampleRequestDTO.getId())).thenReturn(Optional.ofNullable(example));
        ExampleResponseDTO modify = exampleService.modify(exampleRequestDTO);
        Assertions.assertThat(modify.getCurrent()).isEqualTo(20);
    }

    @Test
    public void exampleServiceTest_exception() {
        ExampleRequestDTO exampleRequestDTO = ExampleRequestDTO.builder().id(ID).add(3).build();
        Mockito.when(exampleRepository.findById(exampleRequestDTO.getId())).thenReturn(Optional.empty());
        RuntimeException thr = (RuntimeException) Assertions.catchThrowable(() -> exampleService.modify(exampleRequestDTO));
        Assertions.assertThat(thr).isInstanceOf(ExampleNotFoundException.class);
        String err = String.format("Unable to find example by id:" + exampleRequestDTO.getId());
        Assertions.assertThat(thr.getMessage()).isEqualTo(err);
    }
}
