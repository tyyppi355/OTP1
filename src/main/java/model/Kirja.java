package model;

public class Kirja {

	private int kirja_id;
	private String tila;
	private String luokka;
	private int kirja_ISBN;
	private int kirjasto_id;

	public Kirja() {

	}

	public Kirja(int kirja_id, String tila, String luokka, int kirja_ISBN, int kirjasto_id) {
		this.kirja_id = kirja_id;
		this.tila = tila;
		this.luokka = luokka;
		this.kirja_ISBN = kirja_ISBN;
		this.kirjasto_id = kirjasto_id;
	}

	public int getKirja_id() {
		return kirja_id;
	}

	public void setKirja_id(int kirja_id) {
		this.kirja_id = kirja_id;
	}

	public String getTila() {
		return tila;
	}

	public void setTila(String tila) {
		this.tila = tila;
	}

	public String getLuokka() {
		return luokka;
	}

	public void setLuokka(String luokka) {
		this.luokka = luokka;
	}

	public int getKirja_ISBN() {
		return kirja_ISBN;
	}

	public void setKirja_ISBN(int kirja_ISBN) {
		this.kirja_ISBN = kirja_ISBN;
	}

	public int getKirjasto_id() {
		return kirjasto_id;
	}

	public void setKirjasto_id(int kirjasto_id) {
		this.kirjasto_id = kirjasto_id;
	}

}
