package budhioct.dev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pendidikan")
public class Pendidikan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status")
    private String status;
    @Column(name = "time_create")
    private Timestamp timeAt;
    @ManyToOne
    @JoinColumn(name = "id_murid", referencedColumnName = "id")
    private Murid murid;
}
