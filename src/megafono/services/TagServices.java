package megafono.services;

import megafono.dao.TagDAO;
import megafono.dao.implementacion.TagDAONeodatis;
import megafono.domain.model.Tag;

public class TagServices {

	private TagDAO tagDAO;
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

	public void guardar(Tag tag){
		tagDAO.guardar(tag);
	}
	
}
