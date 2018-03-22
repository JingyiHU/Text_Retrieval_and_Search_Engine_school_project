package main.sql.data;

import java.util.HashMap;
import java.util.Map;

public class Arbre {
	Arbre fils=null;
	Arbre frere=null;
	String categorie;
	String mot;
	private Map<String, Object> data = new HashMap<>();
	
	private static <T> T nullOr(Object check, T value) {
		return check != null ? value : null;
	}
	
	public Integer getIntegerData(String key) {
		Object object = data.get(key);
		return nullOr(object, (Integer) object);
	}

	public void setIntegerData(String key, Integer value) {
		data.put(key, value);
	}
	
	public Boolean getBooleanData(String key) {
		Object object = data.get(key);
		return nullOr(object, (Boolean) object);
	}

	public void setBooleanData(String key, Boolean value) {
		data.put(key, value);
	}

	public String getStringData(String key) {
		Object object = data.get(key);
		return nullOr(object, (String) object);
	}

	public void setStringData(String key, String value) {
		data.put(key, value);
	}

	public void incrementIntegerData(String key) {
		data.put(key, ((Integer) data.getOrDefault(key, 0)) + 1);
	}
	
	public Arbre getFils() {
		return fils;
	}

	public Arbre(String categorie,String mot) {
		this.categorie = categorie ;
		this.mot = mot ;
	}

	public Arbre(String categorie) {
		this.categorie = categorie ;
		this.mot = "" ;
	}

	public void ajouteFils(Arbre a) {
		if (fils == null)
			fils = a;
		else
			fils.ajouteFrere(a);
	}

	private void ajouteFrere(Arbre a) {
		Arbre tmp = frere ;
		if (frere == null)
			frere = a;
		else {
			while (tmp.frere != null)
				tmp = tmp.frere ;
			tmp.frere = a;
		}
	}

	public String sortArbre() {
		return sortArbreAvecNl(false);
	}

	private String sortArbreAvecNl(boolean withParens) {
		String arbre = categorie + " " + mot +" ";
		if (fils != null) {
			if (withParens) { arbre = arbre +" ( "; }
			arbre = arbre + fils.sortArbreAvecNl(true);
			if (withParens) { arbre = arbre +" ) "; }
		}
		if (frere != null) {
			arbre = arbre + frere.sortArbreAvecNl(true);
		}
		return arbre;
	}

	private void afficheCatAvecNl() {
		System.out.print(categorie+" ");
		System.out.print(mot+" ");
		if (fils != null) {
			System.out.print(" ( ");
			fils.afficheCatAvecNl();
			System.out.print(") ");
		}
		if (frere != null) {
			frere.afficheCatAvecNl();
		}
	}
	private void afficheCatSansNl() {
		System.out.print(categorie+" ");
		if (fils != null) {
			System.out.print(" ( ");
			fils.afficheCatSansNl();
			System.out.print(") ");
		}
		if (frere != null) {
			frere.afficheCatSansNl();
		}
	}

}
