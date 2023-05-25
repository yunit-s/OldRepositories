# 알고리즘 공부 기록 - java

---

---

# 자주 헷갈리는 문법

* 문자열 String에서 알파벳 하나만 바꾸는 방법은 없다. <br>
char배열 사용하기 / StringBuilder 클래스 활용하기
* 배열의 길이는 arr.length, 문자열의 길이는 String.length()
* swap() 은 내장 메소드가 없다. 구현해야 한다.
* ArrayList<Integer>를 int[] 로 한 번에 바꾸는 방법은 없다. 하나씩 저장해야함 <br>
=> 되지 않나? int[] intArr = 어레이리스트.toArray(new int[어레이리스트.size()]); <br>
=> ㄴㄴㄴㄴ 안 될 듯. int[]같은 primitive type은 제네릭 타입으로 사용할 수 없고, 이때는 자동변환이 안 되기 때문. <br>
43164
* int[] 를 ArrayList 로 한 번에(x) 두 번에(o) 바꾸는 방법 <br>
Integer[] peopleArray = Arrays.stream(people).boxed().toArray(Integer[]::new); // int[] 를 Integer[]로 변경 <br>
List<Integer> peopleList = new LinkedList<>(Arrays.asList(peopleArray)); <br>
42885,
* int[] 를 Set 으로 한 번에 바꾸는 방법 <br>
=> new HashSet<>(Arrays.asList(배열)) <br>
=> ㄴㄴㄴㄴ 이것도 안 됨. int는 primitive type이기 때문
43163,
* int[] 를 Stack 으로 한 번에 바꾸는 방법
* int[] -> Integer[] <br>
Integer[] Integer배열 = Arrays.stream(int배열).boxed().toArray(Integer[]::new); <br>
42746,
* Integer[] -> int[] <br>
int배열 = Arrays.stream(Integer배열).mapToInt(Integer::intValue).toArray(); <br>
42746,
* 속도 비교 : Arrays.sort(배열) > ArrayList.sort(컴퍼레이터) > LinkedList.sort(컴퍼레이터) <br>
42885,
* 이미 map.entrySet() 으로 for-each문이 실행되는 경우, 하위 로직을 실행하는 중에 map에서 데이터를 빼버리면
for문에서 오류난다. <br>
43162,

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
* 가변 문자열 StringBuilder 클래스 <br>
setCharAt(인덱스, char형 고칠 문자) <br>
155652,

## 배열

* Arrays.sort(배열) <br>
42576, 42577, <br>
* int[] 배열을 내림차순으로 정렬하기 <br>
Integer[] 새배열 = Arrays.stream(기존배열).boxed().toArray(Integer[]::new); <br>
Arrays.sort(새배열, Collections.reverseOrder()); <br>
42747,
* 배열 정렬할 때 기준 커스텀하기 <br>
Arrays.sort(배열, new Comparator<Integer>() {}) <br>
42746
* 다차원 배열 정렬하기 <br>
Arrays.sort(다차원배열, Comparator.comparingInt(a -> a[0])); <br>
42884,
* System.arraycopy(srcArray, 0, destArray, 0, srcArray.length); <br>
배열 내용 복사하기 <br>
42839, <br>
* int[] 배열 복사하기 <br>
int[] 새배열 = Arrays.copyOf(소스배열, 소스배열길이); <br>
87946,

# 자료구조 라이브러리

* LinkedList
* ArrayList <br>
단순 배열보다 요소의 추가, 삭제, 검색 등에서 용이하다.
* Map <br>
put(데이터), get(키), getOrDefault(키, 기본값), putIfAbsent(키, 기본value), keySet(), values(), <br>
1845, <br>
* Stack <br>
push(), pop(), <br>
64061,
* Queue <br>
offer(), poll(), peek(), isEmpty(), size(), clear(), <br>
add(), remove(), element()는 오류가 생기면 exception이 발생하는 메서드임. <br>
LinkedList<>() 로 구현한다. <br>
1844, 12906, 120956,
* PriorityQueue <br>
add(), poll(), <br>
Heap 과 관련이 있음 <br>
42626, <br>
* TreeSet <br>
add(), first(), pullFirst(), <br>
HashSet보다 느리지만 자동 오름차순 정렬을 해준다. <br>
42839, <br>

# 알고리즘

* Greedy(탐욕법) <br>
42860, 42862, 42883
* BFS(Bread-First Search) <br>
1844, 43163, 87694
* DFS(Depth-First Search) <br>
43162, 43164

---

---

# 백준 온라인 저지

---

---

# 프로그래머스

## 미해결 문제

* 42860_조이스틱 <br>
반례를 못 찾겠음

## 생각해볼 문제

* 67256_키패드 누르기 <br>
키패드 누르기 <br>
맵을 하드 코딩 말고 좌료값 계산하는 방식으로 구현해보기

* 43164_여행경로 <br>
내 코드로 테스트케이스 1, 2번 해결 안 한 채로, ChatGPT 코드로 해결했음
* 42883_큰 수 만들기 <br>
내 코드로 테스트케이스 10번 해결 못함. 로직은 맞는데 자료구조를 안 쓰니까 코드가 너무 지저분해서 포기. ChatGPT 코드로 해결했음