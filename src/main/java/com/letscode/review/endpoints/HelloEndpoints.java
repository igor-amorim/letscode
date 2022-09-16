package com.letscode.review.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.letscode.review.service.HelloService;

@RestController
public class HelloEndpoints {

    @Autowired
    HelloService hello;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("Hello!", HttpStatus.OK);
    }

    @RequestMapping(path = "/hello/{nome}", method = RequestMethod.GET)
    public ResponseEntity<String> hello(@PathVariable String nome) {
        return new ResponseEntity<String>("Hello, " + nome + "!", HttpStatus.OK);
    }

    @RequestMapping(path = "/hello/{nome}/horario", method = RequestMethod.GET)
    public ResponseEntity<String> helloHorario(@PathVariable String nome) {
        return new ResponseEntity<String>("Hello, " + nome + "! Agora são " + hello.getHorario() + ", não esqueça!", HttpStatus.OK);
    }

}
