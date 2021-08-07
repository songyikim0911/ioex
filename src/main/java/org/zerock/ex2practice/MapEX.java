package org.zerock.ex2practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapEX {
    public static void main(String[] args) {

        //Map<key, value> mapname = new HashMap<>();

        Map<String, String[]> map = new HashMap<>();

        map.put("kor", new String[]{"불고기", "비빔밥"});
        map.put("jap", new String[]{"초밥", "라면"});
        map.put("wes", new String[]{"피자", "파스타"});

        String[] arr = map.get("wes");

        System.out.println(Arrays.toString(arr));

        int idx = (int)(Math.random() * arr.length);
        //arr.length = 2 니깐, math.random 은 0,1만나옴..
        System.out.println(arr[idx]);


    }
}
