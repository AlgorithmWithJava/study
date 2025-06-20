import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int a = 1; a < n + 1; a++) {
            int b = Integer.parseInt(st.nextToken());
            if (b != -1) {
                list[b].add(a);
            }
        }

        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int man = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            visited[man] += w;

        }

        dfs(1);

        for (int i = 1; i < n + 1; i++) {
            System.out.print(visited[i] + " ");
        }
    }

    static void dfs(int idx) {
        for (int nxt : list[idx]) {
            visited[nxt] += visited[idx];
            dfs(nxt);
        }
    }
}
