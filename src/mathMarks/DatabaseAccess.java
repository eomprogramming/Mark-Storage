package mathMarks;

import java.util.LinkedList;

import javax.management.openmbean.KeyAlreadyExistsException;

/**
 * The DatabaseAccess class provides access to the marks storage databases through
 * various channels.
 * @author Ian Dewan
 *
 */
public abstract class DatabaseAccess {
	/**
	 * Get the Student with the given id from the database, if that Student exists.
	 * @param id The Student id.
	 * @return the Student, or null if no such Student exists.
	 */
	public abstract Student getStudent(String id);
	
	/**
	 * Create a new Student with the given attributes.
	 * @param id The Student id (must be unique)
	 * @param name The Student's name.
	 * @param grade The Student's grade (a number from 1-4)
	 * @return The new Student
	 * @throws KeyAlreadyExistsException if the id is already in use.
	 * @throws IllegalArgumentException if the grade is outside the specified range.
	 */
	public abstract Student newStudent(String id, String name, int grade)
			throws KeyAlreadyExistsException, IllegalArgumentException;
	
	/**
	 * Remove the given Student from the database.
	 * @param id The Student's id.
	 */
	public abstract void deleteStudent(String id);
	
	/**
	 * Get the Course with the given code from the database, if that Course exists.
	 * @param code The course code.
	 * @return the Course, or null if no such Course exists.
	 */
	public abstract Course getCourse(String code);
	
	/**
	 * Create a new Course with the given code.
	 * @param id The course code (must be unique)
	 * @return The new Course
	 * @throws KeyAlreadyExistsException if the code is already in use.
	 */
	public abstract Course newCourse(String code) throws KeyAlreadyExistsException;
	
	/**
	 * Remove the given Course from the database.
	 * @param id The Course's code.
	 */
	public abstract void removeCourse(String code);
	
	/**
	 * Get the Classroom identified by the given information from the database, if it
	 * exists.
	 * @param courseCode The course taught in this class.
	 * @param year The year in which the school year of this Classroom's existence
	 * started.
	 * @param semester True if this is semester one, false otherwise.
	 * @param section The section number.
	 * @return The Classroom, or null if it does not exist.
	 */
	public abstract Classroom getClassroom(int year, boolean semesterOne,
			String courseCode, String section);
	
	/**
	 * Create a new Classroom with the given properties.
	 * @return The new Classroom
	 * @throws KeyAlreadyExistsException if an identical Classroom already exists.
	 */
	public abstract Classroom newClassroom(int year, boolean semesterOne,
			String courseCode, String section) throws KeyAlreadyExistsException;
	
	/**
	 * Remove the Classroom with the given properties from the database.
	 */
	public abstract void removeClassroom(int year, boolean semesterOne,
			String courseCode, String section);
	
	/**
	 * Mark the given Recordable for writing out to the database.
	 * @param id The Recordable to write.
	 */
	protected abstract void markAsChanged(Recordable id);
	
	/**
	 * Flush some of the dirty records to the database.
	 */
	public abstract void flushPartial();
	
	/**
	 * Flush all of the dirty records to the database.
	 */
	public abstract void flush();
	
	/**
	 * Read all the marks for the given Student in the given Course from the database.
	 * @param student The Student.
	 * @param course The Course.
	 * @return A list of all the marks.
	 */
	protected abstract LinkedList<Mark> loadMarks(Student student, Course course);
}
