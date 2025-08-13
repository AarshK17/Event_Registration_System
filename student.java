package projectMain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student frame = new student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentRegistration = new JLabel("Student Registration");
		lblStudentRegistration.setForeground(new Color(0, 102, 255));
		lblStudentRegistration.setFont(new Font("Arial", Font.BOLD, 17));
		lblStudentRegistration.setBounds(129, 10, 166, 25);
		contentPane.add(lblStudentRegistration);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 59, 110, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Department :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 87, 110, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Semester :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(10, 115, 110, 19);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Contact No. :");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(10, 143, 110, 19);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email :");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(10, 172, 110, 19);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Select Event :");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_5.setBounds(10, 201, 110, 19);
		contentPane.add(lblNewLabel_1_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(115, 59, 311, 18);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 86, 311, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 115, 311, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(115, 143, 311, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(115, 172, 311, 19);
		contentPane.add(textField_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CodeStorm", "RoboRumble", "Cyber Clash", "TechTrivia", "BrainWave"}));
		comboBox.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox.setBounds(115, 200, 311, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("BACK TO HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome welcome = new welcome();
                welcome.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(21, 255, 193, 25);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText().trim();
		        String dept = textField_1.getText().trim();
		        int semester;
		        try {
		            semester = Integer.parseInt(textField_2.getText().trim());
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(student.this, "Semester must be an integer.");
		            return;
		        }
		        String contact = textField_3.getText().trim();
		        String email = textField_4.getText().trim();
		        String event = (String) comboBox.getSelectedItem();
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectmain","root","aarshk123");
					String sql = "INSERT INTO student (name, department, semester, contactno, email, eventname) VALUES (?, ?, ?, ?, ?, ?)";
		            PreparedStatement pst = con.prepareStatement(sql);
		            pst.setString(1, name);
		            pst.setString(2, dept);
		            pst.setInt(3, semester);
		            pst.setString(4, contact);
		            pst.setString(5, email);
		            pst.setString(6, event);   
		            int rowsInserted = pst.executeUpdate();
		            if (rowsInserted > 0) {
		                JOptionPane.showMessageDialog(student.this, "Registration successful!");
		            }

		            con.close();

			} catch (Exception ex1) {
	            ex1.printStackTrace();
	            JOptionPane.showMessageDialog(student.this, "Database error: " + ex1.getMessage()); 
			} 
			}});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Arial", Font.BOLD, 13));
		btnRegister.setBackground(new Color(0, 102, 255));
		btnRegister.setBounds(233, 255, 193, 25);
		contentPane.add(btnRegister);

	}
}
