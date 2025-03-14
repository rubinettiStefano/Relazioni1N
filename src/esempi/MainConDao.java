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

	private static void init()
	{
		System.out.println("Dammi nome db maledetto");
		con = ConnectionFactory.createConnection(keyboard.nextLine());

		cdao = new CasaDAO(con);
		sdao = new StanzaDAO(con);
	}


	public static void main(String[] args)
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


	private static void createCasa()
	{
		try
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
		} catch (Exception e)
		{
			System.out.println("I tuoi dati non vanno bene, termino inserimento");
		}

	}

	private static void readAllCase()
	{
		for (Casa c : cdao.findAll())
		{
			System.out.println("------------------------------");
			System.out.println(c);
			if (c.getStanze().isEmpty())
				System.out.println("NO STANZE");
			else
			{
				System.out.println("Con stanze");
				for (Stanza stanza : c.getStanze())
					System.out.println(stanza);
			}
		}
	}

	private static void readCasa()
	{
		System.out.println("Inserisci id");
		Long id = Long.parseLong(keyboard.nextLine());
		Casa c = cdao.findById(id);
		System.out.println(c == null ? "Non esiste" : c);
	}


	private static void updateCasa()
	{

		readAllCase();
		Long id;
		while (true)
		{
			try
			{
				System.out.println("Dammi l'id della casa da modificare");
				id = Long.parseLong(keyboard.nextLine().trim());
				break;
			} catch (Exception e)
			{
				System.out.println("BUFFONE NUMERO METTI DAI");
			}
		}
		//verifico che esista
		Casa c = cdao.findById(id);
		if (c == null)
		{
			System.out.println("Non abbiamo case con quell'id");
			return;
		}

		System.out.println("Cambiare indirizzo? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovoIndirizzo = keyboard.nextLine();
		if (!nuovoIndirizzo.isBlank())
			c.setIndirizzo(nuovoIndirizzo);

		System.out.println("Cambiare pmq? scrivilo, oppure premi subito invio per lasciarlo uguale");
		while (true)
		{
			try
			{
				String nuovoPmq = keyboard.nextLine();
				if (!nuovoPmq.isBlank())
					c.setPmq(Integer.parseInt(nuovoPmq));
				break;
			} catch (Exception e)
			{
				System.out.println("BUFFONE NUMERO METTI DAI");
			}
		}


		System.out.println("Cambiare classe energetica? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovaClasse = keyboard.nextLine();
		if (!nuovaClasse.isBlank())
			c.setClasseEnergetica(nuovaClasse);

		System.out.println("Cambiare piano? scrivilo, oppure premi subito invio per lasciarlo uguale");
		while (true)
		{
			try
			{
				//qui chiedo solo il piano fino a quando non mette un numero
				String nuovoPiano = keyboard.nextLine();
				if (!nuovoPiano.isBlank())
					c.setPiano(Integer.parseInt(nuovoPiano));
				break;
			} catch (Exception e)
			{
				System.out.println("BUFFONE NUMERO METTI DAI");
			}
		}

		try
		{
			cdao.save(c);
			System.out.println("Modifica effettuata");
		} catch (Exception e)
		{
			System.out.println("DATI ERRATI, NON EFFETTUO NULLA");
		}

	}

	private static void deleteCasa()
	{
		readAllCase();
		while (true)
		{
			try
			{
				System.out.println("Inserisci id");
				Long id = Long.parseLong(keyboard.nextLine());
				cdao.delete(id);
				System.out.println("DISTRUTTA");
				break;
			} catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	private static void createStanza()
	{
		try
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
			if (c == null)
			{
				System.out.println("BUFFONE!!");
				return;
			}

			c.link(s);
			sdao.save(s);
			System.out.println("STANZA SALVATA");

		} catch (Exception e)
		{
			System.out.println("I tuoi dati non vanno bene, termino inserimento");
		}

	}

	private static void readStanza()
	{
		System.out.println("Inserisci id");
		Long id = Long.parseLong(keyboard.nextLine());
		Stanza s = sdao.findById(id);
		System.out.println(s == null ? "Non esiste" : s);
	}

	private static void updateStanza()
	{
		readAllCase();
		Long id;
		while (true)
		{
			try
			{
				System.out.println("Dammi l'id della casa da modificare");
				id = Long.parseLong(keyboard.nextLine().trim());
				break;
			} catch (Exception e)
			{
				System.out.println("BUFFONE NUMERO METTI DAI");
			}
		}
		//verifico che esista
		Stanza s = sdao.findById(id);
		if (s == null)
		{
			System.out.println("Non abbiamo stanze con quell'id");
			return;
		}

		System.out.println("Cambiare lato 1? scrivilo, oppure premi subito invio per lasciarlo uguale");
		while (true)
		{
			try
			{
				String nuovol1 = keyboard.nextLine();
				if (!nuovol1.isBlank())
					s.setLato1(Integer.parseInt(nuovol1));
				break;
			} catch (Exception e)
			{
				System.out.println("BUFFONE NUMERO METTI DAI");
			}
		}


		System.out.println("Cambiare lato 2? scrivilo, oppure premi subito invio per lasciarlo uguale");
		while (true)
		{
			try
			{
				String nuovol2 = keyboard.nextLine();
				if (!nuovol2.isBlank())
					s.setLato2(Integer.parseInt(nuovol2));
				break;
			} catch (Exception e)
			{
				System.out.println("BUFFONE NUMERO METTI DAI");
			}
		}

		System.out.println("Cambiare tipo? scrivilo, oppure premi subito invio per lasciarlo uguale");
		String nuovoTipo = keyboard.nextLine();
		if (!nuovoTipo.isBlank())
			s.setTipo(nuovoTipo);

		try
		{
			sdao.save(s);
			System.out.println("Modifica effettuata");
		} catch (Exception e)
		{
			System.out.println("DATI ERRATI, NON EFFETTUO NULLA");
		}
	}

	private static void deleteStanza()
	{
		//stampo le case, tanto hanno le stanze
		readAllCase();
		while (true)
		{
			try
			{
				System.out.println("Inserisci id della stanza");
				Long id = Long.parseLong(keyboard.nextLine());
				sdao.delete(id);
				break;
			} catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}


		System.out.println("DISTRUTTA");
	}

	private static void help()
	{
		System.out.println("TODO");
	}
}
