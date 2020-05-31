package refactoring.finalversion;

import org.junit.Assert;
import org.junit.Test;


public class GeneratePrimesTest {

    @Test
    public void testPrimes() {
        int[] nullArray = PrimeGenerator.generatePrimeNumbers(0);
        Assert.assertEquals(nullArray.length, 0);

        int[] minArray = PrimeGenerator.generatePrimeNumbers(2);
        Assert.assertEquals(minArray.length, 1);
        Assert.assertEquals(minArray[0], 2);

        int[] threeArray = PrimeGenerator.generatePrimeNumbers(3);
        Assert.assertEquals(threeArray.length, 2);
        Assert.assertEquals(threeArray[0], 2);
        Assert.assertEquals(threeArray[1], 3);

        int[] centArray = PrimeGenerator.generatePrimeNumbers(100);
        Assert.assertEquals(centArray.length, 25);
        Assert.assertEquals(centArray[24], 97);
    }

    @Test
    public void testExhaustive() {
        for (int i = 2; i < 500; i++)
            verifyPrimeList(PrimeGenerator.generatePrimeNumbers(i));
    }

    private void verifyPrimeList(int[] list) {
        for (int value : list) verifyPrime(value);
    }

    private void verifyPrime(int n) {
        for (int factor = 2; factor < n; factor++)
            Assert.assertTrue(n % factor != 0);
    }
}