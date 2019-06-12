package ru.eugene.java.learn.behaviour.chainofresponsibility;

public class UpperCaseMiddleware extends Middleware {
    public UpperCaseMiddleware(Middleware next) {
        super(next);
    }

    @Override
    public boolean check(String message) {
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            String sym = message.charAt(i) + "";
            if(sym.equals(sym.toUpperCase())){
                count++;
            }
        }
        if(count >= 3){
            System.out.println("check upper case true");
            return nextCheck(message);
        }
        System.err.println("check upper case false");
        return false;
    }
}
