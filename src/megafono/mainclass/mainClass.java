package megafono.mainclass;

import megafono.domain.model.Tag;
import megafono.services.TagServices;

public class mainClass {

	
	public static void main(String[] args) {
		Tag t = new Tag("Deporte");
		TagServices ts = TagServices.getTagService();
		ts.guardar(t);
	}
	

}
