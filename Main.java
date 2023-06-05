package team.memo;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static MemoList memoList;

    public static void main(String[] args) {
        memoList = new MemoList();

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
        while (true) {
            System.out.println();
            System.out.println("1. 입력    2. 목록 보기    3. 수정    4. 삭제    5. 처음으로    6. 종료");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (input) {

                case 1:
                    memoList.addMemo();
                    break;

                case 2:
                    printRecentMemoList(memoList);
                    System.out.println("보고싶은 글 번호를 입력하세요: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    List<Memo> memos = memoList.getMemos();
                    if (num >= 1 && num <= memos.size()) {
                        Memo memo = getMemoByNumber(memos, num);
                        if (memo != null) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String formattedDate = dateFormat.format(memo.getCreatedData());
                            System.out.println(memo.getName() + "\n\n" + memo.getPost() + "\n\n" + formattedDate + "\n");
                        } else {
                            System.out.println("해당 메모는 삭제되었습니다.");
                        }
                    } else {
                        System.out.println("잘못된 글 번호입니다.");
                    }
                    break;
                case 3:
                    printRecentMemoList(memoList);
                    System.out.print("수정할 글 번호를 입력하세요: ");
                    num = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (num >= 1 && num <= memoList.getMemos().size()) {
                        memoList.modifyPost(num - 1);
                    } else {
                        System.out.println("잘못된 글 번호입니다.");
                    }
                    break;
                case 4:
                    printRecentMemoList(memoList);
                    System.out.print("삭제할 글 번호를 입력하세요: ");
                    num = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (num >= 1 && num <= memoList.getMemos().size()) {
                        memoList.deleteMemo(num - 1);
                    } else {
                        System.out.println("잘못된 글 번호입니다.");
                    }
                    break;
                case 5:
                    recentMemo(memoList);
                    break;
                case 6:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    private static void printRecentMemoList(MemoList memoList) {
        List<Memo> memos = memoList.getMemos();
        Collections.sort(memos, Comparator.comparing(Memo::getCreatedData).reversed());
        for (int i = 0; i < memos.size(); i++) {
            int num = i + 1;
            Memo memo = memos.get(i);
            System.out.println(num + ". " + memo.getName() + " | " + memo.getPost());
            memo.setMemoNumber(num); // 메모 객체에 번호를 설정
        }
    }

    private static Memo getMemoByNumber(List<Memo> memos, int number) {
        for (Memo memo : memos) {
            if (memo.getMemoNumber() == number) {
                return memo;
            }
        }
        return null;
    }
}