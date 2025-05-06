package Agentes;

import Mensajes.Mensaje;
import Modelo.Cliente;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Ag1 extends Agent{

    //Configuración inicial agente 
    @Override
    protected void setup() {

        //Agregar comportamiento al agente
        addBehaviour(new Comportamiento());
    }
    
    //Comportamiento cíclico, paralelo y secuencial 
    //Ciclico -> rutinas (Cyclic Behaviour)
    //Paralelo -> dos o más cosas al mismo tiempo
    //Secuencial -> se hace una sola vez (Behaviour)
    
    //Crear comportamiento ciclicos 

    //Multiagents system con Jade
    class Comportamiento extends Behaviour {
        private boolean mensajeEnviado = false;

        //No llamar al metodo (programación orientada a agentes)
        @Override
        public void action() {
            // System.out.println(getName());
            // Mensaje.enviarMensaje(getAgent(), "Ag2", "Hola AG2, te saluda AG1", ACLMessage.REQUEST, "AG1-AG2");


            if (!mensajeEnviado) {
                System.out.println(getName());
                Mensaje.enviarMensaje(getAgent(), "Ag2", "Hola AG2, te saluda AG1", ACLMessage.REQUEST, "AG1-AG2");
                mensajeEnviado = true;
            }
            // Cliente c1 = new Cliente(1,2,50, 25, 20, 21.2,  100.5, 55.25); 

            // Mensaje.enviarMensajeObj(getAgent(), "Ag2", c1, ACLMessage.REQUEST, "AG1-AG2");

            // blockingReceive();

            /* 
            ACLMessage acl = blockingReceive(); 
            System.out.println(acl);

            if (acl.getConversationId().equalsIgnoreCase("AGh-AG1")) {

                //2
                System.out.println("Mensaje recibido de Agh");

                Mensaje.enviarMensaje(getAgent(), "Agh" + Agh.nroHijoAgh, "Helou AGH cómo vas", ACLMessage.REQUEST, "AG1-AGh" + Agh.nroHijoAgh);
            }


            // if (acl.getConversationId().equalsIgnoreCase("AGh" + Agh.nroHijoAgh + "-AG1")) {

            //     System.out.println("Mensaje recibido de Ag" + Agh.nroHijoAgh);

            //     Mensaje.enviarMensaje(getAgent(), "Agh" + Agh.nroHijoAgh, "Hola AGh" + Agh.nroHijoAgh + " te saluda AG1", ACLMessage.REQUEST, "AG1-AG" + Agh.nroHijoAgh);
                
            // }

            /* 

            ACLMessage acl = blockingReceive(); 

            if (acl != null) {
                System.out.println("Mensaje recibido en AG1 de " + acl.getSender().getLocalName() + ": " + acl.getContent());

                // System.out.println(acl);
                String conversationId = acl.getConversationId();

                Mensaje.enviarMensaje(getAgent(), acl.getSender().getLocalName(),
                            "Hola " + acl.getSender().getLocalName() + ", te saluda AG1", ACLMessage.REQUEST, conversationId);
    
                // Responder al agente Agh
                // if (acl.getConversationId().startsWith("AGh-AG1")) {
                //     String conversationId = acl.getConversationId();
                //     Mensaje.enviarMensaje(getAgent(), acl.getSender().getLocalName(),
                //             "Hola " + acl.getSender().getLocalName() + ", te saluda AG1", ACLMessage.REQUEST, conversationId);
                // }
            }
                */

                ACLMessage acl = blockingReceive(); 
            System.out.println(acl);

                if (acl != null && acl.getConversationId().startsWith("AGh-AG1")) {
                    String nombreAgh = acl.getSender().getLocalName();
                    System.out.println("Mensaje recibido de " + nombreAgh);
                
                    Mensaje.enviarMensaje(getAgent(), nombreAgh, "Hola " + nombreAgh + ", te saluda Ag1", ACLMessage.INFORM, "AG1-" + nombreAgh);
                }
                


        }

        @Override
        public boolean done() {
            return false;
            
        }

    

    }
}
