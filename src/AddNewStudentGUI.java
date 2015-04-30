//	AddNewStudentGUI.java by Kyle Wolff and Brandon VanderMey on 4/30/2015

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

// CREATE TABLE Students (StudentNumber CHAR(7) NOT NULL PRIMARY KEY, FirstName CHAR(15), LastName CHAR(25), MajorCode CHAR(3))

@SuppressWarnings("serial")
public class AddNewStudentGUI extends JFrame
{	
	static AddNewStudentGUI viewer;
	
	JTextField txtStudentNumber;
	JTextField txtStudentFName;
	JTextField txtStudentLName;
	JTextField txtMajorCode;
	
	JLabel lblStudentNumber;
	JLabel lblStudentFName;
	JLabel lblStudentLName;
	JLabel lblMajorCode;
	
	JButton btnAdd;
	JButton btnCancel;
	
	JPanel pnlMain;
	JPanel pnlInfo;
	JPanel pnlButtons;
	
	public AddNewStudentGUI()
	{
		super("Add New Student");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		
		createPanel();
		
		add(pnlMain);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void createPanel()
	{
		pnlMain = new JPanel(new BorderLayout());

		pnlButtons = new JPanel();
		
		pnlInfo = new JPanel(new GridLayout(0, 2, 5, 2));
		Border inside = BorderFactory.createTitledBorder("Test");
		Border outside = new EmptyBorder(5, 5, 5, 5);
		pnlInfo.setBorder(new CompoundBorder(outside, inside));
		
		lblStudentNumber = new JLabel("Student Number:");
		txtStudentNumber = new JTextField(10);
		
		lblStudentFName = new JLabel("Student First Name:");
		txtStudentFName = new JTextField(10);
		
		lblStudentLName = new JLabel("Student Last Name:");
		txtStudentLName = new JTextField(10);
		
		lblMajorCode = new JLabel("Major Code:");
		txtMajorCode = new JTextField(10);
		
		btnAdd = new JButton("Add");
		btnCancel = new JButton("Cancel");
		
		btnAdd.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (validation())
					addStudent();
			}
		});
		
		btnCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				viewer.dispose();
			}
		});
		
		pnlInfo.add(lblStudentNumber);
		pnlInfo.add(txtStudentNumber);
		pnlInfo.add(lblStudentFName);
		pnlInfo.add(txtStudentFName);
		pnlInfo.add(lblStudentLName);
		pnlInfo.add(txtStudentLName);
		pnlInfo.add(lblMajorCode);
		pnlInfo.add(txtMajorCode);
		
		pnlButtons.add(btnAdd);
		pnlButtons.add(btnCancel);
		
		pnlMain.add(pnlInfo, BorderLayout.NORTH);
		pnlMain.add(pnlButtons, BorderLayout.SOUTH);
		
	}
	
	public boolean validation()
	{	
		if (txtStudentNumber.getText().equals(""))
		{
			JOptionPane.showMessageDialog(viewer, "Student number is not nullable.", "Null Field Error", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		if (txtStudentFName.getText().equals("") || txtStudentLName.getText().equals("") || txtMajorCode.getText().equals(""))
			JOptionPane.showMessageDialog(viewer, "First name, last name, and major code are blank.", "Blank Fields Warning", JOptionPane.WARNING_MESSAGE);
		
		return true;
	}
	
	public void addStudent()
	{
		final String DB_URL = "jdbc:derby:CollegeDB";
		
		try
		{
			Connection connection = DriverManager.getConnection(DB_URL);
			
			try
			{
				Statement statement = connection.createStatement();
				
				String sql = "INSERT INTO Students VALUES (" + 
						"'" + txtStudentNumber.getText() + "', " + 
						"'" + txtStudentFName.getText() + "', " + 
						"'" + txtStudentLName.getText() + "', " + 
						"'" + txtMajorCode.getText() + "')";
				
				statement.executeUpdate(sql);
			}
			
			catch (Exception ex) {}
		}
		
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(viewer, "Error: " + ex.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args)
	{
		viewer = new AddNewStudentGUI();
	}
}
