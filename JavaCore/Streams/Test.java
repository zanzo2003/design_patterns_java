package JavaCore.Streams;


import java.time.Instant;
import java.util.*;
import java.time.Duration;
import java.util.stream.Collectors;

public class Test {

    public static void main( String[] args ){

        List<String> input = List.of( "java", "stream", "api");

        List<String> output = input
                .stream()
                .parallel()
                .map( (string) -> string.toUpperCase() )
                .filter( (string) -> string.equals("API"))
                .collect(Collectors.toList());

        output.forEach( str -> System.out.println(str));


        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 4, 5, 5, 43, 3, 3, 2 ,4, 33);
        List<Number> countOfDistinctNumbers = numbers
                .stream()
                .parallel()
                .distinct()
                .collect(Collectors.toList());


        Optional<Integer> maxNumber = numbers
                .stream()
                        .max( Integer :: compareTo );

        System.out.println(" Maximum number is : " + maxNumber.get());
        System.out.println("Number of Unique elements : " + countOfDistinctNumbers);


    }

}
