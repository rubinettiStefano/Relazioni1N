package eccezioni;

import ereditarieta.Persona;

import java.util.Scanner;


public class Dimostrazione
{
	public static void main(String[] args)
	{
		try
		{
			chiediInputEDaiEccezione();
		}
		catch (InputSbagliatoException e)
		{
			e.insultaUtente();
			System.out.println(e.produciMessaggioBello());
		}
		catch (RuntimeException e)
		{
			System.out.println(e.getMessage());
		}

	}

	static void chiediInputEDaiEccezione() throws InputSbagliatoException,RuntimeException
	{

		Scanner sc = new Scanner(System.in);

		System.out.println("SE metti pippo do runtime,con paperino InputSbagliato");
		String in = sc.nextLine();

		if(in.equalsIgnoreCase("pippo"))
			throw new RuntimeException("HAI MESSO PIPPO");

		if(in.equalsIgnoreCase("paperino"))
			throw new InputSbagliatoException("HAI MESSO PAPERINO","INPUT STRINGA");
	}
}
