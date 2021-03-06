package facade;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.core.MultivaluedMap;

import model.Reporte;

@Local
public interface ReporteFacade {
	

	public void create(Reporte entity);

	public void edit(Reporte entity);

	public void remove(Reporte entity);

	public Reporte find(Object id);

	public List<Reporte> findAll();
	
	public List<Reporte> findAll(MultivaluedMap<String,String> queryParams);

	public List<Reporte> findRange(int[] range);

	public int count();

}