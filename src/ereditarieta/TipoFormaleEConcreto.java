package ereditarieta;

import eccezioni.Studente;

import java.util.ArrayList;

public class TipoFormaleEConcreto
{
	public static void main(String[] args)
	{
					//tipo concreto Docente
		//Tipo Formale Docente
		Docente d= new Docente();
		d.setMateria("java");
		d.setNome("Stefano");
		d.setCognome("Rubinetti");

		//Qui sto facendo UPCASTING
		//Sto cambiando il TIPO FORMALE
		//Sto vedendo l'oggetto creato alla riga 9
		//non come un docente ma come una persona
//		Persona p1 = d;

//		String msg = p1.getNome() +" "+p1.getCognome();
//		System.out.println(msg);

		//il vantaggio sta nella GENERALIZZAZIONE
		//POTER PRENDERE OGGETTI DI TIPO CONCRETO DIVERSO
		//CON IL TIPO FORMALE IN COMUNE
		Studente s= new Studente();
		s.setMedia(8.25);
		s.setNome("Veronica");
		s.setCognome("Pugliese");
//		stampaUnaPersona(s);
//		Persona p2 = s;
//
//		String msg2 = p2.getNome() +" "+p2.getCognome();
//		System.out.println(msg2);

		//il metodo stampaUnaPersona vuole come parametro un oggetto
		//Persona. VERO IN PARTE
		//vuole un oggetto da poter inserire in una VARIABILE di tipo
		//Persona, quindi un oggetto il cui TIPO FORMALE
		//possa essere Persona, ma il tipo CONCRETO può essere qualsiasi
		//SOTTOTIPO di Persona, sia Studente che Docente
//		stampaUnaPersona(d);

		//LISTA POLIMORFICA, lista che contiene oggetti di tipo
		//concreto diverso, mettendoli a fattor comune con un tipo
		//formale supertipo di entrambi
		ArrayList<Persona> persone = new ArrayList<>();
		persone.add(d);
		persone.add(s);

		for(Persona p : persone)
		{

			String msg = p.getNome() +" "+p.getCognome();
			if(p instanceof Docente)//se il tipo CONCRETO è Docente
			{
				//DOWNCASTING
				Docente doc = (Docente)p;//vedi p come un Docente
				msg+=" è un docente che insegna "+doc.getMateria();
			}

			if(p instanceof Studente)//se il tipo CONCRETO è Studente
			{
				//DOWNCASTING
				Studente st = (Studente)p;//vedi p come uno Studente
				msg+=" è uno studente con media "+st.getMedia();
			}
			System.out.println(msg);
		}
	}

	static void stampaUnaPersona(Persona p)
	{
		String msg = p.getNome() +" "+p.getCognome();
		System.out.println(msg);

	}
}
