package team.memo;

import java.util.*;

//손명지 브랜치

class MemoList {
    private List<Memo> memos;

    public MemoList() {
        this.memos = new ArrayList<>();

        initializeMemos();
    }

    private void initializeMemos() {
        Memo testMemo = new Memo("테스트", 1234, "테스트용입니다.");
        memos.add(testMemo);
    }

    public List<Memo> getMemos() {
        return new ArrayList<>(memos);
    }

    public void setMemos(List<Memo> MemoList) {
        this.memos = memos;
    }

    public void addMemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("새로운 메모를 입력하세요.");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("비밀번호: ");
        int password = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("내용: ");
        String post = scanner.nextLine();

        Memo memo = new Memo(name, password, post);
        memos.add(memo);
        System.out.println("메모가 추가되었습니다.");
    }

}
