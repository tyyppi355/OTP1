package model;

public class Asiakas {

	private String etunimi;
	private String sukunimi;
	private int kirja_id;
	private int tiedot_id;
	
	public Asiakas() {
		
	}
	
	public Asiakas(String etunimi, String sukunimi, int kirja_id, int tiedot_id) {
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.kirja_id = kirja_id;
		this.tiedot_id = tiedot_id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public int getKirja_id() {
		return kirja_id;
	}

	public void setKirja_id(int kirja_id) {
		this.kirja_id = kirja_id;
	}

	public int getTiedot_id() {
		return tiedot_id;
	}

	public void setTiedot_id(int tiedot_id) {
		this.tiedot_id = tiedot_id;
	}

}
