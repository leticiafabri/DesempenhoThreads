public class UMSoma {
    public static void main(String[] args) {
        int totalThreads = 1000; //numero de threads
        int numeroA = 2;
        int numeroB = 3;

        long inicio = System.currentTimeMillis();

        //criando array de threads (cada uma vai ser uma thread do sistema)
        Thread[] threads = new Thread[totalThreads];


        // para cada thread de usuario, cria uma thread de sistema
        for (int i = 0; i < totalThreads; i++) {
            final int id = i + 1;
            //criando a thread real no sistema
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 3; j++) { // 3 iterações por thread
                    int soma = numeroA + numeroB;
                    System.out.println("Thread " + id + " soma: " + numeroA + " + " + numeroB + " = " + soma);
                }
            });
        }

        // Inicia todas as threads de uma vez
        for (Thread t : threads) {
            t.start();
        }


        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) + " ms");
    }
}
