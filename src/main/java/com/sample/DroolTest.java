package com.sample;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolTest {

	KieServices ks;
	KieContainer kContainer;
	KieSession kSession;
	
	Cliente cliente;
	Items item;
	Armazem armazem;
	Loja loja;
	JTable table;
	
	public DroolTest(){
		try {
			// load up the knowledge base
			ks = KieServices.Factory.get();
			kContainer = ks.getKieClasspathContainer();
			kSession = kContainer.newKieSession("ksession-rules");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public DroolTest(Cliente cliente, Items item, Loja loja, JTable table){
		try {
			// load up the knowledge base
			ks = KieServices.Factory.get();
			kContainer = ks.getKieClasspathContainer();
			kSession = kContainer.newKieSession("ksession-rules");
		} catch (Throwable t) {
			t.printStackTrace();
		}
		kSession.setGlobal("TB", table);
		kSession.setGlobal("DFT", (DefaultTableModel) table.getModel());

		this.cliente = cliente;
		this.item = item;
		this.loja = loja;
	}
	
	public void addTest(Cliente cliente, Items item, Loja loja, JTable table) {
		this.cliente = cliente;
		this.item = item;
		this.loja = loja;
	}
	
	public void runTest() {
		kSession.insert(this.cliente);
		kSession.insert(this.item);
		kSession.insert(this.loja);
		kSession.insert(this.loja.getArmazem());
		
		kSession.fireAllRules();
	}
	

}
