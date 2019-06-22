package com.sample;

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
	
	public DroolTest(Cliente cliente, Items item, Armazem armazem){
		try {
			// load up the knowledge base
			ks = KieServices.Factory.get();
			kContainer = ks.getKieClasspathContainer();
			kSession = kContainer.newKieSession("ksession-rules");
		} catch (Throwable t) {
			t.printStackTrace();
		}
		this.cliente = cliente;
		this.item = item;
		this.armazem = armazem;
	}
	
	public void addTest(Cliente cliente, Items item, Armazem armazem) {
		this.cliente = cliente;
		this.item = item;
		this.armazem = armazem;
	}
	
	public void runTest() {
		kSession.insert(this.cliente);
		kSession.insert(this.item);
		kSession.insert(this.armazem);
		
		kSession.fireAllRules();
	}
	

}
