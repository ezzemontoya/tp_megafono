package megafono.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Tag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static private int id = 0;
	private Tag superior;
	private ArrayList<Tag> subTags;
	private String nombre;
	private int idTag;
	
	static private int getId(){
		return id++;
	}

	/**
	 * Constructor Vacio
	 */
	public Tag() {
		this.idTag=Tag.getId();
		this.superior = null;
		this.subTags = new ArrayList<Tag>();
		this.nombre = "";
	}

	/**
	 * Constructor solo con Nombre
	 * 
	 * @param nombre
	 */
	public Tag(String nombre) {
		this.idTag=Tag.getId();
		this.superior = null;
		this.subTags = new ArrayList<Tag>();
		this.nombre = nombre;
	}

	/**
	 * Constructor con nombre y superior
	 * 
	 * @param nombre
	 * @param superior
	 */
	public Tag(String nombre, Tag superior) {
		this.idTag=Tag.getId();
		this.superior = superior;
		this.subTags = new ArrayList<Tag>();
		this.nombre = nombre;
		superior.agregarTagHijo(this);
	}

	/**
	 * Agregar hijos al Tag
	 * 
	 * @param hijo
	 */
	public void agregarTagHijo(Tag hijo) {
		this.subTags.add(hijo);
		hijo.setSuperior(this);
	}

	/**
	 * Borrar hijos al Tag
	 */
	public void borrarTagHijo(Tag hijo) {
		this.subTags.remove(hijo);
		hijo.setSuperior(null);
	}
	
	@Override
	public String toString(){
		return this.nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((subTags == null) ? 0 : subTags.hashCode());
		result = prime * result + ((superior == null) ? 0 : superior.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag otro = (Tag) obj;
		if (nombre == null) {
			if (otro.nombre != null)
				return false;
		} else if (!nombre.equals(otro.nombre))
			return false;
		if (subTags == null) {
			if (otro.subTags != null)
				return false;
		} else if (!subTags.equals(otro.subTags))
			return false;
		if (superior == null) {
			if (otro.superior != null)
				return false;
		} else if (!superior.equals(otro.superior))
			return false;
		return true;
	}

	public Tag getSuperior() {
		return superior;
	}

	public void setSuperior(Tag superior) {
		this.superior.borrarTagHijo(this);
		this.superior = superior;
		this.superior.agregarTagHijo(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getIdTag(){
		return this.idTag;
	}
	
}
