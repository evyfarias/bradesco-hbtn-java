public class Consumidor extends Thread {
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consumir();       
                Thread.sleep(1500);      
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
