package org.zerock.notepractice;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Command {

    private String oper;
//추가,확인,삭제 command명령어 를 담을 곳. oper
    private NoteDTO noteDTO;
    //객체안에서 또다른 객체를 두는 구조로 만들 예정.
    //데이터를 담는곳 noteDTO



}
