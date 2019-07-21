package CodingInterview2;

public class Q10_Fibonacci {
    /**
     * @see 递归实现fibonacci数列
     * @param n
     * @return
     */
    public static int fibonacci(int n){
        int fibonacci_n = 0;
        if(n==0)
            fibonacci_n = 0;
        else if(n==1)
            fibonacci_n = 1;
        else if(n>1)
            fibonacci_n = fibonacci(n-1)+fibonacci(n-2);
        return fibonacci_n;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(9));
        System.out.println(fibonacci(10));


    }
}
