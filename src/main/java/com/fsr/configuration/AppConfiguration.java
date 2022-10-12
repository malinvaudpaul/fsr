package com.fsr.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// si je veux int�grer une config XML venant de mon legacy, j'utilise l'@ImportResource
// @ImportResource(locations = {"classpath:spring/app-context-xml.xml"})

@ImportResource(locations = {"classpath:applicationContext.xml"})
@ComponentScan(basePackages = {"com.fsr.*"})
@Configuration
public class AppConfiguration {

  // plus rien dans la classe Java, juste une indication ou scanner les beans
}
