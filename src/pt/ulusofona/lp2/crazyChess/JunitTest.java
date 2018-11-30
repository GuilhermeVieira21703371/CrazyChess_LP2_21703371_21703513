package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;
import static org.junit.Assert.*;

public class JunitTest {


	@Test
	public void test1Alcunha(){
		CrazyPiece peca1 = new CrazyPiece(2,0,0,"Chefe");
		String resultadoEsperado = "Selvagem";
		String resultadoObtido = peca1.alcunha;
		assertEquals(resultadoEsperado,resultadoObtido);
	}

	@Test
	public void test2idPeca(){
		CrazyPiece peca2 = new CrazyPiece(1,0,0,"Chefe");
		int resultadoEsperado = 1;
		int resultadoObtido = peca2.idPeca;
		assertEquals(resultadoEsperado,resultadoObtido);
	}


}