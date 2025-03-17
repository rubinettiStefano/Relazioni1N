package ereditarieta;

import eccezioni.InputSbagliatoException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Qui li andiamo a catturare TUTTI
 */
public class AshCatchum
{
	public static void main(String[] args)
	{
		try
		{
			vasoDiPandora();
		}
		catch (InputSbagliatoException e)
		{
			e.insultaUtente();
			System.out.println(e.produciMessaggioBello());
		}
		catch (NumberFormatException e)
		{
			System.out.println("BUFFONE,TI INSULTO MANUALMENTE, TI HO DETTO UN NUMERO");
		}
		catch (RuntimeException e)
		{
			System.out.println(e.getMessage());
		}
		catch (SQLException e)
		{
			System.out.println("Problema con db "+e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println("Qualsiasi altra eccezione checked non specificata sopra");
		}


	}

	/**
	 * Questo metodo lancerà un sacco di eccezioni diverse
	 */
	public static void vasoDiPandora()
			throws 	SQLException,IOException,RuntimeException,
					IllegalArgumentException,InputSbagliatoException,NumberFormatException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Dammi un numero da 1 a 4");

		int num = Integer.parseInt(sc.nextLine());

		switch (num)
		{
			case 1->throw new RuntimeException("CASO 1");
			case 2->throw new SQLException("CASO 2");
			case 3->throw new IOException("CASO 3");
			case 4->throw new IllegalArgumentException("CASO 4");
			default -> throw new InputSbagliatoException("numero fuori range","intero");
		}
	}
}
