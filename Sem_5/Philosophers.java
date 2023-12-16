package Sem_5;

// Есть пять философов (потоки), которые могут либо обедать либо размышлять.
// Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
// После каждого приема пищи философ должен размышлять
// Не должно возникнуть общей блокировки
// Философы не должны есть больше одного раза подряд

import java.util.concurrent.Semaphore;

public class Philosophers {

    public static void main(String[] args) {
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Semaphore table = new Semaphore(numPhilosophers - 1);

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, table);
            new Thread(philosophers[i]).start();
        }
    }

    static class Philosopher implements Runnable {
        private int id;
        private Semaphore table;

        public Philosopher(int id, Semaphore table) {
            this.id = id;
            this.table = table;
        }

        private void PhilosopherThink() {
            System.out.println("Философ " + id + " думает");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void PhilosopherEat() {
            System.out.println("Философ " + id + " ест");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                PhilosopherThink();
                try {
                    table.acquire();
                    PhilosopherEat();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    table.release();
                }
            }
        }
    }
}
