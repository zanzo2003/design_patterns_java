package JavaCore.ExceptionHandling;


/*
 - try to write code which might potentially throw some exception
 - catch to catch certain excpetion
 */

public class Test {

    public static void main(String[] args){
        try {
            method1();
        }catch (ArithmeticException exception){
            System.out.println("Exception thrown!!");
        }
    }

    private static int method1(){
        return method2();
    }

    private static int method2(){
        return method3();
    }

    private static int method3(){
        return 5/0;
    }
}
