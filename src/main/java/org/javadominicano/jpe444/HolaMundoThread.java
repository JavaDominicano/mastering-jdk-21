package org.javadominicano.jpe444;

public class HolaMundoThread {

    public static void main(String[] args) throws InterruptedException {

        //Creando un hilo tradicional, conocido ahora como hilos de plataforma.
        Thread hiloPlataforma = Thread.ofPlatform().unstarted(() -> System.out.println(Thread.currentThread()));
        hiloPlataforma.start();

        //Creando el hilo virtual, notar que seguimos utilizando la clase Thread.
        Thread hiloVirtual  = Thread.ofVirtual().unstarted(()-> System.out.println(Thread.currentThread()));
        hiloVirtual.start();

        //Esperando que el hilo complete.
        hiloPlataforma.join();

        //Esperando que el hilo complete.
        hiloVirtual.join();

        System.out.println("Clase "+ hiloVirtual.getClass());
    }
}
