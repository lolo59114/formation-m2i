import org.example.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FibTest {

    private Fib fib;

    @Test
    public void TestFibWhenGetFibSeries_Range1_ThenResult_IsNotEmpty(){
       //Arrange
        int range = 1;
        fib = new Fib(range);

        //Act
        List<Integer> result = fib.getFibSeries();

        //Assert
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    public void TestFibWhenGetFibSeries_Range1_ThenResultContain_0(){
        //Arrange
        int range = 1;
        fib = new Fib(range);

        //Act
        List<Integer> result = fib.getFibSeries();

        //Assert
        Assertions.assertTrue(result.contains(0));
    }

    @Test
    public void TestFibWhenGetFibSeries_Range6_ThenResultContain_3(){
        //Arrange
        int range = 6;
        fib = new Fib(range);

        //Act
        List<Integer> result = fib.getFibSeries();

        //Assert
        Assertions.assertTrue(result.contains(3));
    }

    @Test
    public void TestFibWhenGetFibSeries_Range6_ThenResultContain_6_Elements(){
        //Arrange
        int range = 6;
        int resultSize = 6;
        fib = new Fib(range);

        //Act
        List<Integer> result = fib.getFibSeries();

        //Assert
        Assertions.assertEquals(resultSize,result.size());
    }

    @Test
    public void TestFibWhenGetFibSeries_Range6_ThenResultDoesNotContain_4(){
        //Arrange
        int range = 6;
        fib = new Fib(range);

        //Act
        List<Integer> result = fib.getFibSeries();

        //Assert
        Assertions.assertFalse(result.contains(4));
    }

    @Test
    public void TestFibWhenGetFibSeries_Range6_ThenResultContain_0_1_1_2_3_5(){
        //Arrange
        List<Integer> resultAwait = List.of(0,1,1,2,3,5);
        int range = 6;
        fib = new Fib(range);

        //Act
        List<Integer> result = fib.getFibSeries();

        //Assert
        Assertions.assertEquals(resultAwait,result);

    }

    @Test
    public void TestFibWhenGetFibSeries_Range6_ThenResultIsSortedAscending (){
        //Arrange
        int range = 6;
        fib = new Fib(range);

        //Act
        List<Integer> result = fib.getFibSeries();
        List<Integer> expected = new ArrayList<>(result);
        expected.sort(null);
//        Collections.sort(expected);

        //Assert
        Assertions.assertEquals(expected,result);
    }
}
