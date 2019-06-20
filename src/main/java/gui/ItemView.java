package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sample.Items;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

public class ItemView extends JPanel {


	/**
	 * Create the frame.
	 */
	public ItemView(Items item) {
		this.setBackground(Color.WHITE);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblGender = new JLabel("Gender :");
		this.add(lblGender);
		lblGender.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}
