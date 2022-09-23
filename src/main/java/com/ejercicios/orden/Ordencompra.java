package com.ejercicios.orden;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.ejercicios.producto.Producto;

@Entity
@Table(name = "ordencompra")
public class Ordencompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private int cantidad;

	@Column
	private int total;

	@Column
	private String estado;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaentrada;

	@ManyToMany
	@JoinTable(name = "orden_producto", joinColumns = @JoinColumn(name = "orden_id"), inverseJoinColumns = @JoinColumn(name = "producto_id"))
	private Set<Producto> productos = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaentrada() {
		return fechaentrada;
	}

	public void setFechaentrada(Date fechaentrada) {
		this.fechaentrada = fechaentrada;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Ordencompra(Integer id, int cantidad, int total, String estado, Date fechaentrada, Set<Producto> productos) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.total = total;
		this.estado = estado;
		this.fechaentrada = fechaentrada;
		this.productos = productos;
	}

	public Ordencompra() {
		super();
	}

	public Ordencompra(int cantidad, int total, String estado, Date fechaentrada, Set<Producto> productos) {
		super();
		this.cantidad = cantidad;
		this.total = total;
		this.estado = estado;
		this.fechaentrada = fechaentrada;
		this.productos = productos;
	}

}
