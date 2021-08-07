package org.zerock.note;


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

    private NoteDTO noteDTO;
    //객체안에서 또다른 객체를 두는 구조로 만들 예정.




}
