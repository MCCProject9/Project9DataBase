//	GetStudentInfoGUI.java by Kyle Wolff and Brandon VanderMey on 4/30/2015

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GetStudentInfoGUI extends JFrame
{
	static GetStudentInfoGUI viewer;
	
	JLabel lblStudentFName;
	JLabel lblStudentLName;
	JLabel lblStudentNumber;
	JLabel lblMajorCode;
	JLabel lblMajorDescription;
	
	JTextField txtStudentFName;
	JTextField txtStudentLName;
	JTextField txtStudentNumber;
	JTextField txtMajorCode;
	JTextField txtMajorDescription;
	
	JButton btnSubmit;
	
	JPanel pnlMain;
	JPanel pnlStudentInfo;
	JPanel pnlMajorInfo;
	JPanel pnlInput;
	
	public GetStudentInfoGUI()
	{
		super("Student Information");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createPanel();
		
		add(pnlMain);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void createPanel()
	{
		pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
		
		pnlStudentInfo = new JPanel();
		Border outsideStudent = new EmptyBorder(0, 0, 5, 0);
		Border insideStudent = BorderFactory.createTitledBorder("Student Info");
		pnlStudentInfo.setBorder(new CompoundBorder(outsideStudent, insideStudent));
		
		pnlInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		lblStudentNumber = new JLabel("Student Number:");
		
		txtStudentNumber = new JTextField(10);
		
		lblStudentFName = new JLabel("First Name:");
		
		txtStudentFName = new JTextField(10);
		txtStudentFName.setEditable(false);
		
		lblStudentLName = new JLabel("Last Name:");
		
		txtStudentLName = new JTextField(10);
		txtStudentLName.setEditable(false);
		
		pnlMajorInfo = new JPanel();
		Border outsideMajor = new EmptyBorder(0, 0, 5, 0);
		Border insideMajor = BorderFactory.createTitledBorder("Major Info");
		pnlMajorInfo.setBorder(new CompoundBorder(outsideMajor, insideMajor));
		
		lblMajorCode = new JLabel("Code:");
		
		txtMajorCode = new JTextField(10);
		txtMajorCode.setEditable(false);
		
		lblMajorDescription = new JLabel("Description");
		
		txtMajorDescription = new JTextField(10);
		txtMajorDescription.setEditable(false);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				findStudent();
			}
		});
		
		pnlInput.add(lblStudentNumber);
		pnlInput.add(txtStudentNumber);
		pnlInput.add(btnSubmit);
		
		pnlStudentInfo.add(lblStudentFName);
		pnlStudentInfo.add(txtStudentFName);
		pnlStudentInfo.add(lblStudentLName);
		pnlStudentInfo.add(txtStudentLName);
		
		pnlMajorInfo.add(lblMajorCode);
		pnlMajorInfo.add(txtMajorCode);
		pnlMajorInfo.add(lblMajorDescription);
		pnlMajorInfo.add(txtMajorDescription);
		
		pnlMain.add(pnlInput);
		pnlMain.add(pnlStudentInfo);
		pnlMain.add(pnlMajorInfo);
	}
	
	public void findStudent()
	{
		
	}
	
	public static void main(String[] args)
	{
		viewer = new GetStudentInfoGUI();
	}
}
