package eccezioni;

import ereditarieta.Persona;

public class Studente extends Persona
{

	private double media;

	public Studente()
	{
	}

	public Studente(String nome, String cognome, double media)
	{
		super(nome, cognome);
		this.media = media;
	}

	public double getMedia()
	{
		return media;
	}

	public void setMedia(double media)
	{
		this.media = media;
	}

	public String miPresento()
	{
		return "Ciao sono uno Studente di nome "+nome+ " e cognome "+cognome+" e ho media "+media;
	}
}
