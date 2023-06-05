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
}
