package com.dev.bruno.projectManager.project.api;

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
