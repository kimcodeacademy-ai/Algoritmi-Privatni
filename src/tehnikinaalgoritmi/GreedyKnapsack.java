package tehnikinaalgoritmi;

import java.util.Arrays;

public class GreedyKnapsack {

    static class Item {
        int weight;
        int value;
        double ratio;

        Item(int w, int v) {
            weight = w;
            value = v;
            ratio = (double) v / w;
        }

//        extends Comparable<Item>

//        @Override
//        public int compareTo(Item o) {
//            if (o.ratio > this.ratio) return 1;
//            else if (o.ratio < this.ratio) return -1;
//            else return 0;
//        }
    }

    public static void main(String[] args) {
//        Item[] items = {
//                new Item(2, 12),
//                new Item(1, 10),
//                new Item(3, 20),
//                new Item(2, 15)
//        };

        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        //int W = 5;
        int W = 50;

        System.out.println("Max value (Greedy 0/1): " + greedyKnapsack(items, W));
        System.out.println("Max value (Fractional): " + greedyFractionalKnapsack(items, W));
    }

    static int greedyKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        int totalValue = 0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
            }
        }
        return totalValue;
    }

    static double greedyFractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                int remaining = capacity - currentWeight;
                totalValue += item.ratio * remaining;
                break;
            }
        }
        return totalValue;
    }
}
