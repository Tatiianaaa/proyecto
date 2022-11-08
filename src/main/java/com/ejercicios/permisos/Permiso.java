package com.ejercicios.permisos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Permiso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, nullable = false, unique = true)
	private String namerol;
	@Column(length = 500, nullable = false, unique = true)
	private String descripcion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamerol() {
		return namerol;
	}

	public void setNamerol(String namerol) {
		this.namerol = namerol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Permiso() {
		super();
	}

	public Permiso(Integer id, String namerol, String descripcion) {
		super();
		this.id = id;
		this.namerol = namerol;
		this.descripcion = descripcion;
	}

	public Permiso(Integer id) {
		super();
		this.id = id;
	}

	public Permiso(String namerol) {
		super();
		this.namerol = namerol;
	}
	public Permiso( String namerol, String descripcion) {
		super();
		this.namerol = namerol;
		this.descripcion = descripcion;
	}
	
}
