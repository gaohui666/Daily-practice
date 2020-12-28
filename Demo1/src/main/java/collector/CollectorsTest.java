package collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CollectorsTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("111", "2222", "333333333");
        toList(list);
    }

    private static void toList(List<String> list) {
        List<String> collect = list.stream().collect(Collectors.toList());
        System.out.println(collect);
    }
}
