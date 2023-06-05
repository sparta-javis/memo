package team.memo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoList {

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

}
