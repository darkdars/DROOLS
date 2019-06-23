package com.sample;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;


public class DroolTest {

	KieServices ks;
	KieContainer kContainer;
	KieSession kSession;
	
	Cliente cliente;
	Items item;
	Armazem armazem;
	Loja loja;
	JTable table;
	
	List<Items> itemList = new ArrayList();
	
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
		gravaTestes();
	}
	
	private void gravaTestes(){
		
		BufferedWriter output = null;
		StringBuilder stringBuilder = new StringBuilder();
        try {
            output = new BufferedWriter(new FileWriter("results/Testes Do Utilizador " + this.cliente.getName() + ".txt", true));
            stringBuilder.append("**Teste - " + loja.getArmazem().getLastRule() + " Rule *******\n");
            for(Items i : loja.getArmazem().getLastList())
            	stringBuilder.append("Id: " + i.getId() + ", Nome: " + i.getNome() + ", Tipo: " + i.getTipo() + ", Descricao: " + i.getDescricao() + ", Item Complementar: " + i.getComplementar() + ".\n");
            output.append(stringBuilder.toString());
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
          }
        }
		
		
	}
	

}
