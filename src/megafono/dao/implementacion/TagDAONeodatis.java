package megafono.dao.implementacion;


import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

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

}
