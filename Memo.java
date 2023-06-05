// 수정
package team.memo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

// 이승철 브랜치

class Memo {

    private String name;
    // 이곳은 희석이 브렌치 입니다.
    String name;
    private int password;
    private String post;
    private Timestamp createdData;
    private Timestamp modifiedData; // Modified timestamp added
    private int memoNumber;

    public Memo(String name, int password, String post) {
        this.name = name;
        this.password = password;
        this.post = post;
        this.createdData = getCurrentTimestamp();
        this.modifiedData = getCurrentTimestamp(); // Initialize modified timestamp
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

    public String getPost() {
        return post;
    }

    public Timestamp getCreatedData() {
        return createdData;
    }

    public Timestamp getModifiedData() {
        return modifiedData;
    }

    public void setPost(String post) {
        this.post = post;
        this.modifiedData = getCurrentTimestamp(); // Update modified timestamp
    }

    private Timestamp getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        return Timestamp.valueOf(now);
    }


    public void setMemoNumber(int memoNumber) {
        this.memoNumber = memoNumber;
    }

    public int getMemoNumber() {
        return memoNumber;
    }
}

    public String getName() { return name; }
    public String getPost() { return post; }
    public Timestamp getCreatedData() { return createdData; }

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
// }
