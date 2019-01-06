package pt.ulusofona.lp2.crazyChess;

public class Lebre extends CrazyPiece {

    public Lebre(int idPeca, int idTipopeca, int idEquipa, String alcunha, int[][] tabuleiro, int tamanhoTabuleiro) {
        super(idPeca, idTipopeca, idEquipa, alcunha, tabuleiro, tamanhoTabuleiro);
        this.tipo = "Lebre";
    }

    @Override
    public boolean confirmMove(int xO, int yO, int xD, int yD) {
        if(idEquipa == 10) {
            if((xD == xO -1 && yD == yO -1) || (xD == xO +1 && yD == yO +1) || (xD == xO +1 && yD == yO -1) || (xD == xO -1 && yD == yO +1)) {
                return true;
            }
        }
        return false;

    }
}
