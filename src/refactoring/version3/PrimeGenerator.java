package refactoring.version3;

public class PrimeGenerator {
    private static boolean[] isCrossed;
    private static int[] result;

    public static int[] generatePrimeNumbers(int maxValue) {
        if (maxValue < 2)
            return new int[0];
        else {
            initializeArrayOfIntegers(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void initializeArrayOfIntegers(int maxValue) {
        // declarations
        isCrossed = new boolean[maxValue + 1];
        isCrossed[0] = isCrossed[1] = false; //neither primes nor multiples.
        for (int i = 2; i < isCrossed.length; i++)
            isCrossed[i] = true;
    }

    private static void crossOutMultiples() {
        for (int i = 2; i < Math.sqrt(isCrossed.length) + 1; i++) {
            if (isCrossed[i]) // if i is uncrossed, cross its multiples.
            {
                for (int j = 2 * i; j < isCrossed.length; j += i)
                    isCrossed[j] = false; // multiple is not prime
            }
        }
    }

    private static void putUncrossedIntegersIntoResult() {
        // how many primes are there?
        int count = 0;
        for (boolean b : isCrossed) {
            if (b)
                count++; // bump count.
        }
        result = new int[count];
        // move the primes into the result
        for (int i = 0, j = 0; i < isCrossed.length; i++) {
            if (isCrossed[i]) // if prime
                result[j++] = i;
        }
    }
}
