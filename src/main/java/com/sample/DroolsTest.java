package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			
			// go !
			List<Items> listItems = new ArrayList<Items>();

			// Inserir na lista de items

			Items item1 = new Items("001", "Chapeu",10, "Tommy", Tipo.homem, null);
			Items item2 = new Items("002", "Oculos de Sol",10, "Ray Ban", Tipo.homem, item1);
			Items item3 = new Items("003", "Camisola",0, "Sou o Papa!", Tipo.crianca, null);
			
			
			
			
			listItems.add(item1);
			listItems.add(item2);
			listItems.add(item3);

			// Armazém criado
			Armazem armazem = new Armazem(listItems);
			Loja loja = new Loja(armazem);

			// Clientes
			Cliente cliente1 = new Cliente("001", "Hugo", true, true, false);
			Cliente cliente2 = new Cliente("002", "Carlos", false, true, true);
			Cliente cliente3 = new Cliente("003", "Diogo", true, false, true); // mas que saiba não!

			
			
			
			kSession.insert(loja);
			kSession.insert(cliente1);
			kSession.insert(cliente2);
			kSession.insert(cliente3);

			
			
			kSession.fireAllRules();
			
			
			/*
			 Message message = new Message(); message.setMessage("Hello World");
			  message.setStatus(Message.HELLO); kSession.insert(message);
			  kSession.fireAllRules();
			  */
			 
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static class Message {

		public static final int HELLO = 0;
		public static final int GOODBYE = 1;

		private String message;

		private int status;

		public String getMessage() {
			return this.message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public int getStatus() {
			return this.status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

	}

}