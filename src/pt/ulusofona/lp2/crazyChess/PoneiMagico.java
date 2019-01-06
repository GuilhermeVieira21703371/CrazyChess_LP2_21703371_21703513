package pt.ulusofona.lp2.crazyChess;

public class PoneiMagico extends CrazyPiece {

    public PoneiMagico(int idPeca, int idTipopeca, int idEquipa, String alcunha, int[][] tabuleiro, int tamanhoTabuleiro) {
        super(idPeca, idTipopeca, idEquipa, alcunha, tabuleiro, tamanhoTabuleiro);
        this.tipo = "Ponei Mágico";
    }

    @Override
    public boolean confirmMove(int xO, int yO, int xD, int yD) {
        return true;


    }
}
