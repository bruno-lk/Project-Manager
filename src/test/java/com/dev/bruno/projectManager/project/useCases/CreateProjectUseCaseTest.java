package com.dev.bruno.projectManager.project.useCases;

import com.dev.bruno.projectManager.project.api.ICreateProjectUseCase;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
class CreateProjectUseCaseTest {

    @Test
    void executeTest() throws Exception {
        ICreateProjectUseCase useCase = new CreateProjectUseCase();

        UUID executed = useCase.execute("teste");

        assertNotNull(executed);
    }
}