package AISD;

import java.util.ArrayList;

public class Dynamic {
    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int maxweight = 17;
        int count = weights.length;

        int A[][] = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[maxweight + 1];
        }
        for (int k = 0; k <= count; k++) {
            for (int s = 0; s <= maxweight; s++) {
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    if (s >= weights[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - weights[k - 1]] + prices[k - 1]);
                    } else {
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        roadResult(A, weights, count, maxweight, result);

        System.out.println("Лучший набор предметов:");
        for (Integer integer : result)
            System.out.println(integer);
    }
    public static void roadResult(int A[][], int[] weight, int k, int s, ArrayList<Integer> result/*Для накопления предметов, которые входят в л.н*/) {
        if (A[k][s] == 0) {
            return;
        }
        if (A[k - 1][s] == A[k][s]/*k предмет не участвует*/) {
            roadResult(A, weight, k - 1, s, result);
        } else {
            roadResult(A, weight, k - 1, s - weight[k-1], result);
            result.add(0,k);
        }
    }
}
