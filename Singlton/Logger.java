package Singlton;

public class Logger {

    private static Logger loggerInstace = null;

    private Logger(){
        System.out.println("Initializing Logger instance");
    }


    public static Logger getInstance(){
        if(loggerInstace == null){
            loggerInstace= new Logger();
        }
        return loggerInstace;
    }

    public void writeLog(){
        System.out.println("Writing Log");
    }


}


/*
MAIN CLASS EXAMPLE

CODE
Logger loggerV1 = Logger.getInstance();
Logger loggerV2 = Logger.getInstance();
System.out.println("DO BOTH HAVE SAME MEMORY LOCATION : " + (loggerV1 == loggerV2));

OUTPUT
DO BOTH HAVE SAME MEMORY LOCATION : true

*/