package controller;

import java.util.List;
import model.Kirja;
import model.Kirjatiedot;

@SuppressWarnings("rawtypes")
public interface V2M {
	
	public boolean tarkistaLogin(String user,String pwd);
	public void lainaaPost(List kirjat);
	public void kirjaPost(Kirja k);
	public Kirjatiedot kirjaTiedotPost(Long isbn);

}
