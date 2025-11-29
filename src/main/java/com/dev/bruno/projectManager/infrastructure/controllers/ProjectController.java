package com.dev.bruno.projectManager.infrastructure.controllers;

import com.dev.bruno.projectManager.project.api.ICreateProjectUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ICreateProjectUseCase createProjectUseCase;

    public ProjectController(ICreateProjectUseCase createProjectUseCase) {
        this.createProjectUseCase = createProjectUseCase;
    }

    @PostMapping
    public UUID CreateProject(@RequestBody ProjectRecord record) throws Exception {
        return createProjectUseCase.execute(record.name());
    }
}
