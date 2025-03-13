package model.dao;

import model.entities.Stanza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//LAZY FETCH DEL PADRE, NON LEGGO LE CASE QUANDO LEGGO LE STANZE E BASTA
public class StanzaDAO
{

	//metodo DI CLASSE, static, un convertitore da RIGA a OGGETTO
	public static Stanza convertiRigaInStanza(ResultSet riga) throws Exception
	{
		Stanza res = new Stanza();
		res.setId(riga.getLong("id"));
		res.setTipo(riga.getString("tipo"));
		res.setLato1(riga.getInt("lato1"));
		res.setLato2(riga.getInt("lato2"));
		return res;
	}

	private Connection con;

	public StanzaDAO(Connection con)
	{
		this.con = con;
	}
	//lettura per id
	public Stanza findById(Long id) throws Exception
	{
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM stanza WHERE id="+id);

		if(rs.next())
			return convertiRigaInStanza(rs);

		return null;
	}

	//lettura totale
	public ArrayList<Stanza> findAll() throws Exception
	{
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM stanza");

		ArrayList<Stanza> result = new ArrayList<>();

		while (rs.next())
			result.add(convertiRigaInStanza(rs));

		return result;
	}

	//creazione
	//modifica
	//UPSERT -> Passiamo un oggetto, se ha l'id significa che vogliamo
	//fare un UPDATE, se non lo ha è NUOVO, quindi vogliamo fare una INSERT
	public void save(Stanza s) throws Exception
	{
		Statement st = con.createStatement();

		if(s.getId()==null)
		{
			//in INSERT, vogliamo creare nuova riga
			String query="INSERT INTO stanza(lato1,lato2,tipo,id_casa) VALUES " +
					"('[lato1]' ,'[lato2]','[tipo]','[id_casa]')";

			query=  query.replace("[lato1]",s.getLato1()+"")
					.replace("[lato2]",s.getLato2()+"")
					.replace("[tipo]",s.getTipo())
					.replace("[id_casa]",s.getCasa().getId()+"");
			st.execute(query);

		}
		else
		{
			//siamo in UPDATE, vogliamo modificare riga già esistente
			String query="UPDATE stanza	SET lato1='[lato1]',lato2='[lato2]',tipo='[tipo]'" +
					" WHERE id='[id]'";

			query=  query.replace("[id]",s.getId()+"")
					.replace("[lato1]",s.getLato1()+"")
					.replace("[lato2]",s.getLato2()+"")
					.replace("[tipo]",s.getTipo());
			st.execute(query);
		}
	}

	//cancellazione
	public void delete(Long id) throws Exception
	{
		Statement s = con.createStatement();
		s.execute("DELETE FROM stanza WHERE id="+id);
	}
}
