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

public class RecName extends JFrame {

	
	 
	 JPanel mainPanel;
	 JTextField tf_name;
	 private JTable table;
	
	public static void main(String[] args) {
		RecName frame = new RecName();
		frame.setVisible(true);
	}

	
	public RecName() {
		table = new JTable();
		setUndecorated(true);
		setBounds(280, 120, 1000, 700);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel l_name = new JLabel("NAME");
		l_name.setFont(new Font("Microsoft YaHei", l_name.getFont().getStyle() | Font.BOLD, l_name.getFont().getSize() + 38));
		l_name.setVerticalAlignment(SwingConstants.BOTTOM);
		l_name.setForeground(new Color(255, 255, 255));
		l_name.setBounds(150, 20, 175, 58);
		mainPanel.add(l_name);
		
		tf_name = new JTextField();
		tf_name.setColumns(10);
		tf_name.setBorder(new LineBorder(new Color(171, 173, 179), 3, true));
		tf_name.setBounds(348, 20, 302, 50);
		mainPanel.add(tf_name);
		
		JButton btn_search = new JButton("");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					

		             String name = tf_name.getText();
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
		          PreparedStatement pstmt;
	               
                 String query = "select * from reciever where name=?";

                 
                  pstmt = (PreparedStatement) connection.prepareStatement(query);
                 //pstmt.executeUpdate(query);
                 
                   pstmt.setString(1,name);
                   
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
		btn_search.setBounds(697, 20, 45, 44);
		mainPanel.add(btn_search);
		
		JButton btn_close = new JButton("");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		btn_close.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Exit application.png"));
		btn_close.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
		btn_close.setBackground(Color.WHITE);
		btn_close.setBounds(912, 22, 53, 50);
		mainPanel.add(btn_close);
		
		JPanel panel_display = new JPanel();
		panel_display.setBackground(new Color(204, 255, 255));
		panel_display.setBounds(10, 120, 978, 570);
		mainPanel.add(panel_display);
		panel_display.setLayout(null);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
			table.setBounds(32, 10, 923, 512);
			panel_display.add(table);
		
		JLabel l_bg_image = new JLabel("bgimg");
		l_bg_image.setBorder(new LineBorder(Color.WHITE, 2, true));
		l_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\Downloads\\Untitled design (4).png"));
		l_bg_image.setBounds(0, 0, 1000, 700);
		mainPanel.add(l_bg_image);
	}
}
