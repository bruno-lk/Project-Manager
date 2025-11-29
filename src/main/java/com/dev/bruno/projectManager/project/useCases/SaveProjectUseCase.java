package com.dev.bruno.projectManager.project.useCases;

import com.dev.bruno.projectManager.infrastructure.configuration.DomainService;
import com.dev.bruno.projectManager.infrastructure.mongodb.MongoDBClient;
import com.dev.bruno.projectManager.project.spi.ISaveProject;
import com.dev.bruno.projectManager.project.spi.ProjectEntity;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

@DomainService
public class SaveProjectUseCase implements ISaveProject {

    private final MongoDBClient mongoDBClient;
    private MongoCollection<Document> docProjects;

    public SaveProjectUseCase(MongoDBClient mongoDBClient) {
        this.mongoDBClient = mongoDBClient;
        this.docProjects = mongoDBClient.getDatabase().getCollection("projects");
    }

    @Override
    public void save(ProjectEntity entity) {
        docProjects.insertOne(toDocument(entity));
        System.out.println("Projeto salvo no banco - ID: " + entity.getId());
    }

    public Document toDocument(ProjectEntity entity){
        return new Document("id", entity.getId())
                .append("name", entity.getName())
                .append("creationDate", entity.getCreationDate())
                .append("status", entity.getStatus());
    }
}
