package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sample.Cliente;
import com.sample.Items;
import com.sample.Loja;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class CartView extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public CartView(Loja loja, Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		JButton btnNewButton = new JButton("Go Back");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				StoreView storeView = new StoreView(loja, cliente);
				storeView.setVisible(true);
			}

        });
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		JButton btnRemove = new JButton("Remove");
		panel.add(btnRemove);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		JButton btnBuy = new JButton("Buy");
		panel.add(btnBuy);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		JLabel lblTotal = new JLabel("Pre\u00E7o Total: " + loja.getCart(cliente).getValor() + "€");
		panel.add(lblTotal);
		

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Quantidade", "Valor"
			}) {

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			});

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(Items item : loja.getCart(cliente).getCompras()) {
			model.addRow(new Object[]{item.getId(), item.getNome(), loja.getNumberOfItemsInCart(cliente, item.getId()), item.getValor()});				
		}
		table.setModel(model);
		table.setBounds(5, 11, 394, 215);
		//contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					return;
				}
				loja.removeItemFromCart(cliente, (String)model.getValueAt(row, 0));
				int numberItem = loja.getNumberOfItemsInCart(cliente, (String)model.getValueAt(row, 0));
				if(numberItem == 0) {
					model.removeRow(row);					
				}else {
					table.setValueAt(numberItem, row, 2);
				}
				lblTotal.setText("Pre\u00E7o Total: " + loja.getCart(cliente).getValor() + "€");
			}

        });
		
		btnBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(loja.getCart(cliente).getNumberOfItems() == 0) {
					JOptionPane.showMessageDialog(null, "Go check our items.");
					dispose();
					StoreView storeView = new StoreView(loja, cliente);
					storeView.setVisible(true);	
				}else {
					JOptionPane.showMessageDialog(null, "Obrigado pela compra, o valor total dos "+ loja.getCart(cliente).getNumberOfItems() +" é " + loja.getCart(cliente).getValor() + "€.");
					dispose();
					loja.resetCliente(cliente);
					StoreView storeView = new StoreView(loja, cliente);
					storeView.setVisible(true);						
				}
			}

        });
		
		
	}

}
