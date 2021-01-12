package Assign1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Return extends Issue {

	private JFrame frmReturnBook;
	private JTextField Rstudentid;
	private JTextField Rbookid;
	private JTextField Rbookname;
	private JTextField Rfine;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return window = new Return();
					window.frmReturnBook.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Return() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReturnBook = new JFrame();
		frmReturnBook.setTitle("Return Book");
		frmReturnBook.setBounds(100, 100, 450, 300);
		frmReturnBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReturnBook.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(178, 29, 79, 23);
		frmReturnBook.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID :");
		lblNewLabel_1.setBounds(94, 72, 64, 23);
		frmReturnBook.getContentPane().add(lblNewLabel_1);
		
		JLabel lblBookId = new JLabel("Book ID :");
		lblBookId.setBounds(94, 104, 64, 23);
		frmReturnBook.getContentPane().add(lblBookId);
		
		JLabel lblBookName = new JLabel("Book Name :");
		lblBookName.setBounds(94, 138, 64, 23);
		frmReturnBook.getContentPane().add(lblBookName);
		
		JLabel lblFine = new JLabel("Fine :");
		lblFine.setBounds(94, 172, 64, 23);
		frmReturnBook.getContentPane().add(lblFine);
		
		Rstudentid = new JTextField();
		Rstudentid.setBounds(239, 73, 86, 20);
		frmReturnBook.getContentPane().add(Rstudentid);
		Rstudentid.setColumns(10);
		
		Rbookid = new JTextField();
		Rbookid.setColumns(10);
		Rbookid.setBounds(239, 105, 86, 20);
		frmReturnBook.getContentPane().add(Rbookid);
		
		Rbookname = new JTextField();
		Rbookname.setColumns(10);
		Rbookname.setBounds(239, 139, 86, 20);
		frmReturnBook.getContentPane().add(Rbookname);
		
		Rfine = new JTextField();
		Rfine.setColumns(10);
		Rfine.setBounds(239, 173, 86, 20);
		frmReturnBook.getContentPane().add(Rfine);
		
		JButton btnNewButton = new JButton("RETURN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Rstudentid.getText().isEmpty() || Rbookid.getText().isEmpty() || Rbookname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please provide the details");
				}
				else {
					String std = Rstudentid.getText();
					String bi = Rbookid.getText();
					String bn = Rbookname.getText();
					Node res=l.searchWithId(bi);
					if (res!=null) {
						JOptionPane.showMessageDialog(null, "Book Returned");
					}
					else if(res==null) {
						JOptionPane.showMessageDialog(null, "Book Not Issued");
					}
					Rstudentid.setText(null);
					Rbookid.setText(null); 
					Rbookname.setText(null);
				}
			}
		});
		btnNewButton.setBounds(94, 216, 89, 23);
		frmReturnBook.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage window = new HomePage();
				window.setVisible(true);
			}
		});
		btnBack.setBounds(236, 216, 89, 23);
		frmReturnBook.getContentPane().add(btnBack);
		
		frmReturnBook.setVisible(true);
	}

}
