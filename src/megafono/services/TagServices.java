package megafono.services;

import java.util.ArrayList;

import com.vaadin.ui.Tree;

import megafono.dao.implementacion.TagDAONeodatis;
import megafono.domain.model.Tag;

public class TagServices {

	private TagDAONeodatis tagDAO;
	private static TagServices tagService;

	private TagServices() {
		tagDAO = new TagDAONeodatis();
	}

	public static TagServices getTagService() {
		if (tagService == null) {
			tagService = new TagServices();
		}
		return tagService;
	}

	public void guardar(Tag tag) {
		tagDAO.guardar(tag);
	}

	public ArrayList<Tag> obtenerTags() {
		return tagDAO.obtenerTags();
	}

	public void procesarArbol(Tree arbol) {
		ArrayList<Tag> tags = this.obtenerTags();
		for (Tag t : tags){
			arbol.addItem(t.getNombre());
		}
		for (Tag t : tags){
			if(t.getSuperior() != null){
				arbol.setParent(t.getNombre(),t.getNombreSuperior());
			}
		}
	}

}
