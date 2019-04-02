package com.example.demo;

import com.example.demo.brug.BrugController;
import com.example.demo.brug.BrugNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    BrugController brugController;


    @Test
    public void testFindAll() {
        Assertions.assertThatThrownBy(() -> brugController.findAll()).isInstanceOf(BrugNotFoundException.class);
    }
}
