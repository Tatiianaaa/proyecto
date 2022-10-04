package com.ejercicios.orden;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejercicios.producto.Producto;
import com.ejercicios.producto.ProductoRepository;
import com.ejercicios.proveedores.Proveedor;
import com.ejercicios.proveedores.ProveedorRepository;

@Controller
public class OrdenCompraController {
	@Autowired
	private OrdencompraRepository ordencompraRepository;
	
	@Autowired
	private ProductoRepository productoRepository; 
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("/orden")
	public String listarOrdenes(Model modelo) {
	List<Ordencompra> listaOrdencompras = ordencompraRepository.findAll();
	modelo.addAttribute("listaOrdencompras", listaOrdencompras);
	
	return "orden/ordenes";
	}
	@GetMapping("/ordenes/crear")
	public String registrarNuevaOrden(Model modelo) {
		List<Producto> listaProductos = productoRepository.findAll();
		List<Proveedor> listaProveedores = proveedorRepository.findAll();
		modelo.addAttribute("listaProveedores", listaProveedores);
		modelo.addAttribute("listaProductos", listaProductos);
		modelo.addAttribute("ordencompra", new Ordencompra());
		return "ordenform";
	}
	@PostMapping("/orden/guardar")
	public String guardarNuevaOrden(Ordencompra ordencompra) {
		ordencompraRepository.save(ordencompra);
		return "redirect:/orden";
	}
}
