package tehnikinaalgoritmi;

import java.awt.*;
import java.util.*;

// fractional knapsack - problem kade sto nemora da go zememe cel predmet

class Item{
    int value, weight;
    Item(int v, int w){
        value = v;
        weight = w;
    }
}
public class Greedy {

    static double fractionalKnapsack(int W, Item[] arr){
        Arrays.sort(arr, (a,b) -> Double.compare((double) b.value/b.weight, (double) a.value/a.weight));

//        Item []  items2 = new Item[arr.length];
//        for(int i = 0; i < arr.length; i++){
//            if((arr[i].value / arr[i].weight) > (arr[i+1].value/arr[i+1].weight)){
//                items2[i] = arr[i];
//            }
//            else{
//                items2[i] = arr[i+1];
//            }
//            // + sledno
//            // im gi menam mestata na arr[i], arr[i+1] vo originalnata niza: arr
//        }
        // mi sporeduva a i b elementi, spored nivnata vrednost sto ja imaat podeleno so tezinata sto ja imaat
        // mi gi dava sortirani na kraj
        double total = 0.0;
        for(Item item : arr){
            if (W >= item.weight){
                W -= item.weight;
                total += item.value;
            }
            else{
                total += item.value * ((double)W / item.weight);
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 11), new Item(120, 15)};
        int W = 13;
        System.out.println(fractionalKnapsack(W, items));
    }
}




