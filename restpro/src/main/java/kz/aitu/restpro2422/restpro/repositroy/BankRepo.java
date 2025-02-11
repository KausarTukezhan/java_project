package kz.aitu.restpro2422.restpro.repository;

import kz.aitu.restpro2422.restpro.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<Bank, Integer> {
}