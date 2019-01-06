package pt.ulusofona.lp2.crazyChess;

public class Rainha extends CrazyPiece {

    public Rainha(int idPeca, int idTipopeca, int idEquipa, String alcunha, int[][] tabuleiro, int tamanhoTabuleiro) {
        super(idPeca, idTipopeca, idEquipa, alcunha, tabuleiro, tamanhoTabuleiro);
        this.tipo = "Rainha";
    }
    @Override
    public boolean confirmMove(int xO,int yO,int xD,int yD) {
        return true;


    }
}
