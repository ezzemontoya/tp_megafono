package megafono.dao;

public interface DAO<T> {
	
	public void crear(T t);
	public void actualizar(T t);
	
	public void guardar(T t);
	public void eliminar(T t);
}
