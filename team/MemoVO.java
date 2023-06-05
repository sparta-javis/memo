package team.memo.team;

import java.time.LocalDateTime;

public class MemoVO {
    // 메모 한 건에 대한 정보를 가진 클래스
    // 1.글 번호, 2.작성자 이름, 3.비밀번호,
    // 4.게시글, 5.작성일(컴퓨터 시스템의 날짜와 시간 자동저장)
    int postNumber;
    String name;
    String password;
    String memoText;
    LocalDateTime localDateTime;

    public MemoVO(int postNumber, String name, String password, String memoText, LocalDateTime localDateTime) {
        this.postNumber = postNumber;
        this.name = name;
        this.password = password;
        this.memoText = memoText;
        this.localDateTime = localDateTime;
    }

}
