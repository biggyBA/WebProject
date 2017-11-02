package ba.biggy.dao;

import java.util.List;

import ba.biggy.model.Fault;

public interface FaultDAO {
	
	public void saveOrUpdate (Fault fault);
	
	public List<Fault> listToDoFaults();
	
	public List<Fault> listFaultsByServiceman (String serviceman);
	
	public Fault getFaultById (int faultId);
	
	public void archiveFault (int faultId);
	
	public void deleteFault (int faultId);
	
	public int toDoFaultCount();
}
