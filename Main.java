package team.memo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MemoList memoList = new MemoList();

        System.out.println("메모 리스트");
        List<Memo> memos = memoList.getMemos();
        printMemos(memoList);
    }

    private static void printMemos(MemoList memoList) {
        List<Memo> memos = memoList.getMemos();
        for (int i=0; i<memos.size(); i++) {
            int num = i + 1;
            Memo memo = memos.get(i);
//            System.out.println(num + ". " + memo); // 주소값 출력
            System.out.println(num + ". " + memos.get(i).name + " | " + memos.get(i).post + " | " + memos.get(i).createdData);
        }
    }

}
