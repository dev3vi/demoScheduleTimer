package com.example.demoschedule;

import java.util.TimerTask;

public class Task extends TimerTask {

    private String data;

    public Task(String data) {
        System.out.println(data);
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println(data);
    }
}
