import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // userId와 nickname을 저장할 Map
        Map<String, String> userMap = new HashMap<>();
        // 모든 로그 기록을 저장할 리스트
        List<String[]> logs = new ArrayList<>();

        // 기록을 처리하며 유저 정보 업데이트 및 로그 저장
        for (String entry : record) {
            String[] parts = entry.split(" ");
            String action = parts[0];
            String userId = parts[1];

            if (action.equals("Enter")) {
                userMap.put(userId, parts[2]);  // userId에 해당하는 nickname 업데이트
                logs.add(new String[] {"Enter", userId});
            } else if (action.equals("Leave")) {
                logs.add(new String[] {"Leave", userId});
            } else if (action.equals("Change")) {
                userMap.put(userId, parts[2]);  // userId에 해당하는 nickname 변경
            }
        }

        // 최종 출력 메시지 생성
        String[] answer = new String[logs.size()];
        int idx = 0;
        for (String[] log : logs) {
            String action = log[0];
            String userId = log[1];
            String nickname = userMap.get(userId);

            if (action.equals("Enter")) {
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if (action.equals("Leave")) {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}