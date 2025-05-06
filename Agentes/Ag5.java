package Agentes;

import Mensajes.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class Ag5 extends Agent {

    public static int nroHijoAgh = 0; 

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Hasta luego tonotos (AG5)");

       //Obtener conocimiento --> getArguments()
      //getArguments() obtiene el arreglo que se le dio al usar createNewAgent
      AgentContainer contenedorAgentes = (AgentContainer)getArguments()[0];

      //Obtener ID del agente
    //   int i= (int)getArguments()[1];
    //   i++;

      //Darle a los agente hijos el contenedor de agentes y el ID del agente padre
      try {
          contenedorAgentes.createNewAgent("Agh", Agh.class.getName(), new Object[]{contenedorAgentes, 0}).start();
        //   System.out.println("Holi");
        //   System.out.println(i);

      } catch (StaleProxyException e) {
          e.printStackTrace();
      }


    }

    class Comportamiento extends Behaviour{

        private boolean done = false; 

        private int cantidadMensajes = 0;

        @Override
        public void action() {

            jade.lang.acl.ACLMessage acl = blockingReceive();

            
            
            if (acl.getConversationId().equalsIgnoreCase("AG2-AG5")) {

                System.out.println(acl);

                cantidadMensajes++;
                
                // Mensaje.enviarMensaje(getAgent(), "Ag5", "Hola AG5, te saluda AG3", ACLMessage.REQUEST, "AG3-AG5");
                
                // done = true;
                // doDelete();
            }
            
            if (acl.getConversationId().equalsIgnoreCase("AG3-AG5")) {
                
                System.out.println(acl);
                
                // Mensaje.enviarMensaje(getAgent(), "Ag5", "Hola AG5, te saluda AG3", ACLMessage.REQUEST, "AG3-AG5");
                cantidadMensajes++;
                
                // done = true;
                // doDelete();
            }

            if (acl.getConversationId().equalsIgnoreCase("AG4-AG5")) {
                
                System.out.println(acl);
                
                cantidadMensajes++;
                // Mensaje.enviarMensaje(getAgent(), "Ag5", "Hola AG5, te saluda AG3", ACLMessage.REQUEST, "AG3-AG5");

                // done = true;
                // doDelete();
            }

            if (cantidadMensajes == 3) {
                System.out.println("Recibí 3 mensajes, ahí nos vemos");
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

