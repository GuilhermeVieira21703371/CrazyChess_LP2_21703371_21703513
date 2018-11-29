package pt.ulusofona.lp2.crazyChess;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Simulador {
    int tamanhoTabuleiro;
    int nmrPecas;
    int[][] tabuleiro;
    List<CrazyPiece> listaPecas;
    int turno;
    int nmrCapBrancas;
    int nmrCapPretas;
    int nmrJogadasVBrancas;
    int nmrJogadasVPretas;
    int nmrJogadasIVBrancas;
    int nmrJogadasIVPretas;
    int nmrTurnosSemCapturas;
    int nmrCapturas;
    String endGameState;


    public Simulador() {

    }


    public boolean iniciaJogo(File ficheiroInicial) {
        turno = 0;
        nmrCapBrancas = 0;
        nmrCapPretas = 0;
        nmrJogadasVBrancas = 0;
        nmrJogadasVPretas = 0;
        nmrJogadasIVBrancas = 0;
        nmrJogadasIVPretas = 0;
        nmrTurnosSemCapturas = 0;
        nmrCapturas = 0;
        listaPecas = new ArrayList<>();
        try {
            int linhasLidas = 0;
            int boardCount = 0;
            Scanner leitorFicheiro = new Scanner(ficheiroInicial);

            while (leitorFicheiro.hasNextLine()) {

                String linha = leitorFicheiro.nextLine();
                String dados[] = linha.split(":");

                if (linhasLidas > 1 && linhasLidas <= nmrPecas + 1) {

                    int ID_peca = Integer.parseInt(dados[0]);
                    int ID_tipoPeca = Integer.parseInt(dados[1]);
                    int ID_equipa = Integer.parseInt(dados[2]);
                    String alcunha = dados[3];

                    CrazyPiece pecaMaluca = new CrazyPiece(ID_peca, ID_tipoPeca, ID_equipa, alcunha);
                    listaPecas.add(pecaMaluca);

                } else if (linhasLidas == 0) {
                    tamanhoTabuleiro = Integer.parseInt(dados[0]);
                    tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];

                } else if (linhasLidas == 1) {
                    nmrPecas = Integer.parseInt(dados[0]);

                } else {

                    for (int i = 0; i < tamanhoTabuleiro; i++) {
                        int tempData = Integer.parseInt(dados[i]);
                        tabuleiro[boardCount][i] = tempData;
                        if (tempData != 0) {
                            for (CrazyPiece pecaMaluca : listaPecas) {
                                if (tempData == pecaMaluca.getId()) {
                                    pecaMaluca.changePos(i, boardCount);
                                    pecaMaluca.changeCapture_status(0);
                                }
                            }
                        }

                    }
                    boardCount++;
                    }
                linhasLidas++;
            }
            leitorFicheiro.close();
            return true;
        } catch (FileNotFoundException exception) {
            return false;
        }

    }

    public int getTamanhoTabuleiro() {
        return tamanhoTabuleiro;

    }

    public boolean processaJogada(int xO, int yO, int xD, int Yd) {
        int pieceIDO = 0;
        int pieceIDD = 0;

        for(CrazyPiece pecaMaluca : listaPecas) { // Verificação da presença de uma peça da equipa atual na origem
            int posX = pecaMaluca.getPosX();
            int posY = pecaMaluca.getPosY();
            if(posX == xO && posY == yO) {
                int tempTeamID = pecaMaluca.getID_equipa();
                if(tempTeamID == getIDEquipaAJogar() ) {// Verificação da equipa da peça selecionada
                    int tempID = pecaMaluca.getId();
                    pieceIDO = tempID; // no caso de existir efetivamente uma peça na origem, guarda-se o ID da peça numa variável dentro do método
                }
            }
        }

        if(pieceIDO == 0) {
            if(getIDEquipaAJogar() == 0) {
                nmrJogadasIVPretas++;
            } else {
                nmrJogadasIVBrancas++;
            }
            return false;
        }

        for(CrazyPiece pecaMaluca : listaPecas) { // Verificação da presença de uma peça da equipa atual no destino
            int posX = pecaMaluca.getPosX();
            int posY = pecaMaluca.getPosY();
            if(posX == xD && posY == Yd) {
                int tempTeamID = pecaMaluca.getID_equipa();
                if(tempTeamID == getIDEquipaAJogar()) {
                    if(getIDEquipaAJogar() == 0) {
                        nmrJogadasIVPretas++;
                    } else {
                        nmrJogadasIVBrancas++;
                    }
                    return false;
                } else {
                    int tempID = pecaMaluca.getId();
                    pieceIDD = tempID; // Guardar o ID da peça no destino
                }
            }
        }

        boolean confirmarJogada = confirmarNmrCasas(xO, yO, xD, Yd); // Verificação do numero de casas movido

        if(!confirmarJogada) {
            if(getIDEquipaAJogar() == 0) {
                nmrJogadasIVPretas++;
            } else {
                nmrJogadasIVBrancas++;
            }
            return false;
        }

        if(xO > tamanhoTabuleiro -1 || xO < 0 || yO > tamanhoTabuleiro -1 || yO < 0 || xD > tamanhoTabuleiro -1 || xD < 0 || Yd > tamanhoTabuleiro -1 || Yd < 0 ) { // Verificação das cordenadas de origem e destino
            if(getIDEquipaAJogar() == 0) {
                nmrJogadasIVPretas++;
            } else {
                nmrJogadasIVBrancas++;
            }
            return false;
        }

        CrazyPiece pecamalucaOrig = getPiece(pieceIDO);
        if(pecamalucaOrig != null) {
            pecamalucaOrig.changePos(xD, Yd);
            tabuleiro[Yd][xD] = pieceIDO;
            tabuleiro[yO][xO] = 0;
            CrazyPiece pecamalucaDest = getPiece(pieceIDD);
            if(pecamalucaDest != null) {
                pecamalucaDest.changeCapture_status(1);
                if(getIDEquipaAJogar() == 0) {
                    nmrCapPretas++;
                    nmrCapturas++;
                    nmrTurnosSemCapturas = 0;
                } else {
                    nmrCapBrancas++;
                    nmrCapturas++;
                    nmrTurnosSemCapturas = 0;
                }
            } else if(nmrCapturas > 0) {
                nmrTurnosSemCapturas++;

            }
        } else {
            return false;
        }


        if(getIDEquipaAJogar() == 0) {
            nmrJogadasVPretas++;
        } else {
            nmrJogadasVBrancas++;
        }
        turno++; // incrementação de turno
        return true;
    }

    public List<CrazyPiece> getPecasMalucas() {
        return listaPecas;

    }

    public boolean jogoTerminado() {
        int nmrReisBrancos = 0;
        int nmrReisPretos = 0;
        for(CrazyPiece pecaMaluca : listaPecas) {
            int id_equipaPeca = pecaMaluca.getID_equipa();
            int id_tipo = pecaMaluca.getID_tipoPeca();
            boolean capture_status = pecaMaluca.getCaptureStatus();
            if(id_tipo == 0 && id_equipaPeca== 0 && !capture_status) {
                nmrReisPretos++;
            } else if(id_tipo == 0 && id_equipaPeca == 1 && !capture_status) {
                nmrReisBrancos++;
            }
        }

        if(nmrReisBrancos == 0) {
            endGameState = "VENCERAM AS PRETAS";
            return true;
        }

        if(nmrReisPretos == 0) {
            endGameState = "VENCERAM AS BRANCAS";
            return true;
        }

        if(nmrTurnosSemCapturas >= 10 || (nmrReisBrancos == 1 && nmrReisPretos == 1)) {
            endGameState = "EMPATE";
            return true;
        } else {
            return false;

        }

    }

    public List<String> getAutores() {
        List<String> autores = new ArrayList<>();
        autores.add("Guilherme Vieira");
        autores.add("Xiaoyue Xie");
        return autores;

    }


    public List<String> getResultados()  {
        List<String> results = new ArrayList<>();
        results.add("JOGO DE CRAZY CHESS");
        results.add("Resultado: " + endGameState);
        results.add("---");
        results.add("Equipa das Pretas");
        results.add(Integer.toString(nmrCapPretas));
        results.add(Integer.toString(nmrJogadasVPretas));
        results.add(Integer.toString(nmrJogadasIVPretas));
        results.add("Equipa das Brancas");
        results.add(Integer.toString(nmrCapBrancas));
        results.add(Integer.toString(nmrJogadasVBrancas));
        results.add(Integer.toString(nmrJogadasIVBrancas));
        return results;



    }

    public int getIDPeca(int x, int y) {

        for (CrazyPiece pecaMaluca : listaPecas) {
            int posX = pecaMaluca.getPosX();
            int posY = pecaMaluca.getPosY();
            if (posX == x && posY == y) {
                int pieceID = pecaMaluca.getId();
                return pieceID;
            }
        }
        return 0;


    }

    public int getIDEquipaAJogar() {
        if(turno%2 == 0) { // rotação da equipa atual
            return 0;
        } else {
            return 1;
        }

    }

    public boolean confirmarNmrCasas(int xO, int yO, int xD, int yD) {
        if((xD - xO) == 1 || (xD - xO) == -1 || (xD -xO) == 0 ) {
            if((yD - yO) == 1 || (yD - yO) == -1 || (yD -yO) == 0 ) {
                return true;

            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public CrazyPiece getPiece(int id) {
        for(CrazyPiece pecamaluca: listaPecas) {
            if(id == pecamaluca.getId()) {
                return pecamaluca;
            }
        }
        return null;
    }


}
