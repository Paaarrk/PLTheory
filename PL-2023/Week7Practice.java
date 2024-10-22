public class Week7Practice {

    private static class A {
        public int v;
        public A(int v) {
            this.v = v;
        }
    }

    public static void swap(A a1, A a2) {
        A tmp = a1;
        a1 = a2;
        a2 = tmp;
        System.out.println("swap() - A1:" + a1);
        System.out.println("swap() - A2:" + a2);
    }

    public static void real_swap(A a1, A a2) {
        // 참조로 주소에 저장된 값을 직접 바꾼다.
        int tmp = a1.v;
        a1.v = a2.v;
        a2.v = tmp;
        System.out.println("real_swap() - A1:" + a1);
        System.out.println("real_swap() - A2:" + a2);
    }

    public static void main(String[] args){
        //Sometimes Call-by-Reference won't work in Java.
        //What are the values of a1 and a2?
        A a1 = new A(10);
        A a2 = new A(5);
        System.out.println("A1:" + a1);
        System.out.println("A2:" + a2);
        swap(a1, a2);
        System.out.println("A1:" + a1);
        System.out.println("A2:" + a2);

        //Implement the real_swap() to actually swap the values.
        real_swap(a1, a2);
        System.out.println("A1:" + a1.v);
        System.out.println("A2:" + a2.v);

        //Here are examples of implicit/explicit conversion.
        Parent p = new Child(); //implicit
        Parent p1 = new Parent();
        Child c = (Child) p; //explicit

        /*
        Parent와Child의 관계
        [[Parent] Child]
        1. p = new Chield()로 생성하면 Child를 포함한 메모리를 할당하지만, Child의 멤버에는 접근 할 수 없다. 
           생성 순서가 Parent가 생성되고 Child를 마저 할당하므로 x = 3이 된다.
        2. p를 (Child)로 캐스팅 할 경우 Child에 대한 메모리가 존재하기 때문에 가능하며, 이를 통해 y값에 접근할 수 있다.
        3. p1 = new Parent()로 생성하면 [Parent]만 생성하기 때문에 x = 1이다.
        4. p1의 경우 (Child)p1으로 캐스팅 불가능하다. (Child에 대한 메모리가 할당되어 있지 않기 때문에)
       */
        System.out.println("1. p.x의 값: "+p.x);
        System.out.println("2. c.y의 값: "+c.y);
        System.out.println("3. p1.x의 값: "+p1.x);
        /*
         */
        /*
        Write your own examples to reveal differences among the above cases.
         - You may print out values of fields, add methods to the classes, etc.
        Breifly explain your examples
         - what is the difference and why the examples show such behaviour?

        ex)
        - Is it okay to access p.y?
            System.out.println(p.y);
        - Is it possible to cast?
            Child c1 = (Child) p1;
        */
    }

    public static class Parent {
        public int x = 1;
        public Parent(){
            System.out.println("Parent생성");
        }
    }
    public static class Child extends Parent {
        public int y = 2;
        public Child() {
            System.out.println("Child생성");
            x = 3;
        }
    }
}
