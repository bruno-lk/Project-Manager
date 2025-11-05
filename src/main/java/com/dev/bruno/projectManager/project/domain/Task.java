package com.dev.bruno.projectManager.project.domain;

import java.util.Date;
import java.util.UUID;

public class Task {
    UUID id;
    String name;
    Date creationDate;
    Date conclusionDate;
    Status status;
    Project project;

    public Task(String name, Date creationDate, Status status, Project project) {
        this.name = name;
        this.creationDate = creationDate;
        this.status = status;
        this.project = project;
    }

    public void createTask(String name, Project project) throws Exception {
        if (name == null || name.isEmpty()){
            throw new Exception("Nome inválido");
        }

        this.creationDate = new Date();
        this.id = UUID.randomUUID();
        this.name = name;
        this.project = project;
        this.status = Status.CREATED;
    }

    public void finishTask(Date conclusionDate) throws Exception {
        if (conclusionDate.before(this.creationDate)){
            throw new Exception("Data inválida");
        }

        this.conclusionDate = conclusionDate;
        this.status = Status.FINISHED;
    }

    public void cancelTask(Date conclusionDate) throws Exception {
        if (conclusionDate.before(this.creationDate)){
            throw new Exception("Data inválida");
        }

        this.conclusionDate = conclusionDate;
        this.status = Status.CANCELED;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getConclusionDate() {
        return conclusionDate;
    }

    public Status getStatus() {
        return status;
    }

    public Project getProject() {
        return project;
    }
}
