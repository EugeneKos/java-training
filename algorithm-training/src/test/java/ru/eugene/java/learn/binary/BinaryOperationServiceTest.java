package ru.eugene.java.learn.binary;

import org.junit.Assert;
import org.junit.Test;

public class BinaryOperationServiceTest {
    private BinaryOperationService binaryOperationService = new BinaryOperationService();

    @Test
    public void xorTest(){
        int operandOne = 0b1000;
        Assert.assertEquals(8, operandOne);

        int operandTwo = 0b0101;
        Assert.assertEquals(5, operandTwo);

        int result = binaryOperationService.xor(operandOne, operandTwo);
        Assert.assertEquals(0b1101, result);
        Assert.assertEquals(13, result);
    }

    @Test
    public void bitwiseAndTest(){
        int operandOne = 0b1000;
        Assert.assertEquals(8, operandOne);

        int operandTwo = 0b0101;
        Assert.assertEquals(5, operandTwo);

        int result = binaryOperationService.bitwiseAnd(operandOne, operandTwo);
        Assert.assertEquals(0b0000, result);
        Assert.assertEquals(0, result);
    }

    @Test
    public void bitwiseOrTest(){
        int operandOne = 0b1000;
        Assert.assertEquals(8, operandOne);

        int operandTwo = 0b0101;
        Assert.assertEquals(5, operandTwo);

        int result = binaryOperationService.bitwiseOr(operandOne, operandTwo);
        Assert.assertEquals(0b1101, result);
        Assert.assertEquals(13, result);
    }

    @Test
    public void leftShiftTest(){
        int operandOne = 0b11111111111111111111111000100000;
        Assert.assertEquals(-480, operandOne);

        int result = binaryOperationService.leftShift(operandOne, 5);
        Assert.assertEquals(0b11111111111111111100010000000000, result);
        Assert.assertEquals(-15360, result);

        int operandTwo = 0b00000111111111111111111000100000;
        Assert.assertEquals(134217248, operandTwo);

        result = binaryOperationService.leftShift(operandTwo, 5);
        Assert.assertEquals(0b11111111111111111100010000000000, result);
        Assert.assertEquals(-15360, result);
    }

    @Test
    public void rightShiftTest(){
        int operandOne = 0b11111111111111111111111000100000;
        Assert.assertEquals(-480, operandOne);

        int result = binaryOperationService.rightShift(operandOne, 5);
        Assert.assertEquals(0b11111111111111111111111111110001, result);
        Assert.assertEquals(-15, result);

        int operandTwo = 0b00000111111111111111111000100000;
        Assert.assertEquals(134217248, operandTwo);

        result = binaryOperationService.rightShift(operandTwo, 5);
        Assert.assertEquals(0b00000000001111111111111111110001, result);
        Assert.assertEquals(4194289, result);
    }

    @Test
    public void unsignedRightShiftTest(){
        int operandOne = 0b11111111111111111111111000100000;
        Assert.assertEquals(-480, operandOne);

        int result = binaryOperationService.unsignedRightShift(operandOne, 5);
        Assert.assertEquals(0b00000111111111111111111111110001, result);
        Assert.assertEquals(134217713, result);

        int operandTwo = 0b00000111111111111111111000100000;
        Assert.assertEquals(134217248, operandTwo);

        result = binaryOperationService.unsignedRightShift(operandTwo, 5);
        Assert.assertEquals(0b00000000001111111111111111110001, result);
        Assert.assertEquals(4194289, result);
    }
}