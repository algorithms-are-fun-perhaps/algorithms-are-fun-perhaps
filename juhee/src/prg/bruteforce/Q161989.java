package prg.bruteforce;

/**
 * Q161989. 덧칠하기
 */
public class Q161989 {
	/**
	 * 1. 배열 전체를 0으로 초기화
	 * 2. 배열에 대하여 loop돌며 해당 배열이 1일때 m만큼 배열을 돌며 1을 0으로 변환 및 answer을 1만큼 증가
	 * 3. 이때 경계값 처리에 대한 로직 처리: Math.min(i + m - 1, n)
	 */
	public int solution(int n, int m, int[] section) {
		int answer = 0;
		int[] arr = new int[n + 1];
		for (int sector : section) arr[sector] = 1;
		for (int i = 1 ; i <= n; i++) {
			if (arr[i] == 0) continue;
			for (int j = i; j <= Math.min(i + m - 1, n); j++) {
				if (arr[j] == 1) arr[j] = 0;
			}
			answer++;
		}
		return answer;
	}
}
