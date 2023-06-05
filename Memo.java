package team.memo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

class Memo {
    // 이곳은 희석이 브렌치 입니다.
    String name;
    private int password;
    String post;
    Timestamp createdData;

    Memo(String name, int password, String post) {
        this.name = name;
        this.password = password;
        this.post = post;
        this.createdData = getCurrentTimestamp();
    }

    private Timestamp getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        return Timestamp.valueOf(now);
    }

    // 김희석 MemoVO 관련 주석

    // 0. 변경하는 인풋에서 현재시간 업데이트
    // LocalDateTime localDateTime = LocalDateTime.now();

    // 1. 변경할 리스트 데이터 생성
    // new Memo = new Memo(memoInput.getMemos().get(i).postNumber,name,password,memoText,localDateTime);


    // 2. 인풋을 통해 리스트(memos)에 추가 할 때
    // 인풋 값 넣는 클래스 폴더 안에서
    // public List<Memo> getMemos() {
    //     return memos;
    // } 를 통해서 memos 라는 리스트를 만들었을 때
    // memos.add(new Memo(++postNumber,name,password,memoText,localDateTime));
}
