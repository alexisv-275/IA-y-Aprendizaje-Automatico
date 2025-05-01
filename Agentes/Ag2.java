// package Agentes;

// import Mensajes.Mensaje;
// import Modelo.Cliente;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
// import jade.core.behaviours.CyclicBehaviour;
// import jade.domain.introspection.ACLMessage;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;


public class Ag2 extends Agent{

    //Configuración inicial agente 
    @Override
    protected void setup() {

        addBehaviour(new Comportamiento());
    }

    // Ultimo suspiro del agente para liberar recursos del agente
    @Override
    protected void takeDown() {
        System.out.println("Nooooo");
    }

    class Comportamiento extends Behaviour {

        private boolean done = false; 
        
        //No llamar al metodo (programación orientada a agentes)
        @Override
        public void action() {

            //Mantiene al agente en espera
            jade.lang.acl.ACLMessage acl = blockingReceive();

            try {
                //Dado que es un objeto serializado es necesario hacer casting 
                Cliente c1 = (Cliente)acl.getContentObject(); 

                System.out.println(c1.getTotalPagos());

                done = true; 

                myAgent.doDelete();

                

            } catch (UnreadableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Enviar respuesta de AG2 -> AG1

            //Obtener ID de la conversación 
            // if (acl.getConversationId().equalsIgnoreCase("AG1-AG2")) {
            //     //Obtener agente actual
            //     //Obtener emisor del mensaje (acl)
            //     //Mensaje
            //     //Tipo ACL
            //     //ID conversación 
            //     Mensaje.enviarMensaje(getAgent(), acl.getSender().getLocalName(), "hola, soy " + getName(), ACLMessage.REQUEST,  "AG1-AG2");
            // }

            

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
