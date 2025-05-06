# IA y Aprendizaje Automático

## Envío de Mensajes entre Agentes

### Primer Ciclo de Ag1

1. **Interacción Inicial**:
    - **Ag1** envía un mensaje al agente **Ag2** con el objeto `Cliente`.
    - **Ag2** recibe el mensaje, imprime el valor de `c1.getTotalPagos()`, y luego se elimina mediante `doDelete()`.

2. **Respuesta Esperada**:
    - **Ag1** espera una respuesta utilizando el método `blockingReceive()`.
    - Sin embargo, **Ag2** ya no existe para enviar una respuesta, lo que genera un problema.

### Bloqueo de Ag1

- En el siguiente ciclo del comportamiento cíclico de **Ag1**, el método `blockingReceive()` no recibirá ningún mensaje porque **Ag2** ya no está activo.
- Esto provoca que **Ag1** quede bloqueado indefinidamente, esperando un mensaje que nunca llegará.


CLASE 3 
Crear un agente cuando otro acaba de morir

Tarea 
5 3 4 2 1 

variable global para validar recibir 3 mensajes

Ah -> comunica a A1
una vez que acaban de enviar mensaje a 5, mueren
una vez que se crea Ah, muere 5
A1 -> comunica a Ah

2 enviar 3 mensajes y muere

agente 1 se tiene que comunicar con Ahi 


Lista que recibe mensajes y valida id de las conversaciones
AG1 -> validar recibir mensaje con idConversacion
+2 comportamientos (uno puede ir dentro del action)