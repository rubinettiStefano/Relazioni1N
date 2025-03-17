package ereditarieta;

/**
 * Sono il supertipo, la versione non specializzata
 * Definisco 2 proprietà, nome e cognome, il costruttore e i getters/setters
 * <br/>
 * <img height=100 width=100 src='https://p.turbosquid.com/ts-thumb/bH/FdWIDC/rm91SUUe/minecraftsteve3dmodel02/jpg/1458104524/600x600/fit_q87/b9f2946651caad9448b8d8552112a62c495574ef/minecraftsteve3dmodel02.jpg'>
 */
public class Persona
{
	private String nome,cognome;

	public Persona(){}

	public Persona(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
}
