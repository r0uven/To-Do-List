package com.myapp.controller;

import com.myapp.model.TaskModel;
import com.myapp.sevice.TaskService;
import com.myapp.sevice.InputService;

import java.util.Date;

public class TaskController {
    private final TaskService taskService = new TaskService();
    private final InputService inputService = new InputService();  // Новый сервис для обработки ввода

    // Метод для создания задачи
    public void createTask(int id) {
        String title = inputService.getString("Введите название задачи: ");
        String description = inputService.getString("Введите описание задачи: ");
        Date dueDate = inputService.getDate("Введите дату в формате dd.MM.yyyy: ");
        int priority = inputService.getInt("Введите приоритет задачи: ");

        taskService.addTask(new TaskModel(id, title, description, dueDate, priority));
    }

    // Метод для вывода всех задач
    public void listTasks() {
        for (TaskModel task : taskService.getAllTasks()) {

            System.out.println(task.getTaskInfo());
        }
        System.out.println();
    }

    // Метод для завершения задачи
    public void completeTask() {
        int taskId = inputService.getInt("Введите ID задачи для завершения: ");
        taskService.markTaskAsComplete(taskId);
        System.out.println("Задача с ID " + taskId + " завершена!\n");
    }

    // Метод для удаления задачи
    public void deleteTask() {
        int taskId = inputService.getInt("Введите ID задачи для удаления: ");
        taskService.deleteTask(taskId);
        System.out.println("Задача с ID " + taskId + " удалена!\n");
    }

}
