package megafono.dao.implementacion;

import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import megafono.dao.TagDAO;
import megafono.domain.model.Tag;

public class TagDAONeodatis extends DAONeodatis<Tag> implements TagDAO {

	public void guardar(Tag tag) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("tags");
			odb.store(tag);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public ArrayList<Tag> obtenerTags() {
		ODB odb = null;
		ArrayList<Tag> guardados = new ArrayList<Tag>();
		try {
			odb = ODBFactory.open("tags");
			Objects<Tag> tags = odb.getObjects(Tag.class);
			for (Tag t : tags){
				guardados.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
		return guardados;
	}

}
