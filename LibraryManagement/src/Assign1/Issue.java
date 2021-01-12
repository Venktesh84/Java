package Assign1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Issue {

	private JFrame frmIssueBook;
	private JTextField Istudentid;
	private JTextField Ibookid;
	private JTextField Ibookname;
	private int current=0;
	private int count=0;
	private int max=8;
	List l=new List(25);
	

	public void gotoEl(int i){
		Node temp=l.getElement(i);
		Istudentid.setText(temp.std());
		Ibookid.setText(""+temp.bi());
		Ibookname.setText(""+temp.bn());
		current=i;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue window = new Issue();
					window.frmIssueBook.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Issue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIssueBook = new JFrame();
		frmIssueBook.setTitle("Issue Book");
		frmIssueBook.setBounds(100, 100, 450, 300);
		frmIssueBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIssueBook.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(157, 11, 79, 28);
		frmIssueBook.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID :");
		lblNewLabel_1.setBounds(84, 63, 67, 20);
		frmIssueBook.getContentPane().add(lblNewLabel_1);
		
		JLabel lblBookId = new JLabel("Book ID :");
		lblBookId.setBounds(84, 94, 67, 20);
		frmIssueBook.getContentPane().add(lblBookId);
		
		JLabel lblBookName = new JLabel("Book Name :");
		lblBookName.setBounds(84, 125, 67, 20);
		frmIssueBook.getContentPane().add(lblBookName);
		
		Istudentid = new JTextField();
		Istudentid.setBounds(238, 63, 86, 20);
		frmIssueBook.getContentPane().add(Istudentid);
		Istudentid.setColumns(10);
		
		Ibookid = new JTextField();
		Ibookid.setBounds(238, 94, 86, 20);
		frmIssueBook.getContentPane().add(Ibookid);
		Ibookid.setColumns(10);
		
		Ibookname = new JTextField();
		Ibookname.setBounds(238, 125, 86, 20);
		frmIssueBook.getContentPane().add(Ibookname);
		Ibookname.setColumns(10);
		
		JButton btnNewButton = new JButton("ISSUE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
					if (Istudentid.getText().isEmpty() || Ibookid.getText().isEmpty() || Ibookname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please provide the details");
				}
				else{
					String std = Istudentid.getText();
					String bi = Ibookid.getText();
					String bn = Ibookname.getText();
					boolean res=l.insert(std,bi,bn);
					if (res==true) {
						count++;
						JOptionPane.showMessageDialog(null, "Book Issued"); 
						Istudentid.setText(null);
						Ibookid.setText(null); 
						Ibookname.setText(null);
					}
					else { 
						JOptionPane.showMessageDialog(null, "Book not Issued"); 
						Istudentid.setText(null);
						Ibookid.setText(null); 
						Ibookname.setText(null);}
					} 
				
				} 
				
			
		});
		btnNewButton.setBounds(176, 182, 89, 23);
		frmIssueBook.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage window = new HomePage();
				window.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(306, 182, 89, 23);
		frmIssueBook.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Issued Books");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l.printlist();
			}
		});
		btnNewButton_2.setBounds(35, 182, 103, 23);
		frmIssueBook.getContentPane().add(btnNewButton_2);
		
		frmIssueBook.setVisible(true);
	}
}
