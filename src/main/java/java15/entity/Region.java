package java15.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "regions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regionName;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private Set<Bank> banks = new HashSet<>();

    public Region(String regionName, Set<Bank> banks) {
        this.regionName = regionName;
        this.banks = banks;
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }
}