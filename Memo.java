package team.memo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

class Memo {

    public int postNumber; // 실제로 사용되지 않는 것과 마찬가지. printRecentMemoList 메서드를 통해 매번 새로 할당받음.
    private String name;
    private int password;
    private String post;
    private Timestamp createdData;


    public Memo(String name, int password, String post) {
        this.postNumber = postNumber;
        this.name = name;
        this.password = password;
        this.post = post;
        this.createdData = getCurrentTimestamp();
    }

    public void setPost(String post) {
        this.post = post; // 수정 내용
        this.createdData = getCurrentTimestamp(); // 수정 시간
    }

    public String getName() { return name; }
    public String getPost() { return post; }

    public Timestamp getCreatedData() {
        return createdData;
    }

    private Timestamp getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        return Timestamp.valueOf(now);
    }

    public int getPassword() {
        return password;
    }
}
