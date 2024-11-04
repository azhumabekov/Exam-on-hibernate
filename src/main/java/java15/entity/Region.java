package java15.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "regions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regionName;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Bank> banks = new HashSet<>();

    public Region(String regionName, Set<Bank> banks) {
        this.regionName = regionName;
        this.banks = banks;
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }
}