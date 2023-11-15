
package edu.school21.numbers;
public class NumberWorker {
    public boolean isPrime(int number) throws IllegalNumberException{
        if(number < 2) {
            throw new IllegalNumberException("the number must be a natural number");
        }
        int sqrt = (int)Math.ceil(Math.sqrt(number)) + 1;
        for(int i = 2; i < sqrt; ++i) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int digitsSum(int number) {
        if(number < 0) number *= -1;
        int res = 0;
        while(number > 0) {
            res += number % 10;
            number /= 10;
        }
        return res;
    }
}

