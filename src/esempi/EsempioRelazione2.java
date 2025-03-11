package esempi;

import model.Casa;
import model.Stanza;

import java.util.ArrayList;

public class EsempioRelazione2
{
	public static void main(String[] args)
	{
		ArrayList<Casa> listaCase = new ArrayList<>();

		Casa casa1 = new Casa();
		casa1.setId(1);
		casa1.setIndirizzo("Via Roma 1");
		casa1.setPmq(120);
		casa1.setClasseEnergetica("A");
		casa1.setPiano(1);

		Stanza stanza11 = new Stanza();
		stanza11.setId(101);
		stanza11.setLato1(4);
		stanza11.setLato2(5);
		stanza11.setTipo("camera");
		casa1.link(stanza11);

		Stanza stanza12 = new Stanza();
		stanza12.setId(102);
		stanza12.setLato1(3);
		stanza12.setLato2(3);
		stanza12.setTipo("bagno");
		casa1.link(stanza12);

		Stanza stanza13 = new Stanza();
		stanza13.setId(103);
		stanza13.setLato1(4);
		stanza13.setLato2(4);
		stanza13.setTipo("cucina");
		casa1.link(stanza13);

		Stanza stanza14 = new Stanza();
		stanza14.setId(104);
		stanza14.setLato1(5);
		stanza14.setLato2(6);
		stanza14.setTipo("soggiorno");
		casa1.link(stanza14);

		listaCase.add(casa1);

		// Creazione della Casa 2
		Casa casa2 = new Casa();
		casa2.setId(2);
		casa2.setIndirizzo("Via Milano 2");
		casa2.setPmq(140);
		casa2.setClasseEnergetica("B");
		casa2.setPiano(2);

		Stanza stanza21 = new Stanza();
		stanza21.setId(201);
		stanza21.setLato1(4);
		stanza21.setLato2(3);
		stanza21.setTipo("camera");
		casa2.link(stanza21);

		System.out.println("Area21: "+stanza21.calcolaArea());

		Stanza stanza22 = new Stanza();
		stanza22.setId(202);
		stanza22.setLato1(3);
		stanza22.setLato2(3);
		stanza22.setTipo("bagno");
		casa2.link(stanza22);

		Stanza stanza23 = new Stanza();
		stanza23.setId(203);
		stanza23.setLato1(4);
		stanza23.setLato2(4);
		stanza23.setTipo("camera");
		casa2.link(stanza23);

		Stanza stanza24 = new Stanza();
		stanza24.setId(204);
		stanza24.setLato1(5);
		stanza24.setLato2(5);
		stanza24.setTipo("soggiorno");
		casa2.link(stanza24);

		listaCase.add(casa2);

		// Creazione della Casa 3
		Casa casa3 = new Casa();
		casa3.setId(3);
		casa3.setIndirizzo("Via Napoli 3");
		casa3.setPmq(160);
		casa3.setClasseEnergetica("A+");
		casa3.setPiano(3);

		Stanza stanza31 = new Stanza();
		stanza31.setId(301);
		stanza31.setLato1(3);
		stanza31.setLato2(3);
		stanza31.setTipo("camera");
		casa3.link(stanza31);

		Stanza stanza32 = new Stanza();
		stanza32.setId(302);
		stanza32.setLato1(3);
		stanza32.setLato2(4);
		stanza32.setTipo("bagno");
		casa3.link(stanza32);

		Stanza stanza33 = new Stanza();
		stanza33.setId(303);
		stanza33.setLato1(4);
		stanza33.setLato2(4);
		stanza33.setTipo("cucina");
		casa3.link(stanza33);

		Stanza stanza34 = new Stanza();
		stanza34.setId(304);
		stanza34.setLato1(6);
		stanza34.setLato2(5);
		stanza34.setTipo("soggiorno");
		casa3.link(stanza34);

		listaCase.add(casa3);


		for(Casa c:listaCase)
		{
			System.out.println("------------------------------------------------");
			System.out.println("Indirizzo:"+c.getIndirizzo());




			System.out.println("Area:"+c.calcArea());

			System.out.println("Bagni:"+c.numeroBagni());
			System.out.println("Numero stanze:"+c.getStanze().size());

			System.out.println("Tipi stanze");
			for(Stanza s: c.getStanze())
				System.out.println(s.getTipo());
		}
	}
}
