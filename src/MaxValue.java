/**
 * Created by Ronni on 18-10-2016.
 */

import java.util.Random;
public class MaxValue extends Thread {
    private int lo, hi;
    private int[] arr;
    private int max = 0;

    public MaxValue(int[] arr, int lo, int hi) {
        this.arr = arr;
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    public void run() {
        for (int i = lo; i < hi; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
    }


    public static int max(int[] arr) throws InterruptedException {
        int len = arr.length;
        int temp = 0;
        MaxValue[] ts = new MaxValue[4];
        for (int i = 0; i < 4; i++) {
            ts[i] = new MaxValue(arr, (i * len) / 4, ((i + 1) * len / 4));
            ts[i].start();
        }

        for (int i = 0; i < 4; i++) {
            ts[i].join();
            if(ts[i].max > temp){
                temp = ts[i].max;
            }
        }
        return temp;
    }

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000) + 1;
        }
        int max = max(arr);
        System.out.println("Max: " + max);
    }
}
