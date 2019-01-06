package pt.ulusofona.lp2.crazyChess;

public class TorreVer extends CrazyPiece {

    public TorreVer(int idPeca, int idTipopeca, int idEquipa, String alcunha, int[][] tabuleiro, int tamanhoTabuleiro) {
        super(idPeca, idTipopeca, idEquipa, alcunha, tabuleiro, tamanhoTabuleiro);
        this.tipo = "TorreV";
    }
    @Override
    public boolean confirmMove(int xO,int yO,int xD,int yD) {
        if(xD < 0 || xD > tamanhoTabuleiro -1 || yD < 0 || yD > tamanhoTabuleiro - 1 || xD < xO || xD > xO) {
            return false;
        }
        if(yD < yO) {
            for (int i = xO; i < xD; i++) {
                if(tabuleiro[xO][i] != 0){
                    return false;

                }

            }

        } else if(yO < yD){
            for (int i = xO; i > xD; i--) {
                if(tabuleiro[yO][i] != 0){
                    return false;

                }

            }
        }

        return true;

    }
}
