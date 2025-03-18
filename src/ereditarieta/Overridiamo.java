package ereditarieta;

import eccezioni.Studente;

import java.util.ArrayList;

public class Overridiamo
{
	public static void main(String[] args)
	{
		Docente d= new Docente();
		d.setMateria("java");
		d.setNome("Stefano");
		d.setCognome("Rubinetti");
//		System.out.println(d.toString());

//		Object o = d;
//		System.out.println(o.toString());
		Persona pers = new Persona();
		pers.setNome("Francesco");
		pers.setCognome("Pippo");

//		Object o2 = pers;
//
//		System.out.println(o2.toString());

//		Studente s = new Studente();
//		s.setMedia(9.75);
//		s.setNome("Vincenzo");
//		s.setCognome("Mascolo");
//
//		Persona pers = new Persona();
//		pers.setNome("Francesco");
//		pers.setCognome("Pippo");

//		System.out.println(d.miPresento());
//		System.out.println(s.miPresento());
//		System.out.println(pers.miPresento());

		ArrayList<Persona> tutti = new ArrayList<>();
		tutti.add(d);
//		tutti.add(s);
		tutti.add(pers);
//
		for(Persona p:tutti)
			System.out.println(p);

	}


}
