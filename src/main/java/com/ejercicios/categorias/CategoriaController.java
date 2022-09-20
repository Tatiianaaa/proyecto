package com.ejercicios.categorias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categorias")
	public String listarCategorias(Model modelo){
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		modelo.addAttribute("listaCategorias", listaCategorias);
		return "categorias";
	}
	@GetMapping("/categorias/crear")
	public String mostrarFormCrearCategoria(Model modelo) {
		modelo.addAttribute("categoria", new Categoria());
		return "categoria_form";
	} 
	
	@PostMapping("/categoria/guardar")
	public String guardarcategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		return "redirect:/categorias";
		
	}
	
	
	
}
