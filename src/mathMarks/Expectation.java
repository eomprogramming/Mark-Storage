package mathMarks;

import org.jdom.Element;

/**
 * This class represents a course expectation for which a Student may recieve marks.
 * Expectations are immutable; rather than changing them, delete them with
 * {@link Course#removeExpectation()} and create a new one.
 * @author Hao Wei
 * @author Aly Hassan
 * @author Ian Dewan
 */
public class Expectation implements Recordable {
	private Course course;
	private String name;
	private String description;
	
	/**
	 * Create a new Expectation with the given properties.
	 * @param course The Course this Expectation id for.
	 * @param name The (short) Expectation name.
	 * @param desc A longer description of the Expectation.
	 */
	public Expectation(Course course, String name, String desc)
	{
		this.course = course;
		this.name = name;
		description = desc;
		course.addExpectations(this);
	}
	
	/**
	 * Get the Course this Expectation is for.
	 * @return The Course.
	 */
	public Course getCourse()
	{
		return course;
	}
	
	/**
	 * Get this Expectation's name.
	 * @return The name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get this Expectation's description.
	 * @return The description.
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
