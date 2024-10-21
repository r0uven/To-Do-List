package com.myapp.model;

public class TaskModel {
    private final int id;
    private String title;
    private String description;
    private boolean completed;
    
    // Конструктор с параметрами для задания начальных значений
    public TaskModel(int id, String title, String description) {
        this.id = id;                     // Присваиваем значение полю id при создании объекта
        this.title = title;               // Присваиваем значение полю title при создании объекта
        this.description = description;   // Присваиваем значение полю description
        this.completed = false;           // По умолчанию задача считается не выполненной
    }

    // Сеттеры для возможности изменения значений полей позже
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Геттеры для доступа к значениям полей
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }

    public String getTaskInfo() {
        return "Id:" + id + " TaskModel: " + title + " - " + description + " (Complete: " + completed + ")";
    }
}
