package com.jacaranda.primerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.Service.StudentService;
import com.jacaranda.primerSpring.model.Student;

@Controller
public class StudentController {
	
	//Solo se define el objeto, el lo creara cuando sea necesario
	@Autowired
	StudentService repositorio;

	@GetMapping("listStudent")
	//Recibe un modelo
	public String listStudent(Model model) {
		//Le añadimos un atributo, ahora puede usarlo en 
		//su plantilla o vista
		model.addAttribute("lista",repositorio.getLista());
		return "listStudent";
	}
	
	@GetMapping("addStudent")
	public String addStudent(Model model) {
		//Se crea el objeto
		Student student=new Student();
		
		//Se le pasa al modelo para que la plantilla lo utilice cuando le haga falta
		model.addAttribute("estudiante", student);
		return "addStudent";
	}
	
	@PostMapping("execAdd")
	//Recibe un estudiante que le ha mandado una vista
	public String execAdd(@ModelAttribute("estudiante")Student pepe) {
		//Añade ese estudiante
		repositorio.add(pepe);
		//Redirige de nuevo al de la lista
		return "redirect:/listStudent";
	}
	
	
	
	@GetMapping("delStudent")
	//Le paso que se requieren esos dos atributos cuando me llamen
	public String delStudent(Model model
			,@RequestParam(name="name") String name
			,@RequestParam(name="apellido") String apellido) {
		//Creo el student que voy a mostrar en la plantilla
		//con esos parametros
		Student student=repositorio.get(name, apellido);
		
		//Setteo a un atributo que se llama estudiante el student
		//Para que pueda usarse en la plantilla
		model.addAttribute("estudiante", student);
		return "borrarStudent";
	}
	
	@PostMapping("execDel")
	public String execdel(@ModelAttribute("estudiante")Student pepe) {
		repositorio.remove(pepe);
		return "redirect:/listStudent";
	}
	
	@GetMapping("updateStudent")
	public String updateStudent(Model model,
			@RequestParam(name="name")String name,
			@RequestParam(name="apellido")String apellido) {
			Student estudiante=repositorio.get(name, apellido);
			model.addAttribute("estudiante", estudiante);	
		
		return "updateStudent";
	}
	
	@PostMapping("execUpdate")
	public String execUpdate(Model model,Student updateado) {
		repositorio.update(updateado);
		return "redirect:/listStudent";
	}
}
