package com.dixn.dxboot.java8.stream;

import com.dixn.dxboot.java8.bean.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Test {


    public Map<String, List<User>> group () {
        List<User>  list= Arrays.asList(
                new User("钢铁侠",40,0,"华盛顿"),
                new User("蜘蛛侠",20,0,"华盛顿"),
                new User("赵丽颖",30,1,"湖北武汉市"),
                new User("詹姆斯",35,0,"洛杉矶"),
                new User("李世民",60,0,"山西省太原市"),
                new User("蔡徐坤",20,1,"陕西西安市"),
                new User("葫芦娃的爷爷",70,0,"山西省太原市")
        );
        Map<String, List<User>> cityMap = list.stream()
                .collect(Collectors.groupingBy(User::getAddress));

        return cityMap;
    }

    public List<User> tetst () {
        List<User>  list= Arrays.asList(
                new User("钢铁侠",40,0,"华盛顿"),
                new User("蜘蛛侠",20,0,"华盛顿"),
                new User("赵丽颖",30,1,"湖北武汉市"),
                new User("詹姆斯",35,0,"洛杉矶"),
                new User("李世民",60,0,"山西省太原市"),
                new User("蔡徐坤",20,1,"陕西西安市"),
                new User("葫芦娃的爷爷",70,0,"山西省太原市")
        );
        List<User> filterList = list.stream().filter(user -> user.getAge() >= 40)
                .collect(toList());
        return filterList;
    }

    public static void main(String[] args) {
        Test test = new Test();

        test.group ();
        //test.tetst().forEach(u -> System.out.println(u.getName() + "----" + u.getAge()));

        /*List<String> flatList = new ArrayList<>();
        flatList.add("唱,跳");
        flatList.add("rape,篮球,music");
        flatList = flatList.stream().map(s -> s.split(",")).flatMap(Arrays::stream).collect(toList());

        flatList.forEach(System.out::println);*/



    }
}
