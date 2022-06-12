package share.step1;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋局
 */
public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();;

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(1, "車", ChessPiece.Color.BLACK, 0, 0));
        chessPieces.put(2, new ChessPiece(1, "馬", ChessPiece.Color.BLACK, 0, 1));
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //
        System.out.println("move chesspiece.");
    }
}
