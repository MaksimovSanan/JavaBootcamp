package edu.school21.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {
    NumberWorker numberWorker = new NumberWorker();

    @ParameterizedTest
    @ValueSource(ints = {3,5,7,17})
    void isPrimeForPrimes(int number) {
        try {
            assertTrue(numberWorker.isPrime(number));
        } catch (IllegalNumberException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10})
    void isPrimeForNotPrimes(int number){
        try {
            assertFalse(numberWorker.isPrime(number));
        } catch (IllegalNumberException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0 ,1})
    void isPrimeForIncorrectNumbers(int number){
        Throwable exception = assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(number));
        assertEquals("the number must be a natural number", exception.getMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void digitsSumTest(String number, String result) {
        assertEquals(Integer.valueOf(result), numberWorker.digitsSum(Integer.parseInt(number)));
    }
}

