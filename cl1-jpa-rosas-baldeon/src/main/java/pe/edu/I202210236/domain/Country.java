package pe.edu.I202210236.domain;

import jakarta.persistence.*;


import java.util.List;
import java.util.Set;


@Entity
@Table(name = "country")
public class Country {
    public enum Continent {
        ASIA("Asia"),
        EUROPE("Europe"),
        NORTH_AMERICA("North America"),
        AFRICA("Africa"),
        OCEANIA("Oceania"),
        ANTARCTICA("Antarctica"),
        SOUTH_AMERICA("South America");

        private final String dbValue;

        Continent(String dbValue) {
            this.dbValue = dbValue;
        }

        public String getDbValue() {
            return dbValue;
        }

        public static Continent fromDbValue(String dbValue) {
            for (Continent continent : Continent.values()) {
                if (continent.dbValue.equalsIgnoreCase(dbValue)) {
                    return continent;
                }
            }
            throw new IllegalArgumentException("Unknown database value: " + dbValue);
        }
    }
    @Converter(autoApply = true)
    public static class ContinentConverter implements AttributeConverter<Continent, String> {

        public ContinentConverter() {}

        @Override
        public String convertToDatabaseColumn(Continent attribute) {
            return attribute == null ? null : attribute.getDbValue();
        }

        @Override
        public Continent convertToEntityAttribute(String dbData) {
            return Continent.fromDbValue(dbData);
        }
    }
    @Id
    @Column(name = "Code",nullable = false, length = 3)
    private String code;

    @Column(name = "Name")
    private String name;

    @Convert(converter = ContinentConverter.class)

    @Column(name = "Continent",nullable = false)
    private Continent continent;

    @Column(name = "Region")
    private String region;

    @Column(name = "SurfaceArea")
    private double surfaceArea;

    @Column(name = "IndepYear")
    private Short indepYear;

    @Column(name = "Population")
    private int population;

    @Column(name = "LifeExpectancy")
    private double lifeExpectancy;

    @Column(name = "GNP")
    private double gnp;

    @Column(name = "GNPOld")
    private double gnpOld;

    @Column(name = "LocalName")
    private String localName;

    @Column(name = "GovernmentForm")
    private String governmentForm;

    @Column(name = "HeadOfState")
    private String headOfState;

    @Column(name = "Capital")
    private int capital;

    @Column(name = "Code2")
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities;

    @OneToMany(mappedBy = "country")
    private List<Countrylanguage> languages;

    // Constructor vacío
        public Country() {
        }

        // Constructor con llave primaria
        public Country(String code) {
            this.code = code;
        }

        // Constructor completo
        public Country(String code, String name, Continent continent, String region, double surfaceArea,
                       Short indepYear, int population, double lifeExpectancy, double gnp, double gnpOld,
                       String localName, String governmentForm, String headOfState, int capital, String code2) {
            this.code = code;
            this.name = name;
            this.continent = continent;
            this.region = region;
            this.surfaceArea = surfaceArea;
            this.indepYear = indepYear;
            this.population = population;
            this.lifeExpectancy = lifeExpectancy;
            this.gnp = gnp;
            this.gnpOld = gnpOld;
            this.localName = localName;
            this.governmentForm = governmentForm;
            this.headOfState = headOfState;
            this.capital = capital;
            this.code2 = code2;
        }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", indepYear=" + indepYear +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", gnp=" + gnp +
                ", gnpOld=" + gnpOld +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", capital='" + capital + '\'' +
                ", code2='" + code2 + '\'' +
                '}';
    }
        // Getters y Setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {  // Cambiado para aceptar un enum
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(double gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public List<Countrylanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Countrylanguage> languages) {
        this.languages = languages;
    }
}


