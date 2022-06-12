package chainofresponsibility;


public class M {
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        handlerChain.addHandler(handlerA);
        handlerChain.addHandler(handlerB);

        handlerChain.handle();
    }
}
