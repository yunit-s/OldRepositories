/*
// 11279-최대 힙

// 구현 방법
최소 힙 코드에서 살짝만 수정. 부등호, 가독성을 위한 변수 추가 및 변수명 수정, 주석 수정

// 변수 설명


*/

#include <iostream>

using namespace std;

int N;
int heap[100001] = { 0, };
int heapSize = 0;

void pushHeap(int input) {
    heap[heapSize] = input; // 새로운 숫자를 heap 맨 뒤에 추가
    // 루트로 올라올 때까지 반복
    int i = heapSize;
    while (i > 0) {
        int parent = (i - 1) / 2;
        if (heap[i] > heap[parent]) {
            int temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;
            i = parent;
        }
        else break;
    }
    heapSize++;
}

int popHeap(void) {
    // heap이 비어있는 경우
    if (heapSize == 0) return 0;

    int rVal = heap[0];
    // max heap 유지하는 코드
    heap[0] = heap[heapSize - 1];
    heapSize--;
    int i = 0;
    while (1) {
        int child = i * 2 + 1;
        // 자식노드 유무 판단
        if (child <= heapSize - 1) {
            // 더 큰 자식노드 고르기
            if (child < heapSize - 1) {
                if (heap[child] < heap[child + 1]) child++;
            }
            // 자식노드보다 작은 숫자인 경우 교환
            if (heap[i] < heap[child]) {
                int temp = heap[i];
                heap[i] = heap[child];
                heap[child] = temp;
                i = child;
            }
            else break;
        }
        else break;
    }
    return rVal;
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    //input
    cin >> N;
    // scanf("%d", &N);

    //process
    for (int i = 0; i < N; i++) {
        int input;
        cin >> input;
        // scanf("%d", &input);
        if (input != 0)
            pushHeap(input);
        else
            cout << popHeap() << "\n";
            // printf("%d\n", popHeap());
    }

    //output

    return 0;
}


/*

// 제출 결과
구현 시간 - 20분(기존 최소 힙 코드 활용)
1번째 시도 - 맞았습니다. 채점 시간 약 1초

// test case
13 0 1 2 0 0 3 2 1 0 0 0 0 0

// test case 정답
0 2 1 3 2 1 0 0

*/
