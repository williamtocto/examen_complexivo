package com.example.prueba_web.controller;

import com.example.prueba_web.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/api")
public class IndexController {

    //@RequestMapping(value="/index", method=RequestMethod.GET)
    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("titulo", "Taller con Spring");
        return "index";

    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
    Usuario usuario = new Usuario();
    usuario.setNombre("William");
    usuario.setApellido("Fernando");
    usuario.setApellido("williamtocto@gmail.com");

    model.addAttribute("usuario",usuario);
    model.addAttribute("titulo","Perfil de usuario:".concat(usuario.getNombre()));

    return "perfil";

}

@RequestMapping("/listar")
public String listar(Model model){

    List<Usuario> usuarios=new ArrayList<>();

    usuarios.add(new Usuario ("Carmen", "Tacuri","tacurijuanita@hotmail.com"));
    usuarios.add(new Usuario ("Patricia", "Tacuri", "tacuripa@hotmail.com"));
    usuarios.add(new Usuario ("Juan", "Vintimilla", "jv@hotmail.com"));
    usuarios.add(new Usuario("Gabriel", "Velastegui", "gv@hotmail.com"));

    model.addAttribute("titulo", "Listado de Usuarios");
    model.addAttribute("usuarios", usuarios);


    return "listar";

}

    @RequestMapping("/ejemplo")
    public String ejemplo(Model model) {


        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){

        List<Usuario> usuarios = Arrays.asList(new Usuario("Juan","Inga","juan@gmail.com"),
                new Usuario("Pedro","Marquez","pedro@gmail.com"),
                new Usuario("Luis","Fernandez","luis@gmail.com"),
                new Usuario("Maria","Sanchez","pedro@gmail.com")
        );
        return usuarios;
    }



}
