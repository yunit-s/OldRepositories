package Algorithm;

class Solution_84512 {
    int count;
    int answerCnt;
    String target;
    public int solution(String word) {
        int answer = 0;

        count = 0;
        target = word;
        dfs("");
        answer = answerCnt;

        return answer;
    }

    private void dfs(String word) {
        char[] vowel = { 'A', 'E', 'I', 'O', 'U' };
        for (int i = 0; i < vowel.length; i++) {
            String wordCopy = word + vowel[i];
            count++;
            if (wordCopy.equals(target)) {
                answerCnt = count;
                return;
            }
            if (wordCopy.length() < 5) {
                dfs(wordCopy);
            }
        }
    }
}

public class Pgms_84512_VowelDictionary {
    public static void main(String[] args) {
        String[] tcWord = { "AAAAE", "AAAE", "I", "EIO" };

        Solution_84512 sol = new Solution_84512();
        for (int i = 0; i < tcWord.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcWord[i]));
        }
    }
}
