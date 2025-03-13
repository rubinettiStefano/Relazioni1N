package esempi;

import model.dao.CasaDAO;
import model.entities.Casa;
import model.entities.Stanza;
import utility.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class EsempioUsoDAO
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Connection con = ConnectionFactory.createConnection("agenzia_immobiliare");
		CasaDAO cdao = new CasaDAO(con);
		Casa casaTorino = cdao.findById(1L);

//		System.out.println("Indirizzo: "+casaTorino.getIndirizzo());
//
//		for(Stanza s : casaTorino.getStanze())
//			System.out.println(s.getTipo());


		//aggiungo una nuova casa
		Casa nuova = new Casa();
		System.out.println("Dammi indirizzo");
		nuova.setIndirizzo(sc.nextLine());
		System.out.println("Dammi pmq");
		nuova.setPmq(Integer.parseInt(sc.nextLine()));
		System.out.println("Dammi classe_energetica");
		nuova.setClasseEnergetica(sc.nextLine());
		System.out.println("Dammi piano");
		nuova.setPiano(Integer.parseInt(sc.nextLine()));

		cdao.save(nuova);


		//ESEMPIO 2 PROGRAMMA DI PRIMA
		ArrayList<Casa> listaCase = cdao.findAll();

		for(Casa c:listaCase)
		{
			System.out.println("------------------------------------------------");
			System.out.println("Indirizzo:"+c.getIndirizzo());




			System.out.println("Area:"+c.calcArea());

			System.out.println("Bagni:"+c.numeroBagni());
			System.out.println("Numero stanze:"+c.getStanze().size());

			System.out.println("Tipi stanze");
			for(Stanza s: c.getStanze())
				System.out.println(s.getTipo());
		}

	}
}
