/*public class Test {
public static void main(String ar[]) {
	MyTest t1=new MyTest();
	MyTest t2=(MyTest) t1.clone();
	System.out.println(t1.hashCode()+"-----"+t2.hashCode());
	}
}
class MyTest implements Cloneable{
	public Object clone() {
		try{return super.clone();}
		catch(Exception e){ return null; }
			}
}

*/

//A correct implementation of a producer and consumer.
class Test {

        static class Q {
                int n;
                boolean valueSet = false;

                synchronized int get() {
                        while (!valueSet)
                                try {
                                        wait();
                                        Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                        System.out.println("InterruptedException caught");
                                }
                        System.out.println("Got: " + n);
                        valueSet = false;
                        notify();
                        return n;
                }

                synchronized void put(int n) {
                        while (valueSet)
                                try {
                                        wait();
                                        Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                        System.out.println("InterruptedException caught");
                                }
                        this.n = n;
                        valueSet = true;
                        System.out.println("Put: " + n);
                        notify();
                }
        }

        static class Producer implements Runnable {
                Q q;

                Producer(Q q) {
                        this.q = q;
                        new Thread(this, "Producer").start();
                }

                public void run() {
                        int i = 0;
                        while (true) {
                                q.put(i++);
                        }
                }
        }

        static class Consumer implements Runnable {
                Q q;

                Consumer(Q q) {
                        this.q = q;
                        new Thread(this, "Consumer").start();
                }

                public void run() {
                        while (true) {
                                q.get();
                        }
                }
        }

        public static void main(String args[]) {
                Q q = new Q();
                new Producer(q);
                new Consumer(q);
                System.out.println("Press Control-C to stop.");
        }
}