package team.memo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MemoList {
    private List<Memo> memos;

    public MemoList() {
        this.memos = new ArrayList<>(); // String과 int 요소를 함께 저장이 가능함
    }

    public void addMemo() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력하세요:");
        String name = scanner.nextLine();
        System.out.println("비밀번호: ");
        int password = scanner.nextInt();
        scanner.nextLine();
        System.out.println("메모를 입력하세요:");
        String post = scanner.nextLine();

        Memo newMemo = new Memo(name, password, post);
        memos.add(newMemo);
    }

    public void modifyPost(int postNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("비밀번호를 입력하세요: ");
        int passwordInput = scanner.nextInt();
        scanner.nextLine(); // 입력 씹힘 현상 방지

        Memo memo = memos.get(postNumber);

        if (passwordInput == memo.getPassword()) { // 숫자이기 때문에 == 가능. String이라면 equals() 사용.
            System.out.println("새로운 내용을 입력하세요: ");
            String newPost = scanner.nextLine();
            memo.setPost(newPost); // 기존의 정보를 수정하는 것이기 때문에 set 필요.
            System.out.println("메모가 수정되었습니다.");
        } else {
            System.out.println("비밀번호가 올바르지 않습니다.");
        }
    }

    public void deleteMemo(int postNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("비밀번호를 입력하세요: ");
        int passwordInput = scanner.nextInt();
        scanner.nextLine();

        Memo memo = memos.get(postNumber);

        if (passwordInput == memo.getPassword()) {
            memos.remove(postNumber);
            System.out.println("메모가 삭제되었습니다.");
        } else {
            System.out.println("비밀번호가 올바르지 않습니다.");
        }
    }

    public List<Memo> getMemos() {
        return memos;
    }
}
