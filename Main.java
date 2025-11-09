import Singlton.Logger;


public class Main {

    public static void main(String[] args) {

        Logger loggerV1 = Logger.getInstance();
        Logger loggerV2 = Logger.getInstance();

        System.out.println("DO BOTH HAVE SAME MEMORY LOCATION : " + (loggerV1 == loggerV2));

    }

}