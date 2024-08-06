package prg.bruteforce;

/**
 * Q161990. 바탕화면 정리하기
 */
public class Q161990 {
	/**
	 * 1. 문자열에 대하여 문자 이차원 배열로 변경
	 * 2. 이차원 배열에 대하여 loop를 돌며 파일이 발견될때마다 가로, 세로의 최대 최소값을 갱신
	 * 3. 배열이 다 돈 후 구해진 좌표를 반환
	 */
	public int[] solution(String[] wallpaper) {
		int[] answer = new int[4];
		int width = wallpaper[0].length();
		int height = wallpaper.length;
		int rowMin = Integer.MAX_VALUE, rowMax = Integer.MIN_VALUE, colMin = Integer.MAX_VALUE, colMax = Integer.MIN_VALUE;
		char[][] board = new char[height][width];
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				board[x][y] = wallpaper[x].charAt(y);
			}
		}

		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (board[x][y] == '#') {
					rowMin = Math.min(rowMin, y);
					rowMax = Math.max(rowMax, y);
					colMin = Math.min(colMin, x);
					colMax = Math.max(colMax, x);
				}
			}
		}
		answer[0] = colMin;
		answer[1] = rowMin;
		answer[2] = colMax + 1;
		answer[3] = rowMax + 1;
		return answer;
	}
}
