package q1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, M, N, K, count;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void DFS(int x, int y) {

		int i, ax, ay;

		if (map[x][y] == 0)
			return;

		map[x][y] = 0;

		for (i = 0; i < 4; i++) {
			ax = x + dx[i];
			ay = y + dy[i];

			if (ax < 0 || ax >= M || ay < 0 || ay >= N)
				continue;

			DFS(ax, ay);
		}
	}

	public static void main(String[] args) throws IOException {

		int i, j, k;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());

		for (k = 0; k < T; k++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			count = 0;
			map = new int[M][N];

			for (i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}

			for (i = 0; i < M; i++) {
				for (j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						DFS(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		in.close();
	}
}
