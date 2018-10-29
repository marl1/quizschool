package model;
// Generated Oct 25, 2018 10:38:53 AM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Stagiaire generated by hbm2java
 */
@Entity
@Table(name = "stagiaire", catalog = "QUIZ2")
public class Stagiaire implements java.io.Serializable {

	private int idStagiaire;
	private String mailStagiaire;
	private String mdpStagiaire;
	private Set<Passer> passers = new HashSet<Passer>(0);
	private Set<Donner> donners = new HashSet<Donner>(0);

	public Stagiaire() {
	}

	public Stagiaire(int idStagiaire, String mailStagiaire, String mdpStagiaire) {
		this.idStagiaire = idStagiaire;
		this.mailStagiaire = mailStagiaire;
		this.mdpStagiaire = mdpStagiaire;
	}

	public Stagiaire(int idStagiaire, String mailStagiaire, String mdpStagiaire, Set<Passer> passers,
			Set<Donner> donners) {
		this.idStagiaire = idStagiaire;
		this.mailStagiaire = mailStagiaire;
		this.mdpStagiaire = mdpStagiaire;
		this.passers = passers;
		this.donners = donners;
	}

	@Id

	@Column(name = "idStagiaire", unique = true, nullable = false)
	public int getIdStagiaire() {
		return this.idStagiaire;
	}

	public void setIdStagiaire(int idStagiaire) {
		this.idStagiaire = idStagiaire;
	}

	@Column(name = "mailStagiaire", nullable = false, length = 32)
	public String getMailStagiaire() {
		return this.mailStagiaire;
	}

	public void setMailStagiaire(String mailStagiaire) {
		this.mailStagiaire = mailStagiaire;
	}

	@Column(name = "mdpStagiaire", nullable = false, length = 128)
	public String getMdpStagiaire() {
		return this.mdpStagiaire;
	}

	public void setMdpStagiaire(String mdpStagiaire) {
		this.mdpStagiaire = mdpStagiaire;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stagiaire")
	public Set<Passer> getPassers() {
		return this.passers;
	}

	public void setPassers(Set<Passer> passers) {
		this.passers = passers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stagiaire")
	public Set<Donner> getDonners() {
		return this.donners;
	}

	public void setDonners(Set<Donner> donners) {
		this.donners = donners;
	}

}
