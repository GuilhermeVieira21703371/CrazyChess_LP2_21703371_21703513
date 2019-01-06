package pt.ulusofona.lp2.crazyChess;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Simulador {
    int tamanhoTabuleiro;
    int nmrPecas;
    int[][] tabuleiro;
    List<CrazyPiece> listaPecas;
    int turno;
    int idEquipaAtual;
    int nmrCapBrancas;
    int nmrCapPretas;
    int nmrJogadasVBrancas;
    int nmrJogadasVPretas;
    int nmrJogadasIVBrancas;
    int nmrJogadasIVPretas;
    int nmrTurnosSemCapturas;
    int nmrCapturas;
    String endGameState;
    int jokerCounter;


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

                    int idPeca = Integer.parseInt(dados[0]);
                    int idTipopeca = Integer.parseInt(dados[1]);
                    int idEquipa = Integer.parseInt(dados[2]);
                    String alcunha = dados[3];

                    if(idTipopeca==0){
                        Rei rei = new Rei(idPeca,idTipopeca,idEquipa,alcunha,tabuleiro,tamanhoTabuleiro);
                        listaPecas.add(rei);
                    }
                    if(idTipopeca==1){
                        Rainha rainha = new Rainha(idPeca,idTipopeca,idEquipa,alcunha,tabuleiro,tamanhoTabuleiro);
                        listaPecas.add(rainha);
                    }
                    if(idTipopeca==2){
                        PoneiMagico poneiMagico = new PoneiMagico(idPeca,idTipopeca,idEquipa,alcunha,tabuleiro,tamanhoTabuleiro);
                        listaPecas.add(poneiMagico);
                    }
                    if(idTipopeca==3){
                        PadreDaVila padreDaVila = new PadreDaVila(idPeca,idTipopeca,idEquipa,alcunha,tabuleiro,tamanhoTabuleiro);
                        listaPecas.add(padreDaVila);
                    }
                    if(idTipopeca==4){
                        TorreHor torreHor = new TorreHor(idPeca,idTipopeca,idEquipa,alcunha,tabuleiro,tamanhoTabuleiro);
                        listaPecas.add(torreHor);
                    }
                    if(idTipopeca==5){
                        TorreVer torreVer = new TorreVer(idPeca,idTipopeca,idEquipa,alcunha,tabuleiro,tamanhoTabuleiro);
                        listaPecas.add(torreVer);
                    }
                    if(idTipopeca==6){
                        Lebre lebre = new Lebre(idPeca,idTipopeca,idEquipa,alcunha,tabuleiro,tamanhoTabuleiro);
                        listaPecas.add(lebre);
                    }
                    if(idTipopeca==7){
                        Joker joker = new Joker(idPeca,idTipopeca,idEquipa,alcunha,tabuleiro,tamanhoTabuleiro);
                        listaPecas.add(joker);
                    }
                    linhasLidas++;
                } else if (linhasLidas == 0) {
                    tamanhoTabuleiro = Integer.parseInt(dados[0]);
                    tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];
                    linhasLidas++;
                } else if (linhasLidas == 1) {
                    nmrPecas = Integer.parseInt(dados[0]);
                    linhasLidas++;
                }
                else if(linhasLidas<=nmrPecas+tamanhoTabuleiro){
                    for (int i = 0; i < tamanhoTabuleiro; i++) {
                        int tempData = Integer.parseInt(dados[i]);
                        tabuleiro[boardCount][i] = tempData;
                        if (tempData != 0) {
                            for (CrazyPiece pecaMaluca : listaPecas) {
                                if (tempData == pecaMaluca.getId()) {
                                    pecaMaluca.changePos(i, boardCount);
                                    pecaMaluca.changeCaptureStatus( 0);
                                }
                            }
                        }
                    }
                    boardCount++;
					linhasLidas++;
            }else{
					idEquipaAtual=Integer.parseInt(dados[0]);
                	nmrJogadasVPretas=Integer.parseInt(dados[1]);
					nmrCapPretas=Integer.parseInt(dados[2]);
					nmrJogadasIVPretas=Integer.parseInt(dados[3]);
					nmrJogadasVBrancas=Integer.parseInt(dados[4]);
					nmrCapBrancas=Integer.parseInt(dados[5]);
					nmrJogadasIVBrancas=Integer.parseInt(dados[6]);
				}

			}
            leitorFicheiro.close();
            return true;
        } catch (FileNotFoundException exception) {
            return false;
        }
    }

    public List<String> obterSugestoesJogada(int xO, int yO) {

        int tempId = getIDPeca(xO, yO);
        CrazyPiece tempPiece = getPiece(tempId);

        int pieceId = tempPiece.getIdTipopeca();
        List<String> listaSugestoes = new ArrayList<>();
        switch(pieceId) {

            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default: break;

        }

        return listaSugestoes;


        }


    public boolean gravarJogo(File ficheiroDestino) {

        String newLine = System.getProperty("line.separator");
        try {
            File output=new File("teste.txt");
            FileWriter writer=new FileWriter(output);

            writer.write(tamanhoTabuleiro + "");
            writer.write(newLine);
            writer.write(getPecasMalucas().size() + "");
            writer.write(newLine);

            for (CrazyPiece p : getPecasMalucas()) {
                String peca=p.getId() + ":" + p.getIdTipopeca() + ":" + p.getIdEquipa() + ":" + p.getAlcunha();
                writer.write(peca);
                writer.write(newLine);
            }

            ArrayList<Integer> pecas=new ArrayList<>();
            for (int i=0; i < tamanhoTabuleiro; i++) {
                for (int j=0; j < tamanhoTabuleiro; j++) {
                    if (tabuleiro[i][j] == 0) {
                        pecas.add(0);
                    } else {
                        pecas.add(tabuleiro[i][j]);
                    }
                }

                for (int b=0; b < tamanhoTabuleiro * 2; b++) {
                    for (int a=0; a < tamanhoTabuleiro; a++) {
                        String memoriaGravar="";
                        memoriaGravar+=pecas.get(a);
                        memoriaGravar+=":";
                        writer.write(memoriaGravar);
                    }
                    writer.write(newLine);
                }
            }
            String memoriaGravar="";
            if(turno%2==0){
                memoriaGravar += "20";
            }
            else{
                memoriaGravar += "10";
            }
            memoriaGravar += ":";
            memoriaGravar += nmrJogadasVPretas + ":";
            memoriaGravar += nmrCapPretas + ";";
            memoriaGravar += nmrJogadasIVPretas + ":";
            memoriaGravar += nmrJogadasVBrancas + ":";
            memoriaGravar += nmrCapBrancas + ";";
            memoriaGravar += nmrJogadasIVBrancas + ":";

        }
        catch(IOException e) {
            System.out.println("Ocorreu um erro.");
            return false;
        }
        return true;
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
                int tempTeamID = pecaMaluca.getIdEquipa();
                if(tempTeamID == getIDEquipaAJogar() ) {// Verificação da equipa da peça selecionada
                    int tempID = pecaMaluca.getId();
                    pieceIDO = tempID; // no caso de existir efetivamente uma peça na origem, guarda-se o ID da peça numa variável dentro do método
                }
            }
        }

        if(pieceIDO == 0) {
            if(getIDEquipaAJogar() == 10) {
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
                int tempTeamID = pecaMaluca.getIdEquipa();
                if(tempTeamID == getIDEquipaAJogar()) {
                    if(getIDEquipaAJogar() == 10) {
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

        if(xO > tamanhoTabuleiro -1 || xO < 0 || yO > tamanhoTabuleiro -1 || yO < 0 || xD > tamanhoTabuleiro -1 || xD < 0 || Yd > tamanhoTabuleiro -1 || Yd < 0 ) { // Verificação das cordenadas de origem e destino
            if(getIDEquipaAJogar() == 10) {
                nmrJogadasIVPretas++;
            } else {
                nmrJogadasIVBrancas++;
            }
            return false;
        }

        CrazyPiece pecamalucaOrig = getPiece(pieceIDO);
        boolean confirmarJogada = pecamalucaOrig.confirmMove(xO,yO,xD,Yd);

        if(!confirmarJogada) {
            if(getIDEquipaAJogar() == 10) {
                nmrJogadasIVPretas++;
            } else {
                nmrJogadasIVBrancas++;
            }
            return false;
        }

        if(pecamalucaOrig != null) {
            pecamalucaOrig.changePos(xD, Yd);
            tabuleiro[Yd][xD] = pieceIDO;
            tabuleiro[yO][xO] = 0;
            CrazyPiece pecamalucaDest = getPiece(pieceIDD);
            if(pecamalucaDest != null) {
                pecamalucaDest.changeCaptureStatus(1);
                if(getIDEquipaAJogar() == 10) {
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


        if(getIDEquipaAJogar() == 10) {
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
            int id_equipaPeca = pecaMaluca.getIdEquipa();
            int id_tipo = pecaMaluca.getIdTipopeca();
            boolean capture_status = pecaMaluca.getCaptureStatus();
            if(id_tipo == 0 && id_equipaPeca== 10 && !capture_status) {
                nmrReisPretos++;
            } else if(id_tipo == 0 && id_equipaPeca == 20 && !capture_status) {
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

    public CrazyPiece getPiece(int id) {
        for(CrazyPiece pecamaluca: listaPecas) {
            if(id == pecamaluca.getId()) {
                return pecamaluca;
            }
        }
        return null;
    }


}
