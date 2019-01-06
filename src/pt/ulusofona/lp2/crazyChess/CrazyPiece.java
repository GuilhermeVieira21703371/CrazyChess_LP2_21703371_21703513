package pt.ulusofona.lp2.crazyChess;

public abstract class  CrazyPiece {
    int idPeca;
    int idTipopeca;
    int idEquipa;
    String alcunha;
    String tipo;
    int posX;
    int posY;
    boolean captureStatus = true;
    int[][] tabuleiro;
    int tamanhoTabuleiro;

    public CrazyPiece() {
        }


    public CrazyPiece(int idPeca, int idTipopeca, int idEquipa, String alcunha, int[][] tabuleiro, int tamanhoTabuleiro) {
        this.idPeca = idPeca;
        this.idTipopeca = idTipopeca;
        this.idEquipa = idEquipa;
        this.alcunha = alcunha;
        this.tabuleiro = tabuleiro;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
    }


    public int getId() {
        return idPeca;

    }

    public String getAlcunha(){
        return alcunha;
    }

    public int getIdTipopeca() {
        return idTipopeca;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public String getImagePNG() {
        if(idEquipa == 10) {
            return "pecas_pretas.png";
        } else {
            return "pecas_brancas.png";
        }
    }

    public String toString() {
        if(!captureStatus) {
            return idPeca + " | " + idTipopeca + " | " + idEquipa + " | " + alcunha + " @ " + "(" + posX + ", " + posY + ")";
        } else {
            return idPeca + " | " + idTipopeca + " | " + idEquipa + " | " + alcunha + " @ (n/a)";
        }
    }

    void changePos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    boolean getCaptureStatus() {
        return captureStatus;
    }

    void changeCaptureStatus(int newStatus) {
        if(newStatus == 1) {
            posX = -1;
            posY = -1;
            captureStatus = true;
        } else {
            captureStatus = false;
        }
    }

    public abstract boolean confirmMove(int xO,int yO,int xD,int yD);


}