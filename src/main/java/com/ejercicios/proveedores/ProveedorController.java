package com.ejercicios.proveedores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorController {
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("/proveedores")
	public String listarProveedores(Model modelo) {
		List<Proveedor> listaProveedores = proveedorRepository.findAll();
		modelo.addAttribute("listaProveedores", listaProveedores);
		return "proveedor/proveedores";
	}
	@GetMapping("/proveedores/nuevo")
	public String mostrarFormularioProveedor(Model modelo) {
		modelo.addAttribute("proveedor", new Proveedor());
		return "proveedor/prove_form";
	}
	
	@PostMapping("/proveedor/guardar")
	public String guardarProveedor(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
		return "redirect:/proveedores";
	}
	
	@GetMapping("/proveedor/editar/{id}")
	public String mostrarFormularioEditarProveedor(@PathVariable("id") Integer id,Model modelo) {
		Proveedor proveedor = proveedorRepository.findById(id).get();
		modelo.addAttribute("proveedor", proveedor);
		return "proveedor/prove_form";
	}
	
	@GetMapping("/proveedor/eliminar/{id}")
	public String eliminarProveedor(@PathVariable("id") Integer id,Model modelo) {
		proveedorRepository.deleteById(id);
		return "redirect:/proveedores";
	}
	
}
