package polymorphic;

/**
 * 多态，对执行结果重点理解
 */
class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

}

class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    public String show(A obj){
        return ("B and A");
    }
}

class C extends B{

}

class D extends B{

}

class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));             //1--A and A
        System.out.println("2--" + a1.show(c));             //2--A and A
        System.out.println("3--" + a1.show(d));             //3--A and D
        /**
         * 当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，
         * 但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法。这句话对多态进行了一个概括。
         * 其实在继承链中对象方法的调用存在一个优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
         *
         *
         * a2.show(c)，a2是A类型的引用变量，所以this就代表了A，a2.show(c),
         * 它在A类中找发现没有找到，于是到A的超类中找(super)，由于A没有超类（Object除外），
         * 所以跳到第三级，也就是this.show((super)O)，C的超类有B、A，所以(super)O为B、A，this同样是A，
         * 这里在A中找到了show(A obj)，同时由于a2是B类的一个引用且B类重写了show(A obj)，
         * 因此最终会调用子类B类的show(A obj)方法，结果也就是B and A。
         */
        System.out.println("4--" + a2.show(b));             //4--B and A
        System.out.println("5--" + a2.show(c));             //5--B and A
        System.out.println("6--" + a2.show(d));             //6--A and D
        System.out.println("7--" + b.show(b));              //7--B and B
        System.out.println("8--" + b.show(c));              //8--B and B
        System.out.println("9--" + b.show(d));              //9--A and D
    }
}
