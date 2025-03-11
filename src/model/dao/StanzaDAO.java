package model.dao;

import model.entities.Stanza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StanzaDAO
{

	//metodo DI CLASSE, static, un convertitore da RIGA a OGGETTO
	public static Stanza convertiRigaInStanza(ResultSet riga) throws Exception
	{
		Stanza res = new Stanza();
		res.setId(riga.getInt("id"));
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
	public Stanza findById(int id) throws Exception
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

	//cancellazione
}
