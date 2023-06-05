package team.memo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
//이건 이승철 브랜치입니다 브랜치입니다.sdfsfafsfdfss dfsf sfdsfaf
class Memo {
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
