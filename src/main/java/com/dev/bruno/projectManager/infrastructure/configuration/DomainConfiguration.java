package com.dev.bruno.projectManager.infrastructure.configuration;

import com.dev.bruno.projectManager.project.useCases.CreateProjectUseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackageClasses = {CreateProjectUseCase.class},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class})})
public class DomainConfiguration {
}