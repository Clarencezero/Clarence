package chainofresponsibility;

public class HandlerA extends Handler{
    @Override
    protected boolean doHandle() {
        System.out.println("A Handler handle");
        return true;
    }
}
