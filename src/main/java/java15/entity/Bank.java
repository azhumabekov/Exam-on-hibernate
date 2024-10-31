package java15.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "banks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @ManyToMany(mappedBy = "banks", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Client> clients = new HashSet<>();

    @ManyToOne
    private Region region;

    public Bank(String name, String address, Set<Client> clients, Region region) {
        this.name = name;
        this.address = address;
        this.clients = clients;
        this.region = region;
    }
}