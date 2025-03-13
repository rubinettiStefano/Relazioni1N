package esempi;

import model.dao.CasaDAO;
import model.entities.Casa;
import utility.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;

public class EsempioRead
{
	static Connection con = ConnectionFactory.createConnection("agenzia_immobiliare");
	static  CasaDAO dao = new CasaDAO(con);

	public static void main(String[] args) throws Exception
	{
		read();
	}


	public static void read() throws Exception
	{
		ArrayList<Casa> casette = dao.findAll();
		for (Casa c:casette)
			System.out.println(c);
	}

	public static void creaCasa() throws Exception
	{
		Casa c  = new Casa();
		//la riempio
		c.setIndirizzo("aaa");
		dao.save( c);
	}
}
