/**
 * Created by Ronni on 20-10-2016.
 */
public class SharedCounter extends Thread
{
    private static int count;

    public SharedCounter() {
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            count++;
            i++;
        }
        System.out.println(getCount());
    }

    public int getCount()
    {
        return count;
    }

    public static void counter() throws InterruptedException {
        SharedCounter[] ts = new SharedCounter[10];
        for (int i = 0; i < 10; i++) {
            ts[i] = new SharedCounter();
            ts[i].start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        counter();
    }
}
