/**
 * Created by Ronni on 18-10-2016.
 */
public class ReverseHello extends Thread
{
    private int count;

    public ReverseHello(int n) {
        this.count = n;
    }

    @Override
    public void run() {
        while(count > 0) {
            System.out.println("Hello from " + count);
            count--;
            run();
        }
    }

    public static void Hello() throws InterruptedException {
        ReverseHello ts = new ReverseHello(50);
        ts.start();
    }

    public static void main(String[] args) throws InterruptedException {
        Hello();
    }
}