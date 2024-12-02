package com.myapp.sevice;

import com.myapp.model.TaskModel;
import com.myapp.util.JsonSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<TaskModel> tasks;
    private final JsonSerializer serializer;

    protected void Serialize(List<TaskModel> tasks){
        try {
            // Сериализуем (сохраняем) обновлённый список задач в файл
            serializer.serializeTasks(tasks, "tasks.json");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи задач в файл", e);
        }
    }

    public TaskService() {
        this.serializer = new JsonSerializer();

        try {
            // Попытка десериализации задач из файла
            this.tasks = serializer.deserializeTasks("tasks.json");

            // Если tasks == null, инициализируем пустой список
            if (this.tasks == null) {
                this.tasks = new ArrayList<>();
                System.out.println("tasks.json не содержит задач. Инициализируем пустой список задач.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении tasks.json.");
        }
    }

    public void addTask(TaskModel task) {
        tasks.add(task);  // Добавляем новую задачу в список
        System.out.println("Задача добавлена");
        System.out.println("Id - " + task.getId());
        System.out.println("Название задачи - " + task.getTitle());
        System.out.println("Описание задачи - " + task.getDescription());
        System.out.println("Выполнение задачи - " + task.getCompleted() + "\n");

        Serialize(tasks);
    }

    // Метод для получения всех задач
    public List<TaskModel> getAllTasks() {
        if (tasks.isEmpty()){
            System.out.println("Список задач пуст");
        }
        return tasks;
    }

    public void markTaskAsComplete(int id) {
        if (id >= 0) {
            for (TaskModel i : tasks){
                if(i.getId() == id){
                    i.setCompleted(true);
                    Serialize(tasks);
                    break;
                }
            }
        }
    }
    public void deleteTask(int id) {
        if (id >= 0) {
            for (TaskModel i : tasks){
                if(i.getId() == id){
                    tasks.remove(i);
                    Serialize(tasks);
                    break;
                }
            }
        }
    }

}
