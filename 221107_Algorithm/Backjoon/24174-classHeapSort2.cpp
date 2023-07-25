/*
// 24174-알고리즘 수업 - 힙 정렬 2

// 구현 방법
24173 코드에서 출력부 살짝 수정하자.
2번째 시도 - 출력을 heapSize개만 하는게 아니라 N개를 해야하니까, N을 전역변수로 빼고, 출력문 수정

// 변수 설명


*/

#include <iostream>

using namespace std;

int N;
int heap[500001] = { 0, };
int target;
int swapNum;

void printHeap(void) {
    for (int i = 1; i < N + 1; i++)
        cout << heap[i] << " ";
    cout << "\n";
}

void heapify(int cur, int heapSize) {
    if (swapNum == target) return; // 문제에서 원하는 교환 횟수가 채워졌으면 바로 종료

    // 더 작은 자식노드 찾기
    int childL = cur * 2;
    int childR = cur * 2 + 1;
    int smaller;
    if (childR <= heapSize) {
        if (heap[childL] < heap[childR]) smaller = childL;
        else smaller = childR;
    }
    else if (childL <= heapSize) smaller = childL;
    else return; // 자식노드가 없는 경우 리턴

    // 최소 힙 성질을 만족하지 못하는 경우 재귀 호출
    if (heap[smaller] < heap[cur]) {
        int temp = heap[smaller];
        heap[smaller] = heap[cur];
        heap[cur] = temp;
        if (++swapNum == target) printHeap(); // 현재 heap 상태 출력
        heapify(smaller, heapSize);
    }
}

void buildMinHeap(int heapSize) {
    if (swapNum == target) return; // 문제에서 원하는 교환 횟수가 채워졌으면 바로 종료

    // 깊이가 깊은 노드부터 heapify 실행
    // heapSize / 2 + 1 부터는 자식노드가 없으므로, 굳이 heapify를 실행할 이유가 없음
    for (int i = heapSize / 2; i > 0; i--)
        heapify(i, heapSize);
}

void heapSort(int heapSize) {
    buildMinHeap(heapSize); // 초기 입력된 숫자들 min heap 구조로 만들기

    // 배열 내에서 내림차순 정렬
    for (int i = heapSize; i > 1; i--) {
        if (swapNum == target) return; // 문제에서 원하는 교환 횟수가 채워졌으면 바로 종료
        int temp = heap[1];
        heap[1] = heap[i];
        heap[i] = temp;
        if (++swapNum == target) printHeap(); // 현재 heap 상태 출력
        heapify(1, i - 1);
    }
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
    //input
    int heapSize = 0;
    cin >> N >> target;
    for (int i = 1; i < N + 1; i++) {
        cin >> heap[i];
        heapSize++;
    }

    //process
    heapSort(heapSize);

    //output
    if (swapNum < target) cout << -1 << "\n";

    return 0;
}


/*

// 제출 결과
구현 시간 - 20~30분
1번째 시도 - 틀렸습니다. 채점 시간 2초, 몇 퍼센트에서 틀렸는지 못 봄.
2번째 시도 - 맞았습니다! 채점 시간 23초. 서버 상태가 안 좋았나..?

// test case
8 11 7 2 4 1 8 3 6 5
8 21 7 2 4 1 8 3 6 5
8 22 7 2 4 1 8 3 6 5

// test case 정답
3 5 4 7 8 6 2 1
8 7 6 5 4 3 2 1
-1

*/
