package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
public class Tietokanta {

	/**
	 * This method connect java to the database.
	 *
	 * @return connection to the database
	 * @throws Exception the exception
	 */
	public static Connection getConnection() throws Exception {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {

			String url = "jdbc:mariadb://mysql.metropolia.fi/rikukosk";
			String username = "rikukosk";
			String password = "Mustekala1337";

			Connection connection = DriverManager.getConnection(url, username, password);

			System.out.println("Connected!!");
			return connection;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * This method store the data in the database.
	 *
	 * @param asiakastiedot the asiakastiedot
	 * @throws Exception the exception
	 */
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

	
	/**
	 * Post kirjan tiedot.
	 *
	 * @param kirjatiedot the kirjatiedot
	 * @throws Exception the exception
	 */
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

	/**
	 * This method store the data in the database.
	 *
	 * @param kirjasto the kirjasto
	 * @throws Exception the exception
	 */
	public static void post_kirjasto(Kirjasto kirjasto) throws Exception {

		try {
			Connection connection = getConnection();
			PreparedStatement posted = connection.prepareStatement("insert into kirjasto "
					+ " (kirjasto_id, kirjasto_nimi, kirjasto_osoite, puh_numero, posti_numero, kaupunki)"
					+ " values ('" + kirjasto.getKirjasto_id() + "', '" + kirjasto.getKirjasto_nimi() + "', '"
					+ kirjasto.getOsoite() + "', '" + kirjasto.getPuh_numero() + "', '" + kirjasto.getPosti_numero()
					+ "', '" + kirjasto.getKaupunki() + "')");

			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}
	}

	/**
	 * This method gets the data form the database and print out the data the the
	 * console.
	 *
	 * @param kirjastoid the kirjastoid
	 * @return new Kirjasto object with in all it new data
	 * @throws Exception the exception
	 */
	public static Kirjasto get_kirjasto(int kirjastoid) throws Exception { // Yksi kirjasto haku
		try {
			Connection connection = getConnection();
			PreparedStatement getData = connection
					.prepareStatement("SELECT * FROM kirjasto WHERE kirjasto_id = " + kirjastoid + "");
			ResultSet resultSet = getData.executeQuery();

			resultSet.next();
			System.out.print("kirjasto_id: " + resultSet.getInt("kirjasto_id") + ", ");
			System.out.print("kirjasto_nimi: " + resultSet.getString("kirjasto_nimi") + ", ");
			System.out.print("kirjasto_osoite: " + resultSet.getString("kirjasto_osoite") + ", ");
			System.out.print("puh_numero: " + resultSet.getInt("puh_numero") + ", ");
			System.out.print("posti_numero: " + resultSet.getInt("posti_numero") + ", ");
			System.out.print("kaupunki: " + resultSet.getString("kaupunki") + "\n");

			System.out.println("All have been selected!");

			return new Kirjasto(resultSet.getInt("kirjasto_id"), resultSet.getString("kirjasto_nimi"),
					resultSet.getString("kirjasto_osoite"), resultSet.getInt("puh_numero"),
					resultSet.getInt("posti_numero"), resultSet.getString("kaupunki"));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * This method store the data in the database.
	 *
	 * @param kirja to get the data and store it in the database for example like
	 *              kirja.getTila()
	 * @throws Exception the exception
	 */
	public static void post_kirja(Kirja kirja) throws Exception {

		try {
			Connection connection = getConnection();
			System.out.println(kirja.getKirja_ISBN() + "===Tämä");
			PreparedStatement posted = connection.prepareStatement("insert into kirja "
					+ " (tila, luokka, kirja_ISBN, kirjasto_id)" + " values ('" + kirja.getTila() + "', '"
					+ kirja.getLuokka() + "', '" + kirja.getKirja_ISBN() + "', '" + kirja.getKirjasto_id() + "')");
			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}

	}

	/**
	 * This method gets the data form the database and print out the data the the
	 * console.
	 *
	 * @return Kirja of ArrayList
	 * @throws Exception the exception
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

				arrayList.add(new Kirja(resultSet.getInt("kirja_id"), resultSet.getString("tila"),
						resultSet.getString("luokka"), resultSet.getLong("kirja_ISBN"), resultSet.getInt("kirjasto_id"),
						new Kirjatiedot(resultSet.getLong("kirja_ISBN"), resultSet.getString("nimi"),
								resultSet.getString("kustantaja"), resultSet.getString("kirjoittajat"),
								resultSet.getString("kuva"), resultSet.getInt("julkaisuvuosi"),
								resultSet.getInt("sivumäärä"))));
			}
			System.out.println("All have been selected!");
			return arrayList;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * This method gets the data form the database and print out the data the the
	 * console.
	 *
	 * @param kirja_id the kirja id
	 * @return new Kirja object with in all it's new data and new Kirjatiedot object
	 *         with in all it's new data
	 * @throws Exception the exception
	 */
	public static Kirja get_kirja(int kirja_id) throws Exception {
		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM kirja INNER JOIN kirjan_tiedot ON kirja.kirja_ISBN=kirjan_tiedot.kirja_ISBN WHERE kirja_id = "
					+ kirja_id + "";
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
			
			Kirja k = new Kirja(resultSet.getInt("kirja_id"), resultSet.getString("tila"), resultSet.getString("luokka"),
					resultSet.getLong("kirja_ISBN"), resultSet.getInt("kirjasto_id"),
					new Kirjatiedot(resultSet.getLong("kirja_ISBN"), resultSet.getString("nimi"),
							resultSet.getString("kustantaja"), resultSet.getString("kirjoittajat"),
							resultSet.getString("kuva"), resultSet.getInt("julkaisuvuosi"),
							resultSet.getInt("sivumäärä")));
			
			k.setLainaaja(get_asiakas(resultSet.getInt("lainaaja")));

			return k;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * This method store the data in the database.
	 *
	 * @param asiakas the asiakas
	 * @throws Exception the exception
	 */
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

	/**
	 * This method gets the data form the database and print out the data the the
	 * console.
	 *
	 * @param as_id the as id
	 * @return new Asiakas object with in all it's new data and new Asiakastiedot
	 *         object with in all it's new data
	 * @throws Exception the exception
	 */
	public static Asiakas get_asiakas(int as_id) throws Exception { // yksi asiakas + parametri

		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM asiakas INNER JOIN asiakas_tiedot ON asiakas.puhelinnum=asiakas_tiedot.puh_numero WHERE as_id = "
					+ as_id + " ";
			PreparedStatement getData = connection.prepareStatement(query);
			ResultSet resultSet = getData.executeQuery();

			resultSet.next();
			System.out.print("as_id: " + resultSet.getInt("as_id") + ", ");
			System.out.print("etunimi: " + resultSet.getString("etunimi") + ", ");
			System.out.print("sukunimi: " + resultSet.getString("sukunimi") + ", ");
			System.out.print("puhelinnum: " + resultSet.getString("puhelinnum") + "\n");

			System.out.println("All have been selected!");

			return new Asiakas(resultSet.getInt("as_id"), resultSet.getString("etunimi"),
					resultSet.getString("sukunimi"),
					new Asiakastiedot(resultSet.getString("kaupunki"), resultSet.getString("s_posti"),
							resultSet.getString("posti_numero"), resultSet.getString("osoite"),
							resultSet.getString("puh_numero")));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * This method store the data in the database.
	 *
	 * @param admin the admin
	 * @throws Exception the exception
	 */
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

	/**
	 * This method gets the data form the database and print out the data to the
	 * console.
	 *
	 * @param kirjasto_id the kirjasto id
	 * @return new Admin object with in all it's new data
	 * @throws Exception the exception
	 */
	public static Admin get_admin(int kirjasto_id) throws Exception { /// yksi admin
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection
					.prepareStatement("SELECT * FROM admin WHERE kirjasto_id = " + kirjasto_id + "");
			ResultSet resultSet = getData.executeQuery();

			resultSet.next();
			System.out.print("Käyttäjätunnus: " + resultSet.getString("Käyttäjätunnus") + ", ");
			System.out.print("salasana: " + resultSet.getString("salasana") + ", ");
			System.out.print("kirjasto_id: " + resultSet.getInt("kirjasto_id") + "\n");

			System.out.println("All have been selected!");
			return new Admin(resultSet.getString("Käyttäjätunnus"), resultSet.getString("salasana"),
					resultSet.getInt("kirjasto_id"));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * This method gets the data form the database and print out the data the the
	 * console.
	 *
	 * @param isbn the isbn
	 * @return new Kirjatiedot object with in all it's new data
	 * @throws Exception the exception
	 */
	public static Kirjatiedot get_Kirjatiedot(long isbn) throws Exception { /// yksi admin
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection
					.prepareStatement("SELECT * FROM kirjan_tiedot WHERE kirja_ISBN = " + isbn + "");
			ResultSet resultSet = getData.executeQuery();

			resultSet.next();

			System.out.println("All have been selected!");
			return new Kirjatiedot(resultSet.getLong("kirja_ISBN"), resultSet.getString("nimi"),
					resultSet.getString("kustantaja"), resultSet.getString("kirjoittajat"), resultSet.getString("kuva"),
					resultSet.getInt("julkaisuvuosi"), resultSet.getInt("sivumäärä"));

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * This method gets the data form the database and print out the data the the
	 * console.
	 *
	 * @param asiakas_id the asiakas id
	 * @param kirja_id the kirja id
	 * @return new Kirja object with in all it's new data and new Kirjatiedot object
	 *         with in all it's new data
	 * @throws Exception the exception
	 */
	public static Kirja lainaus(String asiakas_id, String kirja_id) throws Exception {
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("UPDATE `rikukosk`.`kirja` SET `lainaaja`='"
					+ asiakas_id + "' WHERE  `kirja_id`=" + kirja_id + ";");
			getData.executeUpdate();
			
			LocalDate date = LocalDate.now();
			getData = connection.prepareStatement(
					"UPDATE `rikukosk`.`kirja` SET `tila`='" + date.plusDays(30) + "' WHERE  `kirja_id`=" + kirja_id + ";");
			getData.executeUpdate();

			getData = connection.prepareStatement("SELECT * FROM kirja INNER JOIN"
					+ " kirjan_tiedot ON kirja.kirja_ISBN=kirjan_tiedot.kirja_ISBN WHERE kirja_id = " + kirja_id + "");
			ResultSet resultSet = getData.executeQuery();

			resultSet.next();
			System.out.println("\n" + "kirja_id: " + resultSet.getInt("kirja_id"));
			System.out.println("tila: " + resultSet.getString("tila"));
			System.out.println("luokka: " + resultSet.getString("luokka"));
			System.out.println("kirja_ISBN: " + resultSet.getString("kirja_ISBN"));
			System.out.println("kirjasto_id: " + resultSet.getInt("kirjasto_id"));
			System.out.println("lainaaja: " + resultSet.getInt("lainaaja") + "\n");

			return new Kirja(resultSet.getInt("kirja_id"), resultSet.getString("tila"), resultSet.getString("luokka"),
					resultSet.getLong("kirja_ISBN"), resultSet.getInt("kirjasto_id"),
					new Kirjatiedot(resultSet.getLong("kirja_ISBN"), resultSet.getString("nimi"),
							resultSet.getString("kustantaja"), resultSet.getString("kirjoittajat"),
							resultSet.getString("kuva"), resultSet.getInt("julkaisuvuosi"),
							resultSet.getInt("sivumäärä")));

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/**
	 * This method gets the data form the database and print out the data the the
	 * console.
	 *
	 * @param kirja_id the kirja id
	 * @return new Kirja object with in all it's new data and new Kirjatiedot object
	 *         with in all it's new data
	 * @throws Exception the exception
	 */
	public static Kirja palautus(String kirja_id) throws Exception {
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement(
					"UPDATE `rikukosk`.`kirja` SET `lainaaja`=NULL WHERE  `kirja_id`=" + kirja_id + ";");
			getData.executeUpdate();
			
			getData = connection.prepareStatement(
					"UPDATE `rikukosk`.`kirja` SET `tila`='" + "hyllyssä" + "' WHERE  `kirja_id`=" + kirja_id + ";");
			getData.executeUpdate();

			getData = connection.prepareStatement("SELECT * FROM kirja INNER JOIN"
					+ " kirjan_tiedot ON kirja.kirja_ISBN=kirjan_tiedot.kirja_ISBN WHERE kirja_id = " + kirja_id + "");
			ResultSet resultSet = getData.executeQuery();

			resultSet.next();
			System.out.println("\n" + "kirja_id: " + resultSet.getInt("kirja_id"));
			System.out.println("tila: " + resultSet.getString("tila"));
			System.out.println("luokka: " + resultSet.getString("luokka"));
			System.out.println("kirja_ISBN: " + resultSet.getString("kirja_ISBN"));
			System.out.println("kirjasto_id: " + resultSet.getInt("kirjasto_id"));
			System.out.println("lainaaja: " + resultSet.getInt("lainaaja") + "\n");

			return new Kirja(resultSet.getInt("kirja_id"), resultSet.getString("tila"), resultSet.getString("luokka"),
					resultSet.getLong("kirja_ISBN"), resultSet.getInt("kirjasto_id"),
					new Kirjatiedot(resultSet.getLong("kirja_ISBN"), resultSet.getString("nimi"),
							resultSet.getString("kustantaja"), resultSet.getString("kirjoittajat"),
							resultSet.getString("kuva"), resultSet.getInt("julkaisuvuosi"),
							resultSet.getInt("sivumäärä")));

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/**
	 * This method deletes kirja from the database.
	 *
	 * @param kirja_id the kirja id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean delete_kirja(int kirja_id) throws Exception { 
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("DELETE FROM kirja WHERE kirja_id = " + kirja_id + "");
			getData.executeQuery();
			System.out.println("The book has been delete!");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/**
	 * Delete kirja.
	 *
	 * @param selectedForDeletion the selected for deletion
	 * @return the boolean
	 * @throws Exception the exception
	 */
	// new delete_kirja method
		public static Boolean delete_kirja(Kirjatiedot selectedForDeletion) throws Exception { 
			try {
				Connection conn = getConnection();
				String deleteStatement = "DELETE FROM kirja WHERE kirja_id  = ?";
	            PreparedStatement stmt = conn.prepareStatement("DELETE FROM kirjan_tiedot WHERE kirja_ISBN = ?");
	            stmt.setLong(1, selectedForDeletion.getKirja_ISBN());
	            int res = stmt.executeUpdate();
	            if (res == 1) {
	                return true;
	            }
			} catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
	
	/**
	 * This method deletes asiakas from the database.
	 *
	 * @param as_id the as id
	 * @throws Exception the exception
	 */
	public static void delete_asiakas(int as_id) throws Exception { 
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("DELETE FROM asiakas WHERE as_id = " + as_id + "");
//			ResultSet resultSet = getData.executeQuery();
			getData.executeQuery(); // it work like that
			System.out.println("The asiakas has been delete!");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		
		//delete_kirja(34);// this works
		//delete_asiakas(10); // this works
	}

}
