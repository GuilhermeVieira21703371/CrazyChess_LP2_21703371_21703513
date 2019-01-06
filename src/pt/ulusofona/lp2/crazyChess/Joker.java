package pt.ulusofona.lp2.crazyChess;

public class Joker extends CrazyPiece{

    int jokerID = 1;
    int valorRelativo = 4;

    public Joker(int idPeca, int idTipopeca, int idEquipa, String alcunha, int[][] tabuleiro, int tamanhoTabuleiro) {
        super(idPeca, idTipopeca, idEquipa, alcunha, tabuleiro, tamanhoTabuleiro);
        this.tipo = "Joker";
    }

    public void changeJokerId(int currentTurn) {

        switch (currentTurn) {
            case 0: jokerID = 1;
            tipo = "Joker/Rainha";
                break;
            case 1:  jokerID = 2;
                tipo = "Joker/Ponei Mágico";
                break;
            case 2: jokerID = 3;
                tipo = "Joker/Padre da Vila\n";
                break;
            case 3: jokerID = 4;
                tipo = "Joker/TorreH";
                break;
            case 4: jokerID = 5;
                tipo = "Joker/TorreV";
                break;
            case 5: jokerID = 6;
                tipo = "Joker/Lebre";
                break;
            default:
                break;
        }

    }
    @Override
    public boolean confirmMove(int xO,int yO,int xD,int yD) {
        return true;
    }

}
