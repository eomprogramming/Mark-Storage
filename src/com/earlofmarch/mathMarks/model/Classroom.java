 package com.earlofmarch.mathMarks.model;

import java.util.LinkedList;
import java.util.logging.*;

import org.jdom.Element;

/**
 * Represents one class in the marks database. A class can be uniquely represented by
 * its course code and section, as well as the semester of its existence.
 * @author Hao Wei
 * @author Aly Hassan
 * @author Ian Dewan
 * @see DatabaseAccess#newClassroom(int, boolean, String, String)
 * @see DatabaseAccess#getClassroom(int, boolean, String, String)
 * @see DatabaseAccess#removeClassroom(int, boolean, String, String)
 */
public class Classroom implements Recordable {
	private DatabaseAccess creator;
	private Course course;
	private LinkedList<Student> student;
	private int year;
	private boolean semesterOne;
	private String section;
	
	/**
	 * Create a new Classroom. This constructor should only be called by DatabaseAccess
	 * subclasses.
	 * @param creator The DatabaseAccess that created this Classroom.
	 * @param course The course taught in this class.
	 * @param year The year in which the school year of this Classroom's existence
	 * started.
	 * @param semester True if this is semester one, false otherwise.
	 * @param section The section number.
	 * @see DatabaseAccess#newClassroom(int, boolean, String, String)
	 */
	protected Classroom(DatabaseAccess creator, Course course, int year,
			boolean semester, String section)
	{
		this.creator = creator;
		this.course = course;
		this.semesterOne = semester;
		this.section = section;
		this.year = year;		
	}
	
	/**
	 * Get the class name: the course code, a hyphen and then section number
	 * <i>e.g.</i> <code>CLN4U-01</code><br/>
	 * Usually used to identify the course in the database.
	 * @return The class name.
	 */
	public String getName() {
		return (course.getCode() + "-" + section);
	}
	
	/**
	 * Get an array containing all the students in this class.
	 * @return An array of all Students.
	 */
	public Student[] getStudents()
	{
		return (Student[]) student.toArray();
	}
	
	/**
	 * Get the year the school year that this class took place in began in.<br/>
	 * <i>N.B.</i> A class starting in February 2013 will have a year of 2012, because
	 * it is second semester.
	 * @return The year.
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Return whether or not this class takes/took place in semester one.
	 * @return True if semester one.
	 */
	public boolean getSemester() {
		return semesterOne;
	}
	
	/**
	 * Add a new Student to the class.
	 * @param student The Student to add.
	 * @see DatabaseAccess#getStudent(String)
	 */
	public void addStudent(Student student)
	{
		this.student.add(student);
		creator.markAsChanged(this);
	}
	
	/**
	 * Remove a Student from the class based on their index in the array returned by
	 * getStudents().
	 * Does nothing if the index is invalid.
	 * @param index The index.
	 * @see Classroom#getStudents()
	 */
	public void removeStudent(int index)
	{
		try {
			student.remove(index);
		} catch (IndexOutOfBoundsException e) {
			Logger.getLogger("com.earlofmarch.mathMarks").logp(Level.WARNING,
					"Classroom", "removeStudent",
					"Attempt to remove non-existent student.", e);
		}
		creator.markAsChanged(this);
	}
	
	/**
	 * Get the Course taught in this class.
	 * @return The Course.
	 */
	public Course getCourse(){
		return course;
	}

	@Override
	public Element serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
