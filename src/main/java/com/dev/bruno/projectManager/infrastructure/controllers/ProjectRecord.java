package com.dev.bruno.projectManager.infrastructure.controllers;

import java.util.Date;
import java.util.UUID;

public record ProjectRecord(
        UUID id,
        String name,
        Date creationDate,
        Date conclusionDate,
        String status
) {
}
