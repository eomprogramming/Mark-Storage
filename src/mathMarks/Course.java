package mathMarks;

import java.util.LinkedList;

import org.jdom.Element;

public class Course implements Recordable {
	private DatabaseAccess creator;
	private String code;
	private LinkedList<Expectation> expectations;
	
	/**
	 * 
	 * @param code
	 */
	protected Course(DatabaseAccess creator, String code)
	{
		this.code = code;
		this.creator = creator;
	}
	
	public String getCode() {
		return code;
	}
	
	/**
	 * 
	 * @return
	 */
	public Expectation[] getExpectations()
	{
		return expectations.toArray(new Expectation[] {});
	}
	
	/**
	 * 
	 * @param expect
	 */
	protected void addExpectations(Expectation expect)
	{
		expectations.add(expect);
		creator.markAsChanged(this);
	}
	
	/**
	 * 
	 * @param index
	 */
	public void removeExpectation(int index)
	{
		expectations.remove(index);
		creator.markAsChanged(this);
	}

	@Override
	public Element serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
