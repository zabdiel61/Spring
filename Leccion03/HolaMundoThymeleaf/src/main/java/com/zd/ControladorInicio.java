package com.zd;

import com.zd.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String incio(Model model) {
        var msg = "Mensaje con thymeleaf jiji";
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@mail.com");
        persona.setTelefono("88775544");
        var persona2 = new Persona();
        persona2.setNombre("Karla");
        persona2.setApellido("GAomez");
        persona2.setEmail("KrGoz@mail.com");
        persona2.setTelefono("9558866");

//        var personas = new ArrayList();
//        personas.add(persona);
//        personas.add(persona2);
//        var personas = Arrays.asList(persona, persona2);
        var personas = new ArrayList();

        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("msg", msg);
        model.addAttribute("saludo", saludo);
//        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }
}
