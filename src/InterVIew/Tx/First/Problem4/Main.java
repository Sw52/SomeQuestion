package InterVIew.Tx.First.Problem4;

import java.util.Scanner;

public class Main {
    public static int solution(int n, int[] camplayStatus, int[] GamStatus) {
        int days = 0;
        boolean cam = false;
        boolean gam = false;
        for (int i = 0; i < n; i++) {
            if (camplayStatus[i] == 0 && GamStatus[i] == 1) {
                if (gam == false) {
                    gam = true;
                    cam = false;
                } else {
                    days++;
                    cam = false;
                    gam = false;
                }
            } else if (camplayStatus[i] == 1 && GamStatus[i] == 0) {
                if (cam == false) {
                    cam = true;
                    gam = false;
                } else {
                    days++;
                    cam = false;
                    gam = false;
                }
            } else if (camplayStatus[i] == 1 && GamStatus[i] == 1) {
                if (gam == false && cam == true) {
                    gam = true;
                    cam = false;
                } else if (cam == false && gam == true) {
                    cam = true;
                    gam = false;
                } else if (cam == false && gam == false) {
                    if (i + 1 < n && camplayStatus[i + 1] == 1) {
                        gam = true;
                        cam = false;
                    } else if (i + 1 < n && GamStatus[i + 1] == 1) {
                        gam = false;
                        cam = true;
                    } else {
                        gam = true;
                        cam = false;
                    }
                } else if (cam == true && gam == true) {
                    days++;
                    cam = false;
                    gam = false;
                }
            } else if (camplayStatus[i] == 0 && GamStatus[i] == 0) {
                days++;
                cam = false;
                gam = false;
            }
        }
        return days;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] camplayStatus = new int[n];
        for (int i = 0; i < n; i++) {
            camplayStatus[i] = scanner.nextInt();
        }
        int[] GamStatus = new int[n];
        for (int i = 0; i < n; i++) {
            GamStatus[i] = scanner.nextInt();
        }
        System.out.println(solution(n, camplayStatus, GamStatus));
    }
}
