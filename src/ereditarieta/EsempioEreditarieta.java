package ereditarieta;

import java.util.ArrayList;

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
//		System.out.println("Sono un docente di nome "+d.getNome());
//		System.out.println("Sono una vecchietta di nome "+vs.getNome());

		//ho creato una variabile di tipo Persona
		//collegata all'oggetto Docente in memoria
		//IN MEMORIA HO UN DOCENTE, ma java lo vede come una Persona
		Persona p1 = d;
		Persona p2 =  vs;

		//NON POSSO FARLO, vedendolo come una persona perdo la possibilità
		//di usare metodi e proprietà dichiarati nelle specializzazioni
		//System.out.println(p1.spiega());

		//POSSO PERÒ METTERLI A FATTOR COMUNE, CREANDO UNA LISTA DOVE POSSO METTERE SIA OGGETTI
		//Docente che oggetti VecchiettaSupermercato, vedendoli entrambi come Persona grazie a Liskov
		ArrayList<Persona> docentiEVecchietteEPersoneInGenerale = new ArrayList<>();

		docentiEVecchietteEPersoneInGenerale.add(p1);
		docentiEVecchietteEPersoneInGenerale.add(p2);

		for(Persona p:docentiEVecchietteEPersoneInGenerale)
			System.out.println(p.getNome()+" "+p.getCognome());
	}
}
