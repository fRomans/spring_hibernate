package hiber.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "number")
    String number;

    @Column(name = "series")
    int series;

    @OneToOne (mappedBy="car")  //optional=false,
     User user;

    public Car() {
    }

    public Car(String name,int series, String number) {
        this.name = name;
        this.series = series;
        this.number = number;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
            return  name ;
    }
}
