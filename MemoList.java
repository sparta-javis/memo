package team.memo;

import java.util.Scanner;
import java.util.*;

//이승철 브랜치

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

    //메모 수정하기란
    Scanner scanner = new Scanner(System.in);
    private static void modifyMemo() {
        System.out.println("==== 메모 수정 ====");
        System.out.print("비밀번호: ");
        int password = scanner.nextInt();
        scanner.nextLine();

        boolean foundPassword = false;
        for (Memo memo : memos) {
            if (memo.getPassword() == password) {
                System.out.print("새로운 포스트 입력: ");
                String newPost = scanner.nextLine();
                memo.setPost(newPost);
                memo.setCreatedData(new Date());
                foundPassword = true;
                System.out.println("메모 수정 완료");
                break;
            }
        }
        if (!foundPassword) {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }

    public List<Memo> getMemos() {
        return new ArrayList<>(memos);
    }

    public void setMemos(List<Memo> MemoList) {
        this.memos = memos;
    }

}