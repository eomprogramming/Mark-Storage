package mathMarks;

import org.jdom.Element;

public class Expectation implements Recordable {
	private Course course;
	private String name;
	private String description;
	
	/**
	 * 
	 * @param course
	 * @param name
	 * @param desc
	 */
	public Expectation(Course course, String name, String desc)
	{
		this.course = course;
		this.name = name;
		description = desc;
		course.addExpectations(this);
	}
	
	/**
	 * 
	 * @return
	 */
	public Course getCourse()
	{
		return course;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}
	
	@Override
	public boolean equals(Object e)
	{
		if (!(e instanceof Expectation)) {
			return false;
		} else {
			return ((Expectation)e).getCourse().equals(getCourse())
					&& ((Expectation)e).getName().equals(getName());
		}
	}

	@Override
	public Element serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
