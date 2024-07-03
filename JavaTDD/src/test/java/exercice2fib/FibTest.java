package exercice2fib;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FibTest {
    Fib fib;
    @Test
    public void TestFibWhenRange_1_ThenGetFibSeries_NotEmpty_And_Contains_0() {
        int range = 1;
        List<Integer> listExpected = List.of(0);
        fib = new Fib(range);
        List<Integer> listResult = fib.getFibSeries();
        assertThat(listResult).hasSizeGreaterThan(0)
                .containsExactlyInAnyOrderElementsOf(listExpected);
    }

    @Test
    public void TestFibWhenRange_6_ThenGetFibSeries_Contains_Number_3 () {
        int range = 6;
        int number = 3;
        fib = new Fib(range);
        List<Integer> listResult = fib.getFibSeries();
        assertThat(listResult).contains(number);
    }

    @Test
    public void TestFibWhenRange_6_ThenGetFibSeries_Contains_6_Elements () {
        int range = 6;
        int size = 6;
        fib = new Fib(range);
        List<Integer> listResult = fib.getFibSeries();
        assertThat(listResult).hasSize(size);
    }

    @Test
    public void TestFibWhenRange_6_ThenGetFibSeries_NotContains_Number_4 () {
        int range = 6;
        int number = 4;
        fib = new Fib(range);
        List<Integer> listResult = fib.getFibSeries();
        assertThat(listResult).doesNotContain(number);
    }

    @Test
    public void TestFibWhenRange_6_ThenGetFibSeries_Contains_ExpectedList () {
        int range = 6;
        List<Integer> listExpected = List.of(0, 1, 1, 2, 3, 5);
        fib = new Fib(range);
        List<Integer> listResult = fib.getFibSeries();
        assertThat(listResult).containsExactlyInAnyOrderElementsOf(listExpected);
    }

    @Test
    public void TestFibWhenRange_6_ThenGetFibSeries_IsSortedList_Ascendant () {
        int range = 6;
        fib = new Fib(range);
        List<Integer> listResult = fib.getFibSeries();
        assertThat(listResult).isSorted();
    }
}
