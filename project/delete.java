package team.memo.project;

import java.util.HashMap;
import java.util.Scanner;

public class delete {
    public static void main(String[] args) {
        //은아 // 게시글 정보를 저장할 해시맵 생성
        HashMap<Integer, String> posts = new HashMap<>();

        //은아 // 예시로 게시글 몇 개 추가
        posts.put(1, "첫 번째 게시글");
        posts.put(2, "두 번째 게시글");
        posts.put(3, "세 번째 게시글");

        Scanner scanner = new Scanner(System.in);

        //은아 // 삭제할 글 번호를 입력 받음
        System.out.print("삭제할 글 번호를 입력하세요: ");
        int postId = scanner.nextInt();

        //은아 // 입력 받은 글 번호에 해당하는 글이 존재하는지 확인
        if (posts.containsKey(postId)) {
            System.out.print("삭제할 글의 비밀번호를 입력하세요: ");
            String password = scanner.next();

            //은아 // 입력 받은 비밀번호와 해당 글의 비밀번호 비교
            if (checkPassword(posts.get(postId), password)) {
                //은아 // 비밀번호가 일치하면 글 삭제
                posts.remove(postId);
                System.out.println("글이 삭제되었습니다.");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        } else {
            System.out.println("존재하지 않는 글입니다.");
        }
    }

    //은아 // 비밀번호 일치 여부를 확인하는 메소드
    private static boolean checkPassword(String post, String password) {
        //은아 // 여기에서 비밀번호 일치 여부를 판단하는 로직을 구현하세요
        //은아 // 예시로 비밀번호가 password1234일 때만 일치
        return password.equals("password1234");
    }
}