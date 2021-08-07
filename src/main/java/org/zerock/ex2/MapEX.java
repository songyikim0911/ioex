package org.zerock.ex2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapEX {
    public static void main(String[] args) {

        //Map<Key, value> map = new HashMap<>();

        Map<String, String[]> map = new HashMap<>();

        map.put("kor", new String[]{"불고기","비빔밥"});
        map.put("jap", new String[]{"초밥","라멘"});
        map.put("wes", new String[]{"피자","파스타"});


        String[] arr = map.get("wes");

        System.out.println(Arrays.toString(arr));

        int idx = (int)(Math.random() * arr.length);
        //arr.length =2 니깐, math.random은 0,1만나온다고함...
        System.out.println(arr[idx]);


    }
}
