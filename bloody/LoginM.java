package bloody;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class LoginM extends JFrame {

	
	 JPanel mainPanel;
	 JTextField textField;
	 JPasswordField passwordField;
	 

	
	public static void main(String[] args) {
		LoginM frame = new LoginM();
		frame.setVisible(true);
	}

	public LoginM() {
		
		setUndecorated(true);
		setBounds(80, 80, 1383, 768);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 3, true));
		textField.setBounds(892, 266, 286, 42);
		
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 3, true));
		passwordField.setBounds(892, 389, 286, 42);
		
		
		JButton btnNewButton = new JButton("LOGIN");
		
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("Anurag") && passwordField.getText().equals("cse1"))
				{
				setVisible(false);
				new Mainpg().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
				}
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
		btnNewButton.setBackground(new Color(255, 102, 102));
		btnNewButton.setBounds(865, 527, 182, 36);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(706, 243, 182, 86);
		
		
	
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(706, 366, 182, 86);
	
		
		JButton btnClose = new JButton("");
		btnClose.setOpaque(false);
		btnClose.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Close.png"));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClose.setBorderPainted(false);
		btnClose.setBorder(new LineBorder(new Color(255, 102, 102), 3, true));
		btnClose.setBackground(new Color(255, 255, 255));
		btnClose.setBounds(1306, 20, 57, 52);

		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\20220416_205533_0000.png"));
		lblNewLabel.setBounds(0, 0, 1384, 756);

		mainPanel.add(textField);
		mainPanel.add(passwordField);
		mainPanel.add(lblNewLabel_1);
		mainPanel.add(btnNewButton);
		mainPanel.add(lblNewLabel_1_1);
		mainPanel.add(btnClose);
		mainPanel.add(lblNewLabel);

	}
}