package pt.ulusofona.lp2.crazyChess;

public class CrazyPiece {
    int ID_peca;
    int ID_tipoPeca;
    int ID_equipa;
    String alcunha;
    int posX;
    int posY;
    boolean capture_status = true;


    public CrazyPiece(int ID_peca, int ID_tipoPeca, int ID_equipa, String alcunha) {
        this.ID_peca = ID_peca;
        this.ID_tipoPeca = ID_tipoPeca;
        this.ID_equipa = ID_equipa;
        this.alcunha = alcunha;
    }


    public int getId() {
        return ID_peca;

    }

    public int getID_tipoPeca() {
        return ID_tipoPeca;
    }

    public int getID_equipa() {
        return ID_equipa;
    }

    public String getImagePNG() {
        if(ID_equipa == 0) {
            return "pecas_pretas.png";
        } else {
            return "pecas_brancas.png";
        }
    }

    public String toString() {
        if(!capture_status) {
            return ID_peca + " | " + ID_tipoPeca + " | " + ID_equipa + " | " + alcunha + " @ " + "(" + posX + ", " + posY + ")";
        } else {
            return ID_peca + " | " + ID_tipoPeca + " | " + ID_equipa + " | " + alcunha + " @ (n/a)";
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
        return capture_status;
    }

    void changeCapture_status(int newStatus) {
        if(newStatus == 1) {
            posX = -1;
            posY = -1;
            capture_status = true;
        } else {
            capture_status = false;
        }
    }
}