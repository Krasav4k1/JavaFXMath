package sample;


import java.util.Scanner;

public class Lab2 {


    public String lab2(int count, String matrix){
        Scanner sc = new Scanner(matrix);
        int [][] cost = new int[10][10];
        int [] visited = new int[10];
        int [] path = new int[100];
        int a = 0, b = 0, u = 0, v = 0, n;
        int pathIndex = 0;
        int mincost = 0;
        int ne = 1;
        int min;

        n = count;

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0) cost[i][j] = 999;
            }
        }

        visited[1] = 1;
        System.out.println();

        while (ne < n){
            min = 999;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        if (visited[i] != 0) {
                            min = cost[i][j];
                            a = u = i;
                            b = v = j;
                        }
                    }
                }
            }

            if(visited[u] == 0 || visited[v] == 0){
                path[pathIndex] = b;
                pathIndex++;
                ne++;
                mincost += min;
                visited[b] = 1;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        String rez;
        rez =1 + " <--> ";
        for(int i = 0; i < n-1; i++){
            rez += path[i];
            if(i < n - 2) {
                rez +=" <--> ";
            }
        }



        return rez+"\nМінімальная стоймость " + mincost;
    }



    public String lab2Forlab3(int count, String matrix){
        Scanner sc = new Scanner(matrix);
        int [][] cost = new int[10][10];
        int [] visited = new int[10];
        int [] path = new int[100];
        int a = 0, b = 0, u = 0, v = 0, n;
        int pathIndex = 0;
        int mincost = 0;
        int ne = 1;
        int min;

        n = count;

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0) cost[i][j] = 999;
            }
        }

        visited[1] = 1;
        System.out.println();

        while (ne < n){
            min = 999;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        if (visited[i] != 0) {
                            min = cost[i][j];
                            a = u = i;
                            b = v = j;
                        }
                    }
                }
            }

            if(visited[u] == 0 || visited[v] == 0){
                path[pathIndex] = b;
                pathIndex++;
                ne++;
                mincost += min;
                visited[b] = 1;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        String rez;
        rez =1 + " <--> ";
        for(int i = 0; i < n-1; i++){
            rez += path[i];
            if(i < n - 2) {
                rez +=" <--> ";
            }
        }



        return rez;
    }



}
