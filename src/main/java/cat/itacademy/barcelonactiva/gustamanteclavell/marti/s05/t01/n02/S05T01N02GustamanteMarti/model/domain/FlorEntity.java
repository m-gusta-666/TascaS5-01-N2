package cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="flor_entity")
public class FlorEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int florID;
	
	
	@Column(name="nomFlor")
	private String nomFlor;
	
	@Column(name="paisFlor")
	private String paisFlor;

	
	public FlorEntity() {
		
	}

	public FlorEntity(int florID, String nomFlor, String paisFlor) {
	
		this.florID = florID;
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
	}

	public int getFlorID() {
		return florID;
	}

	public void setFlorID(int florID) {
		this.florID = florID;
	}

	public String getNomFlor() {
		return nomFlor;
	}

	public void setNomFlor(String nomFlor) {
		this.nomFlor = nomFlor;
	}

	public String getPaisFlor() {
		return paisFlor;
	}

	public void setPaisFlor(String paisFlor) {
		this.paisFlor = paisFlor;
	}

	@Override
	public String toString() {
		return "FlorEntity [florID=" + florID + ", nomFlor=" + nomFlor + ", paisFlor=" + paisFlor + "]";
	}
	
	
	
	
}
