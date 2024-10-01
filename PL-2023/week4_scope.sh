x=1
function foo() {
    echo $x;    #지역변수 x = 3 출력
    x=2;
}
function bar() {
    local x=3;
    foo;
}

bar
echo $x #전역변수 x = 1 출력