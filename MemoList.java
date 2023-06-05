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

}
