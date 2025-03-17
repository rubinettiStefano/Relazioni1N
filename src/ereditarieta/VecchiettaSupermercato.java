package ereditarieta;

/**
 * Sono una Vecchietta in coda al supermercato.
 * Potreste non essere d'accordo ma sono una Persona anche io
 * La mia capacità speciale è quella di perdere un sacco di tempo nel parlare con la commessa
 * rallentando Stefano che vuole pagare e tornare a casa
 */
public class VecchiettaSupermercato extends Persona
{
	private int minutiSpesiAParlare;

	public VecchiettaSupermercato(String nome, String cognome, int minutiSpesiAParlare)
	{
		super(nome, cognome);
		this.minutiSpesiAParlare = minutiSpesiAParlare;
	}

	public String perdiTempo()
	{
		return "Ciao sono "+getNome()+" "+getCognome()+" e sono "+minutiSpesiAParlare+" che occupo la cassa parlando di come stanno i nipoti";
	}

	public int getMinutiSpesiAParlare()
	{
		return minutiSpesiAParlare;
	}

	public void setMinutiSpesiAParlare(int minutiSpesiAParlare)
	{
		this.minutiSpesiAParlare = minutiSpesiAParlare;
	}
}
