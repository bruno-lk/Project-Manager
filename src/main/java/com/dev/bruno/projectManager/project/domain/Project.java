package com.dev.bruno.projectManager.project.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Project {
    public UUID id;
    String name;
    Date creationDate;
    Date conclusionDate;
    public Status status;
//    List<Task> taskList;

    public Project(UUID id, String name, Date creationDate, Date conclusionDate, Status status) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.conclusionDate = conclusionDate;
        this.status = status;
//        this.taskList = taskList;
    }

    public Project() {
    }

    public void createProject(String name) {
        this.creationDate = new Date();
        this.id = UUID.randomUUID();
        this.name = name;
        this.status = Status.CREATED;
//        this.taskList = new ArrayList<>();
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
//                ", taskList=" + taskList +
                '}';
    }

//    public List<Task> getTaskList() {
//        return taskList;
//    }
}