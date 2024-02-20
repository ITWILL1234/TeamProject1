package com.itwill.page;

import java.util.Scanner;
import com.itwill.crud.Userr_Insert;

public class Main {
    private static final int SIGN_UP = 1;
    private static final int SIGN_IN = 2;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeScreen();
        int inputRL = getUserChoice();
        processUserChoice(inputRL);
    }

    private static void displayWelcomeScreen() {
        System.out.println("\n"
                + "███████╗    ███╗   ███╗ █████╗ ██╗     ██╗     \n"
                + "██╔════╝    ████╗ ████║██╔══██╗██║     ██║     \n"
                + "█████╗█████╗██╔████╔██║███████║██║     ██║     \n"
                + "██╔══╝╚════╝██║╚██╔╝██║██╔══██║██║     ██║     \n"
                + "███████╗    ██║ ╚═╝ ██║██║  ██║███████╗███████╗\n"
                + "╚══════╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝\n");
        System.out.println("1. 회원가입 2. 로그인");
    }

    private static int getUserChoice() {
        while (true) {
            try {
                String input = scan.nextLine();
                int inputRL = Integer.parseInt(input);

                if (inputRL == SIGN_UP || inputRL == SIGN_IN) {
                    return inputRL;
                } else {
                    System.out.println("\n1 또는 2를 입력해주세요. 다시 입력해주세요."); // 잘못된 숫자 입력 처리
                }
            } catch (NumberFormatException e) {
                System.out.println("\n숫자로 입력해주세요."); // 숫자가 아닌 입력 처리
            }
        }
    }

    private static void processUserChoice(int choice) {
        ConsoleClear erase = new ConsoleClear();
        erase.clear(); // 화면 지우기를 선택에 상관없이 한 번만 호출

        if (choice == SIGN_UP) {
        	Userr_Insert regist = new Userr_Insert();
            regist.start();
        } else if (choice == SIGN_IN) {
            Login login = new Login();
            login.login();
        }
    }
}
