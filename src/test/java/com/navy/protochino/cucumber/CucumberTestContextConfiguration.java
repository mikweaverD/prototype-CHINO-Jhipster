package com.navy.protochino.cucumber;

import com.navy.protochino.ProtoChinoApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = ProtoChinoApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
