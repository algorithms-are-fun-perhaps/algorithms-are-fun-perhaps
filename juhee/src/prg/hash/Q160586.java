package prg.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Q160586. 대충 만든 자판
 */
public class Q160586 {
	/**
	 * 1. keymap에 대하여 loop를 돌며 각 문자별 입력하기 위해 누르는 횟수의 최소값을 map에 저장
	 * 2. 입력해야하는 문자에 대하여 반복문을 돌며 map에서 눌러야하는 횟수를 조회하여 집계한다.
	 * 3. 만약 key가 없을 경우 -1을 답에 할당한다.
	 */
	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		Map<Character, Integer> map = new HashMap<>();
		for (String keys : keymap) {
			for (int i = 0; i < keys.length(); i++) {
				map.merge(keys.charAt(i), i + 1,  (oldValue, newValue) -> Math.min(oldValue, newValue));
			}
		}

		for (int x = 0; x < targets.length; x++) {
			int cnt = 0;
			boolean isMapped = true;
			for (int y = 0; y < targets[x].length(); y++) {
				if (!map.containsKey(targets[x].charAt(y))) {
					isMapped = false;
					break;
				}
				cnt += map.get(targets[x].charAt(y));
			}

			answer[x] = isMapped ? cnt : -1;
		}
		return answer;
	}
}
