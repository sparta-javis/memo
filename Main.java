package team.memo;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static MemoList memoList;

    public static void main(String[] args) {
        memoList = new MemoList();

        System.out.println("[ 메모 리스트 ]\n");
        handleMainMenuInput();
    }

    private static void handleMainMenuInput() {
        while (true) {
            printRecentMemoList(memoList);

            System.out.println();
            System.out.println("1. 입력    2. 목록 보기    3. 수정     4. 삭제    5. 종료");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {

                case 1:
                    memoList.addMemo();
                    break;

                case 2:
                    System.out.println("보고싶은 글 번호를 입력하세요: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    List<Memo> memos = memoList.getMemos();
                    if (num >= 1 && num <= memos.size()) {
                        Memo memo = getMemoByNumber(memos, num);
                        if (memo != null) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String createdDate = dateFormat.format(memo.getCreatedData());
                            String modifiedDate = dateFormat.format(memo.getModifiedData());
                            System.out.println(memo.getMemoNumber() + ". " + memo.getName() + "\n\n" + memo.getPost() + "\n\n" + "작성 시간: " + createdDate + "\n" + "수정 시간: " + modifiedDate + "\n");
                        } else {
                            System.out.println("해당 메모는 삭제되었습니다.");
                        }
                    } else {
                        System.out.println("잘못된 글 번호입니다.");
                    }

                    break;

                case 3:
                    System.out.print("수정할 글 번호를 입력하세요: ");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    if (num >= 1 && num <= memoList.getMemos().size()) {
                        memoList.modifyPost(num - 1);
                    } else {
                        System.out.println("잘못된 글 번호입니다.");
                    }

                    break;

                case 4:
                    System.out.print("삭제할 글 번호를 입력하세요: ");
                    num = scanner.nextInt();
                    scanner.nextLine();
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

        int num = 1;
        for (Memo memo : memos) {
            memo.setMemoNumber(num); // 메모 객체에 번호를 설정
            System.out.println(num + ". " + memo.getName() + " | " + memo.getPost());
            num++;
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
