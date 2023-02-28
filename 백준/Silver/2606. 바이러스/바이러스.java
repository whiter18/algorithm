import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        int answer = -1;
        boolean[][] isConnected = new boolean[N][N];
        boolean[] isVisited = new boolean[N];
        
        for (int i = 0 ; i < cnt; i++){
            String[] input = br.readLine().split(" ");
            isConnected[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = true;
            isConnected[Integer.parseInt(input[1])-1][Integer.parseInt(input[0])-1] = true;  
        }
                
        Queue<Integer> que = new LinkedList<>();
        
        que.add(0);
        
        while(!que.isEmpty()){
            int current = que.poll();
            
            if(isVisited[current]){
                continue;
            }
            
            isVisited[current] = true;
            answer++;
            
            for (int i = 0 ; i < N; i++){
                if (isConnected[current][i] && !isVisited[i]){
                    que.add(i);
                }
            }
            
        }
        System.out.println(answer);
    }    
}
