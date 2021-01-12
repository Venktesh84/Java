package Assign1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage {

	private JFrame frmHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setTitle("Home");
		frmHome.setBounds(100, 100, 450, 300);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		
		JButton hissue = new JButton("Issue Book");
		hissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Issue();
			}
		});
		hissue.setBounds(66, 96, 109, 23);
		frmHome.getContentPane().add(hissue);
		
		JButton hreturn = new JButton("Return Book");
		hreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Return();
			}
		});
		hreturn.setBounds(255, 96, 117, 23);
		frmHome.getContentPane().add(hreturn);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(66, 167, 89, 23);
		frmHome.getContentPane().add(btnNewButton);
		//frmHome.setVisible(false);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frmHome.setVisible(true);
		
	}
}
