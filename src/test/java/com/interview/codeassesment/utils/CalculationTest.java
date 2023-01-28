package com.interview.codeassesment.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CalculationTest {

    @Test
    void calculatePoints() {
        log.info("Testing Calculation class");

        log.info("Expecting 0 points from 0 sales");
        assertEquals(0, Calculation.calculatePoints(0.0));
        log.info("Expecting 0 points from 50 sales");
        assertEquals(0, Calculation.calculatePoints(50.0));
        log.info("Expecting 1 points from 51 sales");
        assertEquals(1, Calculation.calculatePoints(51.0));
        log.info("Expecting 52 points from 101 sales");
        assertEquals(52, Calculation.calculatePoints(101.0));
        log.info("Expecting 152 points from 151 sales");
        assertEquals(152, Calculation.calculatePoints(151.0));
    }
}