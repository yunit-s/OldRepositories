# 알고리즘 공부 기록 - java

---

---

# 자주 헷갈리는 문법

* 문자열 String에서 알파벳 하나만 바꾸는 방법은 없다. char배열 사용해야함
* 배열의 길이는 arr.length, 문자열의 길이는 String.length()
* swap() 은 내장 메소드가 없다. 구현해야 한다.
* ArrayList<Integer>를 int[] 로 한 번에 바꾸는 방법은 없다. 하나씩 저장해야함

---

---

# 자주 쓰이는 메소드

## 수학

* Math.abs(숫자 1개)
* Math.min(숫자 2개), Math.max(숫자 2개)
* Math.sqrt(숫자 1개)
* Math.pow(밑, 제곱 횟수) <br>
42839
* Math.ceil(실수 1개) <br>
리턴 자료형도 double임. <br>
42586,

## 문자열

* 문자열.charAt(index) <br>
42860,
* 문자열.toCharArray() <br>
42839,
* 문자열1.indexOf(문자열2) <br>
120908,
* 문자열1.startsWith(문자열2) <br>
42577,
* 문자열.substring(시작index, 끝index + 1)

## 배열

* Arrays.sort(배열) <br>
42576, 42577, <br>
* System.arraycopy(srcArray, 0, destArray, 0, srcArray.length); <br>
배열 내용 복사하기 <br>
42839, <br>

# 자료구조 라이브러리

* LinkedList
* ArrayList <br>
단순 배열보다 요소의 추가, 삭제, 검색 등에서 용이하다.
* Map <br>
put(데이터), get(키), getOrDefault(키, 기본값), keySet(), values(), <br>
1845, <br>
* Stack <br>
push(), pop(), <br>
64061,
* Queue <br>
add(), poll(), <br>
LinkedList<>() 로 구현한다.
12906, 120956,
* PriorityQueue <br>
add(), poll(), <br>
Heap 과 관련이 있음 <br>
42626, <br>
* TreeSet <br>
add(), first(), pullFirst(), <br>
HashSet보다 느리지만 자동 오름차순 정렬을 해준다. <br>
42839, <br>

# 알고리즘

* BFS(Bread-First Search) <br>
1844,

---

---

# 백준 온라인 저지

---

---

# 프로그래머스

## 미해결 문제

* 42860 <br>
반례를 못 찾겠음

## 생각해볼 문제

* 67256 <br>
키패드 누르기 <br>
맵을 하드 코딩 말고 좌료값 계산하는 방식으로 구현해보기