package projectMain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(157, 10, 116, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Event :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(29, 59, 110, 19);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CodeStorm", "RoboRumble", "Cyber Clash", "TechTrivia", "BrainWave"}));
		comboBox.setBounds(29, 81, 377, 25);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(29, 129, 110, 19);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(29, 151, 377, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedEvent = (String) comboBox.getSelectedItem();
		        String enteredPassword = new String(textField.getText());
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectmain","root","aarshk123");
					String sql = "SELECT password FROM admin WHERE eventname = ?";
		            PreparedStatement pst = con.prepareStatement(sql);
		            pst.setString(1, selectedEvent);

		            ResultSet rs = pst.executeQuery();

		            if (rs.next()) {
		                String actualPassword = rs.getString("password");

		                if (enteredPassword.equals(actualPassword)) {
		                    JOptionPane.showMessageDialog(admin.this, "Login successful for " + selectedEvent);
		                } 
		                else {
		                	JOptionPane.showMessageDialog(admin.this, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
		                }
	                }
	                else {
	                    JOptionPane.showMessageDialog(admin.this, "Event not found", "Error", JOptionPane.ERROR_MESSAGE);
	                }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(admin.this, "Database error: " + ex.getMessage());
		        }
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 13));
		btnLogin.setBackground(new Color(0, 102, 255));
		btnLogin.setBounds(29, 206, 377, 25);
		contentPane.add(btnLogin);
		
		JButton btnNewButton = new JButton("BACK TO HOME");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome welcome = new welcome();
                welcome.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setBounds(29, 241, 377, 25);
		contentPane.add(btnNewButton);

	}
}
