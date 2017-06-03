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
	 * Constructor solo con Nombre
	 * 
	 * @param nombre
	 */
	public Tag(String nombre) {
		this.idTag=Tag.getId();
		this.superior = null;
		this.subTags = new ArrayList<Tag>();
		this.nombre = nombre.toUpperCase();
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
		this.nombre = nombre.toUpperCase();
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
		String hijos = "";
		for(Tag t : this.subTags){
			hijos += t.toString();
		}
		return (this.nombre + "[" + hijos + "]").toUpperCase();
	}

	public Tag getSuperior() {
		return superior;
	}
	
	public String getNombreSuperior(){
		return this.superior.getNombre();
	}

	public void setSuperior(Tag superior) {
//		this.superior.borrarTagHijo(this);
		this.superior = superior;
//		this.superior.agregarTagHijo(this);
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
