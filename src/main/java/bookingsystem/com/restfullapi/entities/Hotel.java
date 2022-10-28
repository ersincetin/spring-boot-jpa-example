package bookingsystem.com.restfullapi.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@Table(name = "hotels")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private int status;
    @Column
    private String explanation;
    @Column
    private String created_at;
    @Column
    private String updated_at;
}
