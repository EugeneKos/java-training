package ru.eugene.java.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;

import ru.eugene.java.learn.service.impl.ExampleCacheServiceImpl;

@Configuration
@EnableMBeanExport
@Import(EhCacheConfiguration.class)
@ComponentScan(basePackageClasses = ExampleCacheServiceImpl.class)
public class SpringConfiguration {}
