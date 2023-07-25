/*
// 2751-수 정렬하기 2

// 구현 방법
solv1 버블 정렬 -> 시간 초과
solv2 퀵 정렬 -> 시간 초과. 그 이후 코드 수정하긴 했는데, 굳이 돌려보진 않았음.
solv3 힙 정렬. 24173번 코드 거의 복붙함. 최대 힙 활용, 오름차순 정렬. 배열 0번부터 활용함. -> 시간 초과
solv4 병합 정렬. 2750번 코드 가져와서 배열 크기만 늘림. -> 맞았습니다

// 변수 설명


*/

#define __SOLV4__

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

#ifdef __SOLV1__

#include <iostream>

using namespace std;

void bubbleSort(int num[], int len) {
    for (int i = len - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (num[j] > num[j + 1]) {
                int temp = num[j];
                num[j] = num[j + 1];
                num[j + 1] = temp;
            }
        }
    }
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    // input
    int N;
    int num[1000000];
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> num[i];

    // process
    bubbleSort(num, N);

    // output
    for (int i = 0; i < N; i++)
        cout << num[i] << endl;

    return 0;
}

#endif

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

#ifdef __SOLV2__

#include <iostream>

using namespace std;

void quickSort(int num[], int iL, int iR) {
    if (iL < iR) {
        int i, j, pivot;
        i = iL;
        j = iR + 1;
        pivot = num[iL]; // 기준값 : 배열 중 맨 왼쪽 값

        do {
            // 배열 왼쪽 끝부터, pivot보다 크거나 같은 값 찾기
            do {
                i++;
            } while (i < iR && num[i] < pivot);
            // 배열 오른쪽 끝부터, pivot보다 작은 값 찾기
            do {
                j--;
            } while (j > iL && num[j] >= pivot);
            if (i < j) {
                // cout << "@ a iL=" << iL << ", iR=" << iR << ",\ti=" << i << ", j=" << j << ",\t\tpivot=" << pivot << ",\tnum[i]=" << num[i] << ", num[j]=" << num[j] << "\n";
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        } while (i < j); // i(큰 수)가 j(작은 수)보다 오른쪽에 있으면, 교환할 숫자가 없다는 뜻이기 때문에 break

        if (iL < j) {
            // j위치에 pivot을 넣는다. pivot은 이제 자리 고정됨
            // cout << "@@b iL=" << iL << ", iR=" << iR << ",\tp=" << iL << ", j=" << j << ",\t\tpivot=" << pivot << ",\tnum[l]=" << num[iL] << ", num[j]=" << num[j] << "\n";
            int temp = num[iL];
            num[iL] = num[j];
            num[j] = temp;
        }
        quickSort(num, iL, j - 1);
        quickSort(num, j + 1, iR);
    }
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    // input
    int N;
    int num[1000000];
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> num[i];

    // process
    quickSort(num, 0, N - 1);

    // output
    for (int i = 0; i < N; i++)
        cout << num[i] << "\n";

    return 0;
}

#endif



// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

#ifdef __SOLV3__

#include <iostream>

using namespace std;

void heapify(int heap[], int root, int heapSize) {
    // 더 큰 자식노드 찾기
    int childL = root * 2 + 1;
    int childR = root * 2 + 2;
    int childBig;
    if (childR <= heapSize) {
        if (heap[childL] > heap[childR]) childBig = childL;
        else childBig = childR;
    }
    else if (childL <= heapSize) childBig = childL;
    else return; // 자식노드가 없는 경우 리턴

    // 최대 힙 성질을 만족하지 못하는 경우 재귀 호출
    if (heap[childBig] > heap[root]) {
        int temp = heap[childBig];
        heap[childBig] = heap[root];
        heap[root] = temp;
        heapify(heap, childBig, heapSize);
    }
}

void buildMaxHeap(int heap[], int heapSize) {
    // 깊이가 깊은 노드부터 heapify 실행
    for (int i = (heapSize - 1) / 2; i >= 0; i--)
        heapify(heap, i, heapSize);
}

void heapSort(int heap[], int heapSize) {
    buildMaxHeap(heap, heapSize);

    // 배열 내에서 오름차순 정렬
    for (int i = heapSize - 1; i > 0; i--) {
        int temp = heap[0];
        heap[0] = heap[i];
        heap[i] = temp;
        heapify(heap, 0, i - 1);
    }
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    // input
    int N;
    int num[1000001];
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> num[i];

    // process
    heapSort(num, N);

    // output
    for (int i = 0; i < N; i++)
        cout << num[i] << endl;

    return 0;
}

#endif

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

#ifdef __SOLV4__

#include <iostream>

using namespace std;

void merge(int num[], int iFirst, int iCen, int iLast) {
    int iL = iFirst, iR = iCen + 1, iCur = 0;
    int numTemp[iLast - iFirst + 1];
    while(iCur <= iLast - iFirst) {
        // 왼쪽에서 숫자를 가져와야 하는 경우
        if (iR > iLast || (iL <= iCen && num[iL] <= num[iR])) numTemp[iCur++] = num[iL++];
        // 오른쪽에서 숫자를 가져와야 하는 경우
        else numTemp[iCur++] = num[iR++];
    }
    // 임시로 정렬된 배열 저장하기
    for (int i = 0; i < iLast - iFirst + 1; i++)
        num[iFirst + i] = numTemp[i];
}

void mergeSort(int num[], int iFirst, int iLast) {
    if (iFirst < iLast) {
        int iCen = (iFirst + iLast) / 2;
        mergeSort(num, iFirst, iCen);
        mergeSort(num, iCen + 1, iLast);
        merge(num, iFirst, iCen, iLast);
    }
}

int main(void) {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    // input
    int N, num[1000000] = { 0, };
    cin >> N;
    for (int i = 0; i < N; i++) cin >> num[i];

    // process
    mergeSort(num, 0, N - 1);

    //output
    for (int i = 0; i < N; i++) cout << num[i] << "\n";

    return 0;
}

#endif



// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


/*

// 제출 결과
구현 시간 - 모름. 5시간 이상일 듯?
1번째 시도 - 시간 초과. 채점 1%에서 3초 있다가 중단됨. 버블 정렬은 확실히 안 될 듯. 퀵 정렬 써보자.
2번째 시도 - 컴파일 에러. main문 안 넣었음.
3번째 시도 - 시간 초과. 채점 1%도 못 가서 바로 시간 초과 떴음. cin cout 이 문제인가?
4번째 시도 - 시간 초과. 그냥 퀵 정렬이 문제인듯? 퀵 정렬 최악의 케이스가 들어가있나? 힙 정렬 써보자.
5번째 시도 - 시간 초과. 아니... 힙 정렬도 안 되네... 뭐지? 병합 정렬 써보자. 2750번 코드 가져와서 배열 크기 늘리고, 버퍼 설정 바꾸기.
6번째 시도 - 맞았습니다! 채점 시간 31초.


// test case
6 27 14 42 32 11 23

// test case 정답
11
14
23
27
32
42

*/
