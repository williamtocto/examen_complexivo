package com.example.prueba_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("Titulo", "Enviar parametros de la ruta (@PathVariable)");
		return "variables/index";

	}
	
	@GetMapping("/String/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		
		model.addAttribute("Titulo", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es" + texto);
		return "variables/ver";

	}
	
	@GetMapping("/String/{texto}/{numero}")
	public String variables(@PathVariable String texto,Integer numero, Model model) {
		
		model.addAttribute("Titulo", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es" + texto + "y el numero enviado en el path es: " + numero);
		return "variables/ver";

	}
}
