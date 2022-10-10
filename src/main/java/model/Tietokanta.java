package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Tietokanta {


	public static void main(String[] args) throws Exception {

		// getConnection(); 

		 //post_asiakas_tiedot(new Asiakastiedot("qwe", "wqerw", "123", "werwer","234"));
		//get_asiakas_tiedot();

		// post_kirjan_tiedot();
		 //get_kirjan_tiedot();
		
		//palautus("4","29");
		
		// post_kirjasto();
		// get_kirjasto(2);

		//post_kirja(new Kirja("matkalla","1.7",547559259,2));
		//   get_kirja(1);
		//Kirjatiedot kor = get_Kirjatiedot(5345345);
		//System.out.println(kor.getNimi());
//		ArrayList<Kirja> kirjat = get_kirjat();
//		System.out.println(kirjat.get(0).getkTiedot().getNimi() + " " + kirjat.get(0).getKirja_ISBN());
//		System.out.println(kirjat.get(1).getkTiedot().getNimi() + " " + kirjat.get(1).getKirja_ISBN());

		// post_asiakas();
		// get_asiakas(5);
		 
		//post_admin();
		// get_admin(4);

	}

	
	public static Connection getConnection() throws Exception {
		try {
			
			String url = "jdbc:mariadb://mysql.metropolia.fi/rikukosk";
			String username = "rikukosk";
			String password = "Mustekala1337";
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			System.out.println("Connected!!");
			return connection;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	public static void post_asiakas_tiedot(Asiakastiedot asiakastiedot) throws Exception {

		try {
			Connection connection = getConnection();
			PreparedStatement posted = connection.prepareStatement(
					"insert into asiakas_tiedot " + " (kaupunki, s_posti, posti_numero, osoite, puh_numero)"
							+ " values ('" + asiakastiedot.getKaupunki() + "', '" + asiakastiedot.getS_posti() + "', '"
							+ asiakastiedot.getPosti_numero() + "', '" + asiakastiedot.getOsoite() + "', '"
							+ asiakastiedot.getPuh_numero() + "')");

			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}

	}

	
	public static void post_kirjan_tiedot(Kirjatiedot kirjatiedot) throws Exception {

		try {
			Connection connection = getConnection();
			System.out.println(kirjatiedot.getKirja_ISBN() + kirjatiedot.getNimi() + kirjatiedot.getKunstantaja());
			PreparedStatement posted = connection.prepareStatement("insert into kirjan_tiedot "
					+ " (kirja_ISBN, nimi, kustantaja, kirjoittajat, kuva, julkaisuvuosi, sivumäärä)" + " values ('"
					+ kirjatiedot.getKirja_ISBN() + "', '" + kirjatiedot.getNimi() + "', '"
					+ kirjatiedot.getKunstantaja() + "', '" + kirjatiedot.getKirjoittajat() + "', '"
					+ kirjatiedot.getKuva() + "', '" + kirjatiedot.getJulkasuvuosi() + "', '"
					+ kirjatiedot.getSivumäärä() + "')");

			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}
	}

	
	public static void post_kirjasto(Kirjasto kirjasto) throws Exception {

		try {
			Connection connection = getConnection();
			PreparedStatement posted = connection.prepareStatement("insert into kirjasto "
					+ " (kirjasto_id, kirjasto_nimi, kirjasto_osoite, puh_numero, posti_numero, kaupunki)"
					+ " values ('" + kirjasto.getKirjasto_id() + "', '" + kirjasto.getKirjasto_nimi() + "', '" + kirjasto.getOsoite() + "', '"
					+ kirjasto.getPuh_numero() + "', '" + kirjasto.getPosti_numero() + "', '" + kirjasto.getKaupunki() + "')"); 
			
			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}
	}

	public static Kirjasto get_kirjasto(int kirjastoid) throws Exception { // Yksi kirjasto haku
		try {
			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("SELECT * FROM kirjasto WHERE kirjasto_id = "+kirjastoid+"");														
			ResultSet resultSet = getData.executeQuery();

				resultSet.next();
				System.out.print("kirjasto_id: " + resultSet.getInt("kirjasto_id") + ", ");
				System.out.print("kirjasto_nimi: " + resultSet.getString("kirjasto_nimi") + ", ");
				System.out.print("kirjasto_osoite: " + resultSet.getString("kirjasto_osoite") + ", ");
				System.out.print("puh_numero: " + resultSet.getInt("puh_numero") + ", ");
				System.out.print("posti_numero: " + resultSet.getInt("posti_numero") + ", ");
				System.out.print("kaupunki: " + resultSet.getString("kaupunki") + "\n");

			System.out.println("All have been selected!");

			return new Kirjasto(resultSet.getInt("kirjasto_id"), 
					resultSet.getString("kirjasto_nimi"), 
					resultSet.getString("kirjasto_osoite"), 
					resultSet.getInt("puh_numero"), 
					resultSet.getInt("posti_numero"),
					resultSet.getString("kaupunki"));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	public static void post_kirja(Kirja kirja) throws Exception {

		try {
			Connection connection = getConnection();
			System.out.println(kirja.getKirja_ISBN() + "===Tämä");
			PreparedStatement posted = connection.prepareStatement("insert into kirja "
					+ " (tila, luokka, kirja_ISBN, kirjasto_id)" + " values ('" + kirja.getTila()
					+ "', '" + kirja.getLuokka() + "', '" + kirja.getKirja_ISBN() + "', '" + kirja.getKirjasto_id() + "')"); 
			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}

	}
	
	/**
	 * Tässä tekstiä
	 * @return Kirja listan
	 * @throws Exception
	 */
	public static ArrayList<Kirja> get_kirjat() throws Exception {
		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM kirja INNER JOIN kirjan_tiedot ON kirja.kirja_ISBN=kirjan_tiedot.kirja_ISBN";
		PreparedStatement getData = connection.prepareStatement(query);
			ResultSet resultSet = getData.executeQuery();
			ArrayList<Kirja> arrayList = new ArrayList<Kirja>();

			while (resultSet.next()) {
				
				System.out.println("--Kirja--- kirja_id: " + resultSet.getInt("kirja_id"));
				System.out.println("---Kirjan_tiedot--- nimi: " + resultSet.getString("nimi") + "\n");
				
				arrayList.add(new Kirja(resultSet.getInt("kirja_id"),
						resultSet.getString("tila"),
						resultSet.getString("luokka"),
					resultSet.getLong("kirja_ISBN"),
					resultSet.getInt("kirjasto_id"),
						new Kirjatiedot(resultSet.getLong("kirja_ISBN"),
							resultSet.getString("nimi")
							,resultSet.getString("kustantaja"),
								resultSet.getString("kirjoittajat")
							,resultSet.getString("kuva"),
							resultSet.getInt("julkaisuvuosi"),
							resultSet.getInt("sivumäärä"))));
			}
			System.out.println("All have been selected!");
			return arrayList;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static Kirja get_kirja(int kirja_id) throws Exception {
		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM kirja INNER JOIN kirjan_tiedot ON kirja.kirja_ISBN=kirjan_tiedot.kirja_ISBN WHERE kirja_id = "+kirja_id+"";
			PreparedStatement getData = connection.prepareStatement(query);
			ResultSet resultSet = getData.executeQuery();
				
				resultSet.next();
				System.out.println("\n" + "kirja_id: " + resultSet.getInt("kirja_id"));
				System.out.println("tila: " + resultSet.getString("tila"));
				System.out.println("luokka: " + resultSet.getString("luokka"));
				System.out.println("kirja_ISBN: " + resultSet.getString("kirja_ISBN"));
				System.out.println("kirjasto_id: " + resultSet.getInt("kirjasto_id"));
				System.out.println("lainaaja: " + resultSet.getInt("lainaaja") + "\n");

			System.out.println("All have been selected!");
			
			return new Kirja(resultSet.getInt("kirja_id"),
					resultSet.getString("tila"),
					resultSet.getString("luokka"),
					resultSet.getLong("kirja_ISBN"),
					resultSet.getInt("kirjasto_id"),
					new Kirjatiedot(resultSet.getLong("kirja_ISBN"),
							resultSet.getString("nimi")
							,resultSet.getString("kustantaja"),
							resultSet.getString("kirjoittajat")
							,resultSet.getString("kuva"),
							resultSet.getInt("julkaisuvuosi"),
							resultSet.getInt("sivumäärä")));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void post_asiakas(Asiakas asiakas) throws Exception {

		try {
			Connection connection = getConnection();
			PreparedStatement posted = connection.prepareStatement(
					"insert into asiakas " + " (etunimi, sukunimi, puhelinnum)" + " values ('" + asiakas.getEtunimi()
							+ "', '" + asiakas.getSukunimi() + "', '" + asiakas.getPuhelinnum() + "')"); 
			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}

	}

	public static Asiakas get_asiakas(int as_id) throws Exception { //yksi asiakas + parametri
		
		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM asiakas INNER JOIN asiakas_tiedot ON asiakas.puhelinnum=asiakas_tiedot.puh_numero WHERE as_id = "+as_id+" ";
			//String query = "SELECT * FROM (asiakas WHERE as_id = "+as_id+") CROSS JOIN  ( asiakas INNER JOIN asiakas_tiedot ON asiakas.puhelinnum=asiakas_tiedot.puh_numero)";
			//String query1 = "SELECT * FROM asiakas WHERE as_id = "+as_id+"";
			PreparedStatement getData = connection.prepareStatement(query);															
			ResultSet resultSet = getData.executeQuery();
			
				resultSet.next();				
				System.out.print("as_id: " + resultSet.getInt("as_id") + ", ");
				System.out.print("etunimi: " + resultSet.getString("etunimi") + ", ");
				System.out.print("sukunimi: " + resultSet.getString("sukunimi") + ", ");
				System.out.print("puhelinnum: " + resultSet.getString("puhelinnum") + "\n");

			System.out.println("All have been selected!");

			return new Asiakas(resultSet.getInt("as_id"),
					resultSet.getString("etunimi"), 
					resultSet.getString("sukunimi"), 
					new Asiakastiedot(resultSet.getString("kaupunki"),
							resultSet.getString("s_posti"), 
							resultSet.getString("posti_numero"), 
							resultSet.getString("osoite"),
							resultSet.getString("puh_numero")));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	public static void post_admin(Admin admin) throws Exception {

		try {
			Connection connection = getConnection();
			PreparedStatement posted = connection.prepareStatement("insert into admin "
					+ " (Käyttäjätunnus, salasana, kirjasto_id)" + " values ('" + admin.getKäyttäjätunnu() + "', '"
					+ admin.getSalasana() + "', '" + admin.getKirjasto_id() + "')"); 
			
			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}

	}

	public static Admin get_admin(int kirjasto_id) throws Exception { /// yksi admin
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("SELECT * FROM admin WHERE kirjasto_id = "+kirjasto_id+"");																
			ResultSet resultSet = getData.executeQuery();
				
				resultSet.next();
				System.out.print("Käyttäjätunnus: " + resultSet.getString("Käyttäjätunnus") + ", ");
				System.out.print("salasana: " + resultSet.getString("salasana") + ", ");
				System.out.print("kirjasto_id: " + resultSet.getInt("kirjasto_id") + "\n");

			System.out.println("All have been selected!");
			return new Admin( resultSet.getString("Käyttäjätunnus"),resultSet.getString("salasana"),resultSet.getInt("kirjasto_id"));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static Kirjatiedot get_Kirjatiedot(long isbn) throws Exception { /// yksi admin
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("SELECT * FROM kirjan_tiedot WHERE kirja_ISBN = " + isbn + "");																
			ResultSet resultSet = getData.executeQuery();
				
				resultSet.next();

			System.out.println("All have been selected!");
			return new Kirjatiedot(resultSet.getLong("kirja_ISBN"),resultSet.getString("nimi"),resultSet.getString("kustantaja")
					,resultSet.getString("kirjoittajat"),resultSet.getString("kuva"),resultSet.getInt("julkaisuvuosi"),resultSet.getInt("sivumäärä"));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static Kirja lainaus(String asiakas_id,String kirja_id) throws Exception { /// yksi admin
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("UPDATE `rikukosk`.`kirja` SET `lainaaja`='"
			+ asiakas_id + "' WHERE  `kirja_id`=" + kirja_id + ";");																
			getData.executeUpdate();
			//getData = connection.prepareStatement("SELECT * FROM kirja WHERE kirja_id = " + kirja_id + "");
			getData = connection.prepareStatement("SELECT * FROM kirja INNER JOIN"
					+ " kirjan_tiedot ON kirja.kirja_ISBN=kirjan_tiedot.kirja_ISBN WHERE kirja_id = "+kirja_id+"");
			ResultSet resultSet = getData.executeQuery();
			
			resultSet.next();
			System.out.println("\n" + "kirja_id: " + resultSet.getInt("kirja_id"));
			System.out.println("tila: " + resultSet.getString("tila"));
			System.out.println("luokka: " + resultSet.getString("luokka"));
			System.out.println("kirja_ISBN: " + resultSet.getString("kirja_ISBN"));
			System.out.println("kirjasto_id: " + resultSet.getInt("kirjasto_id"));
			System.out.println("lainaaja: " + resultSet.getInt("lainaaja") + "\n");
			
			return new Kirja(resultSet.getInt("kirja_id"),
					resultSet.getString("tila"),
					resultSet.getString("luokka"),
					resultSet.getLong("kirja_ISBN"),
					resultSet.getInt("kirjasto_id"),
					new Kirjatiedot(resultSet.getLong("kirja_ISBN"),
							resultSet.getString("nimi")
							,resultSet.getString("kustantaja"),
							resultSet.getString("kirjoittajat")
							,resultSet.getString("kuva"),
							resultSet.getInt("julkaisuvuosi"),
							resultSet.getInt("sivumäärä")));
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		


	}
	
	public static Kirja palautus(String kirja_id) throws Exception { /// yksi admin
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("UPDATE `rikukosk`.`kirja` SET `lainaaja`=NULL WHERE  `kirja_id`=" + kirja_id + ";");																
			getData.executeUpdate();
			//getData = connection.prepareStatement("SELECT * FROM kirja WHERE kirja_id = " + kirja_id + "");
			getData = connection.prepareStatement("SELECT * FROM kirja INNER JOIN"
					+ " kirjan_tiedot ON kirja.kirja_ISBN=kirjan_tiedot.kirja_ISBN WHERE kirja_id = "+kirja_id+"");
			ResultSet resultSet = getData.executeQuery();
			
			resultSet.next();
			System.out.println("\n" + "kirja_id: " + resultSet.getInt("kirja_id"));
			System.out.println("tila: " + resultSet.getString("tila"));
			System.out.println("luokka: " + resultSet.getString("luokka"));
			System.out.println("kirja_ISBN: " + resultSet.getString("kirja_ISBN"));
			System.out.println("kirjasto_id: " + resultSet.getInt("kirjasto_id"));
			System.out.println("lainaaja: " + resultSet.getInt("lainaaja") + "\n");
			
			return new Kirja(resultSet.getInt("kirja_id"),
					resultSet.getString("tila"),
					resultSet.getString("luokka"),
					resultSet.getLong("kirja_ISBN"),
					resultSet.getInt("kirjasto_id"),
					new Kirjatiedot(resultSet.getLong("kirja_ISBN"),
							resultSet.getString("nimi")
							,resultSet.getString("kustantaja"),
							resultSet.getString("kirjoittajat")
							,resultSet.getString("kuva"),
							resultSet.getInt("julkaisuvuosi"),
							resultSet.getInt("sivumäärä")));
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		


	}

	
}
