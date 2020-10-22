package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mashape.unirest.http.Unirest;

@RestController
@RequestMapping( "api" )
@CrossOrigin(origins = "*")
public class TaskController {
    //https://taskplannerieti.azurewebsites.net/api/list-tasks?code=7Fsi5lElz3ImDt3a4ne9KqDaRhbvV/pNfVexRdvTa/1ZySexKBZYnw==
    @Autowired
    ObjectMapper mapperJson;

    @GetMapping
    public ResponseEntity<?> getAllTask() {
        String allTasks = null;
        try {
            allTasks = Unirest.get("https://taskplannerieti.azurewebsites.net/api/list-tasks?code=7Fsi5lElz3ImDt3a4ne9KqDaRhbvV/pNfVexRdvTa/1ZySexKBZYnw==")
                    .asString().getBody();
        } catch (UnirestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody Task task){
        try {
            Unirest.post("https://taskplannerieti.azurewebsites.net/api/list-tasks?code=7Fsi5lElz3ImDt3a4ne9KqDaRhbvV/pNfVexRdvTa/1ZySexKBZYnw==")
                    .header("Content-Type","application/json")
                    .body(mapperJson.writeValueAsString(task)).asString().getStatus();
        } catch (UnirestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}



