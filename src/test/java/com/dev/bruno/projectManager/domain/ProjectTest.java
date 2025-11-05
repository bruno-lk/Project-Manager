package com.dev.bruno.projectManager.domain;

import com.dev.bruno.projectManager.project.domain.Project;
import com.dev.bruno.projectManager.project.domain.Status;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void createProjectTest() {
        String name = "TEST NAME";

        Project testProject = new Project();
        testProject.createProject(name);

        assertSame(Status.CREATED, testProject.getStatus());
    }

    @Test
    void finishProject() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss z");

        String dateInString = "05/11/2013 11:21:38 BRT";
        Date date = formatter.parse(dateInString);

        Project testProject = new Project("name",date,Status.CREATED);
        testProject.finishProject(new Date());

        assertSame(Status.FINISHED, testProject.getStatus());
    }

    @Test
    void cancelProject() {
    }
}