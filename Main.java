package team.memo;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MemoList memoList = new MemoList();

        System.out.println("[ 메모 리스트 ]\n");

        // 테스트 목록 출력
        List<Memo> memos = memoList.getMemos();
        printMemos(memoList);

        handleMainMenuInput();
    }

    private static void printMemos(MemoList memoList) {
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
        int num = scanner.nextInt();

        switch(input) {
            case 1:
                memoList.addMemo
                break;
            case 2:
                List<Memo> memos = memoList.getMemos();
                for (int i=0; i<memos.size(); i++) {
                    num = i + 1;
                    Memo memo = memos.get(i);
                    System.out.println(num + ". " + memos.get(i).name + " | " + memos.get(i).post);
                }
                break;
            case 3:
                System.out.print("수정할 글 번호를 입력하세요: ");
                scanner.nextLine(); // Consume the newline character
                if (num >= 1 && num <= memos.size()) {
                    memoList.modifyMemo(num - 1);
                } else {
                    System.out.println("잘못된 글 번호입니다.");
                }
                break;
            case 4:
                System.out.print("삭제할 글 번호를 입력하세요: ");
                num = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                if (num >= 1 && num <= memos.size()) {
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
