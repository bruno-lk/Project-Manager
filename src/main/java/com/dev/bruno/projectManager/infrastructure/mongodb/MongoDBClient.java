package com.dev.bruno.projectManager.infrastructure.mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MongoDBClient {
    @Value("${mongodb.username}")
    private String USERNAME;
    @Value("${mongodb.password}")
    private String PASSWORD;
    @Value("${mongodb.cluster_url}")
    private String CLUSTER_URL;
    @Value("${mongodb.database_name}")
    private String DATABASE_NAME;

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBClient(){
        try {
            String connectionString = String.format("mongodb+srv://"+USERNAME+":"+PASSWORD+"@"+CLUSTER_URL +
                    "/?appName="+DATABASE_NAME);

            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .serverApi(serverApi)
                    .build();

            mongoClient = MongoClients.create(settings);

            try {
                database = mongoClient.getDatabase("admin");
//                    database.runCommand(new Document("ping", 1));
                System.out.println("Successfully connected to MongoDB!");
            } catch (MongoException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (MongoException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
