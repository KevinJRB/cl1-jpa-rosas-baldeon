package pe.edu.I202210236.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private Country country;

    @Column(name = "District")
    private String district;

    @Column(name = "Population")
    private int population;

    public City() {}



    public City(String name, Country country, String district, int population) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }



    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + (country != null ? country.getCode() : "null") +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() { // Cambiado a devolver Country
        return country;
    }

    public void setCountry(Country country) { // Métodos del `Country`
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

