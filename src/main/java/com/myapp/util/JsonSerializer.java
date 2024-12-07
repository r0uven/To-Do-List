package com.myapp.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myapp.model.TaskModel;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class JsonSerializer {
    private final Gson gson = new Gson();


    private void check_file_exists(String filePath) throws IOException {
        File file = new File(filePath);

        // Проверка, существует ли родительская директория
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs(); // Создать директории, если их нет
        }

        // Создание файла, если его нет
        if (!file.exists()) {
            file.createNewFile(); // Создать файл
        }
    }

    public void serializeTasks(List<TaskModel> tasks, String filePath) throws IOException {
        check_file_exists(filePath);

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(tasks, writer);
        }
    }

    public List<TaskModel> deserializeTasks(String filePath) throws IOException {
        check_file_exists(filePath);

        try (FileReader reader = new FileReader(filePath)) {
            Type tasksListType = new TypeToken<List<TaskModel>>(){}.getType();
            return gson.fromJson(reader, tasksListType);
        }
    }
}