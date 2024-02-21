package sem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private  String author;
     private  String title;
     @ManyToOne
     @JoinColumn(name = "reader_id")
     private  Reader reader;
}
