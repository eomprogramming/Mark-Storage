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
	
	private JList list;
	private JScrollPane listPane;
	
	private JButton chooseButton, addButton;
	
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
		list.setVisible(false);
		list.setBackground(new Color(223,251,160));
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
		
		/*   MAKE THE ADD A CLASS BUTTON */		
		
		addButton = new JButton("Add a class");
		addButton.setFocusable(false);
		addButton.addActionListener(this);
		leftPanel.add(addButton);
		
		leftLayout.putConstraint(SpringLayout.NORTH, addButton, 20, 
				SpringLayout.NORTH, leftPanel);
		leftLayout.putConstraint(SpringLayout.WEST, addButton, 20, 
				SpringLayout.WEST, leftPanel);
		leftLayout.putConstraint(SpringLayout.EAST, addButton, -20, 
				SpringLayout.EAST, leftPanel);
		
		/*   MAKE THE CHOOSE A CLASS BUTTON */
	
		chooseButton = new JButton("Select a class");
		chooseButton.setFocusable(false);
		chooseButton.addActionListener(this);
		leftPanel.add(chooseButton);
		
		leftLayout.putConstraint(SpringLayout.NORTH, chooseButton, 10, 
				SpringLayout.SOUTH, addButton);
		leftLayout.putConstraint(SpringLayout.EAST, chooseButton, -20, 
				SpringLayout.EAST, leftPanel);
		leftLayout.putConstraint(SpringLayout.WEST, chooseButton, 20, 
				SpringLayout.WEST, leftPanel);
		
		leftLayout.putConstraint(SpringLayout.NORTH, list, 20, 
				SpringLayout.SOUTH, chooseButton);
		leftLayout.putConstraint(SpringLayout.NORTH, listPane, 20, 
				SpringLayout.SOUTH, chooseButton);
				
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(null);
		add(rightPanel);
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		
	}
	
	

}
