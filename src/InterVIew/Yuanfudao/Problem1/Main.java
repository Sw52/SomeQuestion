package InterVIew.Yuanfudao.Problem1;

import java.util.*;


public class Main {

    public static void solution(int[] arr,int m) {
        int[] arrayCopy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arrayCopy);
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < arrayCopy.length-m; i++) {
            for (int j = i+1; j <= i+m; j++) {
                if (arrayCopy[i]==arrayCopy[j])
                    flag = true;
                else
                    flag = false;
            }
            if (flag)
                set.add(arrayCopy[i]);
        }

        int[] re = new int[set.size()];
        int l = 0;
        for (int i:set
             ) {
            re[l] = i;
            l++;
        }
        boolean ge = true;
        for (int i = 0; i < arr.length; i++) {
            ge = true;
            for (int j = 0; j < re.length; j++) {
                if (arr[i]==re[j])
                    ge = false;
            }
            if (ge)
                list.add(arr[i]);
        }
        for (int i:list
             ) {
            System.out.print(i+" ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(arr,m);
    }
}
