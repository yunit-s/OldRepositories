/*
// 1927-최소 힙

// 구현 방법
1번째 시도 - 직접 짜보자. heap[0] 활용하는 방법으로! -> 시간 초과
2번째 시도 - 동빈나 힙 정렬 코드 가져와서 응용하기 -> 틀렸습니다. ㅋㅋㅋ 시간초과는 해결이 되긴 한 건가?
3번째 시도 - 마지막 do while 조건문 수정. -> 시간 초과
4번째 시도 - 다시 1번째 코드 활용함. heap 관련 변수들을 지역변수에서 전역변수로 변경. 입출력을 cin, cout 이 아니라 scanf, printf 로 변경
5번째 시도 - printf, scanf 대신 버퍼 활용코드 넣고 cin, cout 으로 완성

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
        if (heap[i] < heap[(i - 1) / 2]) {
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
        else break;
    }
    heapSize++;
}

int popHeap(void) {
    // heap이 비어있는 경우
    if (heapSize == 0) return 0;

    int r_value = heap[0];
    // min heap 유지하는 코드
    heap[0] = heap[heapSize - 1];
    heapSize--;
    int i = 0;
    while (1) {
        int child = i * 2 + 1;
        // 자식노드 유무 판단
        if (child <= heapSize - 1) {
            // 더 작은 자식노드 고르기
            if (child < heapSize - 1) {
                if (heap[child] > heap[child + 1]) child++;
            }
            // 자식노드보다 큰 숫자인 경우 교환
            if (heap[i] > heap[child]) {
                int temp = heap[i];
                heap[i] = heap[child];
                heap[child] = temp;
                i = child;
            }
            else break;
        }
        else break;
    }
    return r_value;
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
구현 시간 - 7~9시간
1번째 시도 - 시간 초과. 7%에서 0.5초 머물더니 시간 초과
2번째 시도 - 틀렸습니다. 3%에서 2초쯤 머물더니 7%에서 틀렸습니다. 3%에서 오래 걸려서 통과한 거 보면 시간 초과 문제는 해결된 건가?
3번째 시도 - 시간 초과. 7%에서 0.5초 머물더니 시간 초과
4번째 시도 - 맞았습니다. 채점 시간 약 1.5초
5번째 시도 - 맞았습니다. 채점 시간 약 1.5초. 동작시간 20ms에서 16ms로 줄었네

// test case
8
7 2 4 1 8 3 6 5
14
7 2 4 1 8 3 6 5 0 0 0 0 0 0
9
0 12345678 1 2 0 0 0 0 32
11
1 1 1 1 2 2 0 0 0 0 0


// test case 정답
아무것도 출력 안 됨
1 2 3 4 5 6
0 1 2 12345678 0
1 1 1 1 2

*/



/*
2, 3번째 시도한 코드 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

#include <iostream>

using namespace std;

int main(void) {
    //input
    int N;
    int heap[100002] = { 0, };
    int heap_size = 0;
    cin >> N;

    //process
    for (int i = 0; i < N; i++) {
        int input;
        cin >> input;
        if (input != 0) {
            // 배열에 숫자 저장, 힙 구조 유지
            int child = heap_size;
            heap[child] = input;
            heap_size++;
            if (heap_size > 1) {
                do {
                    int root = (child - 1) / 2;
                    if (heap[root] > heap[child]) {
                        int temp = heap[root];
                        heap[root] = heap[child];
                        heap[child] = temp;
                    }
                    child = root;
                } while( child != 0);
            }
        }
        else {
            // 최솟값 출력, 힙배열에서 제거
            if (heap_size == 0) cout << "0" << endl;
            else {
                cout << heap[0] << endl;
                heap_size--;
                heap[0] = heap[heap_size];
                int root = 0;
                int child;
                do {
                    child = root * 2 + 1;
                    // 자식 중에 더 작은 값 찾기
                    if (child < heap_size - 1 && heap[child] > heap[child + 1]) child++;
                    // 자식이 더 작으면 교환
                    if (heap[root] > heap[child]) {
                        int temp = heap[root];
                        heap[root] = heap[child];
                        heap[child] = temp;
                    }
                    root = child;
                } while (root * 2 + 1 < heap_size);
            }
        }
    }
    
    //output

    return 0;
}

*/