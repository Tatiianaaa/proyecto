package com.ejercicios.producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ejercicios.categorias.Categoria;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	@Column
	private int valor;
	
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Producto(Integer id, String nombre, int valor, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.categoria = categoria;
	}


	public Producto() {
		super();
	}


	public Producto(String nombre, int valor, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.categoria = categoria;
	}


	public Producto(Integer id) {
		super();
		this.id = id;
	}


	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}
	
}
