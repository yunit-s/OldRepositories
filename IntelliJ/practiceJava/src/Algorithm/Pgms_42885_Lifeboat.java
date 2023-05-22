package Algorithm;

import java.util.*;

// int[] 를 ArrayList로 바꿨더니 시간초과
// 여기서 LinkedList로 바꾸면 더 느려져서 효율성 1~5 모두 시간초과로 바뀜.
//        정확성  테스트
//        테스트 1 〉	통과 (9.93ms, 75.6MB)
//        테스트 2 〉	통과 (7.10ms, 76.4MB)
//        테스트 3 〉	통과 (7.15ms, 75.7MB)
//        테스트 4 〉	통과 (9.40ms, 73MB)
//        테스트 5 〉	통과 (4.77ms, 78.7MB)
//        테스트 6 〉	통과 (4.23ms, 78.6MB)
//        테스트 7 〉	통과 (4.54ms, 82.6MB)
//        테스트 8 〉	통과 (2.63ms, 74.4MB)
//        테스트 9 〉	통과 (3.33ms, 73.2MB)
//        테스트 10 〉	통과 (8.48ms, 79MB)
//        테스트 11 〉	통과 (8.89ms, 80.6MB)
//        테스트 12 〉	통과 (5.92ms, 80.2MB)
//        테스트 13 〉	통과 (7.40ms, 81MB)
//        테스트 14 〉	통과 (8.62ms, 75.4MB)
//        테스트 15 〉	통과 (4.19ms, 69.1MB)
//        효율성  테스트
//        테스트 1 〉	통과 (52.16ms, 57.4MB)
//        테스트 2 〉	통과 (45.25ms, 55.9MB)
//        테스트 3 〉	통과 (41.95ms, 56.1MB)
//        테스트 4 〉	통과 (39.80ms, 54.4MB)
//        테스트 5 〉	실패 (시간 초과)
class Solution_42885_3 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Integer[] peopleArray = Arrays.stream(people).boxed().toArray(Integer[]::new); // int[] 를 Integer[]로 변경
        List<Integer> list = new ArrayList<>(Arrays.asList(peopleArray));
        list.sort(Comparator.naturalOrder());
        int small = 0, big = people.length - 1;
        while (small <= big) {
            if (small == big) {
                answer++;
                break;
            } else {
                if (list.get(small) + list.get(big) > limit) {
                    big--;
                    answer++;
                } else {
                    small++;
                    big--;
                    answer++;
                }
            }
        }

        return answer;
    }
}

// 통과
//        정확성  테스트
//        테스트 1 〉	통과 (2.11ms, 70.8MB)
//        테스트 2 〉	통과 (1.35ms, 76.1MB)
//        테스트 3 〉	통과 (1.25ms, 77.8MB)
//        테스트 4 〉	통과 (2.44ms, 72.1MB)
//        테스트 5 〉	통과 (0.99ms, 72.5MB)
//        테스트 6 〉	통과 (1.00ms, 81.9MB)
//        테스트 7 〉	통과 (1.15ms, 72.8MB)
//        테스트 8 〉	통과 (0.52ms, 75MB)
//        테스트 9 〉	통과 (0.57ms, 71MB)
//        테스트 10 〉	통과 (1.60ms, 76.9MB)
//        테스트 11 〉	통과 (1.75ms, 76.7MB)
//        테스트 12 〉	통과 (1.02ms, 74.8MB)
//        테스트 13 〉	통과 (1.23ms, 74.8MB)
//        테스트 14 〉	통과 (1.00ms, 78.8MB)
//        테스트 15 〉	통과 (0.65ms, 79.5MB)
//        효율성  테스트
//        테스트 1 〉	통과 (12.71ms, 64.7MB)
//        테스트 2 〉	통과 (8.69ms, 53.8MB)
//        테스트 3 〉	통과 (10.67ms, 53.5MB)
//        테스트 4 〉	통과 (13.07ms, 69.2MB)
//        테스트 5 〉	통과 (9.68ms, 54.1MB)
class Solution_42885_2 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int small = 0, big = people.length - 1;
        while (small <= big) {
            if (small == big) {
                answer++;
                break;
            } else {
                if (people[small] + people[big] > limit) {
                    big--;
                    answer++;
                } else {
                    small++;
                    big--;
                    answer++;
                }
            }
        }

        return answer;
    }
}

//        정확성  테스트
//        테스트 1 〉	통과 (2512.88ms, 79.8MB)
//        테스트 2 〉	통과 (3251.70ms, 95.2MB)
//        테스트 3 〉	통과 (839.09ms, 74.5MB)
//        테스트 4 〉	통과 (373.14ms, 102MB)
//        테스트 5 〉	통과 (147.67ms, 86.4MB)
//        테스트 6 〉	통과 (86.99ms, 91.2MB)
//        테스트 7 〉	통과 (199.18ms, 78.7MB)
//        테스트 8 〉	통과 (7.05ms, 75.9MB)
//        테스트 9 〉	통과 (8.16ms, 75.6MB)
//        테스트 10 〉	통과 (1092.65ms, 75.1MB)
//        테스트 11 〉	통과 (276.14ms, 75.4MB)
//        테스트 12 〉	통과 (402.08ms, 74.1MB)
//        테스트 13 〉	통과 (1424.71ms, 89MB)
//        테스트 14 〉	통과 (5264.32ms, 94.2MB)
//        테스트 15 〉	통과 (19.05ms, 79MB)
//        효율성  테스트
//        테스트 1 〉	실패 (시간 초과)
//        테스트 2 〉	실패 (시간 초과)
//        테스트 3 〉	실패 (시간 초과)
//        테스트 4 〉	실패 (시간 초과)
//        테스트 5 〉	실패 (시간 초과)
class Solution_42885_1 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 사람들 몸무게를 list에 저장, 내림차순 정렬
        Integer[] peopleArray = Arrays.stream(people).boxed().toArray(Integer[]::new); // int[] 를 Integer[]로 변경
        List<Integer> peopleList = new LinkedList<>(Arrays.asList(peopleArray));
        peopleList.sort(Comparator.naturalOrder());

        while (!peopleList.isEmpty()) {
            int small = 0;
            int large = peopleList.size() - 1;
            while (small < large) {
                if (peopleList.get(small) + peopleList.get(large) > limit) {
                    large--;
                } else {
                    break;
                }
            }
            if (small == large) {
                peopleList.remove(small);
            } else {
                peopleList.remove(large);
                peopleList.remove(small);
            }
            answer++;
        }

        return answer;
    }
}

public class Pgms_42885_Lifeboat {
    public static void main(String[] args) {
        int[][] tcPeople = {
                { 70, 50, 80, 50 },
                { 70, 80, 50 }
        };
        int[] tcLimit = { 100, 100 };

        Solution_42885_2 sol = new Solution_42885_2();
        for (int i = 0; i < tcPeople.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcPeople[i], tcLimit[i]));
        }
    }
}
