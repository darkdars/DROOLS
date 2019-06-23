package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sample.Cliente;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblName = new JLabel("Name :");
		panel_2.add(lblName);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblGender = new JLabel("Gender :");
		panel_3.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.WHITE);
		panel_3.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.WHITE);
		panel_3.add(rdbtnFemale);
		
		rdbtnMale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnFemale.setSelected(false);
			}

        });
		rdbtnFemale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnMale.setSelected(false);
			}

        });
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("Married :");
		panel_4.add(label);
		
		JRadioButton radioButton = new JRadioButton("Yes");
		radioButton.setBackground(Color.WHITE);
		panel_4.add(radioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.WHITE);
		panel_4.add(rdbtnNo);
		
		radioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnNo.setSelected(false);
			}

        });
		rdbtnNo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				radioButton.setSelected(false);
			}

        });
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_5.setBackground(Color.WHITE);
		panel.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_1 = new JLabel("Children :");
		panel_5.add(label_1);
		
		JRadioButton radioButton_1 = new JRadioButton("Yes");
		radioButton_1.setBackground(Color.WHITE);
		panel_5.add(radioButton_1);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setBackground(Color.WHITE);
		panel_5.add(rdbtnNo_1);
		
		radioButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnNo_1.setSelected(false);
			}

        });
		rdbtnNo_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				radioButton_1.setSelected(false);
			}

        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnRegister = new JButton("Register");
		panel_1.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean register = true;
				String name = textField.getText();
				boolean gender = false;
				boolean married = false;
				boolean children = false;
				if(name == null || name.contentEquals("") || name.contentEquals(" ")) {
					register = false;
				}
				if(rdbtnMale.isSelected()) {
					gender = true;
				}else if(rdbtnFemale.isSelected()) {
					gender = false;
				}else {
					register = false;
				}
				
				if(radioButton.isSelected()) {
					married = false;
					
				}else if(rdbtnNo.isSelected()) {
					married = true;
					
				}else {
					register = false;
				}
				
				if(radioButton_1.isSelected()) {
					children = true;
					
				}else if(rdbtnNo_1.isSelected()) {
					children = false;
					
				}else {
					register = false;
				}
				if(register) {
					Cliente cliente = new Cliente(name, gender, married, children);
					dispose();
					StoreView storeView = new StoreView(null, cliente);
					storeView.setVisible(true);
				}
				
			}

        });
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);
		
		JButton btnCancel = new JButton("Cancel");
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
			}

        });
	}

}
