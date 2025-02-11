package kz.aitu.restpro2422.restpro.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor  // Добавлен конструктор без параметров
@AllArgsConstructor // Добавлен конструктор со всеми параметрами
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(unique = true, nullable = false)
    private String customer;

    private int loan;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customers;

    public Bank(int id, String customer, int loan) {
        this.id = id;
        this.customer = customer;
        this.loan = loan;
    }
}