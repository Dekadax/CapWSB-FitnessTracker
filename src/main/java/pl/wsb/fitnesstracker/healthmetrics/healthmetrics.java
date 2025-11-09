package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

@Entity
@Table(name="health_metrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class healthmetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "height", nullable = false)
    private int height;

    @Column(name = "heartrate") // If the user does not a heart rate band
    private int heartrate;
    //Working  6 pass
    public healthmetrics(LocalDate date, int weight, int height, int heartrate) {
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.heartrate = heartrate;
    }
}
