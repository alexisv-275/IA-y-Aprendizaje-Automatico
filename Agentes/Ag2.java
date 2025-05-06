package Agentes;

import Mensajes.Mensaje;
import Modelo.Cliente;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
// import jade.core.behaviours.CyclicBehaviour;
// import jade.domain.introspection.ACLMessage;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;


public class Ag2 extends Agent{

    //Configuración inicial agente 
    @Override
    protected void setup() {

        addBehaviour(new Comportamiento());
    }

    // Ultimo suspiro del agente para liberar recursos del agente
    @Override
    protected void takeDown() {
        //Obtener conocimiento --> getArguments()
        // AgentContainer contenedorAgentes = (AgentContainer)getArguments()[0];

        //Obtener ID del agente
        // int i= (int)getArguments()[1];
        // i++;

        //Darle a los agente hijos el contenedor de agentes y el ID del agente padre
        // try {
        //     contenedorAgentes.createNewAgent("Agh" + i, Agh.class.getName(), new Object[]{contenedorAgentes, i}).start();
        // } catch (StaleProxyException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }


        System.out.println("Hasta luego tonotos (AG2)");
    }


    class Comportamiento extends Behaviour {

        private boolean done = false; 
        
        //No llamar al metodo (programación orientada a agentes)
        @Override
        public void action() {

            //Mantiene al agente en espera
            //Este método bloquea la ejecución del agente hasta que llega un mensaje, y cuando esto ocurre, asigna el mensaje recibido a una instancia de la clase ACLMessage.
            
            // try {
            //     //Dado que es un objeto serializado es necesario hacer casting 
            //     Cliente c1 = (Cliente)acl.getContentObject(); 
                
            //     System.out.println(c1.getTotalPagos());
                
            //     done = true; 
                
            //     myAgent.doDelete();
                
                
                
            // } catch (UnreadableException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
            
            //Enviar respuesta de AG2 -> AG1
            jade.lang.acl.ACLMessage acl = blockingReceive();
            
            // Obtener ID de la conversación 
            if (acl.getConversationId().equalsIgnoreCase("AG1-AG2")) {
                //Obtener agente actual
                //Obtener emisor del mensaje (acl)
                //Mensaje
                //Tipo ACL
                //ID conversación 
                // Mensaje.enviarMensaje(getAgent(), acl.getSender().getLocalName(), "hola, soy " + getName(), ACLMessage.REQUEST,  "AG1-AG2");

                System.out.println(acl);

                Mensaje.enviarMensaje(getAgent(), "Ag3", "Hola AG3, te saluda AG2", ACLMessage.REQUEST, "AG2-AG3");
                Mensaje.enviarMensaje(getAgent(), "Ag4", "Hola AG4, te saluda AG2", ACLMessage.REQUEST, "AG2-AG4");
                Mensaje.enviarMensaje(getAgent(), "Ag5", "Hola AG5, te saluda AG2", ACLMessage.REQUEST, "AG2-AG5");

                done = true;
                doDelete();
            }

            

        }

        //Bandera que permite controlar cuántas veces quiero que se realice un comportamiento
        @Override
        public boolean done() {
            // TODO Auto-generated method stub
            return done; 

            //false -> detener ejecución
        }
        

    

    }
}
