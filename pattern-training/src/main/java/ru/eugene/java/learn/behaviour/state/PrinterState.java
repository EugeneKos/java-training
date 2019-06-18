package ru.eugene.java.learn.behaviour.state;

/**
 * Применяется Когда у вас есть объект, поведение которого кардинально меняется в зависимости от внутреннего состояния,
 * причём типов состояний много, и их код часто меняется.
 *
 * В данном примере 3 разных состояния принтера.
 * Принтер с полным картриджом, с полупустым и пустым.
 *
 * В зависимости от этого принтер или хорошо печатает или плохо или вообще не печатает
 */
public interface PrinterState {
    void print(String text);
}
