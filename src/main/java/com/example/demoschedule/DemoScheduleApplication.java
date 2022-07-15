package com.example.demoschedule;

import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class DemoScheduleApplication{
    public static Timer t = new Timer();
    public static Map<Long, TimerTask> listTimerTask = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoScheduleApplication.class, args);
    }

    @GetMapping("/start")
    public void startSchedule(@RequestBody DataDTO dataDTO){
        System.out.println("start!");
        Long period = 2000L;
        TimerTask task = new Task(dataDTO.getData());
        t.schedule(task, new Date(), period);
        listTimerTask.put(dataDTO.getId(),task);
        System.out.println(t);
    }


    @GetMapping("/stop")
    public void stopSchedule(@RequestBody DataDTO dataDTO){

        TimerTask tt = listTimerTask.get(dataDTO.getId());
        System.out.println(tt);
        tt.cancel();
        System.out.println(t);
        System.out.println("stoped schedule!");
    }
}
