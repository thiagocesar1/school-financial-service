package br.com.school.financialservice.domain.repository;

import br.com.school.financialservice.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
