package com.test;

import java.util.Scanner;

public class TestSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weekNumber = scanner.nextInt();
        switch (weekNumber){
           /* case 1:
                System.out.println("工作日");
                break;

            case 2:
                System.out.println("工作日");
                break;

            case 3:
                System.out.println("工作日");
                break;

            case 4:
                System.out.println("工作日");
                break;

            case 5:
                System.out.println("工作日");
                break;

            case 6:
                System.out.println("休息日");
                break;

            case 7:
                System.out.println("休息日");
                break;

            default:
                System.out.println("没有这个选项");*/
           /* case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("工作日");
                break;
            case 6:
            case 7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("没有这个选项");*/
           /* case 1,2,3,4,5:
                System.out.println("工作日");
                break;
            case 6,7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("没有这个选项");*/
            case 1,2,3,4,5-> System.out.println("工作日");
            case 6,7->System.out.println("休息日");
            default-> System.out.println("没有这个选项");

        }
    }
}
