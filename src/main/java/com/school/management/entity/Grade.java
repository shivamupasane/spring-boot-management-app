package com.school.management.entity;
import com.school.management.validation.Score;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="grade", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Score(message = "Score can only be alphabet")
    @Column(name="score", nullable = false)
    private String score;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id", name="student_id")
    private Student student;
    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id", name="course_id")
    private Course course;
}
