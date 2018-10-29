package model;
// Generated Oct 25, 2018 10:38:53 AM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name = "admin", catalog = "QUIZ2")
public class Admin implements java.io.Serializable {

	private Integer idAdmin;
	private String nomAdmin;
	private String prenomAdmin;
	private String mailAdmin;
	private String mdpAdmin;

	public Admin() {
	}

	public Admin(String nomAdmin, String prenomAdmin, String mailAdmin, String mdpAdmin) {
		this.nomAdmin = nomAdmin;
		this.prenomAdmin = prenomAdmin;
		this.mailAdmin = mailAdmin;
		this.mdpAdmin = mdpAdmin;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idAdmin", unique = true, nullable = false)
	public Integer getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	@Column(name = "nomAdmin", nullable = false, length = 20)
	public String getNomAdmin() {
		return this.nomAdmin;
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}

	@Column(name = "prenomAdmin", nullable = false, length = 20)
	public String getPrenomAdmin() {
		return this.prenomAdmin;
	}

	public void setPrenomAdmin(String prenomAdmin) {
		this.prenomAdmin = prenomAdmin;
	}

	@Column(name = "mailAdmin", nullable = false, length = 32)
	public String getMailAdmin() {
		return this.mailAdmin;
	}

	public void setMailAdmin(String mailAdmin) {
		this.mailAdmin = mailAdmin;
	}

	@Column(name = "mdpAdmin", nullable = false)
	public String getMdpAdmin() {
		return this.mdpAdmin;
	}

	public void setMdpAdmin(String mdpAdmin) {
		this.mdpAdmin = mdpAdmin;
	}

}