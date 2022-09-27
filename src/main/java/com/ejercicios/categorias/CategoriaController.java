package com.ejercicios.categorias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categorias")
	public String listarCategorias(Model modelo){
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		modelo.addAttribute("listaCategorias", listaCategorias);
		return "categoria/categorias";
	}
	@GetMapping("/categorias/crear")
	public String mostrarFormCrearCategoria(Model modelo) {
		modelo.addAttribute("categoria", new Categoria());
		return "categoria/categoria_form";
	} 
	
	@PostMapping("/categoria/guardar")
	public String guardarcategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		return "redirect:/categorias";
		
	}
	@GetMapping("/categoria/editar/{id}")
	public String editarCategoria(@PathVariable("id") Integer id,Model modelo) {
		Categoria categoria = categoriaRepository.findById(id).get();
		modelo.addAttribute("categoria", categoria);
		return "categoria/categoria_form";
	}
	@GetMapping("/categoria/eliminar/{id}")
	public String eliminarCategoria(@PathVariable("id") Integer id,Model modelo) {
		categoriaRepository.deleteById(id);
		return "redirect:/categorias";
	}
	
}
