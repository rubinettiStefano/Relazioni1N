package model.dao;

import model.entities.Casa;
import model.entities.Stanza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CasaDAO
{
	//metodo DI CLASSE, static, un convertitore da RIGA a OGGETTO
	public static Casa convertiRigaInCasa(ResultSet riga) throws Exception
	{
		Casa res = new Casa();
		res.setId(riga.getLong("id"));
		res.setIndirizzo(riga.getString("indirizzo"));
		res.setPmq(riga.getInt("pmq"));
		res.setClasseEnergetica(riga.getString("classe_energetica"));
		res.setPiano(riga.getInt("piano"));
		return res;
	}

	private Connection con;

	public CasaDAO(Connection con)
	{
		this.con = con;
	}
	//lettura per id
	public Casa findById(Long id) throws Exception
	{
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM casa WHERE id="+id);

		if(rs.next())
		{
			Casa c = convertiRigaInCasa(rs);
			collegaStanze(c);//vengono collegate tutte le stanze figlie
			return c;
		}


		return null;
	}

	//lettura totale
	public ArrayList<Casa> findAll() throws Exception
	{
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM Casa");

		ArrayList<Casa> result = new ArrayList<>();

		while (rs.next())
		{
			Casa c = convertiRigaInCasa(rs);
			collegaStanze(c);
			result.add(c);
		}

		return result;
	}

	//creazione
	//modifica
	//UPSERT -> Passiamo un oggetto, se ha l'id significa che vogliamo
	//fare un UPDATE, se non lo ha è NUOVO, quindi vogliamo fare una INSERT
	public void save(Casa s) throws Exception
	{
		Statement st = con.createStatement();

		if(s.getId()==null)
		{
			//in INSERT, vogliamo creare nuova riga
			String query="INSERT INTO Casa(indirizzo,pmq,classe_energetica,piano) VALUES " +
					"('[indirizzo]','[pmq]','[classe_energetica]','[piano]')";

			query=	query.replace("[indirizzo]",s.getIndirizzo()+"")
					.replace("[pmq]",s.getPmq()+"")
					.replace("[classe_energetica]",s.getClasseEnergetica())
					.replace("[piano]",s.getPiano()+"");
			st.execute(query);

		}
		else
		{
			//siamo in UPDATE, vogliamo modificare riga già esistente
			String query="UPDATE Casa	SET indirizzo='[indirizzo]',pmq='[pmq]',classe_energetica='[classe_energetica]',piano='[piano]'" +
					" WHERE id='[id]'";

			query=  query.replace("[id]",s.getId()+"")
					.replace("[indirizzo]",s.getIndirizzo()+"")
					.replace("[pmq]",s.getPmq()+"")
					.replace("[classe_energetica]",s.getClasseEnergetica())
					.replace("[piano]",s.getPiano()+"");
			st.execute(query);
		}
	}

	//cancellazione
	public void delete(Long id) throws Exception
	{
		//POLITICA NIENTE ORFANI
		//CASCADE DELETE
		Statement s1 = con.createStatement();
		s1.execute("DELETE FROM stanza WHERE id_casa="+id);

		Statement s2 = con.createStatement();
		s2.execute("DELETE FROM casa WHERE id="+id);

	}

	private void collegaStanze(Casa c) throws Exception
	{
		Statement st = con.createStatement();
		//leggo le stanze FIGLIE
		ResultSet rs = st.executeQuery("SELECT * FROM stanza WHERE id_casa="+c.getId());
		while(rs.next())
		{
			Stanza trasformata = StanzaDAO.convertiRigaInStanza(rs);
			c.link(trasformata);
		}
	}
}
