package pt.ulusofona.lp2.crazyChess;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Simulador {
    int tamanhoTabuleiro;
    int nmrPecas;
    int[][] tabuleiro;
    List<CrazyPiece> listaPecas = new ArrayList<>();
    int playingTeam;
    int turno = 0;


    public Simulador() {

    }


    public boolean iniciaJogo(File ficheiroInicial) {
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
                                    pecaMaluca.setPos(i, boardCount);
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
        return true;

    }

    public List<CrazyPiece> getPecasMalucas() {
        return listaPecas;

    }

    public boolean jogoTerminado() {
        return true;

    }

    public List<String> getAutores() {
        List<String> autores = new ArrayList<>();
        autores.add("Guilherme Vieira");
        autores.add("Xiaoyue Xie");
        return autores;

    }


    //public List<String> getResultados()  {

    //}

    public int getIDPeca(int x, int y) {

        for (CrazyPiece pecaMaluca : listaPecas) {
            if (pecaMaluca.posX == x && pecaMaluca.posY == y) {
                int pieceID = pecaMaluca.getId();
                return pieceID;
            }
        }
        return 0;


    }

    public int getIDEquipaAJogar() {
        if (playingTeam == 1) {
            return 1;
        } else {
            return 0;
        }

    }


}
