package ru.eugene.java.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;

@Configuration
@EnableMBeanExport
@Import({EhCacheConfiguration.class, PeriodicTaskConfiguration.class})
@ComponentScan(basePackages = {"ru.eugene.java.learn.service"})
public class SpringConfiguration {}
