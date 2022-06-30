package cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.exceptions.*;
import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.repository.FlorEntityRepository;

@Service
public class FlorEntityService {

	@Autowired
	FlorEntityRepository florRepository;

	public List<FlorDTO> getAll() {
		List<FlorEntity> flors = florRepository.findAll();

		if (flors.isEmpty()) {
			throw new SenseFlorsException();
		} else {
			return flors.stream().map(Mapper::toDTO).collect(Collectors.toList());
		}

	}

	public FlorEntity getOne(int id) {
		return florRepository.findById(id).orElseThrow(FlorNoTrobadaException::new);
	}

	public FlorDTO getOneDTO(int id) {
		FlorEntity flor = florRepository.findById(id).orElseThrow(FlorNoTrobadaException::new);
		return Mapper.toDTO(flor);
	}

	public FlorDTO add(FlorEntity flor) {

		if (flor == null) {
			throw new SenseCosException();
		} else {
			florRepository.save(flor);
			return Mapper.toDTO(flor);
		}

	}

	public void delete(int id) {
		FlorEntity flor = florRepository.findById(id).orElseThrow(FlorNoTrobadaException::new);
		florRepository.deleteById(id);
	}

	public FlorDTO updateOne(int id, FlorEntity flor) {
		if (flor == null) {
			throw new SenseCosException();
		} else {
			Optional<FlorEntity> florOp = florRepository.findById(id);
			if (florOp.isPresent()) {
				FlorEntity florActualitzar = florOp.get();
				florActualitzar.setNomFlor(flor.getNomFlor());
				florActualitzar.setPaisFlor(flor.getPaisFlor());
				return Mapper.toDTO(florRepository.save(florActualitzar));
			} else {
				throw new FlorNoTrobadaException();
			}
		}
	}
}
