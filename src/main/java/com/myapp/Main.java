package com.myapp;
import com.myapp.controller.TaskController;

import java.util.Scanner;


public class Main {


    public static void menuSelector(){
        Scanner in = new Scanner(System.in);
        TaskController taskController = new TaskController();
        while (true){
            System.out.println("""
                    Что вы хотите сделать?
                    1 - ввести задачу
                    2 - отобразить весь список задач
                    3 - отметить выполнение
                    4 - удалить задачу
                    е - закрыть приложение
                    """);
            switch (in.nextLine()){
                case "1":
                    // Ввод задачи
                    taskController.createTask();
                    break;
                case "2":
                    // Получить все задачи
                    taskController.listTasks();
                    break;
                case "3":
                    // Отметить выполнение задачи
                    taskController.completeTask();
                    break;
                case "4":
                    // Удаление задачи
                    taskController.deleteTask();
                    break;
                case "у":
                case "e":
                    // Закрываем Scanner
                    in.close();
                    return;
                default:
                    System.out.println("Вы ввели что-то не из пункта меню");
                    break;
            }

        }
    }

    public static void main(String[] args) {
        menuSelector();
        System.out.println("Программа закончила свое выполнение");
    }
}
