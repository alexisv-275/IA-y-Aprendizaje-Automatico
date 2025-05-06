package Agentes;

import Mensajes.Mensaje;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;



public class Agh extends Agent{

private int id; 
private AgentContainer contenedorAgentes;

public static int nroHijoAgh = 0; 

 @Override
 protected void setup() {

    contenedorAgentes = (AgentContainer) getArguments()[0];
    id = (int) getArguments()[1];

    System.out.println(getLocalName() + " con ID: " +  id + " está vivo.");
    addBehaviour(new Comportamiento());
 }

 @Override
 protected void takeDown() {
     System.out.println("nooo mami");

     System.out.println(getLocalName() + " se va a morir.");

    try {
        int siguienteID =  id + 1;
        String nuevoNombre = "Agh" + siguienteID;
        contenedorAgentes.createNewAgent(nuevoNombre, Agh.class.getName(), new Object[]{contenedorAgentes, siguienteID}).start();
        System.out.println("Nuevo agente creado: " + nuevoNombre);
    } catch (StaleProxyException e) {
        e.printStackTrace();
    }

     


 }
    
 class Comportamiento extends Behaviour {
     private boolean done = false; 
     
     @Override
     public void action() {


         // Enviar mensaje a Ag1
         Mensaje.enviarMensaje(getAgent(), "Ag1", "Hola AG1, te saluda " + getLocalName(), ACLMessage.REQUEST, "AGh-AG1-" +  id);

         // Esperar respuesta
         ACLMessage acl = blockingReceive();
         String nombreAgh = acl.getSender().getLocalName();
         if (acl != null && acl.getConversationId().startsWith("AG1-" + nombreAgh)) {
             System.out.println(getLocalName() + " recibió respuesta: " + acl.getContent());
             done = true;
             doDelete(); // Se elimina
         }

        

     }
 
     @Override
     public boolean done() {
         return done;
     }
 }
}
