package com.example.Controller;

import com.example.bean.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Simple hello endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Dua!";
    }

    // Greet endpoint with a name parameter
    @GetMapping("/greet/{name}")
    public Response greet(@PathVariable String name) {
        Response response=new Response();
          String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        response.setmessage("Hello "+name);
        response.settimestamp(timestamp);
        return response;
    }
}
