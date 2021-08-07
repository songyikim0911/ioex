package org.zerock.note;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {

        ArrayList<NoteDTO> list
                = new ArrayList<>();

        //일반 배열은 인덱스로 내용을 추가하지만, ArrayList는 내부적으로 인덱스 번호를 가지고 있음,
        /*NoteDTO obj = NoteDTO.builder().build();
        //builder를 하게되면 리턴타입이 NoteDTO의 인스턴스임, 결국 이 코드는 NoteDTO의 인스턴스임
        list.add(obj);*/
        list.add(NoteDTO.builder().no(1).who("A").whom("B").build());
        list.add(NoteDTO.builder().no(2).who("A").whom("B").build());
        list.add(NoteDTO.builder().no(3).who("B").whom("A").build());
        list.add(NoteDTO.builder().no(4).who("B").whom("A").build());
        list.add(NoteDTO.builder().no(5).who("A").whom("B").build());

        System.out.println(list.size());

        System.out.println(list);


        //B한테 온 쪽지만 필터링하기
        //stream 쭉 피는것. -stream으로 쭉 핀다음에 filter로 검사하는것. predicate true/false 예상하다.
        //predicate로 지금 true만 뽑아내는것..그중 filter로!
        //whom이 B인것만 필터링해서 뽑는 코드를 blist로 만들었다! 람다식을 이용해서 처리를 간단하게 한 것.

        List<NoteDTO> blist =
                list.stream().filter(noteDTO -> noteDTO.getWhom().equals("B")).collect(Collectors.toList());
//noteDTO에 getWhom이 B인 애들만 반환해라 (true/false 만 반환, predicate를통해.
        //그리고 그 이후로 .collect(Collectors.toList())를 사용하여, list형태로 반환하는 구문임

        System.out.println(blist);

       // list.remove(2);//3번째 것을 리무브하는것임.

        //list.removeIf(predicate)안에 로직(함수)이 들어감

        //noteDTO는 list의 내용물,
//        list.removeIf( noteDTO -> true ); 예를들어 true인 애들을 remove한다면 결국 값있는애들은 다 지워는 내용이다.

        list.removeIf( noteDTO -> noteDTO.getNo()==5 );
        System.out.println(list);

        System.out.println(list.size());


    }
}
