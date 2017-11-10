package testPackage;

import org.springframework.beans.factory.annotation.Value;

public class TestModel {
	
	
	@Value ("${testString}")
	private String testString;
	
	@Value("#{myString}")
	private String myString;

	
	
	
	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}
	
	

}
