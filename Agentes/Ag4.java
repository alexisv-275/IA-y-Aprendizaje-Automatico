package Agentes;

import Mensajes.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class Ag4 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Hasta luego tonotos (AG4)");
    }

    class Comportamiento extends Behaviour{

        private boolean done = false; 

        @Override
        public void action() {
            jade.lang.acl.ACLMessage acl = blockingReceive();
            
            if (acl.getConversationId().equalsIgnoreCase("AG2-AG4")) {

                System.out.println(acl);
                
                Mensaje.enviarMensaje(getAgent(), "Ag5", "Hola AG5, te saluda AG4", ACLMessage.REQUEST, "AG4-AG5");

                done = true;
                doDelete();
            }
            
        }

        @Override
        public boolean done() {
            return done;
        }

    }
    
}
