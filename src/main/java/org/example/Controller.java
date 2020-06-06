package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping(value = "message")
    public void postMessage(@RequestBody Message message) {
        service.postMessage(message);
    }
}
