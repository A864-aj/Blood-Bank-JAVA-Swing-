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
import java.sql.*;

public class AStock extends JFrame {


	 JPanel mainPanel;
	 private JTable table;

	
	public static void main(String[] args) {
		AStock frame = new AStock();
		frame.setVisible(true);
	}

	
	
	public AStock() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 120, 1000, 700);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel l_available_stock = new JLabel("Available Stock");
		l_available_stock.setForeground(Color.WHITE);
		l_available_stock.setFont(new Font("Microsoft YaHei UI", l_available_stock.getFont().getStyle() | Font.BOLD, l_available_stock.getFont().getSize() + 44));
		l_available_stock.setBounds(250, 10, 469, 60);
		mainPanel.add(l_available_stock);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(204, 255, 255));
		panel2.setBounds(10, 106, 980, 584);
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
		
		
		
		JButton btn_close = new JButton("");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_close.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Exit application.png"));
		btn_close.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
		btn_close.setBackground(Color.WHITE);
		btn_close.setBounds(921, 10, 53, 50);
		mainPanel.add(btn_close);
		
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
		btnNewButton.setBounds(708, 27, 115, 31);
		mainPanel.add(btnNewButton);
		
		JLabel l_bg_image = new JLabel("New label");
		l_bg_image.setBorder(new LineBorder(Color.WHITE, 2, true));
		l_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\Downloads\\Untitled design.png"));
		l_bg_image.setBounds(0, 0, 1000, 700);
		mainPanel.add(l_bg_image);
	}
//	private void formComponentShown (java.awt.event.ComponentEvent evt) {
//		
//		
//	}
}
