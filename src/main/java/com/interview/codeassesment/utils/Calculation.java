package com.interview.codeassesment.utils;

public class Calculation {
    public static int calculatePoints(Double sales) {
        int points = 0;
        if (sales > 100) {
            points += (int) (sales - 100) * 2; // 2 points for every dollar over $100 in each transaction
            points += 50; // plus 50 additional points
        } else if (sales > 50) {
            points += (int) (sales - 50); // 1 point for every dollar over $50 in each transaction
        }
        return points;
    }
}
