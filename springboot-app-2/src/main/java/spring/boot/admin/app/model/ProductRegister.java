package spring.boot.admin.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Productos")
public class ProductRegister implements Serializable{
	private static final long seriaVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String cantidad;
	@NotEmpty
	private String stock;
	@NotEmpty
	private String precio;
	@NotEmpty
	private String marca;
	public ProductRegister(Long id, String nombre, String cantidad, String stock, String precio, String marca) {
		Id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.stock = stock;
		this.precio = precio;
		this.marca = marca;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public ProductRegister() {
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public static long getSeriaversionuid() {
		return seriaVersionUID;
	}
}
