package org.javadominicano.jpe444;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleTareaVirtualThread {

    public static void main(String[] args) {

        //Clase entero para trabajar de forma segura entre subprocesos.
        final AtomicInteger atomicInteger =  new AtomicInteger();

        Runnable runnable =  () -> {
            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch(Exception e) {
                System.out.println(e);
            }
            System.out.println("Tarea completada - " + atomicInteger.incrementAndGet());
        };

        Instant start = Instant.now();

        // No es necesario indicar un pool o reserva de hilos para el sistema operativo.
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for(int i = 0; i < 10000; i++) {
                executor.submit(runnable);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        //estará demorando unos 1.5 segundos.
        System.out.println("Tiempo total de ejecución : " + timeElapsed + " ms");
    }
}
