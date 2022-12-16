package bloody;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RecAdd extends JFrame { 
	
	JPanel contentPane;
	 JTextField tf_name;
	 JTextField tf_age;
	 JTextField tf_city;
	 private JTextField tf_unit;

	
	public static void main(String[] args) {
		RecAdd frame = new RecAdd();
		frame.setVisible(true);
	}

	
	public RecAdd() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 120, 735, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l_addReciever = new JLabel("ADD RECIEVER");
		l_addReciever.setForeground(Color.WHITE);
		l_addReciever.setFont(new Font("Tahoma", Font.BOLD, 35));
		l_addReciever.setBounds(237, 10, 272, 50);
		contentPane.add(l_addReciever);
		
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
		
		JLabel l_name = new JLabel("NAME");
		l_name.setForeground(Color.WHITE);
		l_name.setVerticalAlignment(SwingConstants.BOTTOM);
		l_name.setFont(new Font("Tahoma", Font.BOLD, 25));
		l_name.setBounds(120, 102, 131, 34);
		contentPane.add(l_name);
		
		tf_name = new JTextField();
		tf_name.setColumns(10);
		tf_name.setBounds(338, 107, 314, 40);
		contentPane.add(tf_name);
		
		JLabel l_age_Update = new JLabel("AGE");
		l_age_Update.setForeground(Color.WHITE);
		l_age_Update.setVerticalAlignment(SwingConstants.BOTTOM);
		l_age_Update.setFont(new Font("Tahoma", Font.BOLD, 25));
		l_age_Update.setBounds(120, 177, 131, 34);
		contentPane.add(l_age_Update);
		
		tf_age = new JTextField();
		tf_age.setColumns(10);
		tf_age.setBounds(338, 171, 314, 40);
		contentPane.add(tf_age);
		
		JLabel l_gender = new JLabel("GENDER");
		l_gender.setForeground(Color.WHITE);
		l_gender.setVerticalAlignment(SwingConstants.BOTTOM);
		l_gender.setFont(new Font("Tahoma", Font.BOLD, 25));
		l_gender.setBounds(120, 233, 131, 34);
		contentPane.add(l_gender);
		
		JRadioButton radio_male = new JRadioButton("MALE");
		radio_male.setForeground(new Color(255, 255, 255));
		radio_male.setOpaque(false);
		radio_male.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radio_male.setBounds(342, 243, 103, 21);
		contentPane.add(radio_male);
		
		JRadioButton radio_female = new JRadioButton("FEMALE");
		radio_female.setForeground(new Color(255, 255, 255));
		radio_female.setOpaque(false);
		radio_female.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radio_female.setBounds(447, 243, 103, 21);
		contentPane.add(radio_female);
		
		JLabel l_city = new JLabel("CITY");
		l_city.setForeground(Color.WHITE);
		l_city.setVerticalAlignment(SwingConstants.BOTTOM);
		l_city.setFont(new Font("Tahoma", Font.BOLD, 25));
		l_city.setBounds(120, 318, 131, 34);
		contentPane.add(l_city);
		
		tf_city = new JTextField();
		tf_city.setColumns(10);
		tf_city.setBounds(338, 323, 314, 40);
		contentPane.add(tf_city);
		
		JLabel l_blood = new JLabel("Blood Group");
		l_blood.setFont(new Font("Tahoma", Font.BOLD, 26));
		l_blood.setVerticalAlignment(SwingConstants.BOTTOM);
		l_blood.setForeground(new Color(255, 255, 255));
		l_blood.setBounds(120, 398, 202, 40);
		contentPane.add(l_blood);
		
		Choice choice_Blood = new Choice();
		choice_Blood.setBounds(338, 420, 215, 18);
		choice_Blood.add("A+");    
		choice_Blood.add("A-");    
		choice_Blood.add("B+");    
		choice_Blood.add("B-");    
		choice_Blood.add("AB+"); 
		choice_Blood.add("AB-"); 
		choice_Blood.add("O+"); 
		choice_Blood.add("O-"); 
		contentPane.add(choice_Blood);
		
		tf_unit = new JTextField();
		
		JButton btn_Save = new JButton("SAVE DETAILS");
		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String name = tf_name.getText();
                String city = tf_city.getText();
               String age = tf_age.getText();
               String bloo = choice_Blood.getItem(choice_Blood.getSelectedIndex()); 
                 String gender="";
                 String unit = tf_unit.getText();
                

                 
                if(radio_male.isSelected())
                     gender="Male";
                else if(radio_female.isSelected())
                     gender="Female";


                 String msg = "" + name;
                  msg += " \n";
                
                try {
                      //class.forName("jdbc.mysql.");

                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");

                    String query = "INSERT INTO reciever values('" + name + "','" + age + "','" + city + "','" + gender + "','" + bloo + "','" + unit + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(null, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(null,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                try {
//					String bloodgroup =(String)choice_Blood.getSelectedItem();
				
					String blood = choice_Blood.getItem(choice_Blood.getSelectedIndex());
					String unit1=tf_unit.getText();
					int unit2=Integer.parseInt(unit1);
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
					Statement stmt=connection.createStatement();
			          String query= "update stock set unit=unit-'"+unit2+"' where blood='"+blood+"'";
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
		btn_Save.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\save.png"));
		btn_Save.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Save.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btn_Save.setBackground(new Color(255, 255, 255));
		btn_Save.setBounds(279, 530, 180, 40);
		contentPane.add(btn_Save);
		
		JLabel l_unit = new JLabel("Unit");
		l_unit.setVerticalAlignment(SwingConstants.BOTTOM);
		l_unit.setForeground(new Color(255, 255, 255));
		l_unit.setFont(new Font("Tahoma", Font.BOLD, 26));
		l_unit.setBounds(527, 403, 68, 40);
		contentPane.add(l_unit);
		
		
		tf_unit.setBounds(594, 415, 96, 28);
		contentPane.add(tf_unit);
		tf_unit.setColumns(10);
		
		JLabel l_bg_image = new JLabel("bgimg");
		l_bg_image.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		l_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\Downloads\\Untitled design.png"));
		l_bg_image.setBounds(0, 0, 735, 623);
		contentPane.add(l_bg_image);
	}
}
