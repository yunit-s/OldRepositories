/*
// 24173-알고리즘 수업 - 힙 정렬 1

// 구현 방법
문제에서 주어진 힙 정렬 의사코드 활용함.
heapify() : 루트 노드를 제외한 나머지는 이미 min heap 구조를 만족하는 상태에서, 루트 노드에 새로운 수 추가됨. 힙 구조가 되도록 재구성.
buildMinHeap() : 정렬되지 않은 여러 숫자들을 min heap 구조가 되도록 만들기
heapSort() : 정렬되지 않은 여러 숫자들을, buildMinHeap()을 우선 돌려서 힙 구조로 만든 뒤, 내림차순 정렬하기.

// 변수 설명
target : 교환이 실행될 목표 횟수
swapNum : 교환이 실행된 횟수

*/

#include <iostream>

using namespace std;

int heap[500001] = { 0, };
int target;
int swapNum;

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
        if (++swapNum == target) cout << heap[cur] << " " << heap[smaller] << "\n"; // 문제에서 원하는 두 수 출력
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
        if (++swapNum == target) cout << heap [i] << " " << heap[1] << "\n"; // 문제에서 원하는 두 수 출력
        heapify(1, i - 1);
    }
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
    //input
    int N;
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
구현 시간 - 2시간
1번째 시도 - 맞았습니다! 채점 시간 7초. 실행 시간 100ms. 지역변수로 구현해서 그런가? 전역으로 빼보자.
2번째 시도 - 맞았습니다! 채점 시간 8초. 실행 시간 96ms. heap 배열만 전역변수로 뺐을 뿐인데, 수행 시간은 4ms 줄긴 했지만 메모리는 왜 120KB를 더 먹은 거지?

// test case
8 11 7 2 4 1 8 3 6 5
8 22 7 2 4 1 8 3 6 5

// test case 정답
4 6
-1 (총 21번 교환하게 됨)

*/
