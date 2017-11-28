package ba.biggy.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class TestModel {
	
	
	private int faultCount;
	private Fault fault;
	private List<Fault> faultList;
	
	
	public int getFaultCount() {
		return faultCount;
	}
	public void setFaultCount(int faultCount) {
		this.faultCount = faultCount;
	}
	public Fault getFault() {
		return fault;
	}
	public void setFault(Fault fault) {
		this.fault = fault;
	}
	public List<Fault> getFaultList() {
		return faultList;
	}
	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}
	
	

}
