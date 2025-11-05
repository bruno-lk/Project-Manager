package com.dev.bruno.projectManager.domain;

public enum Status {
    CREATED("Criado"),
    IN_PROGRESS("Em progresso"),
    FINISHED("Concluído"),
    CANCELED("Cancelado");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Status{" +
                "value='" + value + '\'' +
                '}';
    }
}
