package com.ejercicios.permisos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PermisosController {
	
	@Autowired
	private PermisoRepository permisoRepository;
	
	@GetMapping("/permisos")
	public String listarPermisos(Model modelo) {
		 List<Permiso> listaPermisos = permisoRepository.findAll(); 
		 modelo.addAttribute("listaPermisos", listaPermisos);
		 return "permiso/permisos";
		
	}

	@GetMapping("/permiso/crear")
	public String mostrarFormCrearPermiso(Model modelo) {
		modelo.addAttribute("permiso", new Permiso());
		return "permiso/permiso_form";
	} 
	
	@PostMapping("/permiso/guardar")
	public String guardarpermiso(Permiso permiso) {
		permisoRepository.save(permiso);
		return "redirect:/permisos";
		
	}
	@GetMapping("/permiso/editar/{id}")
	public String editarPermiso(@PathVariable("id") Integer id,Model modelo) {
		Permiso permiso = permisoRepository.findById(id).get();
		modelo.addAttribute("permiso", permiso);
		return "permiso/permiso_form";
	}
	@GetMapping("/permiso/eliminar/{id}")
	public String eliminarPermiso(@PathVariable("id") Integer id,Model modelo) {
		permisoRepository.deleteById(id);
		return "redirect:/permisos";
	}

}
