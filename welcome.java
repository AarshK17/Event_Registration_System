package projectMain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class welcome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome frame = new welcome();
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
	public welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Event Management System");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(99, 109, 264, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please select an option to continue.");
		lblNewLabel_1.setForeground(new Color(39, 39, 39));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1.setBounds(140, 140, 182, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ADMIN LOGIN");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin admin = new admin();
                admin.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setBounds(34, 200, 386, 27);
		contentPane.add(btnNewButton);
		
		JButton btnStudentRegister = new JButton("STUDENT REGISTER");
		btnStudentRegister.setForeground(new Color(255, 255, 255));
		btnStudentRegister.setBackground(new Color(0, 204, 255));
		btnStudentRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student student = new student();
                student.setVisible(true);
                dispose();
			}
		});
		btnStudentRegister.setFont(new Font("Arial", Font.BOLD, 13));
		btnStudentRegister.setBounds(34, 237, 386, 27);
		contentPane.add(btnStudentRegister);

	}
}
