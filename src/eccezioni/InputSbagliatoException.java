package eccezioni;

public class InputSbagliatoException extends RuntimeException
{
	private String tipologiaInput;

	public InputSbagliatoException(String messaggio)
	{
		super(messaggio);
		//qui sto RICHIAMANDO il COSTRUTTORE DEL MIO SUPERTIPO
		//SUPERTIPO/SUPERCLASSE -> CLASSE DI CUI FACCIAMO extends
	}

	public InputSbagliatoException(String messaggio,String tipologiaInput)
	{
		super(messaggio);
		this.tipologiaInput = tipologiaInput;
	}

	public void insultaUtente()
	{
		System.out.println("BUFFONE,INSERISCI DATI BENE");
	}


	public String produciMessaggioBello()
	{
		return "Errore derivato da "+tipologiaInput+"| messaggio: "+getMessage();
	}
}


