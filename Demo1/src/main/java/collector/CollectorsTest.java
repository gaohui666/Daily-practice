package collector;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("111", "2222", "333333333", "444444", "drtferwf3422");
        List list1 = new ArrayList();

//        toList(list);

//        joiningTest(list);

//        mapingTest(list);

//        collectingAndThenTest(list);

        maxByAndMinByTest(list);
    }

    private static void toList(List<String> list) {
        List<String> collect = list.stream().collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void joiningTest(List<String> list){
        // 无参方法
        String s = list.stream().collect(Collectors.joining());
        System.out.println(s);
        // 指定连接符
        String ss = list.stream().collect(Collectors.joining("-"));
        System.out.println(ss);
        // 指定连接符和前后缀
        String sss = list.stream().collect(Collectors.joining("-","S","E"));
        System.out.println(sss);
    }

    public static void mapingTest(List<String> list){
        List<Integer> ll = list.stream().limit(4).collect(Collectors.mapping(Integer::valueOf,Collectors.toList()));

        System.out.println(ll);
    }

    public static void collectingAndThenTest(List<String> list){
        Integer collect = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), e -> e.size()));
        System.out.println(collect);
    }

    public static void maxByAndMinByTest(List<String> list){
        Optional<String> collect = list.stream().limit(3).collect(Collectors.maxBy((a, b) -> a.length() - b.length()));
        System.out.println(collect);
        System.out.println(list.stream().collect(Collectors.minBy((a, b) -> a.length() - b.length())));
    }

    public static void toMapTest(List<String> list){
        Map<String, String> map = list.stream().limit(3).collect(Collectors.toMap(e -> e.substring(0, 1), e -> e));
    }

}
