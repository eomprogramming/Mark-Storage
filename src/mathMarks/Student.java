package mathMarks;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Student {
	private String id;
	private String name;
	private int grade;
	//private LinkedList<Mark> marks;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param grade
	 */
	public Student(String id, String name, int grade)
	{
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	/**
	 * 
	 * @param name
	 * @param grade
	 */
	public void change(String name, int grade)
	{
		this.name = name;
		this.grade = grade;
	}
	
	/**
	 * 
	 */
	public void promoteGrade()
	{
		//not sure how this works
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
	public String getId()
	{
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getGrade()
	{
		return grade;
	}
	
	public LinkedList<Mark> getMarks(Classroom c, Expectation e)
	{
		LinkedList<Mark> marks = new LinkedList<Mark>();
		IO.openInputFile(c.getPath()+"\\"+e.getName()+"\\"+id+".mark");
		while(true){
			try {
				String mark = IO.readLine();			
				String comment = IO.readLine();
				if(mark==null||comment==null){
					IO.closeInputFile();
					break;
				}
				marks.offer(new Mark(e,mark,comment));
			} catch (Exception exp) {
				exp.printStackTrace();
				break;
			}
		}
		return marks;
	}
	
	/**
	 * 
	 * @return all marks for a given student
	 */
	public LinkedList<Mark> getAllMarks(Classroom c)
	{
		LinkedList<Expectation> expectations = c.getCourse().getExpectations();
		LinkedList<Mark> marks = new LinkedList<Mark>();		
		
		for(Expectation e : expectations){
			System.out.println(e.getName());
			IO.openInputFile(c.getPath()+"\\"+e.getName()+"\\"+id+".mark");
			while(true){
				try {
					String mark = IO.readLine();			
					String comment = IO.readLine();
					if(mark==null||comment==null){
						IO.closeInputFile();
						break;						
					}
					marks.offer(new Mark(e,mark,comment));
				} catch (Exception exp) {
					break;					
				}
			}
		}
		return marks;
	}
	
	/**
	 * adds mark to the correct expectation file
	 * @param mark
	 */
	public void addMark(Classroom c, Mark mark)
	{
		if (new File(c.getPath()+"\\"+mark.getExpectation().getName()+"\\"+id+".mark").exists())
			IO.createOutputFile(c.getPath()+"\\"+mark.getExpectation().getName()+"\\"+id+".mark",true);
		else
			IO.createOutputFile(c.getPath()+"\\"+mark.getExpectation().getName()+"\\"+id+".mark");
		
		IO.println(mark.getLevel());
		IO.println(mark.getComment());
		IO.closeOutputFile();
		
	}
	
	/**
	 * removes the last mark for a certain expectation
	 * @param index
	 */
	public void removeMark(Classroom c, Expectation expectation)
	{
		LinkedList <Mark> marks = getMarks(c,expectation);
		marks.removeLast();
		new File(c.getPath()+"\\"+expectation.getName()+"\\"+id+".mark").delete();
		for(Mark m : marks)
			addMark(c,m);
	}
}
