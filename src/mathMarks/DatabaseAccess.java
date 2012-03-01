package mathMarks;

import java.util.LinkedList;

public abstract class DatabaseAccess {
	public abstract Student getStudent(String id);
	public abstract Student newStudent(String id, String name, int grade);
	public abstract void deleteStudent(String id);
	public abstract Course getCourse(String code);
	public abstract Course newCourse(String code);
	public abstract void removeCourse(String code);
	public abstract Classroom getClassroom(int year, boolean semesterOne,
			String courseCode, String section);
	public abstract Classroom newClassroom(int year, boolean semesterOne,
			String courseCode, String section);
	public abstract void removeClassroom(int year, boolean semesterOne,
			String courseCode, String section);
	protected abstract void markAsChanged(Recordable id);
	public abstract void flushPartial();
	public abstract void flush();
	protected abstract LinkedList<Mark> loadMarks(Student student, Course course);
}
