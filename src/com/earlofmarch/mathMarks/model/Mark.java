package com.earlofmarch.mathMarks.model;

import java.util.Calendar;

import org.jdom.Element;

/**
 * Represents a Mark that was given to a Student in an Expectation.
 * Marks are immutable; instead of changing them, delete them with
 * {@link Student#removeMark(Course, Mark)} and create a new one.
 * @author Hao Wei
 * @author Aly Hassan
 * @author Ian Dewan
 */
public class Mark implements Recordable {
	private Expectation expect;
	private String comment;
	private MarkLevel level;
	private MarkType type;
	private Calendar date;
	
	/**
	 * Creates a new Mark with the given properties.
	 * @param student The Student who was given this Mark.
	 * @param expect The expectation that this Mark is for.
	 * @param level The actual level the Mark represents (<i>e.g.</i> 3+).
	 * @param comment A comment on the Mark.
	 * @param date The date the marks was given.
	 * @param t The type of the mark.
	 */
	public Mark(Student student, Expectation expect, MarkLevel level, String comment,
			Calendar date, MarkType t)
	{
		this.expect = expect;
		this.level = level;
		this.comment = comment;
		this.date = date;
		this.type = t;
		student.addMark(expect.getCourse(), this);
	}
	
	/**
	 * Get the Expectation this Mark is for.
	 * @return The Expectation.
	 */
	public Expectation getExpectation()
	{
		return expect;
	}
	
	/**
	 * Get the level achieved.
	 * @return The level.
	 */
	public MarkLevel getLevel()
	{
		return level;
	}
	
	/**
	 * Get the comment given.
	 * @return The comment.
	 */
	public String getComment()
	{
		return comment;
	}
	
	/**
	 * Get the date the Mark was given.
	 * @return The date.
	 */
	public Calendar getDate() {
		return date;
	}
	
	/**
	 * Get the {@link MarkType} associated with this Mark.
	 * @return The type.
	 */
	public MarkType getType() {
		return type;
	}

	@Override
	public Element serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
