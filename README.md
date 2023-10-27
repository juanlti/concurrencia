# concurrencia

Tp2 -> Synchronized
Tp3 -> Syncrhonized
Tp4 -> Semaphore binary
Tp5 -> Semaphore general
Tp6 -> Monitors (await,notify,notifyAll,syncrhonized)




Circuito cerrado de: Semaphore binary

Circuito de aprendizaje con semaforo binario
//Observaciones:

Un HiloClaseA va a ejecutar su propio mensaje hacerA del recurso Compartido, mientras que otro hilo HiloClasaB ejecuta su propio mensaje hacerB del recursoCompartido.
Si el hiloClaseA realizo una modificacion del atributo compartido AC, y el otro HiloClasaB en su mensaje hacerB, necesita obtener el valor de atributo compartido AC, lo va tener, casos: AC => aun no se alcazo a actualizar
                    AC => actualizado! 
Sin importar si hiloClaseA   sigue  acquire(), o esta en release(),
Conclusion: El recurso Compartido, funciona de manera independiente para  los hilos que esten o no retenidos.  La actualizacion de los atributos en el recurso Compartido es inmediato, para los demas hilos que ejecuten un mensaje diferente al que realizo dicha modificacion.

![WhatsApp Image 2023-10-26 at 21 19 52](https://github.com/juanlti/concurrencia/assets/47389717/af4cb54e-4df9-40b8-9bbd-6743ba5fa254)

