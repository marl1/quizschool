package model;
// Generated Oct 25, 2018 10:38:53 AM by Hibernate Tools 5.1.10.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Donner generated by hbm2java
 */
@Entity
@Table(name = "donner", catalog = "QUIZ2")
public class Donner implements java.io.Serializable {

	private DonnerId id;
	private Proposition proposition;
	private Stagiaire stagiaire;
	private int secondesPourRepondre;
	private String reponseTextuelle;

	public Donner() {
	}

	public Donner(DonnerId id, Proposition proposition, Stagiaire stagiaire, int secondesPourRepondre) {
		this.id = id;
		this.proposition = proposition;
		this.stagiaire = stagiaire;
		this.secondesPourRepondre = secondesPourRepondre;
	}

	public Donner(DonnerId id, Proposition proposition, Stagiaire stagiaire, int secondesPourRepondre,
			String reponseTextuelle) {
		this.id = id;
		this.proposition = proposition;
		this.stagiaire = stagiaire;
		this.secondesPourRepondre = secondesPourRepondre;
		this.reponseTextuelle = reponseTextuelle;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idStagiaire", column = @Column(name = "idStagiaire", nullable = false)),
			@AttributeOverride(name = "idProposition", column = @Column(name = "idProposition", nullable = false)) })
	public DonnerId getId() {
		return this.id;
	}

	public void setId(DonnerId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProposition", nullable = false, insertable = false, updatable = false)
	public Proposition getProposition() {
		return this.proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStagiaire", nullable = false, insertable = false, updatable = false)
	public Stagiaire getStagiaire() {
		return this.stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	@Column(name = "secondesPourRepondre", nullable = false)
	public int getSecondesPourRepondre() {
		return this.secondesPourRepondre;
	}

	public void setSecondesPourRepondre(int secondesPourRepondre) {
		this.secondesPourRepondre = secondesPourRepondre;
	}

	@Column(name = "reponseTextuelle", length = 45)
	public String getReponseTextuelle() {
		return this.reponseTextuelle;
	}

	public void setReponseTextuelle(String reponseTextuelle) {
		this.reponseTextuelle = reponseTextuelle;
	}

}