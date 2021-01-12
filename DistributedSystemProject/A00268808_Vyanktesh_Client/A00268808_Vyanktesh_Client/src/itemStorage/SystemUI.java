package itemStorage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.http.client.ClientProtocolException;


public class SystemUI implements ActionListener {

	private JFrame frmItemStorageSystem;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnsavedetails,btndeletedetails,btnUpdate;
	private JTextArea textArea;
	private JButton btnCreateDB;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemUI window = new SystemUI();
					window.frmItemStorageSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public SystemUI() throws Exception {
		initialize();
	}
	
	public void getInfo() {
		try {
			textArea.setText(GetStorageDetails.Details().toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize()throws Exception {
		
		frmItemStorageSystem = new JFrame();
		frmItemStorageSystem.setTitle("Item Storage Management System");
		frmItemStorageSystem.setBounds(100, 100, 850, 550);
		frmItemStorageSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmItemStorageSystem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(86, 103, 23, 16);
		frmItemStorageSystem.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(62, 132, 56, 16);
		frmItemStorageSystem.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile Number:");
		lblNewLabel_2.setBounds(36, 161, 100, 16);
		frmItemStorageSystem.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cabinet Number:");
		lblNewLabel_3.setBounds(27, 202, 100, 16);
		frmItemStorageSystem.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(128, 100, 116, 22);
		frmItemStorageSystem.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 129, 116, 22);
		frmItemStorageSystem.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 158, 116, 22);
		frmItemStorageSystem.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(128, 199, 116, 22);
		frmItemStorageSystem.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnsavedetails = new JButton("Save");
		btnsavedetails.setBounds(36, 262, 97, 25);
		frmItemStorageSystem.getContentPane().add(btnsavedetails);
		btnsavedetails.addActionListener(this);
		
		btndeletedetails = new JButton("Delete");
		btndeletedetails.setBounds(145, 262, 97, 25);
		frmItemStorageSystem.getContentPane().add(btndeletedetails);
		btndeletedetails.addActionListener(this);
		
		 btnUpdate = new JButton("Update");
		btnUpdate.setBounds(88, 311, 97, 25);
		frmItemStorageSystem.getContentPane().add(btnUpdate);
		
		textArea = new JTextArea();
		textArea.setBounds(268, 58, 550, 278);
		frmItemStorageSystem.getContentPane().add(textArea);
		
		btnCreateDB = new JButton("Create DB");
		btnCreateDB.setBounds(409, 368, 97, 25);
		frmItemStorageSystem.getContentPane().add(btnCreateDB);
		btnCreateDB.addActionListener(this);
		
		btnUpdate.addActionListener(this);
		getInfo();
		
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		int id,cabinet;
		String name, number;
		id = Integer.parseInt(textField.getText());
		name = textField_1.getText();
		number = textField_2.getText();
		cabinet = Integer.parseInt(textField_3.getText());
		if(target==btndeletedetails) {
			DeleteItem d = new DeleteItem();
			try {
				d.testIntegrityUnicityError(id);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textArea.setText("");
			getInfo();
		}
		else if(target==btnsavedetails) {
			InsertItem.insert(id, name, number, cabinet);
			System.out.println("Inserted");
			textArea.setText("");
			getInfo();
			
		}
		else if(target==btnUpdate) {
			UpdateItem up = new UpdateItem();
			
			try {
				up.updateItemData(id, name, number, cabinet);
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textArea.setText("");
			getInfo();
		}
		else if(target==btnCreateDB) {
			Createdb cdb = new Createdb();
			cdb.create();
		}
		
	}

}
