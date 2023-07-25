
function myFunc() {

    // check가 된 checkbox부터 찾는다.
    console.log($('[type=checkbox]:checked + span').text());
}