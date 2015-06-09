package com.edf_decoha;

import java.util.Date;

public class Client {

	/*
	 * Données ne pouvant être modifiées cf service commercial/financier
	 */
	private String identifiant, nom, prenom,adresse, cp,ville, tl;
	
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTl() {
		return tl;
	}
	public void setTl(String tl) {
		this.tl = tl;
	}
	public String getIdcompteur() {
		return idcompteur;
	}
	public void setIdcompteur(String idcompteur) {
		this.idcompteur = idcompteur;
	}
	public Double getAncien_releve() {
		return ancien_releve;
	}
	public void setAncien_releve(Double ancien_releve) {
		this.ancien_releve = ancien_releve;
	}
	public Date getDate_ancien_releve() {
		return date_ancien_releve;
	}
	public void setDate_ancien_releve(Date date_ancien_releve) {
		this.date_ancien_releve = date_ancien_releve;
	}
	public Double getDernier_releve() {
		return dernier_releve;
	}
	public void setDernier_releve(Double dernier_releve) {
		this.dernier_releve = dernier_releve;
	}
	public Date getDate_dernier_releve() {
		return date_dernier_releve;
	}
	public void setDate_dernier_releve(Date date_dernier_releve) {
		this.date_dernier_releve = date_dernier_releve;
	}
	public String getSignature_Base64() {
		return signature_Base64;
	}
	public void setSignature_Base64(String signature_Base64) {
		this.signature_Base64 = signature_Base64;
	}
	public int getSituation() {
		return situation;
	}
	public void setSituation(int situation) {
		this.situation = situation;
	}
	
	// etc etc...
	private String idcompteur;
	private Double ancien_releve;
	private Date date_ancien_releve;
	/*
	 * Données à saisir 
	 */
	private Double dernier_releve;
	private Date date_dernier_releve;
	private String signature_Base64;
	private int situation;
	
	
	/*
	 * 0 client non traité par défaut
	 * 1 Absent 
	 * 2 Absent mais relevé ok sans signature
	 * 3 Present, relevé ok mais pas de signature car pas représentant legal
	 * 4 present et tout ok
	 * 5 déménagé et vide
	 * 6 démanagé et nouveau locataire
	 * 72,73,74 idem 2,3,4 mais suspission fraude
	 * 82,83,84 idem 2,3,4 mais dysfonctionnement / dégradation
	 * 99 pas eu le temps
	 * ... etc etc
	 */
	
	public Client()
	{
	}
	
	public Client (String id , String nomC, String prenomC, String adr, String cpC, String villeC, String tel, String idcompt, Double an_releve, Date date_an_releve)
	{
		identifiant = id;
		nom = nomC;
		prenom = prenomC;
		adresse = adr;
		cp = cpC;
		ville = villeC;
		tl = tel;
		
		idcompteur = idcompt;
		ancien_releve = an_releve;
		date_ancien_releve = date_an_releve;
		
		dernier_releve = 0.0;
		date_dernier_releve = new Date();
		signature_Base64 = "";
		situation = 0;
	}
	
	public void recopieclient(Client vcli)
	{
		 identifiant = vcli.identifiant;
		 nom = vcli.nom;
		 prenom = vcli.prenom;
		 adresse = vcli.adresse;
		 cp = vcli.cp;
		 ville = vcli.ville;
		 tl = vcli.tl;
		 idcompteur = vcli.idcompteur;
		 ancien_releve = vcli.ancien_releve;
		 date_ancien_releve = vcli.date_ancien_releve;
		 dernier_releve = vcli.dernier_releve;
		 date_dernier_releve = vcli.date_dernier_releve;
		 signature_Base64 = vcli.signature_Base64;
		 situation = vcli.situation;
	}
	


}
