package team.memo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

// 손명지 브랜치

class Memo {
    private String name;
    private int password;
    private String post;
    private Timestamp createdData;
    private int memoNumber; // Memo number added

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

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public Timestamp getCreatedData() {
        return createdData;
    }

    public int getPassword() {
        return password;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setModifiedData(Timestamp modifiedData) {
        this.createdData = modifiedData;
    }

    public void setMemoNumber(int memoNumber) {
        this.memoNumber = memoNumber;
    }

    public int getMemoNumber() {
        return memoNumber;
    }
}


