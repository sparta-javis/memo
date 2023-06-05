package team.memo.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class entry {
    private static List<String> memoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("이름을 입력하세요:");
        String name = scanner.nextLine();

        System.out.println("비밀번호를 입력하세요:");
        String password = scanner.nextLine();

        System.out.println("메모를 입력하세요:");
        String memo = scanner.nextLine();

        String note = "이름: " + name + ", 비밀번호: " + password + ", 메모: " + memo;
        memoList.add(note);

        System.out.println("글이 생성되었습니다.");
        System.out.println("메모 리스트: " + memoList);
    }
}