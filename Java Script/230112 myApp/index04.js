
let i = 100; // global variable. 전역 변수. Java script가 실행하고 끝날 때까지 살아있는 변수
function myFunc() {
    let i = 10; // local variable. 지역 변수.
    for (let i=0; i<10; i++) {
        // 여기서의 i 는 for문 안에서만 의미가 있음
        console.log(i); // 0, 1, 2
    }
    console.log(i); // 10
}
myFunc();
console.log(i); // 100
