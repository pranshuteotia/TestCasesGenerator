package generator.GUI;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import generator.eventHandlers.NumBtnHandler;
import generator.eventHandlers.StrBtnHandler;

public class GUI {
	
	private JFrame frame;
	
	// All the Panels.
	private JPanel typePanel;
	private JPanel argumentsPanel;
	
	// Type Buttons
	private JButton num;
	private JButton string;
	
	// JTextFields
	private JTextField field1;
	private JTextField field2;
	private JTextField testCases;
	private JTextField fileName;
	
	// Generate Test Cases button
	private JButton generate;
	
	public GUI() {
		
		// Initializing and setting up the JFrame.
		frame = new JFrame("Test Cases Generator");
		frame.setSize(300, 500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Initializing and setting up the type panel.
		typePanel = new JPanel();
		typePanel.setLayout(new GridLayout(2, 2));
		
		// Initializing and setting up the type buttons.
		num = new JButton("Number");
		num.addActionListener(new NumBtnHandler(this));
		string = new JButton("String");
		string.addActionListener(new StrBtnHandler(this));
		
		// Adding type buttons to the type panel.
		typePanel.add(num);
		typePanel.add(string);
		
		// Initializing the arguments Panel.
		argumentsPanel = new JPanel();
		argumentsPanel = buildArgumentsPanel("number");
		
		// Adding everything to the Frame.
		frame.add(typePanel);
		frame.add(argumentsPanel);
		
		frame.setVisible(true);
	}
	
	JPanel buildArgumentsPanel(String str) {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		
		switch(str) {
			case "number":
				pnl = numberPanel();
				break;
			
			default:
				System.out.println("Invalid Argument");
				break;
		}
		
		pnl.add(new JLabel("Test Cases"));
		testCases = new JTextField("100", 10);
		pnl.add(testCases);
		pnl.add(new JLabel("Filename"));
		fileName = new JTextField("data.in");
		pnl.add(fileName);
		generate = new JButton("Generate");
		pnl.add(generate);
		
		
		return pnl;
	}
	
	JPanel numberPanel() {
		JPanel pnl = new JPanel();
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		
		pnl.add(new JLabel("Lower Bound"));
		field1 = new JTextField("0", 10);
		pnl.add(field1);
		pnl.add(new JLabel("Upper Bound"));
		field2 = new JTextField("100", 10);
		pnl.add(field2);
		
		return pnl;
	}
	
	void update() {
		frame.validate();
	}
}
