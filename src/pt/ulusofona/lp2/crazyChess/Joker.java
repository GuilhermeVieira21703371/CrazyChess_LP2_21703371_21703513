package pt.ulusofona.lp2.crazyChess;

public class Joker extends CrazyPiece{

    int jokerID = 1;
    int valorRelativo = 4;

    public Joker(int idPeca, int idTipopeca, int idEquipa, String alcunha, int[][] tabuleiro) {
        super(idPeca, idTipopeca, idEquipa, alcunha, tabuleiro);
    }

    public void changeJokerId(int currentTurn) {

        switch (currentTurn) {
            case 0: jokerID = 1;
                break;
            case 1:  jokerID = 2;
                break;
            case 2: jokerID = 3;
                break;
            case 3: jokerID = 4;
                break;
            case 4: jokerID = 5;
                break;
            case 5: jokerID = 6;
                break;
            case 6: jokerID = 7;
                break;
            default:
                break;
        }

    }
    @Override
    public boolean confirmMove(int xO,int yO,int xD,int yD) {

    }

}
