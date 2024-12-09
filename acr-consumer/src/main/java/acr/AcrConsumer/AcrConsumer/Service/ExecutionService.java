package acr.AcrConsumer.AcrConsumer.Service;

import acr.AcrConsumer.AcrConsumer.models.Execution;
import acr.AcrConsumer.AcrConsumer.repositories.ExecutionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExecutionService {

	private final ExecutionRepository repository;

	public Execution fromString(String message) {
		log.info("ExecutionService::fromString Id: {} doesn't exist", message);
		return new Execution();
	}

	public List<Execution> getAll() {
		log.info("ExecutionService::getAll");
		return repository.findAll();
	}

	public Execution getById(Long id) {
		log.info("ExecutionService::getById Id: {}", id);
		Optional<Execution> optionalExecution = repository.findById(id);
		if(optionalExecution.isPresent()){
			return optionalExecution.get();
		}

		log.info("ExecutionService::getById Id: {} doesn't exist", id);
		return null;
	}

	public Execution save(String message) {
		log.info("ExecutionService::save");
		return save(fromString(message));
	}

	public Execution save(Execution execution) {
		log.info("ExecutionService::save Id: {} DhRequest: {}", execution.getId(), execution.getDhRequest());
		execution.setDhRequest(LocalDateTime.now());
		Execution savedExecution = repository.save(execution);

		log.info("Id: {} saved successfully", execution.getId());
		return savedExecution;
	}

	public Execution update(Execution execution) {
		log.info("ExecutionService::update Id: {} DhRequest: {}", execution.getId(), execution.getDhRequest());
		Optional<Execution> existingExecution = repository.findById(execution.getIdProject());

		if (existingExecution.isPresent()) {
			execution.setIdProject(existingExecution.get().getIdProject());
			execution.setDhRequest(existingExecution.get().getDhRequest());
		}

		Execution newExecution = repository.save(execution);

		log.info("ExecutionService::update Id: {} updated successfully", execution.getId());
		return newExecution;
	}

	public void deleteById(Long id) {
		log.info("ExecutionService::deleteById Id: {}", id);
		repository.deleteById(id);
		log.info("ExecutionService::deleteById");
	}

}