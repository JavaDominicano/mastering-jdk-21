package org.javadominicano.jpe444;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class AnalisisVirtualThread {

    public static void main(String[] args) throws InterruptedException {
        Set<String> nombresPool = ConcurrentHashMap.newKeySet();
        Set<String> nombreHilosPlataforma = ConcurrentHashMap.newKeySet();

        List<Thread> hilos = IntStream.range(0, 1000).mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
            String nombrePool = leerNombrePool();
            nombresPool.add(nombrePool);
            String nombreWorker = leerNombreWorker();
            nombreHilosPlataforma.add(nombreWorker);
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
        String nombre =  Thread.currentThread().toString();
        //System.out.println("Hilo: "+nombre);
        int i1 = nombre.indexOf("@ForkJoinPool");
        int i2 = nombre.indexOf("worker");
        String pool =  nombre.substring(i1, i2);
        //System.out.println("Pool: "+pool);
        return pool;
    }

    private static String leerNombreWorker(){
        String nombre =  Thread.currentThread().toString();
        int i1 = nombre.indexOf("worker");
        String pt = nombre.substring(i1);
        //System.out.println("Pt: "+pt);
        return pt;
    }
}
