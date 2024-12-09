package acr.AcrConsumer.AcrConsumer.repositories;

import acr.AcrConsumer.AcrConsumer.models.Execution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutionRepository extends JpaRepository<Execution, Long> {}
