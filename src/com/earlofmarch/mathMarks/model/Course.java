package com.earlofmarch.mathMarks.model;

import java.util.LinkedList;

import org.jdom.Element;

/**
 * This class represents a course (<i>e.g.</i> SPH4UR) that students can take.
 * @author Hao Wei
 * @author Aly Hassan
 * @author Ian Dewan
 */
public class Course implements Recordable {
	private DatabaseAccess creator;
	private String code;
	private LinkedList<Expectation> expectations;
	
	/**
	 * Create a new Course. This method should be called only by DatabaseAccess
	 * subclasses.
	 * @param creator The DatabaseAccess that created this Course.
	 * @param code This Course's course code.
	 * @see DatabaseAccess#newCourse(String)
	 */
	protected Course(DatabaseAccess creator, String code)
	{
		this.code = code;
		this.creator = creator;
	}
	
	/**
	 * Get this Course's course code.
	 * @return The code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Get all Expectations in this Course in an array.
	 * @return All the Expectations.
	 */
	public Expectation[] getExpectations()
	{
		return expectations.toArray(new Expectation[] {});
	}
	
	/**
	 * Add an new Expectation to this Course. Do not call this method directly: use the
	 * constructor of Expectation instead.
	 * @param expect The Expectation to add.
	 * @see Expectation#Expectation(Course, String, String)
	 */
	protected void addExpectations(Expectation expect)
	{
		expectations.add(expect);
		creator.markAsChanged(this);
	}
	
	/**
	 * Delete an Expectation by its index in the array returned by getExpectations().
	 * @param index The index.
	 * @see Course#getExpectations()
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
