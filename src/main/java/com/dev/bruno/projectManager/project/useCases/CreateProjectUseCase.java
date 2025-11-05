package com.dev.bruno.projectManager.project.useCases;

import com.dev.bruno.projectManager.infrastructure.configuration.DomainService;
import com.dev.bruno.projectManager.project.api.ICreateProjectUseCase;
import com.dev.bruno.projectManager.project.domain.Project;

import java.util.UUID;

@DomainService
public class CreateProjectUseCase implements ICreateProjectUseCase {

    public UUID execute(String name) throws Exception {
        if (name == null || name.isEmpty()){
            throw new Exception("Nome inválido");
        }

        Project newProject = new Project();
        newProject.createProject(name);

        return newProject.getId();
    }

}
