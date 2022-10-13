# OTP-1
Ryhmä 2 (R2)

Ryhmän jäsenet: Riku Koski @Arbit3r, Fatlum Gerguri @Vikingi22, Hussein AL-Bayati @Hussein3030, Niko Ahonen @tyyppi355

## Visio ja käytetyt kirjastot/työkalut
![Sovellus](https://users.metropolia.fi/~rikukosk/images/BookBastion.PNG)

BookBastion on kirjaston lainausjärjestelmä jolla pysytään lainaamaan asiakkaalle kirja ja palauttamaan.
Ohjelmisto mahdollistaa myös kirjojen ja asiakkastietojen luonnin.

Ohjelmassammen käytettiin Ecplise kehitysympäristöä ja projekti rakennetiin maven mallin mukaisesti.

###Käytetyt kirjastot
-JavaFx
-Gson
-mariadb
-Junit5

#Asennusohjeet
1. Laita Metropolian VPN päälle
2. Kloonaa tämä repo omalle koneellesi
3. Lataa JavaFx SDK omalle koneellesi https://gluonhq.com/products/javafx/
4. Laita tietokanta.java luokkasta löytyvään getConnetion() metodiin käyttäjätunnus ja salasana
```
public static Connection getConnection() throws Exception {
		try {
			
			String url = "jdbc:mariadb://mysql.metropolia.fi/rikukosk";
			String username = "(Annettu käyttäjätunnus)";
			String password = "(Annettu salasana)";
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			System.out.println("Connected!!");
			return connection;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
```
5. Aseta Run-configuration VM asetuksiin seuraava argumentti:
```
--module-path "C:\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml
```
module-path pitää laitaa samaksi missä javafx sijaitsee.



