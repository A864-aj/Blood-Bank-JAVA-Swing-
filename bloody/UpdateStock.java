package bloody;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class UpdateStock extends JFrame {

	
	
	 JPanel mainPanel;
	 JTextField tf_units;
	 private JTable table;


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
		Choice choice_Blood = new Choice();
		
		JLabel l_blood = new JLabel("Blood Group");
		l_blood.setFont(new Font("Microsoft YaHei", l_blood.getFont().getStyle() | Font.BOLD, l_blood.getFont().getSize() + 25));
		l_blood.setVerticalAlignment(SwingConstants.BOTTOM);
		l_blood.setForeground(new Color(255, 255, 255));
		l_blood.setBounds(10, 26, 243, 50);
		mainPanel.add(l_blood);
		
		JButton btn_increase = new JButton("");
		btn_increase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String bloodgroup =(String)choice_Blood.getSelectedItem();
				
					String bloo = choice_Blood.getItem(choice_Blood.getSelectedIndex());
					String unit1=tf_units.getText();
					int unit=Integer.parseInt(unit1);
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
					Statement stmt=connection.createStatement();
			          String query= "update stock set unit=unit+'"+unit+"' where blood='"+bloo+"'";
			          stmt.executeUpdate(query);
//	                   ResultSetMetaData rsmd = rsl.getMetaData();
//
//	                   table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
//	                   table.setModel(DbUtils.resultSetToTableModel(rsl));

			        		  
					
				}
				catch(Exception exception){
					exception.printStackTrace();
					
				}
				
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
		panel2.setBounds(10, 144, 980, 546);
		mainPanel.add(panel2);
		panel2.setLayout(null);
		
		
		table = new JTable();
		table.setBounds(27, 22, 923, 512);
		panel2.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"blood", "unit"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		panel2.add(table);
		
		
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
				try {
//					String bloodgroup =(String)choice_Blood.getSelectedItem();
				
					String bloo = choice_Blood.getItem(choice_Blood.getSelectedIndex());
					String unit1=tf_units.getText();
					int unit=Integer.parseInt(unit1);
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
					Statement stmt=connection.createStatement();
			          String query= "update stock set unit=unit-'"+unit+"' where blood='"+bloo+"'";
			          stmt.executeUpdate(query);
//	                   ResultSetMetaData rsmd = rsl.getMetaData();
//
//	                   table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
//	                   table.setModel(DbUtils.resultSetToTableModel(rsl));

			        		  
					
				}
				catch(Exception exception){
					exception.printStackTrace();
					
				}
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
		
		JButton btnNewButton = new JButton("Show Stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					

		            
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
//			         PreparedStatement pstmt;
			          Statement stmt=connection.createStatement();
			       String query = "select *from stock";

			        
//			         pstmt = (PreparedStatement) connection.prepareStatement(query);
			        //pstmt.executeUpdate(query);
			        
			        
			          
			        ResultSet rsl =stmt.executeQuery(query);
			                   ResultSetMetaData rsmd = rsl.getMetaData();

			                   table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
			                   table.setModel(DbUtils.resultSetToTableModel(rsl));

			               } catch (Exception exception) {
			                   exception.printStackTrace();
			               }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(0, 204, 204));
		btnNewButton.setBounds(464, 96, 115, 31);
		mainPanel.add(btnNewButton);
		
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
