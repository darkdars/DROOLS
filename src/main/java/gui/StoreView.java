package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sample.Carrinho;
import com.sample.Cliente;
import com.sample.DroolTest;
import com.sample.Items;
import com.sample.Loja;

public class StoreView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private Loja loja;
	private Carrinho carrinho;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreView frame = new StoreView(null, new Cliente("001", "Diana", false, false, true));
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
	public StoreView(Loja store, Cliente cliente) {
		
		this.loja = (store == null) ? new Loja() : store;
		loja.addCliente(cliente);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Add");
		panel.add(btnAdd);
		
		JButton btnCart = new JButton("Cart");
		panel.add(btnCart);
		btnCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CartView cartView = new CartView(loja, cliente);
				cartView.setVisible(true);
			}

        });
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Imagem", "Nome", "Quantidade", "Valor"
			}) {

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    } 
			});

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(Items item : loja.getArmazem().getListItems()) {
			model.addRow(new Object[]{item.getId(), item.getImg(), item.getNome(), loja.getArmazem().getNumeroItems(item.getId()), item.getValor()});				
		}
		table.setModel(model);
		table.setBounds(5, 11, 394, 215);
		//contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					return;
				}
				Items item = loja.getArmazem().getItem((String)model.getValueAt(row, 0));
				
				if(item != null) {
					loja.addItemToCart(cliente, item);
					DroolTest droolTest = new DroolTest(cliente, item, loja.getArmazem());
					droolTest.runTest();
	                model.setValueAt(loja.getArmazem().getNumeroItems(item.getId()), row, 3);
				}
			}

        });
	}

}
