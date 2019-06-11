package ru.eugene.java.learn.behaviour.chainofresponsibility;

public class UpperCaseMiddleware extends Middleware {
    public UpperCaseMiddleware(Middleware next) {
        super(next);
    }

    @Override
    public String getName() {
        return "upper case";
    }

    @Override
    public boolean checkMe(String message) {
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            String sym = message.charAt(i) + "";
            if(sym.equals(sym.toUpperCase())){
                count++;
            }
        }
        return count >= 3;
    }
}
