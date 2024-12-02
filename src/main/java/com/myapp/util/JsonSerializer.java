package com.myapp.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myapp.model.TaskModel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class JsonSerializer {
    private final Gson gson = new Gson();

    public void serializeTasks(List<TaskModel> tasks, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(tasks, writer);
        }
    }

    public List<TaskModel> deserializeTasks(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            Type tasksListType = new TypeToken<List<TaskModel>>(){}.getType();
            return gson.fromJson(reader, tasksListType);
        }
    }
}