package bloody;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RecDel extends JFrame {

	

	JPanel contentPane;
	 JTextField tf_name;

	
	public static void main(String[] args) {
		RecDel frame = new RecDel();
		frame.setVisible(true);
	}

	
	public RecDel() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 120, 735, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l_deleteReciever = new JLabel("DELETE RECIEVER");
		l_deleteReciever.setForeground(Color.WHITE);
		l_deleteReciever.setFont(new Font("Tahoma", Font.BOLD, 33));
		l_deleteReciever.setBounds(214, 20, 314, 56);
		contentPane.add(l_deleteReciever);
		
		JButton btn_close_1 = new JButton("");
		btn_close_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_close_1.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Exit application.png"));
		btn_close_1.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
		btn_close_1.setBackground(Color.WHITE);
		btn_close_1.setBounds(658, 10, 53, 50);
		contentPane.add(btn_close_1);
		
		JLabel l_name = new JLabel("Name of Reciever");
		l_name.setForeground(Color.WHITE);
		l_name.setFont(new Font("Tahoma", Font.BOLD, 28));
		l_name.setBounds(48, 125, 259, 45);
		contentPane.add(l_name);
		
		tf_name = new JTextField();
		tf_name.setColumns(10);
		tf_name.setBounds(320, 135, 314, 40);
		contentPane.add(tf_name);
		
		JButton btn_Delete = new JButton("DELETE");
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(btn_Delete,"Confirm Deletetion");
				setVisible(false);
				try{
		             String name = tf_name.getText();
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
		                    PreparedStatement pstmt;
		                    String query = "DELETE FROM reciever WHERE name= '" + name + "'";
		                    

		                   
		                     pstmt = connection.prepareStatement(query);
		                   // pstmt.setString(1,name);
		                    pstmt.executeUpdate(query);

		                   /* if (x > 0) {
		                        JOptionPane.showMessageDialog(null,"Deleted Specific Row in the  table successfully...");
		                    } else {
		                        JOptionPane.showMessageDialog(null,
		                            "Not exist specific row that you select for delete");
		                    }*/ 



		                    JOptionPane.showMessageDialog(null,
		                            "Record Deleted Successfully");
		                    connection.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                }
			}
		});
		btn_Delete.setForeground(Color.DARK_GRAY);
		btn_Delete.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\delete.png"));
		btn_Delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Delete.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btn_Delete.setBackground(new Color(255, 255, 255));
		btn_Delete.setBounds(279, 290, 180, 40);
		contentPane.add(btn_Delete);
		
		JLabel l_bg_image = new JLabel("bgimg");
		l_bg_image.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		l_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\Downloads\\Untitled design.png"));
		l_bg_image.setBounds(0, 0, 735, 403);
		contentPane.add(l_bg_image);
		
	}
}
