package prg.hash;import java.util.*;

class Q42576 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> partMap = new HashMap<>();
		for (String name : participant) partMap.put(name, partMap.getOrDefault(name, 0) + 1);
		for (String name : completion) partMap.put(name, partMap.get(name) - 1);
		for (String name : participant) if (partMap.get(name) >= 1) return name;
		return answer;
	}
}