package anonymous;

/**
 * 匿名内部类
 */
class anonymousTest {

    public void test(Bird bird){
        System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
    }

    public static void main(String[] args) {
        anonymousTest test = new anonymousTest();
        //匿名内部类
        /*test.test(new Bird() {

            public int fly() {
                return 10000;
            }

            public String getName() {
                return "大雁";
            }
        });*/

        WildGoose wildGoose = new WildGoose();
        test.test(wildGoose);
    }
}


abstract class Bird {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}


class WildGoose extends Bird {

    @Override
    public int fly() {
        return 10000;
    }

    public String getName() {
        return "小鸟";
    }
}