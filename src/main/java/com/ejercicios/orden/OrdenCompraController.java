package com.ejercicios.orden;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdenCompraController {
	@Autowired
	private OrdencompraRepository ordencompraRepository;
	
	@GetMapping("/orden")
	public String listarOrdenes(Model modelo) {
	List<Ordencompra> listaOrdencompras = ordencompraRepository.findAll();
	modelo.addAttribute("listaOrdencompras", listaOrdencompras);
	
	return "ordenes";
	}
}
