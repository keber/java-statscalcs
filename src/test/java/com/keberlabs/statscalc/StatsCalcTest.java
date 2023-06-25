package com.keberlabs.statscalc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsCalcTest {

    StatsCalc calc;

    @BeforeEach
    void setUp() {
        this.calc = new StatsCalc();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isPrime() {

        assertTrue(calc.isPrime(1),"True was expected for isPrime(1)");
        assertTrue(calc.isPrime(2),"True was expected for isPrime(2)");
        assertTrue(calc.isPrime(3),"True was expected for isPrime(3)");
        assertFalse(calc.isPrime(4),"False was expected for isPrime(4)");
        assertTrue(calc.isPrime(5),"True was expected for isPrime(5)");
        assertFalse(calc.isPrime(6),"False was expected for isPrime(6)");
        assertTrue(calc.isPrime(7),"True was expected for isPrime(7)");
        assertTrue(calc.isPrime(19),"True was expected for isPrime(19)");
        assertTrue(calc.isPrime(83),"True was expected for isPrime(83)");
        assertTrue(calc.isPrime(1021),"True was expected for isPrime(1021)");
        assertTrue(calc.isPrime(3697),"True was expected for isPrime(3697)");
        assertTrue(calc.isPrime(7873 ),"True was expected for isPrime(7873)");
        assertTrue(calc.isPrime(13669),"True was expected for isPrime(13669)");
        assertTrue(calc.isPrime(32749 ),"True was expected for isPrime(32749)");
        assertFalse(calc.isPrime(32750 ),"False was expected for isPrime(32750)");
    }

    @Test
    void divisorsOf(){
        assertEquals(calc.divisorsOf(6),2 , "Wrong # of dividers for 6" + calc.allDivisorsOf(2));
        assertEquals(calc.divisorsOf(25),1 , "Wrong # of dividers for 25: " + calc.allDivisorsOf(25));
        assertEquals(calc.divisorsOf(36),7 , "Wrong # of dividers for 36: " + calc.allDivisorsOf(36));
    }
}