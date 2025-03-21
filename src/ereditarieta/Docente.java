package ereditarieta;

/**
	sono una SPECIALIZZAZIONE di Persona
 	Possiedo (quasi) tutto ciò che una Persona HA
 	SONO A TUTTI GLI EFFETTI UNA PERSONA, MA PLUS
 	AGGIUNGO la materia spiegata e un metodo per fare spiegazione
 */
public class Docente extends Persona
{

	private String materia;

	public Docente(){}

	public Docente(String nome,String cognome,String materia)
	{
		super(nome,cognome);// new Persona(nome,cognome);
		this.materia=materia;
	}

	/**
	 * Sono il JavaDoc di spiega
	 * io uso proprietà sia proprie di Docente che EREDITATE da Persona
	 */
	public String spiega()
	{
		return "Sono "+nome+" "+getCognome()+" e oggi faremo "+materia+" blablablabla";
	}

	public String getMateria()
	{
		return materia;
	}

	public void setMateria(String materia)
	{
		this.materia = materia;
	}

	//STO SOVRASCRIVENDO IL METODO miPresento ottenuto da Persona
	//facendolo vado a cambiare la versione del metodo utilizzata OVUNQUE quando andiamo
	//a richiamarlo su un oggetto di Tipo Concreto DOCENTE, indipendentemente dal suo tipo formale
	@Override
	public String toString()
	{
		//con super.metodo() posso richiamare la versione del metodo
		//scritta all'interno del supertipo, all'interno di Persona
		return super.toString()+" e insegno "+materia;
	}

}
