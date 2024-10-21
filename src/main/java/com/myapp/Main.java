package com.myapp;
import com.myapp.controller.TaskController;

import java.nio.charset.Charset;
import java.util.Scanner;


public class Main {


    public static void menuSelector(){
        Scanner in = new Scanner(System.in);
        TaskController taskController = new TaskController();
        int id = 1;
        while (true){
            System.out.println("""
                    Что вы хотите сделать?
                    1 - ввести задачу
                    2 - отобразить весь список задач
                    3 - отметить выполнение
                    4 - удалить задачу
                    е - выйти из приложения
                    """);
            switch (in.nextLine()){
                case "1":
                    // Ввод задачи
                    taskController.createTask(id);
                    id++;
                    break;
                case "2":
                    taskController.listTasks();
                    break;
                case "3":
                    taskController.completeTask();
                    break;
                case "4":
                    taskController.deleteTask();
                    break;
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
        System.out.println("Текущая кодировка: " + Charset.defaultCharset().displayName());

        menuSelector();
        System.out.println("Программа закончила свое выполнение");
    }
}
