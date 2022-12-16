package bloody;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import net.proteanit.sql.DbUtils;

public class BGroup extends JFrame {

	

	 JPanel contentPane;
	 private JTable table;

	
	public static void main(String[] args) {
		BGroup frame = new BGroup();
		frame.setVisible(true);
	}

	
	public BGroup() {
		
		setUndecorated(true);
		setBounds(280, 120, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l_blood = new JLabel("Blood Group");
		l_blood.setFont(new Font("Microsoft YaHei", l_blood.getFont().getStyle() | Font.BOLD, l_blood.getFont().getSize() + 34));
		l_blood.setVerticalAlignment(SwingConstants.BOTTOM);
		l_blood.setForeground(new Color(255, 255, 255));
		l_blood.setBounds(52, 11, 308, 65);
		contentPane.add(l_blood);
		
		Choice choice_Blood = new Choice();
		
		JButton btn_search = new JButton("");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					

		             String bloo = choice_Blood.getItem(choice_Blood.getSelectedIndex());
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
		          PreparedStatement pstmt;
	               
                String query = "select * from bloodbank where bloo=?";

                
                 pstmt = (PreparedStatement) connection.prepareStatement(query);
                //pstmt.executeUpdate(query);
                
                  pstmt.setString(1,bloo);
                  
                ResultSet rsl = pstmt.executeQuery();
		                    ResultSetMetaData rsmd = rsl.getMetaData();

		                    table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		                    table.setModel(DbUtils.resultSetToTableModel(rsl));

		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
				
			}
		});
		btn_search.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\search1.png"));
		btn_search.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn_search.setBounds(612, 29, 34, 35);
		contentPane.add(btn_search);
		
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
		contentPane.add(btn_close);
		
		
		
		choice_Blood.setBounds(411, 42, 215, 18);
		choice_Blood.add("A+");    
		choice_Blood.add("A-");    
		choice_Blood.add("B+");    
		choice_Blood.add("B-");    
		choice_Blood.add("AB+"); 
		choice_Blood.add("AB-"); 
		choice_Blood.add("O+"); 
		choice_Blood.add("O-"); 
		contentPane.add(choice_Blood);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(102, 204, 255));
		panel2.setBounds(10, 116, 980, 574);
		contentPane.add(panel2);
		panel2.setLayout(null);
		table = new JTable();
		table.setBounds(27, 22, 923, 512);
		panel2.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		
		JLabel l_bg_image = new JLabel("bgimg");
		l_bg_image.setBorder(new LineBorder(Color.WHITE, 2, true));
		l_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\Downloads\\Untitled design.png"));
		l_bg_image.setBounds(0, 0, 1002, 700);
		contentPane.add(l_bg_image);
	}
}
