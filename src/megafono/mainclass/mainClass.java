package megafono.mainclass;

import megafono.domain.model.Tag;
import megafono.services.TagServices;

public class mainClass {

	public static void main(String[] args) {
		Tag t = new Tag("Futbol");
		Tag b = new Tag("Tenis");
		Tag d = new Tag("Deporte");
		d.agregarTagHijo(t);
		d.agregarTagHijo(b);
		TagServices ts = TagServices.getTagService();
		ts.guardar(d);
	}

}
