public class MNSoma {
    public static void main(String[] args) {
        int totalThreads = 1000;
        int numeroA = 2;
        int numeroB = 3;

        long inicio = System.currentTimeMillis();

        //definindo tamanho de 3 pools de threads
        //ExecutorService faz a distribuição do totalThreads com as do pool
        java.util.concurrent.ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(3);

        for (int i = 1; i <= totalThreads; i++) {
            final int id = i;
            //cada thread do usuario é enviada
            pool.submit(() -> {
                for (int j = 0; j < 3; j++) { // 3 iterações por thread
                    int soma = numeroA + numeroB;
                    System.out.println("Thread " + id + " soma: " + numeroA + " + " + numeroB + " = " + soma);
                }
            });
        }

        pool.shutdown();
        try {
            pool.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) + " ms");
    }
}
