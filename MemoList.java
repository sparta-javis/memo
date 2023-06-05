package team.memo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

//손명지 브랜치

class MemoList {
    private List<Memo> memos;

    public MemoList() {
        this.memos = new ArrayList<>();
    }

    public void addMemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름: ");
        String name = scanner.nextLine();
        System.out.println("비밀번호: ");
        int password = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("내용: ");
        String post = scanner.nextLine();
        memos.add(new Memo(name, password, post));
    }

    public void modifyPost(int index) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("새로운 내용을 입력하세요: ");
        String newPost = scanner.nextLine();
        Memo memo = memos.get(index);
        memo.setPost(newPost);
        memo.setModifiedData(getCurrentTimestamp());
        System.out.println("메모가 수정되었습니다.");
    }

    public void deleteMemo(int index) {
        memos.remove(index);
        System.out.println("메모가 삭제되었습니다.");
    }

    public List<Memo> getMemos() {
        return memos;
    }

    private Timestamp getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        return Timestamp.valueOf(now);
    }
}
