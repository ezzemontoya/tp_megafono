package megafono.vistas;

import java.util.ArrayList;

import megafono.domain.model.Tag;

public class Auxiliar {

	public ArrayList<Tag> misTags = new ArrayList<Tag>();
	
	public Auxiliar(){
		
	}
	
	public void agregar (Tag t){
		this.misTags.add(t);
	}
	
	
}
