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

			Items item1 = new Items("Chapeu", Tipo.homem, null, 1);
			Items item2 = new Items("Oculos de Sol", Tipo.homem, item1, 1);
			Items item3 = new Items("Chapeu", Tipo.homem, item2, 1);
			
			
			
			listItems.add(item1);
			listItems.add(item2);
			listItems.add(item3);

			// Armazém criado
			Armazem armazem = new Armazem(listItems);

			// Clientes
			Cliente cliente1 = new Cliente(null, "Hugo", true, true, false);
			Cliente cliente2 = new Cliente(null, "Carlos", false, true, false);
			Cliente cliente3 = new Cliente(null, "Diogo", true, false, true); // mas que saiba não!

			
			
			kSession.insert(armazem);
			kSession.insert(cliente1);
			kSession.insert(cliente2);
			kSession.insert(cliente3);

			kSession.fireAllRules();
			
			/* Message message = new Message(); message.setMessage("Hello World");
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