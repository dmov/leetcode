class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile boolean isFirstWasCalled = false;
    private volatile boolean isSecondWasCalled = false;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();

                isFirstWasCalled = true;
                isSecondWasCalled = false;
                notifyAll();

                while (!isSecondWasCalled) {
                    wait();
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!isFirstWasCalled) {
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();

                isSecondWasCalled = true;
                isFirstWasCalled = false;
                notifyAll();
            }
        }
    }
}