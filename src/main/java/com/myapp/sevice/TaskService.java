package com.myapp.sevice;

import com.myapp.model.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<TaskModel> tasks;

    public TaskService(){
        this.tasks = new ArrayList<>();
    }
    public void addTask(TaskModel task) {
        tasks.add(task);
        System.out.println("Задача добавлена");
        System.out.println("Id - "+task.getId());
        System.out.println("Название задачи - " + task.getTitle());
        System.out.println("Описание задачи - " + task.getDescription());
        System.out.println("Выполнение задачи - " + task.getCompleted());
    }

    public List<TaskModel> getAllTasks() {
        return tasks;
    }

    public void markTaskAsComplete(int id) {
        if (id >= 0) {
            for (TaskModel i : tasks){
                if(i.getId() == id){
                    i.setCompleted(true);
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
                    break;
                }
            }
        }
    }

}
