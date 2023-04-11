class H2O {

    private final Semaphore hydrogenSemaphore = new Semaphore(2);
    private final Semaphore oxygenSemaphore = new Semaphore(0);
    
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        
        if (hydrogenSemaphore.availablePermits() == 0) {
            oxygenSemaphore.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();

        hydrogenSemaphore.release(2);
    }
}