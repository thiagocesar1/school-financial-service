package br.com.school.financialservice.domain.repository;

import br.com.school.financialservice.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
