package team.memo;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MemoList memoList = new MemoList();

        System.out.println("[ 메모 리스트 ]\n");
        recentMemo(memoList); // 최신 메모 하나만 출력

        handleMainMenuInput();
    }

    private static void recentMemo(MemoList memoList) {
        List<Memo> memos = memoList.getMemos();

        if (!memos.isEmpty()) {

            // createdData 최신순으로 정렬
            Collections.sort(memos, Comparator.comparing(Memo::getCreatedData).reversed());

            Memo latestMemo = memos.get(0);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(latestMemo.getCreatedData());

            System.out.println(latestMemo.getName() + "\n\n" + latestMemo.getPost() + "\n\n" + formattedDate + "\n");
        } else {
            System.out.println("메모가 없습니다.");
        }
    }

    private static void handleMainMenuInput() {

        System.out.println("1. 입력    2. 목록 보기    3. 수정    4. 삭제    5. 종료");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        MemoList memoList = new MemoList();

        switch (input) {
//            case 1:
//                memoList.addMemo
//                break;
            case 2:
                printMemoList(memoList);
                break;
            case 3:
                printMemoList(memoList);
                System.out.print("수정할 글 번호를 입력하세요: ");
                scanner.nextLine(); // Consume the newline character
                if (num >= 1 && num <= memos.size()) {
                    memoList.modifyMemo(num - 1);
                } else {
                    System.out.println("잘못된 글 번호입니다.");
                }
                break;

//            case 4:
//
            case 5:
                System.exit(0);
            default:
                break;
        }
    }

    private static void printMemoList(MemoList memoList) {
        List<Memo> memos = memoList.getMemos();
        for (int i = 0; i < memos.size(); i++) {
            int num = i + 1;
            Memo memo = memos.get(i);
            System.out.println(num + ". " + memos.get(i).name + " | " + memos.get(i).post);
        }
    }
}