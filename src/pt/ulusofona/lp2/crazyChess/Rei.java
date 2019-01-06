package pt.ulusofona.lp2.crazyChess;

public class Rei extends CrazyPiece {


    public Rei(int idPeca, int idTipopeca, int idEquipa, String alcunha, int[][] tabuleiro, int tamanhoTabuleiro) {
        super(idPeca, idTipopeca, idEquipa, alcunha, tabuleiro, tamanhoTabuleiro);
        this.tipo = "Rei";
    }

    @Override
    public boolean confirmMove(int xO, int yO, int xD, int yD) {
        if ((xD - xO) == 1 || (xD - xO) == -1 || (xD - xO) == 0) {
            if ((yD - yO) == 1 || (yD - yO) == -1 || (yD - yO) == 0) {
                return true;
                } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
