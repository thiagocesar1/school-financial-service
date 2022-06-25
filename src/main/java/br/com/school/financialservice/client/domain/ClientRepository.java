package br.com.school.financialservice.client.domain;

import br.com.school.financialservice.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
