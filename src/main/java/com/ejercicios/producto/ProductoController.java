package com.ejercicios.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejercicios.categorias.Categoria;
import com.ejercicios.categorias.CategoriaRepository;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoRepository  productoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/producto/nuevo")
	public String formularioCrearProducto(Model modelo){
		
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		modelo.addAttribute("producto", new Producto());
		
		modelo.addAttribute("listaCategorias", listaCategorias);
		
		return "producto_form";
	}
	@PostMapping("/producto/guardar")
	public String guardarProducto(Producto producto){
		productoRepository.save(producto);
		return "redirect:/productos";
	}
	@GetMapping("/productos")
	public String listarProductos(Model modelo) {
		List<Producto>  listaProductos = productoRepository.findAll();
		modelo.addAttribute("listaProductos", listaProductos);
		
		return "productos";
	}
	@GetMapping("/producto/editar/{id}")
	public String editarProducto(@PathVariable("id") Integer id,Model modelo) {
		Producto producto = productoRepository.findById(id).get();
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		modelo.addAttribute("listaCategorias", listaCategorias);
		modelo.addAttribute("producto", producto);
		return "producto_form";
	}
	
	@GetMapping("/producto/eliminar/{id}")
	public String eliminarproducto(@PathVariable("id") Integer id,Model modelo) {
		productoRepository.deleteById(id);
		return "redirect:/productos";
	}
}
