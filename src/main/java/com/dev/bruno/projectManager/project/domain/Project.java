package com.dev.bruno.projectManager.project.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Project {
    UUID id;
    String name;
    Date creationDate;
    Date conclusionDate;
    Status status;
    List<Task> taskList;

    public Project(String name, Date creationDate, Status status) {
        this.name = name;
        this.creationDate = creationDate;
        this.status = status;
    }

    public Project() {
    }

    public void createProject(String name) {
        this.creationDate = new Date();
        this.id = UUID.randomUUID();
        this.name = name;
        this.status = Status.CREATED;
    }

    public void finishProject(Date conclusionDate) throws Exception {
        if (conclusionDate == null || conclusionDate.before(this.creationDate)){
            throw new Exception("Data inválida");
        }

        this.conclusionDate = conclusionDate;
        this.status = Status.FINISHED;
    }

    public void cancelProject(Date conclusionDate) throws Exception {
        if (conclusionDate == null || conclusionDate.before(this.creationDate)){
            throw new Exception("Data inválida");
        }

        this.conclusionDate = conclusionDate;
        this.status = Status.CANCELED;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", conclusionDate=" + conclusionDate +
                ", status=" + status +
                ", taskList=" + taskList +
                '}';
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

    public List<Task> getTaskList() {
        return taskList;
    }
}