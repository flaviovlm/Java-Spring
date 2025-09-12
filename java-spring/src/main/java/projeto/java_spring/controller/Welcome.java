package projeto.java_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/senai")
public class Welcome {

    @GetMapping("/")
        public String mensagem (){
        return ("Bem - vindo!");
    }
    @GetMapping ("/dev")
     public String dev (){
        return ("Sou Flávio!");
    }

}
