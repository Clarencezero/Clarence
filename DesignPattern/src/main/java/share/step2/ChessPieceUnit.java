package share.step2;

/**
 * 享元类
 * 这里定义的字段都是可以复用的
 */
public class ChessPieceUnit {
    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }
    public static enum Color {
        RED, BLACK;
    }
}
