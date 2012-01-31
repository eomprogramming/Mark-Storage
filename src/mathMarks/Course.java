package mathMarks;

import java.util.LinkedList;

public class Course {
	public String code;
	private LinkedList<Expectation> expectations;
	
	public Course(String code)
	{
		this.code = code; 
	}
	
	public Expectation[] getExpectations()
	{
		return (Expectation[]) expectations.toArray();
	}
	
	public void addExpectations(Expectation expect)
	{
		expectations.offer(expect);
	}
	
	public void removeExpectation(int index)
	{
		expectations.remove(index);
	}
}
