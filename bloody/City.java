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

public class City extends JFrame {


	 JPanel mainPanel;
	 JTextField tf_city;
	 JPanel panel_display;
	 private JTable table;


	public static void main(String[] args) {
		City frame = new City();
		frame.setVisible(true);
	}


	public City() {
		
		setUndecorated(true);
		setBounds(280, 120, 1000, 700);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel l_city = new JLabel("CITY");
		l_city.setForeground(new Color(255, 255, 255));
		l_city.setVerticalAlignment(SwingConstants.BOTTOM);
		l_city.setFont(new Font("Microsoft YaHei", l_city.getFont().getStyle() | Font.BOLD, l_city.getFont().getSize() + 43));
		l_city.setBounds(203, 26, 139, 60);
		mainPanel.add(l_city);
		
		tf_city = new JTextField();
		tf_city.setColumns(10);
		tf_city.setBorder(new LineBorder(new Color(171, 173, 179), 3, true));
		tf_city.setBounds(343, 26, 324, 50);
		mainPanel.add(tf_city);
		
		JButton btn_close = new JButton("");
		btn_close.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_close.setBackground(new Color(255, 255, 255));
		btn_close.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Exit application.png"));
		btn_close.setBounds(902, 10, 53, 50);
		mainPanel.add(btn_close);
		
		JButton btn_search = new JButton("");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					

		             String city = tf_city.getText();
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
		          PreparedStatement pstmt;
	               
                 String query = "select * from bloodbank where city=?";

                 
                  pstmt = (PreparedStatement) connection.prepareStatement(query);
                 //pstmt.executeUpdate(query);
                 
                   pstmt.setString(1,city);
                   
                 ResultSet rsl = pstmt.executeQuery();
		                    ResultSetMetaData rsmd = rsl.getMetaData();

		                    table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		                    table.setModel(DbUtils.resultSetToTableModel(rsl));

		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
				
			}
		});
		btn_search.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn_search.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\search1.png"));
		btn_search.setBounds(694, 26, 53, 42);
		mainPanel.add(btn_search);
		
		panel_display = new JPanel();
		panel_display.setBackground(new Color(102, 204, 255));
		panel_display.setBounds(10, 117, 978, 571);
		mainPanel.add(panel_display);
		panel_display.setLayout(null);
		
		table = new JTable();
		table.setBounds(21, 10, 923, 512);
		panel_display.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JLabel l_bg_image = new JLabel("New label");
		l_bg_image.setBorder(new LineBorder(Color.WHITE, 2));
		l_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Untitled design.png"));
		l_bg_image.setBounds(0, 0, 1000, 700);
		mainPanel.add(l_bg_image);
	}
}
