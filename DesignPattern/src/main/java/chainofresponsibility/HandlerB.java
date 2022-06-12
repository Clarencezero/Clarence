package chainofresponsibility;


public class HandlerB extends Handler{
    @Override
    protected boolean doHandle() {
        System.out.println("B Handler handle");
        return true;
    }
}
