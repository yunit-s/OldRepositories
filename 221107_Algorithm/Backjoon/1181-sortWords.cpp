/*
// 1181-단어 정렬

// 구현 방법
단어 개수가 20000개밖에 안 되니까 가볍게 버블정렬 써보자.
참고) string 클래스 객체끼리 비교 가능.(영어사전 순서가 오름차순이라고 생각하면 된다.)
a < z, A < a, aa < aaa, aaa < z
ㅡㅡㅡ
버블정렬 시간초과났음. string 클래스를 쓴 게 문제일 수도 있지만, 일단은 버블 정렬보다 빠른 알고리즘을 써야겠다.
그냥 바로 병합정렬 쓰자.
__SOLV1__ - 버블정렬(시간초과)
__SOLV2__ - 병합정렬(맞았습니다)

// 변수 설명


*/

#define __SOLV2__

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

#ifdef __SOLV1__

#include <iostream>

using namespace std;

int n;
string word[20000];

void bubbleSort() {
    for (int end = n; end > 0; end--) {
        for (int i = 0; i < end - 1; i++) {
            if (word[i].length() > word[i + 1].length())
                swap(word[i], word[i + 1]);
            else if (word[i].length() == word[i + 1].length() && word[i] > word[i + 1])
                swap(word[i], word[i + 1]);
        }
    }
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    //input
    cin >> n;
    for (int i = 0; i < n; i++) cin >> word[i];

    //process
    bubbleSort();

    //output
    for (int i = 0; i < n; i++)
        if (i == n - 1 || word[i] != word[i + 1])
            cout << word[i] << "\n";

    return 0;
}

#endif

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

#ifdef __SOLV2__

#include <iostream>

using namespace std;

int N;
string word[20000];

void printWords() {
    for (int i = 0; i < N; i++) {
        if ((i == 0) || (i > 0 && word[i - 1] != word[i]))
            cout << word[i] << "\n";
    }
}

void merge(int iFirst, int iCen, int iLast) {
    int iL = iFirst, iR = iCen + 1, iCur = 0;
    string wordTemp[iLast - iFirst + 1]; // 정렬 결과 임시 저장

    // 양쪽 다 원소가 남은 경우
    while (iL <= iCen && iR <= iLast) {
        if (word[iL].length() < word[iR].length()) wordTemp[iCur++] = word[iL++];
        else if (word[iL].length() > word[iR].length()) wordTemp[iCur++] = word[iR++];
        else if (word[iL] < word[iR]) wordTemp[iCur++] = word[iL++];
        else wordTemp[iCur++] = word[iR++];
    }
    // 왼쪽 원소만 남은 경우
    while (iL <= iCen) wordTemp[iCur++] = word[iL++];
    // 오른족 원소만 남은 경우
    while (iR <= iLast) wordTemp[iCur++] = word[iR++];

    // 정렬된 원소 저장
    int i = iFirst, j = 0;
    while (i <= iLast) word[i++] = wordTemp[j++];
}

void mergeSort(int iFirst, int iLast) {
    if (iFirst < iLast) {
        int iCen = (iFirst + iLast) / 2;
        mergeSort(iFirst, iCen);
        mergeSort(iCen + 1, iLast);
        merge(iFirst, iCen, iLast);
    }
}

int main(void) {
    //input
    cin >> N;
    for (int i = 0; i < N; i++) cin >> word[i];

    //process
    mergeSort(0, N - 1);

    //output
    printWords();

    return 0;
}

#endif

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


/*

// 제출 결과
구현 시간 - 2~3시간?
1번째 시도 - 시간 초과. 2만개여도 시간초과가 나네? 버블정렬때문일까? 아니면 버퍼 설정때문일까? 일단 버퍼 설정부터 해보자.
2번째 시도 - 시간 초과. 버퍼 설정 문제는 아니네. 그냥 병합정렬 써봐야겠다.
3번째 시도 - 맞았습니다! 채점 시간 1.5초. 버퍼 설정 빼도 되려나?
4번째 시도 - 맞았습니다! 채점 시간 1.5초. 버퍼 옵션 안 넣어도, string 변수 20000개 정도는 커버 가능하구만

// test case
13 but i wont hesitate no more no more it cannot wait im yours

// test case 정답
i im it no but more wait wont yours cannot hesitate

*/
