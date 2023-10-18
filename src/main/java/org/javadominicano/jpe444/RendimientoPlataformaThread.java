package org.javadominicano.jpe444;

import java.util.List;
import java.util.stream.IntStream;

public class RendimientoPlataformaThread {

    public static void main(String[] args) throws InterruptedException {
        //Creando lista de hilos
        List<Thread> hilos = IntStream.range(0, 10).mapToObj(i -> Thread.ofPlatform().unstarted(() -> {
            if(i == 0){
                System.out.println(Thread.currentThread());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i == 0){
                System.out.println(Thread.currentThread());
            }
        })).toList();

        //
        hilos.forEach(Thread::start);
        for(Thread hilo : hilos){
            hilo.join();
        }
    }
}
