package com.ejercicios.proveedores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20,nullable = false)
	private String nombre;
	
	@Column(length = 20,nullable = false)
	private String apellido;
	
	private int telefono;
	
	@Column(length = 55,nullable = false)
	private String email;
	
	@Column(length = 15,nullable = false)
	private String estado;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Proveedor() {
		super();
	}

	public Proveedor(Integer id, String nombre, String apellido, int telefono, String email, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.estado = estado;
	}

	public Proveedor(Integer id) {
		super();
		this.id = id;
	}

	public Proveedor(String nombre, String apellido, int telefono, String email, String estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.estado = estado;
	}

	public Proveedor(String nombre) {
		super();
		this.nombre = nombre;
	}
}
