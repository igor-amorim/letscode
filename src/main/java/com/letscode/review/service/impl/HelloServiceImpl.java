package com.letscode.review.service.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import com.letscode.review.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

    private LocalTime horario;

    @Override
    public String getHorario() {
        horario = LocalTime.now();
        return horario.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

}
