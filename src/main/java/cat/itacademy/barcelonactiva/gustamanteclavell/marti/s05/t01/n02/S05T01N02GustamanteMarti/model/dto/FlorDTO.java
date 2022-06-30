package cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.dto;

import java.util.List;

import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.utils.Paisos;

public class FlorDTO {

	
	private int florID;
	private String nomFlor;
	private String paisFlor;
	private String tipusFlor;
	
	
	public FlorDTO(int florID, String nomFlor, String paisFlor) {
		
		
		this.florID = florID;
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
		
		List<String> paisosUE = Paisos.getLlistaUE();

		if (paisosUE.contains(paisFlor)) {
			tipusFlor = "UE";
		} else {
			tipusFlor = "Fora UE";
		}
		
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


	public String getTipusFlor() {
		return tipusFlor;
	}


	public void setTipusFlor(String tipusFlor) {
		this.tipusFlor = tipusFlor;
	}


	@Override
	public String toString() {
		return "FlorDTO [florID=" + florID + ", nomFlor=" + nomFlor + ", paisFlor=" + paisFlor + ", tipusFlor="
				+ tipusFlor + "]";
	}
	
	
	
	
	
	
	
}
