package team.memo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MemoList {
    private List<Memo> memos;
    private int memoNumberCounter;

    public MemoList() {
        this.memos = new ArrayList<>();
        this.memoNumberCounter = 1;
    }

    public void addMemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름: ");
        String name = scanner.nextLine();
        System.out.println("비밀번호: ");
        int password = scanner.nextInt();
        scanner.nextLine();
        System.out.println("내용: ");
        String post = scanner.nextLine();

        Memo newMemo = new Memo(name, password, post);
        newMemo.setMemoNumber(memoNumberCounter);
        memos.add(newMemo);

        memoNumberCounter++;
    }

    public void modifyPost(int index) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("비밀번호를 입력하세요: ");
        int passwordInput = scanner.nextInt();
        scanner.nextLine();

        Memo memo = memos.get(index);

        if (passwordInput == memo.getPassword()) {
            System.out.println("새로운 내용을 입력하세요: ");
            String newPost = scanner.nextLine();
            memo.setPost(newPost);
            System.out.println("메모가 수정되었습니다.");
        } else {
            System.out.println("비밀번호가 올바르지 않습니다.");
        }
    }

    public void deleteMemo(int index) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("비밀번호를 입력하세요: ");
        int passwordInput = scanner.nextInt();
        scanner.nextLine();

        Memo memo = memos.get(index);

        if (passwordInput == memo.getPassword()) {
            memos.remove(index);
            System.out.println("메모가 삭제되었습니다.");
        } else {
            System.out.println("비밀번호가 올바르지 않습니다.");
        }
    }

    public List<Memo> getMemos() {
        return memos;
    }
}
