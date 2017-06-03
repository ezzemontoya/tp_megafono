package megafono.services;

import java.util.ArrayList;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
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
	
	public void procesarArbol(Tree arbol, ComboBox cb) {
		ArrayList<Tag> tags = this.obtenerTags();
		agregarTagsEn(arbol, tags);
		acomodarSuperiores(arbol, tags, cb);
	}

	private void agregarTagsEn(Tree arbol, ArrayList<Tag> tags) {
		for (Tag t : tags){
			arbol.addItem(t.getNombre());
		}
	}
	
	private void acomodarSuperiores(Tree arbol, ArrayList<Tag> tags, ComboBox cb) {
		for (Tag t : tags){
			if(t.getSuperior() != null){
				arbol.setParent(t.getNombre(),t.getNombreSuperior());
				cb.addItem(t.getNombreSuperior());
			}
		}
	}

	public void actualizarArbol (Tree arbol, String tag, ComboBox cb){
		String superior = cb.getValue().toString();
		if(tag == ""){
			Notification.show("Debe ingresar un tag para poder guardar", Type.TRAY_NOTIFICATION);
			return;
		}
		if(superior == "" && tag != ""){
			this.guardar(new Tag(tag));
			Notification.show("Se guardo el tag: " + tag, Type.TRAY_NOTIFICATION);
		}
		if(superior != "" & tag != "" ){
			this.guardar(new Tag(tag, new Tag(superior)));
			Notification.show("Se guardo el tag: " + tag +" en: " +superior, Type.TRAY_NOTIFICATION);
		}
		this.procesarArbol(arbol,cb);
	}
}
