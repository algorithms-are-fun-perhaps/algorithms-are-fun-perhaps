package prg.stack;
import java.util.*;

class Q76502 {
	public int solution(String s) {
		int answer = isRightExp(s) ? 1 : 0;
		for (int i = 0; i < s.length() - 1; i++) {
			s =  s.substring(1, s.length()) + s.charAt(0);
			answer += isRightExp(s) ? 1 : 0;
		}
		return answer;
	}

	static boolean isRightExp(String str) {
		Stack<Character> from = new Stack<>();
		Stack<Character> to = new Stack<>();
		for (char c : str.toCharArray()) from.push(c);
		while (!from.isEmpty()) {
			Character tmp = from.pop();
			if (tmp.equals('(')) {
				if (to.isEmpty()) return false;
				Character cp = to.pop();
				if (!cp.equals(')')) return false;
			} else if (tmp.equals('{')) {
				if (to.isEmpty()) return false;
				Character cp = to.pop();
				if (!cp.equals('}')) return false;
			}  else if (tmp.equals('[')) {
				if (to.isEmpty()) return false;
				Character cp = to.pop();
				if (!cp.equals(']')) return false;
			} else {
				to.push(tmp);
			}
		}
		if (!to.isEmpty()) return false;
		return true;
	}
}