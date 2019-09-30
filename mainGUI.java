import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class mainGUI extends JFrame implements ActionListener,ItemListener { // 
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private JPanel parentPanel = new JPanel(new BorderLayout());
	private JPanel panelNewStudent = new JPanel(new BorderLayout());
	private JPanel panelButtons = new JPanel();
	private JPanel panelAddStudent = new JPanel();
	private JPanel panelShowStudent = new JPanel(new BorderLayout());
	private JPanel panelModules = new JPanel(new GridLayout(2, 1));
	private JLabel lblName = new JLabel("Name: ");
	private JLabel lblAddress = new JLabel("Address: ");
	private JTextField txtName = new JTextField("Peter Smith", 25);
	private JTextField txtAddress = new JTextField("35 Liffey Street, Dublin 2", 25);
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnClear = new JButton("Clear");
	private JLabel lblStudentList = new JLabel();
	private JTextArea txtShowStudent = new JTextArea(100,100);
	private JPanel panelCheckBoxes = new JPanel(new GridLayout(0, 1));
	private JCheckBox chkDB = new JCheckBox("Databases");
	private JCheckBox chkJava = new JCheckBox("Java");
	private JCheckBox chkAcct = new JCheckBox("Accountancy");
	private JTextArea txtCheck = new JTextArea(3, 16);
	private JButton btnFinish = new JButton("Finish");
	private JButton btnClearAll = new JButton("Clear all");
	boolean database = false;
	boolean java = false;
	boolean acct = false;

	public mainGUI() {
		createWindow();

	}

	public void createWindow() {
		panelShowStudent.add(txtShowStudent);
		panelShowStudent.add(lblStudentList);
		panelCheckBoxes.add(chkDB);
		chkDB.addActionListener(this);
		panelCheckBoxes.add(chkJava);
		chkJava.addActionListener(this);
		panelCheckBoxes.add(chkAcct);
		chkAcct.addActionListener(this);
		panelCheckBoxes.add(txtCheck);

		panelAddStudent.add(lblName);
		panelAddStudent.add(txtName);
		panelAddStudent.add(lblAddress);
		panelAddStudent.add(txtAddress);
		panelAddStudent.add(btnSubmit);
		btnSubmit.addActionListener(this);
		panelAddStudent.add(btnClear);
		btnClear.addActionListener(this);
		panelShowStudent.add(lblStudentList);
		panelShowStudent.add(txtShowStudent);
		
		panelCheckBoxes.add(chkDB);
		chkDB.addItemListener(this);
		panelCheckBoxes.add(chkJava);
		chkJava.addItemListener(this);
		panelCheckBoxes.add(chkAcct);
		chkAcct.addItemListener(this);
		panelCheckBoxes.add(txtCheck);
		panelModules.add(panelCheckBoxes);
		txtCheck.setSize(400, 500);
		panelNewStudent.add(panelAddStudent, BorderLayout.NORTH);
		panelNewStudent.add(panelShowStudent, BorderLayout.CENTER);
		panelNewStudent.add(panelModules, BorderLayout.EAST);

		panelButtons.add(btnFinish);
		btnFinish.addActionListener(this);
		panelButtons.add(btnClearAll);
		btnClearAll.addActionListener(this);
		
		parentPanel.add(panelNewStudent, BorderLayout.CENTER);
		parentPanel.add(panelButtons, BorderLayout.SOUTH);

		parentPanel.setBackground(Color.gray);
		
		add(parentPanel);
		setSize(1000, 600);
		setTitle("Student Information System");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		TitledBorder leftBorder = BorderFactory.createTitledBorder("New Student");
		leftBorder.setTitleJustification(TitledBorder.LEFT);
		panelNewStudent.setBorder(BorderFactory.createRaisedBevelBorder());
		panelNewStudent.setBorder(leftBorder);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSubmit) {
			String sName = txtName.getText();
			String sAddress = txtAddress.getText();
			boolean database, java, acct;
			if (chkDB.isSelected()) {
				database = true;
			} else {
				database = false;
			}
			if (chkJava.isSelected()) {
				java = true;
			} else {
				java = false;
			}
			if (chkAcct.isSelected()) {
				acct = true;
			} else {
				acct = false;
			}
			Student student = new Student(sName, sAddress, database, java, acct);
			studentList.add(student);
			txtShowStudent.setText(studentList.toString().replace("[","").replace("]",""));
		} else if (e.getSource() == btnClear) {
			txtName.setText("");
			txtAddress.setText("");
		} else if (e.getSource() == btnFinish) {
			System.exit(0);
		} else if (e.getSource() == btnClearAll) {
			txtName.setText("");
			txtAddress.setText("");
			txtShowStudent.setText("");
			txtCheck.setText("");
			chkDB.setSelected(false);
			chkJava.setSelected(false);
			chkAcct.setSelected(false);
			txtCheck.setText("");
		}
	}

	
		
		 public void itemStateChanged(ItemEvent e) {
		        
		        Object chkBox = e.getItemSelectable(); // Local variable will hold which checkbox(s) have been clicked
		 
		        if (chkBox == chkDB) { // If the database checkbox is clicked
		            
		        	txtCheck.append(chkDB.getText() + "\n"); //Database is appended to the text area below the checkboxes
		        }
		        
		        else if (chkBox == chkJava) { // If the java checkbox is clicked
		            
		        	txtCheck.append(chkJava.getText() + "\n"); //Java is appended to the text area below the checkboxes
		        }
		        
		        else if (chkBox == chkAcct) {// If the accountancy checkbox is clicked
		        	txtCheck.append(chkAcct.getText() + "\n");//Accountancy is appended to the text area below the checkboxes
		        }
		       
		        if (chkDB.isSelected()==false) { // If the checkbox is not or unclicked
		        	txtCheck.setText(txtCheck.getText().replace("Databases\n", "")); // The specified text is removed from the text area
		        }
		        if (chkJava.isSelected()==false) {
		        	txtCheck.setText(txtCheck.getText().replace("Java\n", "")); // The specified text is removed from the text area
		        }
		        if (chkAcct.isSelected()==false) {
		        	txtCheck.setText(txtCheck.getText().replace("Accountancy\n", "")); // The specified text is removed from the text area
		        }
		        
		 }

	public static void main(String[] args) {
		new mainGUI();

	}
}
