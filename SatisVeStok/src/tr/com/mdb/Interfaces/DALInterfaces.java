package tr.com.mdb.Interfaces;

import java.util.List;

public interface DALInterfaces<T> {

	void Insert(T entity);
	List<T> GetAll();
	void Delete(T entity);
	void Update(T entity);
	 List<T> GetById(int id);
}
