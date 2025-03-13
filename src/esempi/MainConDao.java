package esempi;

import model.dao.CasaDAO;
import model.dao.StanzaDAO;
import model.entities.Casa;
import model.entities.Stanza;
import utility.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainConDao
{
	private static Scanner keyboard = new Scanner(System.in);
	private static Connection con;
	private static CasaDAO cdao;
	private static StanzaDAO sdao;

	private static void init()  throws Exception
	{
		System.out.println("Dammi nome db maledetto");
		con = ConnectionFactory.createConnection(keyboard.nextLine());

		cdao = new CasaDAO(con);
		sdao = new StanzaDAO(con);
	}


	public static void main(String[] args) throws Exception
	{
		init();
		String cmd;

		do
		{

			System.out.println("Dammi comando");
			cmd = keyboard.nextLine().toUpperCase();

			switch (cmd)
			{
				case "CREATECASA" -> createCasa();
				case "READCASE" -> readAllCase();
				case "READCASA" -> readCasa();
				case "UPDATECASA" -> updateCasa();
				case "DELETECASA" -> deleteCasa();

				case "CREATESTANZA" -> createStanza();
				case "READSTANZA" -> readStanza();
				case "UPDATESTANZA" -> updateStanza();
				case "DELETESTANZA" -> deleteStanza();
				//agenzia_immobiliare
				case "HELP" -> help();
				case "QUIT" -> System.out.println("Bye bye, alla prossima, termino");
				default -> System.out.println("Comando non valido");

			}
		} while (!cmd.equals("QUIT"));
	}


	private static void createCasa()  throws Exception
	{
		Casa c = new Casa();
		System.out.println("Dammi indirizzo");
		c.setIndirizzo(keyboard.nextLine());
		System.out.println("Dammi pmq");
		c.setPmq(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Dammi classe_energetica");
		c.setClasseEnergetica(keyboard.nextLine());
		System.out.println("Dammi piano");
		c.setPiano(Integer.parseInt(keyboard.nextLine()));

		cdao.save(c);
	}

	private static void readAllCase()  throws Exception
	{
		for(Casa c: cdao.findAll())
		{
			System.out.println("------------------------------");
			System.out.println(c);
			if(c.getStanze().isEmpty())
				System.out.println("NO STANZE");
			else
			{
				System.out.println("Con stanze");
				for (Stanza stanza : c.getStanze())
					System.out.println(stanza);
			}
		}
	}

	private static void readCasa() throws Exception
	{
		System.out.println("Inserisci id");
		Long id = Long.parseLong(keyboard.nextLine());
		Casa c = cdao.findById(id);
		System.out.println(c==null?"Non esiste":c);
//		if(c==null)
//			System.out.println("Non esiste");
//		else
//			System.out.println(c);
	}


	private static void updateCasa()  throws Exception
	{
		readAllCase();
		System.out.println("Dammi l'id della casa da modificare");
		Long id = Long.parseLong(keyboard.nextLine());
		//verifico che esista
		Casa c = cdao.findById(id);
		if(c==null)
		{
			System.out.println("Non abbiamo case con quell'id");
			return;
		}

		System.out.println("Cambiare indirizzo? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovoIndirizzo = keyboard.nextLine();
		if (!nuovoIndirizzo.isBlank())
			c.setIndirizzo(nuovoIndirizzo);

		System.out.println("Cambiare pmq? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovoPmq = keyboard.nextLine();
		if (!nuovoPmq.isBlank())
			c.setPmq(Integer.parseInt(nuovoPmq));

		System.out.println("Cambiare classe energetica? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovaClasse = keyboard.nextLine();
		if (!nuovaClasse.isBlank())
			c.setClasseEnergetica(nuovaClasse);

		System.out.println("Cambiare piano? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovoPiano = keyboard.nextLine();
		if (!nuovoPiano.isBlank())
			c.setPiano(Integer.parseInt(nuovoPiano));

		cdao.save(c);
		System.out.println("Modifica effettuata");
	}

	private static void deleteCasa()  throws Exception
	{
		System.out.println("Inserisci id");
		Long id = Long.parseLong(keyboard.nextLine());
		cdao.delete(id);
		System.out.println("DISTRUTTA");
	}

	private static void createStanza() throws Exception
	{
		Stanza s = new Stanza();
		System.out.println("Inserisci lato 1");
		s.setLato1(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Inserisci lato 2");
		s.setLato2(Integer.parseInt(keyboard.nextLine()));
		System.out.println("Inserisci tipo");
		s.setTipo(keyboard.nextLine());

		System.out.println("HEI, a che casa la vuoi associare, dammi l'id");
		readAllCase();
		Casa c = cdao.findById(Long.parseLong(keyboard.nextLine()));
		if(c==null)
		{
			System.out.println("BUFFONE!!");
			return;
		}

		c.link(s);
		sdao.save(s);
		System.out.println("STANZA SALVATA");
	}

	private static void readStanza() throws Exception
	{
		System.out.println("Inserisci id");
		Long id = Long.parseLong(keyboard.nextLine());
		Stanza s = sdao.findById(id);
		System.out.println(s==null?"Non esiste":s);
	}

	private static void updateStanza() throws Exception
	{
		readAllCase();
		System.out.println("Dammi l'id della stanza da modificare");
		Long id = Long.parseLong(keyboard.nextLine());
		//verifico che esista
		Stanza s = sdao.findById(id);
		if(s==null)
		{
			System.out.println("Non abbiamo stanze con quell'id");
			return;
		}

		System.out.println("Cambiare lato 1? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovol1 = keyboard.nextLine();
		if (!nuovol1.isBlank())
			s.setLato1(Integer.parseInt(nuovol1));

		System.out.println("Cambiare lato 2? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovol2= keyboard.nextLine();
		if (!nuovol2.isBlank())
			s.setLato2(Integer.parseInt(nuovol2));

		System.out.println("Cambiare tipo? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovoTipo = keyboard.nextLine();
		if (!nuovoTipo.isBlank())
			s.setTipo(nuovoTipo);

		sdao.save(s);
		System.out.println("Modifica effettuata");
	}

	private static void deleteStanza() throws Exception
	{
		//stampo le case, tanto hanno le stanze
		readAllCase();
		System.out.println("Inserisci id della stanza");
		Long id = Long.parseLong(keyboard.nextLine());
		sdao.delete(id);
		System.out.println("DISTRUTTA");
	}

	private static void help()
	{
		System.out.println("TODO");
	}
}
