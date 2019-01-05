package pt.ulusofona.lp2.crazyChess;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;

public class TestSimulador {
    @Test
    public void test1() {
        Simulador novoJogo = new Simulador();

        novoJogo.listaPecas = new ArrayList<>();

        novoJogo.tamanhoTabuleiro = 4;
        novoJogo.tabuleiro = new int[novoJogo.tamanhoTabuleiro][novoJogo.tamanhoTabuleiro];

        CrazyPiece peca1 = new CrazyPiece(1,0,0,"teste1");
        peca1.changePos(1,1);
        int posX = peca1.getPosX();
        int posY = peca1.getPosY();

        novoJogo.tabuleiro[posX][posY] = 1;

        for(int i = 0; i < novoJogo.tamanhoTabuleiro; i++) {
            if(novoJogo.tabuleiro[i][i] != 1) {
                novoJogo.tabuleiro[i][i] = 0;
            }
        }

        novoJogo.listaPecas.add(peca1);


        assertTrue(novoJogo.processaJogada(1,1,0,0));
        assertEquals(0, peca1.posX);
        assertEquals(0,peca1.posY);
    }

    @Test
    public void test2() {
        Simulador novoJogo = new Simulador();

        novoJogo.listaPecas = new ArrayList<>();

        novoJogo.tamanhoTabuleiro = 12;
        novoJogo.tabuleiro = new int[novoJogo.tamanhoTabuleiro][novoJogo.tamanhoTabuleiro];

        CrazyPiece peca1 = new CrazyPiece(1,0,0,"teste1");
        peca1.changePos(0,0);
        int posX = peca1.getPosX();
        int posY = peca1.getPosY();

        novoJogo.tabuleiro[posX][posY] = 1;

        for(int i = 0; i < novoJogo.tamanhoTabuleiro; i++) {
            if(novoJogo.tabuleiro[i][i] != 1) {
                novoJogo.tabuleiro[i][i] = 0;
            }
        }

        novoJogo.listaPecas.add(peca1);


        assertFalse(novoJogo.processaJogada(0,0,-1,-1));
        assertEquals(0, peca1.posX);
        assertEquals(0,peca1.posY);
    }
}
