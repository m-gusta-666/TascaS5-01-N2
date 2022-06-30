package cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.services;

import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.dto.FlorDTO;

public class Mapper {

	
	public static FlorDTO toDTO(FlorEntity flor) {
		return new FlorDTO(flor.getFlorID(),flor.getNomFlor(),flor.getPaisFlor());
	}
	
	
	public static FlorEntity toFlor(FlorDTO florDTO) {
		return new FlorEntity(florDTO.getFlorID(),florDTO.getNomFlor(),florDTO.getPaisFlor());
	}
}
