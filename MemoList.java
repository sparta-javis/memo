package team.memo;

import java.util.*;

class MemoList {
    private List<Memo> memos;
    private Scanner scanner;

    public MemoList() {
        this.memos = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        initializeMemos();
    }

    private void initializeMemos() {
        Memo testMemo = new Memo("테스트", 1234, "테스트용입니다.");
        memos.add(testMemo);
    }

    public List<Memo> getMemos() {
        return new ArrayList<>(memos);
    }

    public void setMemo() {
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

    public void modifyPost(int key) {
        if (key >= 0 && key < memos.size()) {
            Memo memo = memos.get(key);
            System.out.print("Enter the password: ");
            int password = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (memo.getPassword() == password) {
                System.out.print("Enter the new post: ");
                String newPost = scanner.nextLine();
                memo.setPost(newPost);
                System.out.println("Post modified successfully.");
            } else {
                System.out.println("Incorrect password. Post cannot be modified.");
            }
        } else {
            System.out.println("No memo found for the given key.");
        }
    }

    public void deleteMemo(int key) {
        if (key >= 0 && key < memos.size()) {
            Memo memo = memos.get(key);
            System.out.print("Enter the password: ");
            int password = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (memo.getPassword() == password) {
                memos.remove(key);
                System.out.println("Memo deleted successfully.");
            } else {
                System.out.println("Incorrect password. Memo cannot be deleted.");
            }
        } else {
            System.out.println("No memo found for the given key.");
        }
    }
}
