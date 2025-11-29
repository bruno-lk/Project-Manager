package com.dev.bruno.projectManager.project.spi;

import com.dev.bruno.projectManager.project.domain.Project;
import com.dev.bruno.projectManager.project.domain.Status;
import com.dev.bruno.projectManager.project.domain.Task;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ProjectEntity {
    UUID id;
    String name;
    Date creationDate;
    Date conclusionDate;
    Status status;

    public ProjectEntity(UUID id, String name, Date creationDate, Date conclusionDate, Status status, List<Task> taskList) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.conclusionDate = conclusionDate;
        this.status = status;
    }

    public Project mapToDomain(ProjectEntity entity){
        return new Project(entity.id,
                entity.name,
                entity.creationDate,
                entity.conclusionDate,
                entity.status);
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", conclusionDate=" + conclusionDate +
                ", status=" + status +
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
}
