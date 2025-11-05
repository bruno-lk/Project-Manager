package com.dev.bruno.projectManager.project.api;

import java.util.UUID;

public interface ICreateProjectUseCase {
    UUID execute(String name) throws Exception;
}
