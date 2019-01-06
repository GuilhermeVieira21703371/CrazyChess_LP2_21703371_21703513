package pt.ulusofona.lp2.crazyChess;

public class TorreHor extends CrazyPiece {

    public TorreHor(int idPeca, int idTipopeca, int idEquipa, String alcunha, int[][] tabuleiro, int tamanhoTabuleiro) {
        super(idPeca, idTipopeca, idEquipa, alcunha, tabuleiro, tamanhoTabuleiro);
        this.tipo = "TorreH";
    }
    @Override
    public boolean confirmMove(int xO,int yO,int xD,int yD) {
        if(xD < 0 || xD > tamanhoTabuleiro -1 || yD < 0 || yD > tamanhoTabuleiro - 1 || yD < yO || yD > yO) {
            return false;
        }
        if(xD < xO) {
            for (int i = yO; i < yD; i++) {
                if(tabuleiro[i][xO] != 0){
                    return false;

                }

            }

        } else if(xO < xD){
            for (int i = yO; i > yD; i--) {
                if(tabuleiro[i][xO] != 0){
                    return false;

                }

            }
        }

        return true;

    }
}
