package ereditarieta;

public class EsempioEreditarieta
{

	public static void main(String[] args)
	{
		Docente d = new Docente("Stefano","Rubinetti","java");
		VecchiettaSupermercato vs = new VecchiettaSupermercato("Malenia","Concetta",15);

		//posso richiamare metodi definiti nelle classi specifiche
//		System.out.println(d.spiega());
//		System.out.println(vs.perdiTempo());

		//ma anche metodi di Persona
		System.out.println("Sono un docente di nome "+d.getNome());
		System.out.println("Sono una vecchietta di nome "+vs.getNome());
	}
}
