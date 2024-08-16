package prg.bruteforce;

/**
 * Q172928. 공원산책
 */
public class Q172928 {
	/**
 * 1. park를 바탕으로 String[][] board를 만들고 시작 지점을 찾는다.
 * 2. routes에 대하여 loop를 돌며 로봇 강아지를 움직인다.
 */
	public int[] solution(String[] park, String[] routes) {
		int[] answer = {};
		int[] cur = new int[2];
		char[][] board = new char[park.length][park[0].length()];
		// 공원을 표현한 이차원 배열 board를 만드는 코드
		for (int x = 0; x < park.length; x++) {
			for (int y = 0; y < park[x].length(); y++) {
				char tmp = park[x].charAt(y);
				board[x][y] = tmp;
				// 출발점이 나올 경우 해당 좌표를 point에 저장
				if (tmp == 'S') {
					cur[0] = x;
					cur[1] = y;
				}
			}
		}
		// 주어진 명령어들에 대하여 loop를 돌며 로봇 강아지의 좌표를 구하는 코드
		for (int x = 0; x < routes.length; x++) {
			char dir = routes[x].split(" ")[0].charAt(0);
			int steps = Integer.parseInt(routes[x].split(" ")[1]);
			// 동쪽으로 움직일 때
			if (dir == 'E') {
				int ny = cur[1] + steps;
				boolean isBlocked = false;
				if (ny >= park[0].length()) continue;
				for (int y = cur[1]; y <= ny; y++) {
					if (board[cur[0]][y] == 'X') {
						isBlocked = true;
						break;
					}
				}
				if (!isBlocked) cur[1] = ny;
			}

			// 서쪽으로 움직일 때
			if (dir == 'W') {
				int ny = cur[1] - steps;
				boolean isBlocked = false;
				if (ny < 0) continue;
				for (int y = cur[1]; y >= ny; y--) {
					if (board[cur[0]][y] == 'X') {
						isBlocked = true;
						break;
					}
				}
				if (!isBlocked) cur[1] = ny;
			}

			// 북쪽으로 움직일 때
			if (dir == 'N') {
				int nx = cur[0] - steps;
				boolean isBlocked = false;
				if (nx < 0) continue;
				for (int y = cur[0]; y >= nx; y--) {
					if (board[y][cur[1]] == 'X') {
						isBlocked = true;
						break;
					}
				}
				if (!isBlocked) cur[0] = nx;
			}

			// 남쪽으로 움직일 때
			if (dir == 'S') {
				int nx = cur[0] + steps;
				boolean isBlocked = false;
				if (nx >= park.length) continue;
				for (int y = cur[0]; y <= nx; y++) {
					if (board[y][cur[1]] == 'X') {
						isBlocked = true;
						break;
					}
				}
				if (!isBlocked) cur[0] = nx;
			}
		}
		answer = cur;
		return answer;
	}
}
