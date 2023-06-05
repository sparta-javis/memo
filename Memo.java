package team.memo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

class Memo {
    private String name;
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