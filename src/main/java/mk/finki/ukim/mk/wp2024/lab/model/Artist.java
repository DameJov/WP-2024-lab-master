package mk.finki.ukim.mk.wp2024.lab.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
public class Artist {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;

    public Artist(String firstName, String lastName, String bio) {
        this.id = (long) (Math.random() * 1000);
        this.bio = bio;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Artist() {
        this.id = (long) (Math.random() * 1000);
    }
}
