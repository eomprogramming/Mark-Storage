package com.earlofmarch.mathMarks.model;

import org.jdom.Element;

/**
 * This interface represents an item that can be recorded in the database.
 * @author Ian Dewan
 */
public interface Recordable {
	/**
	 * Get the database representation of the Recordable.
	 * @return This representation.
	 */
	public Element serialize();
}
