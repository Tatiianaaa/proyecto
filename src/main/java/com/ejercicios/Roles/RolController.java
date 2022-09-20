package com.ejercicios.Roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RolController {

	@Autowired
	private RolReposytory rolRepository;
	
	@GetMapping("/roles")
	public String listarRoles(Model modelo) {
		List<Rol> listaRoles = rolRepository.findAll();
		modelo.addAttribute("listaRoles", listaRoles);
		return "roles";
	}
	
	@GetMapping("/roles/nuevo")
	public String mostrarFormularioDeCrearRol(Model modelo) {
		modelo.addAttribute("rol", new Rol());
		return "rol_form";
	}
	@PostMapping("/rol/guardar")
	public String guardarRol(Rol rol) {
		rolRepository.save(rol);
		return "redirect:/roles";
	}
	@GetMapping("/rol/editar/{id}")
	public String mostrarFormularioDeEditarRol(@PathVariable("id") Integer id,Model modelo) {
		Rol rol = rolRepository.findById(id).get();
		modelo.addAttribute("rol", rol);
		return "rol_form";
	}
	
	@GetMapping("/rol/eliminar/{id}")
	public String eliminarRol(@PathVariable("id") Integer id,Model modelo) {
		rolRepository.deleteById(id);
		return "redirect:/roles";
	}
}
