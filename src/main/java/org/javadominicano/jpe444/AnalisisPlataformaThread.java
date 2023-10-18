package org.javadominicano.jpe444;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class AnalisisPlataformaThread {

    public static void main(String[] args) throws InterruptedException {
        Set<String> nombresPool = ConcurrentHashMap.newKeySet();
        Set<String> nombreHilosPlataforma = ConcurrentHashMap.newKeySet();

        List<Thread> hilos = IntStream.range(0, 10000000).mapToObj(i -> Thread.ofPlatform().unstarted(() -> {
            String nombrePool = leerNombrePool();
            nombresPool.add(nombrePool);
            String nombreWorker = leerNombreWorker();
            nombreHilosPlataforma.add(nombreWorker);
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        })).toList();

        Instant inicioEjecucion = Instant.now();

        hilos.forEach(Thread::start);
        for(Thread hilo : hilos){
            hilo.join();
        }

        Instant finEjecucion =  Instant.now();
        System.out.println("Tiempo = " + Duration.between(inicioEjecucion, finEjecucion).toMillis()+ "ms");
        System.out.println("Número de Core = "+ Runtime.getRuntime().availableProcessors());
        System.out.println("Número de Pools = "+ nombresPool.size());
        System.out.println("Número de Hilos de Plataformas = "+ nombreHilosPlataforma.size());


    }

    private static String leerNombrePool(){
        return Thread.currentThread().getThreadGroup().getName();
    }

    private static String leerNombreWorker(){
        return Thread.currentThread().getName();
    }
}
