package org.javadominicano.jpe444;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleTareaPlataformaThread {

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

        try (var executor = Executors.newFixedThreadPool(100)) {
            for(int i = 0; i < 10000; i++) {
                executor.submit(runnable);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        //estará demorando unos 101 segundos.
        System.out.println("Tiempo total de ejecución : " + timeElapsed + " ms");
    }
}
