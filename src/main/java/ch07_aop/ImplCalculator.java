package ch07_aop;

public class ImplCalculator implements Calculator{

    @Override
    public long factorial(long n) {
        long result = 1;
        for(long i = 1; i<= n; i++)
            result *= i;

        return result;
    }
}
