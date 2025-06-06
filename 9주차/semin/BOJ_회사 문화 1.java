import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            graph.get(parent).add(i);
        }

        int[] answer = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            answer[node] += weight;
        }

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{1, 0});
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int curNode = cur[0];
            int curWeight = answer[curNode];
            int totalWeight = cur[1];
            answer[curNode] += totalWeight;
            for (int nextNode : graph.get(curNode)) {
                stack.push(new int[]{nextNode, curWeight + totalWeight});
            }
        }

        System.out.println(
            IntStream.rangeClosed(1, n)
                     .mapToObj(i -> String.valueOf(answer[i]))
                     .collect(Collectors.joining(" "))
        );
    }
}
