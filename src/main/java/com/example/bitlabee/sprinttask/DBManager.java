package com.example.bitlabee.sprinttask;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Tasks> tasks = new ArrayList<>();
    static {
        tasks.add(new Tasks(1L,"Создать веб приложение на Java EE", "Нужно создать веб приложение на Java EE по Sprint Task.","2023-03-29"));
    }
    private static Long taskId = 2L;

    public static void addTask(Tasks task){
        task.setId(taskId);
        tasks.add(task);
        taskId++;
    }

    public static Tasks getTask(Long id){
        for (Tasks task: tasks){
            if (task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }

    public static ArrayList<Tasks> getTasks(){
        return tasks;
    }

    public static void deleteTask(Long id){
        for (Tasks task: tasks){
            if (task.getId().equals(id)){
                tasks.remove(task);
                break;
            }
        }
    }

    public static void editTask(Long id,String name,String description,String deadlineDate,boolean isDone){
        for (Tasks task: tasks){
            if (task.getId().equals(id)){
                task.setName(name);
                task.setDescription(description);
                task.setDeadlineDate(deadlineDate);
                task.setDone(isDone);
            }
        }
    }
}
