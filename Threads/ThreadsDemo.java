public class ThreadsDemo {
  public static void main(String[] args) {
    // two threads in java which runs in parallel
    Thread threadA = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println(i + ": " + Thread.currentThread().getName());
        }
      }
    }, "Thread A");

    Thread threadB = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println(i + ": " + Thread.currentThread().getName());
        }
      }
    }, "Thread B");

    // Starting both threads in java
    threadA.start();
    threadB.start();
  }
}