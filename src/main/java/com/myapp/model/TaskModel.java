package com.myapp.model;

import java.util.Date;

public class TaskModel {
    private final int id;
    private String title;
    private String description;
    private boolean completed;
    private Date dueDate;
    private int priority;

    // Конструктор с параметрами для задания начальных значений
    public TaskModel(int id, String title, String description, Date dueDate, int priority) {
        this.id = id;                     // Присваиваем значение полю id при создании объекта
        this.title = title;               // Присваиваем значение полю title при создании объекта
        this.description = description;   // Присваиваем значение полю description
        this.dueDate = dueDate;
        this.priority = priority;
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

    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public void setPriority(int priority) { this.priority = priority; }

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

    public Date getDueDate() { return dueDate; }

    public int getPriority() { return priority; }

    public String getTaskInfo() {
        return "Id:" + id + " Название задачи: " + title + " Описание задачи: " + description + " (Complete: " + completed + ")" + " Дата выполнения "+ dueDate + " Приоритет: " + priority;
    }
}
