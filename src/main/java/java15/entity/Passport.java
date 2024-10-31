package java15.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inn;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false) // Добавлено ограничение на null
    private Client client;

    public Passport(String inn, Client client) {
        this.inn = inn;
        this.client = client;
    }
}