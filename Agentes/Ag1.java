// package Agentes;

import Mensajes.Mensaje;
import Modelo.Cliente;
import jade.core.Agent;
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
    class Comportamiento extends CyclicBehaviour {
        
        //No llamar al metodo (programación orientada a agentes)
        @Override
        public void action() {
            System.out.println(getName());
            // Mensaje.enviarMensaje(getAgent(), "Ag2", "Hola", ACLMessage.REQUEST, "AG1-AG2");

            Cliente c1 = new Cliente(1,2,50, 25, 20, 21.2,  100.5, 55.25); 

            Mensaje.enviarMensajeObj(getAgent(), "Ag2", c1, ACLMessage.REQUEST, "AG1-AG2");

    

            ACLMessage acl = blockingReceive(); 
            System.out.println(acl);

        }

    

    }
}
