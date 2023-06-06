package team.memo;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static MemoList memoList;

    public static void main(String[] args) {
        memoList = new MemoList();

        System.out.println("[ 메모 리스트 ]\n");
        printRecentMemoList(memoList);
        handleMainMenuInput();
    }

    private static void handleMainMenuInput() {
        while (true) {

            System.out.println();
            System.out.println("1. 입력    2. 목록 보기    3. 수정     4. 삭제    5. 종료");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            scanner.nextLine(); // 입력 씹힘 방지

            switch (input) {

                case 1:
                    memoList.addMemo();
                    break;

                case 2:
                    printRecentMemoList(memoList);
                    break;

                case 3:
                    printRecentMemoList(memoList);
                    System.out.println();
                    System.out.print("수정할 글 번호를 입력하세요:\n");

                    int num = scanner.nextInt();
                    scanner.nextLine(); // 입력 씹힘 방지
                    if (num >= 1 && num <= memoList.getMemos().size()) {
                        memoList.modifyPost(num - 1);
                    } else {
                        System.out.println("잘못된 글 번호입니다.");
                    }

                    break;

                case 4:
                    printRecentMemoList(memoList);
                    System.out.println();
                    System.out.print("삭제할 글 번호를 입력하세요:\n");

                    num = scanner.nextInt();
                    scanner.nextLine(); // 입력 씹힘 방지
                    if (num >= 1 && num <= memoList.getMemos().size()) {
                        memoList.deleteMemo(num - 1);
                    } else {
                        System.out.println("잘못된 글 번호입니다.");
                    }

                    break;

                case 5:
                    System.exit(0);

                default:
                    break;
            }
        }
    }

    private static void printRecentMemoList(MemoList memoList) {
        List<Memo> memos = memoList.getMemos();

        // createdData 최신순으로 정렬
        Collections.sort(memos, Comparator.comparing(Memo::getCreatedData).reversed());

        for (int i=0; i<memos.size(); i++) {
            int postNumber = i+1;
            Memo memo = memos.get(postNumber-1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(memo.getCreatedData());
            System.out.println(postNumber + ". " + memo.getName() + " | " + memo.getPost() + " | " + formattedDate);
        }
    }
}