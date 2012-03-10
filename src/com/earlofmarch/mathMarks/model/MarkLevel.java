package com.earlofmarch.mathMarks.model;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.logging.*;

/**
 * Represents a possible level a {@link Mark} can have.
 * This includes both ordinary mark levels and the learning
 * skill style levels (excellent, good, etc.).
 * @author Ian Dewan
 */
public class MarkLevel implements Comparable<MarkLevel> {
	private String label;
	private boolean trueMark;
	private static HashMap<String,MarkLevel> levelByName = new HashMap<String, MarkLevel>();
	public static final MarkLevel FOUR_PLUS_PLUS = new MarkLevel("4++", true);
	public static final MarkLevel FOUR_PLUS = new MarkLevel("4+", true);
	public static final MarkLevel FOUR = new MarkLevel("4", true);
	public static final MarkLevel FOUR_MINUS = new MarkLevel("4-", true);
	public static final MarkLevel THREE_PLUS = new MarkLevel("3+", true);
	public static final MarkLevel THREE = new MarkLevel("3", true);
	public static final MarkLevel THREE_MINUS = new MarkLevel("3-", true);
	public static final MarkLevel TWO_PLUS = new MarkLevel("2+", true);
	public static final MarkLevel TWO = new MarkLevel("2", true);
	public static final MarkLevel TWO_MINUS = new MarkLevel("2-", true);
	public static final MarkLevel ONE_PLUS = new MarkLevel("1+", true);
	public static final MarkLevel ONE = new MarkLevel("1", true);
	public static final MarkLevel ONE_MINUS = new MarkLevel("1-", true);
	public static final MarkLevel R = new MarkLevel("R", true);
	public static final MarkLevel EXCELLENT = new MarkLevel("E", false);
	public static final MarkLevel GOOD = new MarkLevel("G", false);
	public static final MarkLevel SATISFACTORY = new MarkLevel("S", false);
	public static final MarkLevel NEEDS_IMPROVEMENT = new MarkLevel("N", false);
	
	static {
		Object val;
		int mods;
		for (Field f: MarkLevel.class.getFields()) {
			mods = f.getModifiers();
			if (Modifier.isFinal(mods) && Modifier.isStatic(mods) && Modifier.isPublic(mods)) {
				try {
					val = f.get(null);
				} catch (IllegalAccessException e) {
					// This is an indicator of a coming apocalypse; it _cannot_ happen.
					Logger.getLogger("com.earlofmarch.mathMarks").logp(Level.SEVERE, "MarkLevel",
							"<clinit>", "It's the end of the world! Run!");
					continue;
				}
				levelByName.put(((MarkLevel) val).getLabel(), ((MarkLevel) val));
			}
		}
	}
	
	/**
	 * Create a new MarkLevel.
	 * @param disp The commonly used name or label for the level.
	 * @param tm Whether the level is a "true mark" used for actual
	 * evaluations, as opposed to learning skill style levels.
	 */
	private MarkLevel(String disp, boolean tm) {
		this.label = disp;
		this.trueMark = tm;
	}
	
	/**
	 * Get the human readable mark label.
	 * @return The label.
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Return whether or not the MarkLevel is a true (evaluation)
	 * mark.
	 * @return True or false.`
	 */
	public boolean isTrueMark() {
		return trueMark;
	}
	
	/**
	 * Compare two <b>text</b> mark levels (<i>e.g.</i> 4+ and 2-).
	 * @param a The first level.
	 * @param b The Second level.
	 * @return 1 if a &gt; b,<br/>
	 * 0 if a = b,<br/>
	 * -1 if a &lt; b
	 */
	public static int compareLevels(String a, String b)
	{
		a = a.trim();
		b = b.trim();
		
		if(a.substring(0, 1).compareTo(b.substring(0, 1)) > 0)
			return 1;
		if(a.substring(0, 1).compareTo(b.substring(0, 1)) < 0)
			return -1;
		if(a.length() == 2 && b.length() == 2)
		{
			if(a.substring(1, 2).compareTo(b.substring(1, 2)) < 0)
				return 1;
			if(a.substring(1, 2).compareTo(b.substring(1, 2)) > 0)
				return -1;
		}
		if(a.length() == 1 && b.length() == 2)
		{
			if(b.substring(1, 2).equals("+"))
				return -1;
			if(b.substring(1, 2).equals("-"))
				return 1;
		}
		if(a.length() == 2 && b.length() == 1)
		{
			if(a.substring(1, 2).equals("+"))
				return 1;
			if(a.substring(1, 2).equals("-"))
				return -1;
		}
		return 0;
	}
	
	/**
	 * Get a level by its name/label.
	 * @param l The label
	 * @return The level
	 */
	public static MarkLevel getByLabel(String l) {
		return levelByName.get(l);
	}

	@Override
	public int compareTo(MarkLevel o) {
		return compareLevels(this.getLabel(), o.getLabel());
	}
}
