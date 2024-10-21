package com.myapp.controller;

import com.myapp.model.TaskModel;
import com.myapp.sevice.TaskService;

import java.util.Scanner;

public class TaskController {
    private TaskService taskService;
    private Scanner scanner;

    public TaskController() {
        this.taskService = new TaskService();
        this.scanner = new Scanner(System.in);
    }

    // ИЗБЫТОЧНО НО МОЖЕТ ПРИГОДИТСЯ ПРИ ПОЯВЛЕНИИ ДРУГИХ ПОЛЕЙ
    // Универсальный метод для ввода значений
    public Object inputValue(String prompt, Class<?> type) {
        System.out.print(prompt);
        String input = scanner.nextLine();  // Ввод всех данных как строки

        // Преобразуем строку в нужный тип данных
        if (type == String.class) {
            return input;  // Если это строка, просто возвращаем введённую строку
        } else if (type == int.class) {
            return Integer.parseInt(input);  // Преобразование строки в целое число
        } else {
            return null;  // Для других типов можно добавить обработку
        }
    }


    public void createTask(int id) {
        String title = (String) inputValue("Enter task title: ", String.class);  // Ввод строки
        String description = (String) inputValue("Enter task description: ", String.class);  // Ввод строки

        // Создаём и возвращаем объект TaskModel
        taskService.addTask(new TaskModel(id, title, description));
    }

    public void listTasks() {
        for (TaskModel task : taskService.getAllTasks()) {
            System.out.println(task.getTaskInfo());
        }
    }

    public void completeTask() {
        System.out.print("Enter task index to mark as complete: ");
        int index = scanner.nextInt();
        taskService.markTaskAsComplete(index);
        System.out.println("TaskModel marked as complete!");
    }
    public void deleteTask() {
        System.out.print("Enter task index to mark as complete: ");
        int index = scanner.nextInt();
        taskService.deleteTask(index);
        System.out.println("Task deleted!");
    }

}
