package model;

public class Asiakastiedot extends Asiakas {

	private int tiedot_id;
	private String kaupunki;
	private String s_posti;
	private int posti_numero;
	private String osoite;
	private int puh_numero;
	
	public Asiakastiedot() {
		
	}

	public Asiakastiedot(int tiedot_id, String kaupunki, String s_posti, int posti_numero, String osoite, int puh_numero) {
		this.tiedot_id = tiedot_id;
		this.kaupunki = kaupunki;
		this.s_posti = s_posti;
		this.posti_numero = posti_numero;
		this.osoite = osoite;
		this.puh_numero = puh_numero;
	}
	
	public int getTiedot_id() {
		return tiedot_id;
	}

	public void setTiedot_id(int tiedot_id) {
		this.tiedot_id = tiedot_id;
	}

	public String getKaupunki() {
		return kaupunki;
	}

	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}

	public String getS_posti() {
		return s_posti;
	}

	public void setS_posti(String s_posti) {
		this.s_posti = s_posti;
	}

	public int getPosti_numero() {
		return posti_numero;
	}

	public void setPosti_numero(int posti_numero) {
		this.posti_numero = posti_numero;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public int getPuh_numero() {
		return puh_numero;
	}

	public void setPuh_numero(int puh_numero) {
		this.puh_numero = puh_numero;
	}

}
