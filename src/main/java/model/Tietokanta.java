package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Tietokanta {

	// Admin class
	//protected static Admin admin = new Admin("admin2","123",2);
	private static String Käyttäjätunnus;
	private static String salasana;
//	private static int kirjasto_id; // use the kirjasto for (kirjasto_id)

	// Asiakastiedot class
	protected static Asiakastiedot asiakastiedot = new Asiakastiedot();
	private static int tiedot_id;
	private static String kaupunki;
	private static String s_posti;
	private static int posti_numero;
	private static String osoite;
	private static int puh_numero;

	// Kirjatiedot class
	protected static Kirjatiedot kirjatiedot = new Kirjatiedot();
	private static int kirja_ISBN;
	private static String nimi;
	private static String kunstantaja;
	private static String kirjoittajat;
	private static String kuva;
	private static int julkasuvuosi;
	private static int sivumäärä;
	
	// kirjasto class
	protected static Kirjasto kirjasto = new Kirjasto();
	private static int kirjasto_id;
	private static String kirjasto_nimi;
	private static String kirjasto_osoite;
	private static int puh_numero_kirjasto;
	private static int posti_numero_kirjasto;
	private static String kaupunki_kirjasto;
	
	// asiakas class
	protected static Asiakas asiakas = new Asiakas();
	private static String etunimi;
	private static String sukunimi;
//	private static int kirja_id;  // use the kirja for (kirja_id)
//	private static int tiedot_id; // use the asiakastiedot for (tiedot_id)
	

	public static void main(String[] args) throws Exception {

		// getConnection(); // The connection is already their in the post()

		// post_asiakas_tiedot();
		//get_asiakas_tiedot();

		// post_kirjan_tiedot();
		 //get_kirjan_tiedot();

		// post_kirjasto();
		// get_kirjasto();

		// post_kirja();
		ArrayList<Kirja> kirjat = get_kirjat();
		System.out.println(kirjat.get(0).getkTiedot().getNimi() + " " + kirjat.get(0).getKirja_ISBN());
		System.out.println(kirjat.get(1).getkTiedot().getNimi() + " " + kirjat.get(1).getKirja_ISBN());

		// post_asiakas();
		// get_asiakas();
		//post_admin(new Admin("admin3","222",4));
		ArrayList<Admin> a = get_admin();
		System.out.println(a.get(0).getKäyttäjätunnu());
		System.out.println(a.get(1).getKäyttäjätunnu());

	}

	
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver"; // the new one is com.mysql.cj.jdbc.Driver
			String url = "jdbc:mysql://localhost:3306/library_database"; // add the port and the name of the database
			String username = "root"; // your database name
			String password = "1234"; // your database password
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected!!");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	public static void post_asiakas_tiedot() throws Exception {

		try {
			Connection connection = getConnection();
			PreparedStatement posted = connection.prepareStatement(
					"insert into asiakas_tiedot " + " (tiedot_id , kaupunki, s_posti, posti_numero, osoite, puh_numero)"
							+ " values ('"+asiakastiedot.getTiedot_id()+"', '" + asiakastiedot.getKaupunki() + "', '" + asiakastiedot.getS_posti() + "', '"
							+ asiakastiedot.getPosti_numero() + "', '" + asiakastiedot.getOsoite() + "', '"
							+ asiakastiedot.getPuh_numero() + "')");

			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}

	}

	public static ArrayList<String> get_asiakas_tiedot() throws Exception {
		
		try {
			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("SELECT * FROM asiakas_tiedot");
			ResultSet resultSet = getData.executeQuery();
			ArrayList<String> arrayList = new ArrayList<String>();
			
			while (resultSet.next()) {
				
				System.out.print("tiedot_id: " + resultSet.getInt("tiedot_id") + ", ");
				System.out.print("kaupunki: " + resultSet.getString("kaupunki") + ", ");
				System.out.print("s_posti: " + resultSet.getString("s_posti") + ", ");
				System.out.print("posti_numero: " + resultSet.getInt("posti_numero") + ", ");
				System.out.print("osoite: " + resultSet.getString("osoite") + ", ");
				System.out.print("puh_numero: " + resultSet.getInt("puh_numero") + "\n");
				
				tiedot_id = resultSet.getInt("tiedot_id");
				kaupunki = resultSet.getString("kaupunki");
				s_posti = resultSet.getString("s_posti");
				posti_numero = resultSet.getInt("posti_numero");
				osoite = resultSet.getString("osoite");
				puh_numero = resultSet.getInt("puh_numero");
				
				asiakastiedot.setTiedot_id(tiedot_id);
				asiakastiedot.setKaupunki(kaupunki);
				asiakastiedot.setS_posti(s_posti);
				asiakastiedot.setPosti_numero(posti_numero);
				asiakastiedot.setOsoite(osoite);
				asiakastiedot.setPuh_numero(puh_numero);

				arrayList.add(resultSet.getString("tiedot_id")); // we add the tiedot_id to the arrayList
				arrayList.add(resultSet.getString("kaupunki"));
				arrayList.add(resultSet.getString("s_posti"));
				arrayList.add(resultSet.getString("posti_numero"));
				arrayList.add(resultSet.getString("osoite"));
				arrayList.add(resultSet.getString("puh_numero"));
			}
			System.out.println("All have been selected!");
			// System.out.println("arraylist: " + arrayList.get(1));
			return arrayList;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
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

	public static ArrayList<String> get_kirjan_tiedot() throws Exception {
		try {
			
			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("SELECT * FROM kirjan_tiedot");																			// table too
			ResultSet resultSet = getData.executeQuery();
			ArrayList<String> arrayList = new ArrayList<String>();

			while (resultSet.next()) {
				
				System.out.print("kirja_ISBN: " + resultSet.getInt("kirja_ISBN") + ", ");
				System.out.print("nimi: " + resultSet.getString("nimi") + ", ");
				System.out.print("kunstantaja: " + resultSet.getString("kunstantaja") + ", ");
				System.out.print("kirjoittajat: " + resultSet.getString("kirjoittajat") + ", ");
				System.out.print("kuva: " + resultSet.getString("kuva") + ", ");
				System.out.print("julkasuvuosi: " + resultSet.getInt("julkasuvuosi") + ", ");
				System.out.print("sivumäärä: " + resultSet.getInt("sivumäärä") + "\n");
				
				kirja_ISBN = resultSet.getInt("kirja_ISBN");
				nimi = resultSet.getString("nimi");
				kunstantaja = resultSet.getString("kunstantaja");
				kirjoittajat = resultSet.getString("kirjoittajat");
				kuva = resultSet.getString("kuva");
				julkasuvuosi = resultSet.getInt("julkasuvuosi");
				sivumäärä = resultSet.getInt("sivumäärä");
				
				kirjatiedot.setKirja_ISBN(kirja_ISBN);
				kirjatiedot.setNimi(nimi);
				kirjatiedot.setKunstantaja(kunstantaja);
				kirjatiedot.setKirjoittajat(kirjoittajat);
				kirjatiedot.setKuva(kuva);
				kirjatiedot.setJulkasuvuosi(julkasuvuosi);
				kirjatiedot.setSivumäärä(sivumäärä);
				
				arrayList.add(resultSet.getString("kirja_ISBN")); // we add the kirja_ISBN to the arrayList
				arrayList.add(resultSet.getString("nimi"));
				arrayList.add(resultSet.getString("kunstantaja"));
				arrayList.add(resultSet.getString("kirjoittajat"));
				arrayList.add(resultSet.getString("kuva"));
				arrayList.add(resultSet.getString("julkasuvuosi"));
				arrayList.add(resultSet.getString("sivumäärä"));
			}
			System.out.println("All have been selected!");
			// System.out.println("arraylist: " + arrayList.get(0));
			return arrayList;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	public static void post_kirjasto() throws Exception {

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

	public static ArrayList<String> get_kirjasto() throws Exception {
		try {
			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("SELECT * FROM kirjasto");																
			ResultSet resultSet = getData.executeQuery();
			ArrayList<String> arrayList = new ArrayList<String>();

			while (resultSet.next()) {
				
				System.out.print("kirjasto_id: " + resultSet.getInt("kirjasto_id") + ", ");
				System.out.print("kirjasto_nimi: " + resultSet.getString("kirjasto_nimi") + ", ");
				System.out.print("kirjasto_osoite: " + resultSet.getString("kirjasto_osoite") + ", ");
				System.out.print("puh_numero: " + resultSet.getInt("puh_numero") + ", ");
				System.out.print("posti_numero: " + resultSet.getInt("posti_numero") + ", ");
				System.out.print("kaupunki: " + resultSet.getString("kaupunki") + "\n");
				
				Kirjasto k = new Kirjasto();
				
				kirjasto_id = resultSet.getInt("kirjasto_id");
				kirjasto_nimi = resultSet.getString("kirjasto_nimi");
				kirjasto_osoite = resultSet.getString("kirjasto_osoite");
				puh_numero_kirjasto = resultSet.getInt("puh_numero");
				posti_numero_kirjasto = resultSet.getInt("posti_numero");
				kaupunki_kirjasto = resultSet.getString("kaupunki");
				
				kirjasto.setKirjasto_id(kirjasto_id);
				kirjasto.setKirjasto_nimi(kirjasto_nimi);
				kirjasto.setOsoite(kirjasto_osoite);
				kirjasto.setPuh_numero(puh_numero_kirjasto);
				kirjasto.setPosti_numero(posti_numero_kirjasto);
				kirjasto.setKaupunki(kaupunki_kirjasto);
				
				arrayList.add(resultSet.getString("kirjasto_id")); // we add the kirjasto_id to the arrayList
				arrayList.add(resultSet.getString("kirjasto_nimi"));
				arrayList.add(resultSet.getString("kirjasto_osoite"));
				arrayList.add(resultSet.getString("puh_numero"));
				arrayList.add(resultSet.getString("posti_numero"));
				arrayList.add(resultSet.getString("kaupunki"));
			}
			System.out.println("All have been selected!");
			// System.out.println("arraylist: " + arrayList.get(0));
			return arrayList;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	public static void post_kirja(Kirja kirja) throws Exception {

		try {
			Connection connection = getConnection();
			PreparedStatement posted = connection.prepareStatement("insert into kirja "
					+ " (kirja_id, tila, luokka, kirja_ISBN, kirjasto_id)" + " values ('" + kirja.getKirja_id() + "', '" + kirja.getTila()
					+ "', '" + kirja.getLuokka() + "', '" + kirja.getKirja_ISBN() + "', '" + kirja.getKirjasto_id() + "')"); 
			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}

	}

	public static ArrayList<Kirja> get_kirjat() throws Exception {
		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM kirja INNER JOIN kirjan_tiedot ON kirja.kirja_ISBN=kirjan_tiedot.kirja_ISBN";
			PreparedStatement getData = connection.prepareStatement(query);
			ResultSet resultSet = getData.executeQuery();
			ArrayList<Kirja> arrayList = new ArrayList<Kirja>(); // no need for it if you don't store the data

			while (resultSet.next()) {
				
				System.out.println("--Kirja--- kirja_id: " + resultSet.getInt("kirja_id"));
				System.out.println("---Kirjan_tiedot--- nimi: " + resultSet.getString("nimi") + "\n");
				
				int kirja_id = resultSet.getInt("kirja_id");
				String tila = resultSet.getString("tila");
				String luokka = resultSet.getString("luokka");
				long kirja_ISBN = resultSet.getLong("kirja_ISBN");
				int kirjasto_id = resultSet.getInt("kirjasto_id");
				String nimi = resultSet.getString("nimi");
				String kustantaja = resultSet.getString("kustantaja");
				String kirjoittajat = resultSet.getString("kirjoittajat");
				String kuva = resultSet.getString("kuva");
				int julkaisuvuosi = resultSet.getInt("julkaisuvuosi");
				int sivumäärä = resultSet.getInt("sivumäärä");
				
				
				
				arrayList.add(new Kirja(kirja_id,tila,luokka,kirja_ISBN,kirjasto_id,
						new Kirjatiedot(kirja_ISBN,nimi,kustantaja,kirjoittajat,kuva,julkaisuvuosi,sivumäärä)));
			}
			System.out.println("All have been selected!");
			// System.out.println("arraylist: " + arrayList.get(1));
			return arrayList;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	public static void post_asiakas() throws Exception {

		try {
			Connection connection = getConnection();
			PreparedStatement posted = connection.prepareStatement(
					"insert into asiakas " + " (etunimi, sukunimi, kirja_id, tiedot_id)" + " values ('" + asiakas.getEtunimi()
							+ "', '" + asiakas.getSukunimi() + "', '" + asiakas.getKirja_id() + "', '" + asiakas.getTiedot_id() + "')"); 
			posted.executeUpdate(); // to add the data to the database

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("The insert is completed!");
		}

	}

	public static ArrayList<String> get_asiakas() throws Exception {
		try {
			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("SELECT * FROM asiakas");																	// too
			ResultSet resultSet = getData.executeQuery();
			ArrayList<String> arrayList = new ArrayList<String>();

			
			while (resultSet.next()) {
				
				System.out.print("as_id: " + resultSet.getInt("as_id") + ", ");
				System.out.print("etunimi: " + resultSet.getString("etunimi") + ", ");
				System.out.print("sukunimi: " + resultSet.getString("sukunimi") + ", ");
				System.out.print("kirja_id: " + resultSet.getInt("kirja_id") + ", ");
				System.out.print("tiedot_id: " + resultSet.getInt("tiedot_id") + "\n");
				
				etunimi = resultSet.getString("etunimi");
				sukunimi = resultSet.getString("sukunimi");
//				kirja_id = resultSet.getInt("kirja_id"); // what if we use kirja_id value without a sign to new value
//				tiedot_id = resultSet.getInt("tiedot_id");  // what if we use tiedot_id value without a sign to new value
				
				asiakas.setEtunimi(etunimi);
				asiakas.setSukunimi(sukunimi);
				//asiakas.setKirja_id(kirja_id);
				asiakas.setTiedot_id(tiedot_id);
				
				arrayList.add(resultSet.getString("as_id")); // we add the as_id to the arrayList
				arrayList.add(resultSet.getString("etunimi"));
				arrayList.add(resultSet.getString("sukunimi"));
				arrayList.add(resultSet.getString("kirja_id"));
				arrayList.add(resultSet.getString("tiedot_id"));

			}
			System.out.println("All have been selected!");
			//System.out.println("arraylist: " + arrayList.get(0));
			return arrayList;

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

	public static ArrayList<Admin> get_admin() throws Exception {
		try {

			Connection connection = getConnection();
			PreparedStatement getData = connection.prepareStatement("SELECT * FROM admin");																
			ResultSet resultSet = getData.executeQuery();
			ArrayList<Admin> arrayList = new ArrayList<Admin>(); // no need for it if you don't store the data

			while (resultSet.next()) {

				// print out to the console all the data form the database
				//System.out.print("Käyttäjätunnus: " + resultSet.getString("Käyttäjätunnus") + ", ");
				//System.out.print("salasana: " + resultSet.getString("salasana") + ", ");
				//System.out.print("kirjasto_id: " + resultSet.getInt("kirjasto_id") + "\n");

				Käyttäjätunnus = resultSet.getString("Käyttäjätunnus");
				salasana = resultSet.getString("salasana");
				kirjasto_id = resultSet.getInt("kirjasto_id"); // what if we use kirjasto_id value without a sign to new value
				

				arrayList.add(new Admin(Käyttäjätunnus,salasana,kirjasto_id));

				
			}
			;
			System.out.println("All have been selected!");
			//System.out.println("arraylist: " + arrayList.get(0));
			//System.out.println("arraylist: " + arrayList.get(1));
			return arrayList;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
}
