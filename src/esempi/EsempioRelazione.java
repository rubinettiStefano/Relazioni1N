package esempi;

import model.entities.Casa;
import model.entities.Stanza;

public class EsempioRelazione
{

	public static void main(String[] args)
	{
		Casa c = new Casa();
		c.setId(1L);
		c.setIndirizzo("VIA viaroma 10, Roma");
		c.setClasseEnergetica("AA--");
		c.setPiano(3);
		c.setPmq(1000);

		Stanza s1 = new Stanza();
		s1.setId(1L);
		s1.setTipo("camera");
		s1.setLato1(3);
		s1.setLato2(4);

		Stanza s2 = new Stanza();
		s2.setId(2L);
		s2.setTipo("cucina");
		s2.setLato1(5);
		s2.setLato2(5);

		c.link(s1);
		c.link(s2);


		System.out.println("s1 a che indirizzo si trova casa tua?");
		System.out.println(s1.getCasa().getIndirizzo());

		System.out.println("Casa quante stanze hai?");
		System.out.println(c.getStanze().size());

		System.out.println("Casa mi stampi i tipi di tutte le tue stanze");

		for(Stanza s:c.getStanze())
			System.out.println(s.getTipo());


		System.out.println("Quale è la tua area?");
		System.out.println(c.numeroBagni());
	}
}
