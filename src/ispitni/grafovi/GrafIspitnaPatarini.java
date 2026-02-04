//Боjан сака да го посети Берлин. Но, Боjан има ограничени средства, па истиот
//мора да избира по коj пат е наjповолно да се движи. За таа цел, тоj изнаjмил
//автомобил и купил мапа на Европа. На неа има ‘N‘ градови. Поме´гу секои два
//града може да има наjмногу еден директен транспортен пат (патот е двонасочен).
//За секоj од тие патишта, Боjан знае колкав броj патарини треба да се поминат
//при изминување на соодветниот пат. Можете ли да му помогнете на Боjан, и
//да jа откриете рутата од Скопjе до Берлин, на коj треба да се поминат наjмал
//можен броj на патарини?
//Влез: Во првата линиjа е запишан еден цел броj ‘N‘ (2 <= N <= 1000), коj
//го означува броjот на градови. Секоj од градовите е означен со единствен броj
//id - коj се движи од 1 до N. Во втората линиjа се запишани два цели броjа ‘A‘
//и ‘B‘ (1 <= A, B <= N), кои ги означуваат id-ата на градовите Скопjе (А) и
//Берлин (B). Во третата линиjа е запишан еден цел броj ‘M‘ (N <= M <= 1500),
//коj го означува броjот на директни патишта. Во секоj од следните M редови се
//запишани по три цели броjа ‘X‘, ‘Y‘ (1 <= X, Y <= N) и ‘K‘ (1 <= K <= 1000),
//кои означуваат дека постои двонасочен пат од X до Y, и на истиот се нао´гаат K
//патарини.
//        Излез: Отпечатете го бараниот наjмал можен броj на патарини.
//Забелешка: Дозволено е користење на готови класи од Java API.
//        Пример:
//Влез:
//        10
//        7 8
//        13
//        1 2 387
//        2 3 831
//        4 1 820
//        5 4 204
//        5 6 304
//        4 7 381
//        5 8 238
//        9 5 214
//        9 10 126
//        8 6 709
//        4 3 3
//        6 7 732
//        3 1 488
//Излез:
//        823



package ispitni.grafovi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GrafIspitnaPatarini {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt() - 1;
        int B = sc.nextInt() -1;
        int M = sc.nextInt();

        Graph<String> g = new Graph<>(N);
        for(int i = 0; i < N; i++){
            g.adjList[i] = new GraphNode<>(i, "City" + (i+1));
        }
        for(int i = 0; i < M; i++){
            int X = sc.nextInt() - 1;
            int Y = sc.nextInt() - 1;
            int K = sc.nextInt();
            g.addEdge(X, Y, K);
            g.addEdge(Y, X, K);
        }

        int result = dijkstra(g, A, B);
        System.out.println(result);

    }

    public static int dijkstra(Graph<String> g, int start, int end){
        int n = g.num_nodes;
        int [] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a  -> a[1]));
        pq.add(new int[]{start, 0});

        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int u =  curr[0];
            if(visited[u]) continue;

            if(u == end){
                return dist[u];
            }

            for (GraphNodeNeighbor<String> neighbor : g.adjList[u].getNeighbors()) {
                int v = neighbor.node.getIndex();
                int weight = (int) neighbor.weight;

                if(dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        return -1;
    }
}