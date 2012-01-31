package mathMarks;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
/**
 * 
 * @author Aly
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener{
	
	private ArrayList<String> students = new ArrayList<String>();
	private ArrayList<String> courses = new ArrayList<String>();
	private ArrayList<String> classes = new ArrayList<String>();
	
	private JList list;
	private JScrollPane listPane;
	
	private JComboBox coursesBox, classesBox;
	
	/**
	 * 
	 */
	public MainFrame(){
		super("Manage Students' Marks");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setMinimumSize(new Dimension(600,400));
		getContentPane().setBackground(new Color(217,255,125));
		setLayout(new GridLayout(1,2));

		UIManager.put("nimbusBase",new Color(161,254,77));
		UIManager.put("control", new Color(161,254,77));		
		UIManager.put("nimbusSelectionBackground",new Color(80,170,0)); 
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		setValues();
		createComponents();
		pack();
		repaint();
	}

	/**
	 * 
	 */
	private void setValues() {
		//read something
		courses.add("Select A Course");
		courses.add("Aly Course |  ALY4U");
		
		//read something
		classes.add("Select A Class");
		classes.add("Mr. ALYALYALY Period 3  |  ALY4U-02");
		
		//read something
		students.add("ALY");
		students.add("Aly improved");
		for(int i=0;i<20;i++)
			students.add("Student "+(i+1));
	}

	/**
	 * 
	 */
	private void createComponents() {
		
		JPanel leftPanel = new JPanel();
		SpringLayout leftLayout = new SpringLayout();
		leftPanel.setLayout(leftLayout);
		leftPanel.setBackground(null);
		add(leftPanel);
		
		/*   MAKE THE JLIST THAT DISPLAYS THE STUDENTS */
		
		DefaultListModel model = new DefaultListModel();
		for(String s : students)
			model.addElement(s);
		
		list = new JList(model);
		list.setFocusable(false);
		list.setBackground(new Color(223,251,160));
		list.setVisible(false);
		list.setBorder(BorderFactory.createLineBorder(new Color(80,170,0)));
		leftPanel.add(list);		
		
		leftLayout.putConstraint(SpringLayout.SOUTH, list, -20, 
				SpringLayout.SOUTH, leftPanel);
		leftLayout.putConstraint(SpringLayout.WEST, list,20, 
				SpringLayout.WEST, leftPanel);
		leftLayout.putConstraint(SpringLayout.EAST, list, -20, 
				SpringLayout.EAST, leftPanel);
		
		listPane = new JScrollPane(list);
		listPane.setOpaque(false);
		listPane.setVisible(list.isVisible());
		listPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		leftPanel.add(listPane);
				
		leftLayout.putConstraint(SpringLayout.SOUTH, listPane, -20, 
				SpringLayout.SOUTH, leftPanel);
		leftLayout.putConstraint(SpringLayout.WEST, listPane,20, 
				SpringLayout.WEST, leftPanel);
		leftLayout.putConstraint(SpringLayout.EAST, listPane, -20, 
				SpringLayout.EAST, leftPanel);
		
		/*   MAKE THE COURSES COMBO BOX */
		
		String[] courseChoices = new String[courses.size()];
		for(int i=0;i<courseChoices.length;i++)
			courseChoices[i] = courses.get(i);
		
		coursesBox = new JComboBox(courseChoices);
		coursesBox.setFocusable(false);
		coursesBox.addActionListener(this);
		leftPanel.add(coursesBox);
		
		leftLayout.putConstraint(SpringLayout.NORTH, coursesBox, 20, 
				SpringLayout.NORTH, leftPanel);
		leftLayout.putConstraint(SpringLayout.WEST, coursesBox, 20, 
				SpringLayout.WEST, leftPanel);
		
		/*   MAKE THE CLASSES COMBO BOX */
		
		String[] classChoices = new String[classes.size()];
		for(int i=0;i<classChoices.length;i++)
			classChoices[i] = classes.get(i);
		
		classesBox = new JComboBox(classChoices);
		classesBox.setFocusable(false);
		classesBox.setEnabled(false);
		classesBox.addActionListener(this);
		leftPanel.add(classesBox);
		
		leftLayout.putConstraint(SpringLayout.NORTH, classesBox, 10, 
				SpringLayout.SOUTH, coursesBox);
		leftLayout.putConstraint(SpringLayout.EAST, classesBox, -20, 
				SpringLayout.EAST, leftPanel);
		leftLayout.putConstraint(SpringLayout.WEST, classesBox, 20, 
				SpringLayout.WEST, leftPanel);
		
		leftLayout.putConstraint(SpringLayout.NORTH, list, 20, 
				SpringLayout.SOUTH, classesBox);
		leftLayout.putConstraint(SpringLayout.NORTH, listPane, 20, 
				SpringLayout.SOUTH, classesBox);
				
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(null);
		add(rightPanel);
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == coursesBox){
			if(coursesBox.getSelectedIndex()>0)
				classesBox.setEnabled(true);
			else{
				classesBox.setEnabled(false);
				classesBox.setSelectedIndex(0);
			}
		}else if(e.getSource() == classesBox){
			if(classesBox.getSelectedIndex()>0){
				list.setVisible(true);
				listPane.setVisible(list.isVisible());
			}else{
				list.setVisible(false);
				listPane.setVisible(list.isVisible());
			}
		}
	}
	
	

}
