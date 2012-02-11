package mathMarks;

import java.io.IOException;
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
		//readExpectationsFromfile();
	}
	
	public void readExpectationsFromfile()
	{
		String path = DatabaseAccess.getLocation().getName() + "\\" + "Courses" + code + ".txt";
		LinkedList<String> expectations = new LinkedList<String>();
		String s;
		for(;;)
		{
			IO.openInputFile(path);
			try {
				s = IO.readLine();
				if(s == null)
				{
					IO.closeInputFile();
					break;
				}
				expectations.add(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//THE ABOVE CODE NEEDS FIXING!
	//	this.expectations = expectations;
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
	
	public void saveChanges()
	{
		
	}
}
