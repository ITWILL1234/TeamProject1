package com.itwill.page;

import java.util.Scanner;

public class Main {
    private static final int SIGN_UP = 1;
    private static final int SIGN_IN = 2;
    private static final Scanner scan = new Scanner(System.in);

    public static void exe() {
        displayWelcomeScreen();
        int inputRL = getUserChoice();
        processUserChoice(inputRL);
        
        return;
    }

    private static void displayWelcomeScreen() {
        System.out.println("\n"
                + "███████╗    ███╗   ███╗ █████╗ ██╗     ██╗     \n"
                + "██╔════╝    ████╗ ████║██╔══██╗██║     ██║     \n"
                + "█████╗█████╗██╔████╔██║███████║██║     ██║     \n"
                + "██╔══╝╚════╝██║╚██╔╝██║██╔══██║██║     ██║     \n"
                + "███████╗    ██║ ╚═╝ ██║██║  ██║███████╗███████╗\n"
                + "╚══════╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝\n");
        System.out.println("<> 콘솔창에 원하는 메뉴를 입력해주세요! <>");
        System.out.println("<> 1. 회원가입 <>\n"
        		+ "<> 2. 로그인 <>");
    }

    // 유저의 입력을 Scanner로 받는 함수입니다.
    // 1, 2 외의 숫자가 입력받았을 때나, 문자를 입력받았을 때는 유저에게 다시 입력하도록
    // 지시하는 코드입니다.
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

    // 유저의 입력값이 valid할 경우, 해당 입력에 맞는 페이지로 리다이렉트 하는 코드입니다.
    private static void processUserChoice(int choice) {
        ConsoleClear.clear();

        if (choice == SIGN_UP) {
        	SignIn.exe();
        } else if (choice == SIGN_IN) {
            Login.exe();
        }
        return;
    }
}
