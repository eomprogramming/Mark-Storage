package mathMarks;

import java.util.LinkedList;

public class Course {
	public String code;
	private LinkedList<Expectation> expectations;
	
	/**
	 * 
	 * @param code
	 */
	public Course(String code)
	{
		this.code = code;
	}
	
	/**
	 * 
	 * @return
	 */
	public Expectation[] getExpectations()
	{
		return (Expectation[]) expectations.toArray();
	}
	
	/**
	 * 
	 * @param expect
	 */
	public void addExpectations(Expectation expect)
	{
		expectations.add(expect);
	}
	
	/**
	 * 
	 * @param index
	 */
	public void removeExpectation(int index)
	{
		expectations.remove(index);
	}
}
