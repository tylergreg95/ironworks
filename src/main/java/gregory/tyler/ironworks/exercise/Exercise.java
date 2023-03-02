package gregory.tyler.ironworks.exercise;

import jakarta.persistence.*;

@Entity
@Table
public class Exercise {
    @Id
    @SequenceGenerator(
            name = "exercise_sequence",
            sequenceName = "exercise_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_sequence"
    )
    private Long id;
    private String name;
    private String muscleGroup;
    private String equipment;
    private String youtubeLink;
    private String imageLink;

    public Exercise() {
    }

    public Exercise(Long id, String name, String muscleGroup, String equipment, String youtubeLink, String imageLink) {
        this.id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.equipment = equipment;
        this.youtubeLink = youtubeLink;
        this.imageLink = imageLink;
    }

    public Exercise(String name, String muscleGroup, String equipment, String youtubeLink, String imageLink) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.equipment = equipment;
        this.youtubeLink = youtubeLink;
        this.imageLink = imageLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", muscleGroup='" + muscleGroup + '\'' +
                ", equipment='" + equipment + '\'' +
                '}';
    }
}
