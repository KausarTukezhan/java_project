package kz.aitu.restpro2422.restpro.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aitu.restpro2422.restpro.entities.Account;
import kz.aitu.restpro2422.restpro.entities.Bank;
import kz.aitu.restpro2422.restpro.entities.Customer;
import kz.aitu.restpro2422.restpro.repository.AccountRepo;
import kz.aitu.restpro2422.restpro.repository.BankRepo;
import kz.aitu.restpro2422.restpro.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MainController {

    private final AccountRepo accountRepo;
    private final BankRepo bankRepo;
    private final CustomerRepo customerRepo;
    private final ObjectMapper objectMapper;

    // *** ACCOUNT (Account) ***
    @PostMapping("/account/add")
    public String addAccount(@RequestBody Account account) {
        try {
            accountRepo.save(account);
            return "Account added successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/account/all")
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @GetMapping("/account")
    public Optional<Account> getAccount(@RequestParam int id) {
        return accountRepo.findById(id);
    }

    @DeleteMapping("/account")
    public String deleteAccount(@RequestParam int id) {
        if (accountRepo.existsById(id)) {
            accountRepo.deleteById(id);
            return "Account deleted successfully!";
        }
        return "Account not found!";
    }

    @PutMapping("/account/update")
    public String updateAccount(@RequestBody Account account) {
        if (!accountRepo.existsById(account.getId())) {
            return "Account not found!";
        }
        accountRepo.save(account);
        return "Account updated successfully!";
    }

    // *** BANK (Bank) ***
    @PostMapping("/bank/add")
    public String addBank(@RequestBody Bank bank) {
        try {
            bankRepo.save(bank);
            return "Bank record added successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/bank/all")
    public List<Bank> getAllBanks() {
        return bankRepo.findAll();
    }

    @GetMapping("/bank")
    public Optional<Bank> getBank(@RequestParam int id) {
        return bankRepo.findById(id);
    }

    @DeleteMapping("/bank")
    public String deleteBank(@RequestParam int id) {
        if (bankRepo.existsById(id)) {
            bankRepo.deleteById(id);
            return "Bank record deleted successfully!";
        }
        return "Bank record not found!";
    }

    @PutMapping("/bank/update")
    public String updateBank(@RequestBody Bank bank) {
        if (!bankRepo.existsById(bank.getId())) {
            return "Bank record not found!";
        }
        bankRepo.save(bank);
        return "Bank record updated successfully!";
    }

    // *** CUSTOMER (Customer) ***
    @PostMapping("/customer/add")
    public String addCustomer(@RequestBody Customer customer) {
        try {
            customerRepo.save(customer);
            return "Customer added successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @GetMapping("/customer")
    public Optional<Customer> getCustomer(@RequestParam int id) {
        return customerRepo.findById(id);
    }

    @DeleteMapping("/customer")
    public String deleteCustomer(@RequestParam int id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
            return "Customer deleted successfully!";
        }
        return "Customer not found!";
    }

    @PutMapping("/customer/update")
    public String updateCustomer(@RequestBody Customer customer) {
        if (!customerRepo.existsById(customer.getId())) {
            return "Customer not found!";
        }
        customerRepo.save(customer);
        return "Customer updated successfully!";
    }
}
