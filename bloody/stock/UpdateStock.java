package bloody;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class UpdateStock extends JFrame {

	
	
	 JPanel mainPanel;
	 JTextField tf_units;


	public static void main(String[] args) {
		UpdateStock frame = new UpdateStock();
		frame.setVisible(true);
	}

	
	public UpdateStock() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 120, 1000, 700);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel l_blood = new JLabel("Blood Group");
		l_blood.setFont(new Font("Microsoft YaHei", l_blood.getFont().getStyle() | Font.BOLD, l_blood.getFont().getSize() + 25));
		l_blood.setVerticalAlignment(SwingConstants.BOTTOM);
		l_blood.setForeground(new Color(255, 255, 255));
		l_blood.setBounds(10, 26, 243, 50);
		mainPanel.add(l_blood);
		
		JButton btn_increase = new JButton("");
		btn_increase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_increase.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Inc.png"));
		btn_increase.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn_increase.setBounds(708, 41, 53, 35);
		mainPanel.add(btn_increase);
		
		JButton btn_close = new JButton("");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		btn_close.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Exit application.png"));
		btn_close.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
		btn_close.setBackground(Color.WHITE);
		btn_close.setBounds(912, 10, 53, 50);
		mainPanel.add(btn_close);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(204, 255, 255));
		panel2.setBounds(10, 116, 980, 574);
		mainPanel.add(panel2);
		panel2.setLayout(null);
		
		Choice choice_Blood = new Choice();
		choice_Blood.setBounds(259, 42, 185, 18);
		choice_Blood.add("A+");    
		choice_Blood.add("A-");    
		choice_Blood.add("B+");    
		choice_Blood.add("B-");    
		choice_Blood.add("AB+"); 
		choice_Blood.add("AB-"); 
		choice_Blood.add("O+"); 
		choice_Blood.add("O-"); 
		mainPanel.add(choice_Blood);
		
		JButton btn_decrease = new JButton("");
		btn_decrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_decrease.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Dec.png"));
		btn_decrease.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn_decrease.setBounds(782, 41, 53, 35);
		mainPanel.add(btn_decrease);
		
		JLabel l_blood_1 = new JLabel("Value");
		l_blood_1.setFont(new Font("Microsoft YaHei", l_blood_1.getFont().getStyle() | Font.BOLD, l_blood_1.getFont().getSize() + 25));
		l_blood_1.setVerticalAlignment(SwingConstants.BOTTOM);
		l_blood_1.setForeground(Color.WHITE);
		l_blood_1.setBounds(448, 26, 124, 50);
		mainPanel.add(l_blood_1);
		
		tf_units = new JTextField();
		tf_units.setBounds(591, 32, 78, 44);
		mainPanel.add(tf_units);
		tf_units.setColumns(10);
		
		JLabel l_bg_image = new JLabel("bgimg");
		l_bg_image.setBorder(new LineBorder(Color.WHITE, 2, true));
		l_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\Downloads\\Untitled design.png"));
		l_bg_image.setBounds(0, 0, 1002, 700);
		mainPanel.add(l_bg_image);
	}
}
