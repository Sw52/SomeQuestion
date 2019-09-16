package InterVIew.Tx.Second.Problem1;

import java.util.Scanner;

/*
钥匙打开锁，钥匙和锁的数字和为奇数时可以打开
 */
public class Main {
    public static int solution(int[] arraylock, int[] arrayKey) {
        int result = 0;
        int lockOrd = 0;
        int lockEve = 0;
        int keyOrd = 0;
        int keyEve = 0;

        for (int i = 0; i < arraylock.length; i++) {
            if ((arraylock[i] & 0x000000001) == 1)
                lockOrd++;
            else
                lockEve++;
        }
        for (int i = 0; i < arrayKey.length; i++) {
            if ((arrayKey[i] & 0x000000001) == 1)
                keyOrd++;
            else
                keyEve++;
        }
//        System.out.println(lockOrd+" "+lockEve);
//        System.out.println(keyOrd+" "+keyEve);
        result = Math.min(lockOrd, keyEve);
        result += Math.min(lockEve, keyOrd);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] array_Lock = new int[n];
        for (int i = 0; i < n; i++) {
            array_Lock[i] = scanner.nextInt();
        }
        int[] array_Key = new int[m];
        for (int i = 0; i < m; i++) {
            array_Key[i] = scanner.nextInt();
        }
//        System.out.println(Arrays.toString(array_Lock));
//        System.out.println(Arrays.toString(array_Key));

        System.out.println(solution(array_Lock, array_Key));
    }
}
