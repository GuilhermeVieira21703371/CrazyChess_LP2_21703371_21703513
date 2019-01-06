package pt.ulusofona.lp2.crazyChess;

public class Joker extends CrazyPiece{

    int jokerID = 1;
    int valorRelativo = 4;

    public Joker(int idPeca, int idTipopeca, int idEquipa, String alcunha) {
        super(idPeca, idTipopeca, idEquipa, alcunha);
    }

    public void changeJokerId(int currentTurn) {


        int newID;
        for(int i = 5; i > 1; i--) {

        }

        switch (newID) {
            case 1:   = "January";
                break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid month";
                break;
        }

    }

}
