package ru.eugene.java.learn.binary;

public class BinaryOperationService {
    public int xor(int operandOne, int operandTwo){
        return operandOne ^ operandTwo;
    }

    public int bitwiseAnd(int operandOne, int operandTwo){
        return operandOne & operandTwo;
    }

    public int bitwiseOr(int operandOne, int operandTwo){
        return operandOne | operandTwo;
    }

    public int leftShift(int operand, int amount){
        return operand << amount;
    }

    public int rightShift(int operand, int amount){
        return operand >> amount;
    }

    public int unsignedRightShift(int operand, int amount){
        return operand >>> amount;
    }
}
