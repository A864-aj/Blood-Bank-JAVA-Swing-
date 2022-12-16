package bloody;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Mainpg extends JFrame {

	

	 JPanel mainPanel;
	 JTextField tf_name_Add;
	 JTextField tf_age_Add;
	 JTextField tf_city_Add;
	 JTextField tf_nameOfDonor_update;
	 JTextField tf_age_Update;
	 JTextField tf_city_Update;
	 JTextField tf_name_Update;
	 JTextField tf_nameOfDonor_Delete;
	

	
	public static void main(String[] args) {
							
			Mainpg frame = new Mainpg();
			frame.setVisible(true);
	}

	
	public Mainpg() {
		setUndecorated(true);
		setBackground(new Color(255, 102, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1393, 805);
		JPanel DeletePanel = new JPanel();
		JPanel updatePanel = new JPanel();
		JPanel addPanel = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_add = new JMenu("");
		menu_add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				menu_add.setText("ADD");
			}public void mouseExited(MouseEvent e) {
				menu_add.setText("");
			}
		});
		menu_add.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\d.png"));
		menuBar.add(menu_add);
		
		JMenuItem item_add_donor = new JMenuItem("Add New Donor");
		item_add_donor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePanel.setVisible(false);
				updatePanel.setVisible(false);
				addPanel.setVisible(true);

				new RecAdd().setVisible(false);
				new RecDel().setVisible(false);
				new AStock().setVisible(false);
				new UpdateStock().setVisible(false);
				new BGroup().setVisible(false);
				new City().setVisible(false);
				new Name().setVisible(false);				
				
				
			}	});
		menu_add.add(item_add_donor);
		
		JMenuItem item_update_donor = new JMenuItem("Update Donor Details");
		item_update_donor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePanel.setVisible(false);
				addPanel.setVisible(false);
			    updatePanel.setVisible(true);
			    
				new RecAdd().setVisible(false);
				new RecDel().setVisible(false);
				new AStock().setVisible(false);
				new UpdateStock().setVisible(false);
				new BGroup().setVisible(false);
				new City().setVisible(false);
				new Name().setVisible(false);
			
			}
		});
		menu_add.add(item_update_donor);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add New Reciever");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecAdd().setVisible(true);
				new RecDel().setVisible(false);
				new AStock().setVisible(false);
				new UpdateStock().setVisible(false);
				new BGroup().setVisible(false);
				new City().setVisible(false);
				new Name().setVisible(false);
				DeletePanel.setVisible(false);
				addPanel.setVisible(false);
			    updatePanel.setVisible(false);
				
			}
		});
		menu_add.add(mntmNewMenuItem);
		
		JMenu menu_delete = new JMenu("");
		menu_delete.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\j.png"));
		menuBar.add(menu_delete);
		
		JMenuItem item_delete_donor = new JMenuItem("Delete Donor");
		item_delete_donor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePanel.setVisible(true);
				addPanel.setVisible(false);
				updatePanel.setVisible(false);
				
				new RecAdd().setVisible(false);
				new RecDel().setVisible(false);
				new AStock().setVisible(false);
				new UpdateStock().setVisible(false);
				new BGroup().setVisible(false);
				new City().setVisible(false);
				new Name().setVisible(false);
			}
			
		});
		menu_delete.add(item_delete_donor);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Delete Reciever");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecDel().setVisible(true);
				
				new RecAdd().setVisible(false);
				new AStock().setVisible(false);
				new UpdateStock().setVisible(false);
				new BGroup().setVisible(false);
				new City().setVisible(false);
				new Name().setVisible(false);
			}
		});
		menu_delete.add(mntmNewMenuItem_1);
		
		JMenu menu_search = new JMenu("");
		menu_search.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\search user.png"));
		menuBar.add(menu_search);
		
		JMenu mnNewMenu = new JMenu("Search Donor");
		menu_search.add(mnNewMenu);
		
		JMenuItem item_name_search = new JMenuItem("Search By Name");
		mnNewMenu.add(item_name_search);
		
		JMenuItem item_city_search = new JMenuItem("Search By City");
		mnNewMenu.add(item_city_search);
		item_city_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new City().setVisible(true);
				
				new RecAdd().setVisible(false);
				new RecDel().setVisible(false);
				new AStock().setVisible(false);
				new UpdateStock().setVisible(false);
				new BGroup().setVisible(false);
				new Name().setVisible(false);
			}
		});
		
		JMenuItem item_blood_search = new JMenuItem("Search By Blood");
		mnNewMenu.add(item_blood_search);
		item_blood_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BGroup().setVisible(true);
				
				new RecAdd().setVisible(false);
				new RecDel().setVisible(false);
				new AStock().setVisible(false);
				new UpdateStock().setVisible(false);
				new City().setVisible(false);
				new Name().setVisible(false);
			}
		});
		item_name_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Name().setVisible(true);
				
				new RecAdd().setVisible(false);
				new RecDel().setVisible(false);
				new AStock().setVisible(false);
				new UpdateStock().setVisible(false);
				new BGroup().setVisible(false);
				new City().setVisible(false);
				
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Search Reciever");
		menu_search.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Seach By Name");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new RecName().setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Search By City");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecCity().setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Search By Blood");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecBGroup().setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu menu_stock = new JMenu("");
		menu_stock.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\stock.png"));
		menuBar.add(menu_stock);
		
		JMenuItem item_available_stock = new JMenuItem("Available Stock ");
		item_available_stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new AStock().setVisible(true);
			
			new RecAdd().setVisible(false);
			new RecDel().setVisible(false);
			new UpdateStock().setVisible(false);
			new BGroup().setVisible(false);
			new City().setVisible(false);
			new Name().setVisible(false);
			}
		});
		menu_stock.add(item_available_stock);
		
		JMenuItem item_update_stock = new JMenuItem("Update Stock");
		item_update_stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new UpdateStock().setVisible(true);
			
			new RecAdd().setVisible(false);
			new RecDel().setVisible(false);
			new AStock().setVisible(false);
			new BGroup().setVisible(false);
			new City().setVisible(false);
			new Name().setVisible(false);
			}
		});
		menu_stock.add(item_update_stock);
		
		JMenu menu_closeApp = new JMenu("");
		menu_closeApp.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\exit.png"));
		menuBar.add(menu_closeApp);
		
		JMenuItem item_logout = new JMenuItem("Log-Out");
		item_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LoginM().setVisible(true);
				
				new RecAdd().setVisible(false);
				new RecDel().setVisible(false);
				new AStock().setVisible(false);
				new UpdateStock().setVisible(false);
				new BGroup().setVisible(false);
				new City().setVisible(false);
				new Name().setVisible(false);
				 
			}
		});
		item_logout.setFont(new Font("Segoe UI", Font.BOLD, 12));
		item_logout.setOpaque(true);
		item_logout.setBackground(Color.LIGHT_GRAY);
		item_logout.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Logout.png"));
		menu_closeApp.add(item_logout);
		
		JMenuItem item_close_program = new JMenuItem("Close ");
		item_close_program.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		item_close_program.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Exit application.png"));
		menu_closeApp.add(item_close_program);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 102, 102));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
			
			
				
				addPanel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 255, 255)));
				addPanel.setBackground(new Color(255, 255, 255));
				addPanel.setBounds(434, 54, 591, 620);
				mainPanel.add(addPanel);
				addPanel.setLayout(null);
				
				JLabel l_name_Add = new JLabel("NAME");
				l_name_Add.setVerticalAlignment(SwingConstants.BOTTOM);
				l_name_Add.setFont(new Font("Tahoma", Font.BOLD, 25));
				l_name_Add.setBounds(44, 88, 131, 34);
				addPanel.add(l_name_Add);
				
				tf_name_Add = new JTextField();
				tf_name_Add.setBounds(180, 88, 314, 40);
				addPanel.add(tf_name_Add);
				tf_name_Add.setColumns(10);
				
				JLabel l_age_Add = new JLabel("AGE");
				l_age_Add.setVerticalAlignment(SwingConstants.BOTTOM);
				l_age_Add.setFont(new Font("Tahoma", Font.BOLD, 25));
				l_age_Add.setBounds(44, 187, 131, 34);
				addPanel.add(l_age_Add);
				
				tf_age_Add = new JTextField();
				tf_age_Add.setColumns(10);
				tf_age_Add.setBounds(180, 187, 314, 40);
				addPanel.add(tf_age_Add);
				
				JLabel l_gender_Add = new JLabel("GENDER");
				l_gender_Add.setVerticalAlignment(SwingConstants.BOTTOM);
				l_gender_Add.setFont(new Font("Tahoma", Font.BOLD, 25));
				l_gender_Add.setBounds(44, 284, 131, 34);
				addPanel.add(l_gender_Add);
				
				
				
				JRadioButton radio_male_Add = new JRadioButton("MALE");
				radio_male_Add.setFont(new Font("Tahoma", Font.PLAIN, 20));
				radio_male_Add.setOpaque(false);
				radio_male_Add.setBounds(240, 294, 103, 21);
				addPanel.add(radio_male_Add);
				
				JRadioButton radio_female_Add = new JRadioButton("FEMALE");
				radio_female_Add.setFont(new Font("Tahoma", Font.PLAIN, 20));
				radio_female_Add.setOpaque(false);
				radio_female_Add.setBounds(345, 294, 103, 21);
				addPanel.add(radio_female_Add);
				
				JLabel l_city_Add = new JLabel("CITY");
				l_city_Add.setVerticalAlignment(SwingConstants.BOTTOM);
				l_city_Add.setFont(new Font("Tahoma", Font.BOLD, 25));
				l_city_Add.setBounds(44, 382, 131, 34);
				addPanel.add(l_city_Add);
				
				tf_city_Add = new JTextField();
				tf_city_Add.setColumns(10);
				tf_city_Add.setBounds(180, 382, 314, 40);
				addPanel.add(tf_city_Add);
				
				Choice choice_Blood_add = new Choice();
				choice_Blood_add.setBounds(229, 500, 265, 81);
				choice_Blood_add.add("A+");    
				choice_Blood_add.add("A-");    
				choice_Blood_add.add("B+");    
				choice_Blood_add.add("B-");    
				choice_Blood_add.add("AB+"); 
				choice_Blood_add.add("AB-"); 
				choice_Blood_add.add("O+"); 
				choice_Blood_add.add("O-"); 
				addPanel.add(choice_Blood_add);
				
				JLabel l_blood_Add = new JLabel("BLOOD GROUP");
				l_blood_Add.setVerticalAlignment(SwingConstants.BOTTOM);
				l_blood_Add.setFont(new Font("Tahoma", Font.BOLD, 25));
				l_blood_Add.setBounds(10, 486, 186, 34);
				addPanel.add(l_blood_Add);
				
				JButton btn_Save_add = new JButton("SAVE DETAILS");
				btn_Save_add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addPanel.setVisible(false);
						
						
						
		                String name = tf_name_Add.getText();
		                String city = tf_city_Add.getText();
		               String age = tf_age_Add.getText();
		               String bloo = choice_Blood_add.getItem(choice_Blood_add.getSelectedIndex()); 
		                 String gender="";
		                

		                 
		                if(radio_male_Add.isSelected())
		                     gender="Male";
		                else if(radio_female_Add.isSelected())
		                     gender="Female";


		                 String msg = "" + name;
		                  msg += " \n";
		                
		                try {
		                      //class.forName("jdbc.mysql.");

		                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");

		                    String query = "INSERT INTO bloodbank values('" + name + "','" + age + "','" + city + "','" + gender + "','" + bloo + "')";

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

		                tf_name_Add.setText("");
						tf_age_Add.setText("");
						tf_city_Add.setText("");
		
						
					
					
					
					}
				});
				btn_Save_add.setBorder(new LineBorder(new Color(102, 51, 255), 3, true));
				btn_Save_add.setBackground(new Color(0, 204, 255));
				btn_Save_add.setFont(new Font("Garamond", btn_Save_add.getFont().getStyle() | Font.BOLD, btn_Save_add.getFont().getSize() + 6));
				btn_Save_add.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\save.png"));
				btn_Save_add.setBounds(137, 556, 163, 45);
				addPanel.add(btn_Save_add);
				
				JButton btn_close_Add = new JButton("CLOSE");
				btn_close_Add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						addPanel.setVisible(false);
						tf_name_Add.setText("");
						tf_age_Add.setText("");
						tf_city_Add.setText("");
						
					}
				});
				btn_close_Add.setFont(new Font("Garamond", btn_close_Add.getFont().getStyle() | Font.BOLD, btn_close_Add.getFont().getSize() + 6));
				btn_close_Add.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Exit application.png"));
				btn_close_Add.setBorder(new LineBorder(Color.RED, 3, true));
				btn_close_Add.setBackground(new Color(255, 51, 51));
				btn_close_Add.setBounds(359, 556, 163, 45);
				addPanel.add(btn_close_Add);
				
				JLabel l_addDonor = new JLabel("ADD DONOR");
				l_addDonor.setFont(new Font("Tahoma", Font.BOLD, 27));
				l_addDonor.setBounds(204, 10, 178, 40);
				addPanel.add(l_addDonor);
				
				JLabel l_add_donor_bg_image = new JLabel("New label");
				l_add_donor_bg_image.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
				l_add_donor_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Untitled design (2).png"));
				l_add_donor_bg_image.setBounds(0, 0, 591, 620);
				addPanel.add(l_add_donor_bg_image);
				addPanel.setVisible(false);
			
			
			
			
			
			updatePanel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 255, 255)));
			updatePanel.setBounds(436, 54, 608, 620);
			mainPanel.add(updatePanel);
			updatePanel.setBackground(new Color(255, 255, 255));
			updatePanel.setLayout(null);
			updatePanel.setVisible(false);
			
			JButton btn_search = new JButton("");
			btn_search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
			             String Name = tf_nameOfDonor_update.getText();
			          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
			                    PreparedStatement pstmt;
			               
			                    String query = "select name,age,city from bloodbank where name=?";

			                    
			                     pstmt = connection.prepareStatement(query);
			                    //pstmt.executeUpdate(query);
			                    
			                      pstmt.setString(1,Name);
			                      
			                    ResultSet rsl = pstmt.executeQuery();
			                     if(rsl.next()==false){
			                       JOptionPane.showMessageDialog(null,"Sorry record not found");
			                       tf_name_Update.setText("");
			                       tf_age_Update.setText("");
			                       tf_city_Update.setText("");


			                    } 
			                    else{
			                    	tf_name_Update.setText(rsl.getString("name"));
			                    	tf_age_Update.setText(rsl.getString("age"));
			                    	tf_city_Update.setText(rsl.getString("city"));

			                   }                
			                    connection.close();

			                } catch (Exception exception) {
			                    exception.printStackTrace();
			                }
				}
			});
			btn_search.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\search1.png"));
			btn_search.setFont(new Font("Tahoma", Font.BOLD, 19));
			btn_search.setBounds(545, 78, 45, 40);
			updatePanel.add(btn_search);
			
			JLabel l_nameOfDonor_update = new JLabel(" Name of Donor");
			l_nameOfDonor_update.setVerticalAlignment(SwingConstants.BOTTOM);
			l_nameOfDonor_update.setFont(new Font("Tahoma", Font.BOLD, 24));
			l_nameOfDonor_update.setBounds(10, 84, 194, 34);
			updatePanel.add(l_nameOfDonor_update);
			
			tf_nameOfDonor_update = new JTextField();
			tf_nameOfDonor_update.setColumns(10);
			tf_nameOfDonor_update.setBounds(230, 84, 305, 34);
			updatePanel.add(tf_nameOfDonor_update);
			
			JLabel l_name_Update = new JLabel("NAME");
			l_name_Update.setVerticalAlignment(SwingConstants.BOTTOM);
			l_name_Update.setFont(new Font("Tahoma", Font.BOLD, 25));
			l_name_Update.setBounds(39, 180, 131, 34);
			updatePanel.add(l_name_Update);
			
			tf_name_Update = new JTextField();
			tf_name_Update.setColumns(10);
			tf_name_Update.setBounds(230, 185, 314, 40);
			updatePanel.add(tf_name_Update);
			
			JLabel l_age_Update = new JLabel("AGE");
			l_age_Update.setVerticalAlignment(SwingConstants.BOTTOM);
			l_age_Update.setFont(new Font("Tahoma", Font.BOLD, 25));
			l_age_Update.setBounds(39, 255, 131, 34);
			updatePanel.add(l_age_Update);
			
			tf_age_Update = new JTextField();
			tf_age_Update.setColumns(10);
			tf_age_Update.setBounds(230, 249, 314, 40);
			updatePanel.add(tf_age_Update);
			
			JLabel l_gender_Update = new JLabel("GENDER");
			l_gender_Update.setVerticalAlignment(SwingConstants.BOTTOM);
			l_gender_Update.setFont(new Font("Tahoma", Font.BOLD, 25));
			l_gender_Update.setBounds(39, 311, 131, 34);
			updatePanel.add(l_gender_Update);
			
			JRadioButton radio_male_Update = new JRadioButton("MALE");
			radio_male_Update.setOpaque(false);
			radio_male_Update.setFont(new Font("Tahoma", Font.PLAIN, 20));
			radio_male_Update.setBounds(285, 321, 103, 21);
			updatePanel.add(radio_male_Update);
			
			JRadioButton radio_female_Upadate = new JRadioButton("FEMALE");
			radio_female_Upadate.setOpaque(false);
			radio_female_Upadate.setFont(new Font("Tahoma", Font.PLAIN, 20));
			radio_female_Upadate.setBounds(412, 321, 103, 21);
			updatePanel.add(radio_female_Upadate);
			
			JLabel l_city_Update = new JLabel("CITY");
			l_city_Update.setVerticalAlignment(SwingConstants.BOTTOM);
			l_city_Update.setFont(new Font("Tahoma", Font.BOLD, 25));
			l_city_Update.setBounds(39, 396, 131, 34);
			updatePanel.add(l_city_Update);
			
			tf_city_Update = new JTextField();
			tf_city_Update.setColumns(10);
			tf_city_Update.setBounds(230, 401, 314, 40);
			updatePanel.add(tf_city_Update);
			
			JLabel l_blood_Update = new JLabel("BLOOD GROUP");
			l_blood_Update.setVerticalAlignment(SwingConstants.BOTTOM);
			l_blood_Update.setFont(new Font("Tahoma", Font.BOLD, 25));
			l_blood_Update.setBounds(39, 485, 186, 34);
			updatePanel.add(l_blood_Update);
			
			Choice choice_Blood_Update = new Choice();
			choice_Blood_Update.setBounds(285, 501, 229, 18);
			choice_Blood_Update.add("A+");    
			choice_Blood_Update.add("A-");    
			choice_Blood_Update.add("B+");    
			choice_Blood_Update.add("B-");    
			choice_Blood_Update.add("AB+"); 
			choice_Blood_Update.add("AB-"); 
			choice_Blood_Update.add("O+"); 
			choice_Blood_Update.add("O-"); 
			updatePanel.add(choice_Blood_Update);
			
			JButton btn_Update = new JButton("UPDATE");
			btn_Update.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Update details.png"));
			btn_Update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = tf_nameOfDonor_update.getText();
				       //String  Name =t2.getText();
				       String age = tf_age_Update.getText();
				       String city = tf_city_Update.getText();
				       String bloo = choice_Blood_Update.getItem(choice_Blood_Update.getSelectedIndex());
				       String gender="";
		                

		                 
		                if(radio_male_Update.isSelected())
		                     gender="Male";
		                else if(radio_female_Upadate.isSelected())
		                     gender="Female";
				       try{
				              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");;
				              Statement st = con.createStatement();
				              st.executeUpdate("update bloodbank set age='"+age+"',city='"+city+"',bloo='"+bloo+"',gender='"+gender+"' where name='"+name+"' ");
				              JOptionPane.showMessageDialog(null,"Succesfully Updated");

				      }catch(Exception exception){
				            JOptionPane.showMessageDialog(null,"Connection Error");

				     }
					
				}
			});
			btn_Update.setFont(new Font("Tahoma", Font.BOLD, 17));
			btn_Update.setBorder(new LineBorder(new Color(102, 51, 255), 3, true));
			btn_Update.setBackground(new Color(0, 204, 255));
			btn_Update.setBounds(149, 552, 163, 45);
			updatePanel.add(btn_Update);
			
			JButton btn_Close_Update = new JButton("CLOSE");
			btn_Close_Update.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Exit application.png"));
			btn_Close_Update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						
					updatePanel.setVisible(false);
					tf_nameOfDonor_update.setText("");
					tf_name_Update.setText("");
					tf_age_Update.setText("");
					tf_city_Update.setText("");
				}
			});
			btn_Close_Update.setFont(new Font("Tahoma", Font.BOLD, 17));
			btn_Close_Update.setBorder(new LineBorder(Color.RED, 3, true));
			btn_Close_Update.setBackground(new Color(255, 51, 51));
			btn_Close_Update.setBounds(381, 552, 163, 45);
			updatePanel.add(btn_Close_Update);
			
			JLabel l_updateDetails_Update = new JLabel("UPDATE DETAILS");
			l_updateDetails_Update.setFont(new Font("Tahoma", Font.BOLD, 26));
			l_updateDetails_Update.setBounds(174, 10, 247, 40);
			updatePanel.add(l_updateDetails_Update);
			
			JLabel l_line_Update = new JLabel("============================================================================================================================================================");
			l_line_Update.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
			l_line_Update.setBounds(0, 146, 605, 13);
			updatePanel.add(l_line_Update);
			
			JLabel l_update_donor_bg_image = new JLabel("New label");
			l_update_donor_bg_image.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
			l_update_donor_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Untitled design (1).png"));
			l_update_donor_bg_image.setBounds(0, 0, 605, 620);
			updatePanel.add(l_update_donor_bg_image);
		
		
		
		
		DeletePanel.setBounds(420, 54, 624, 381);
		mainPanel.add(DeletePanel);
		DeletePanel.setBackground(new Color(0, 204, 204));
		DeletePanel.setLayout(null);
		DeletePanel.setVisible(false);
		
		JLabel L_deleteDonor = new JLabel("DELETE DONOR");
		L_deleteDonor.setFont(new Font("Tahoma", Font.BOLD, 26));
		L_deleteDonor.setBounds(216, 10, 237, 54);
		DeletePanel.add(L_deleteDonor);
		
		JLabel L_nameOfDonor_delete = new JLabel(" Name of Donor");
		L_nameOfDonor_delete.setVerticalAlignment(SwingConstants.BOTTOM);
		L_nameOfDonor_delete.setFont(new Font("Tahoma", Font.BOLD, 24));
		L_nameOfDonor_delete.setBounds(10, 136, 194, 34);
		DeletePanel.add(L_nameOfDonor_delete);
		
		tf_nameOfDonor_Delete = new JTextField();
		tf_nameOfDonor_Delete.setColumns(10);
		tf_nameOfDonor_Delete.setBounds(233, 130, 314, 40);
		DeletePanel.add(tf_nameOfDonor_Delete);
		
		JButton btn_Delete = new JButton("DELETE");
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn_Delete,"Confirm Deletetion");
				DeletePanel.setVisible(false);
				try{
		             String Name = tf_nameOfDonor_Delete.getText();
		          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "rootwdp");
		                    PreparedStatement pstmt;
		                    String query = "DELETE FROM bloodbank WHERE name= '" + Name + "'";
		                    

		                   
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
		btn_Delete.setBorder(new LineBorder(new Color(153, 0, 0), 3, true));
		btn_Delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Delete.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\Desktop\\Images\\BBMS ICON\\delete.png"));
		btn_Delete.setBackground(new Color(204, 0, 51));
		btn_Delete.setBounds(168, 274, 116, 40);
		DeletePanel.add(btn_Delete);
		
		JButton btn_Close_delete = new JButton("CLOSE");
		btn_Close_delete.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Exit application.png"));
		btn_Close_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePanel.setVisible(false);
			}
		});
		btn_Close_delete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_Close_delete.setBorder(new LineBorder(new Color(102, 51, 255), 3, true));
		btn_Close_delete.setBackground(new Color(0, 204, 255));
		btn_Close_delete.setBounds(371, 274, 122, 40);
		DeletePanel.add(btn_Close_delete);
		
		JLabel l_del_donor_bg_image = new JLabel("New label");
		l_del_donor_bg_image.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		l_del_donor_bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\Untitled design (3).png"));
		l_del_donor_bg_image.setBounds(0, 0, 624, 381);
		DeletePanel.add(l_del_donor_bg_image);
		
		JLabel l_main_Bg_image = new JLabel("New label");
		l_main_Bg_image.setBounds(-52, 0, 1445, 749);
		l_main_Bg_image.setIcon(new ImageIcon("C:\\Users\\Anurag Gurjar\\eclipse-workspace\\blood\\src\\blood\\main.png"));
		mainPanel.add(l_main_Bg_image);
	}
}
