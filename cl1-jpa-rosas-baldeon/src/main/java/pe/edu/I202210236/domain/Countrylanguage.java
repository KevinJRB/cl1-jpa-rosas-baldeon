package pe.edu.I202210236.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;



@Entity
@Table(name = "countrylanguage")
@IdClass(CountryLanguageId.class)
public class Countrylanguage {

    public enum OfficialStatus {
        TRUE("T"),
        FALSE("F");

        private final String databaseValue;

        OfficialStatus(String databaseValue) {
            this.databaseValue = databaseValue;
        }

        public String getDatabaseValue() {
            return databaseValue;
        }

        public static OfficialStatus fromDatabaseValue(String value) {
            for (OfficialStatus status : values()) {
                if (status.databaseValue.equals(value)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid value for OfficialStatus: " + value);
        }
    }
    @Id
    @ManyToOne
    @JoinColumn(name = "Countrycode", referencedColumnName = "Code")
    private Country country;

    @Id
    @Column(name = "Language")
    private String language;

    @Convert(converter = OfficialStatusConverter.class)
    @Column(name = "IsOfficial")
    private OfficialStatus isOfficial;

    @Column(name = "Percentage")
    private double percentage;

    // Constructor vacío

    public Countrylanguage() {

    }

    // Constructor completo
    public Countrylanguage(Country country, String language, OfficialStatus isOfficial, double percentage) {
        this.country = country;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "countryCode='" + country.getCode() + '\'' +
                ", language='" + language + '\'' +
                ", isOfficial=" + isOfficial +
                ", percentage=" + percentage +
                '}';
    }

    // Getters y Setters
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public OfficialStatus isOfficial() {
        return isOfficial;
    }

    public void setOfficial(OfficialStatus official) {
        isOfficial = official;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }



    public static class OfficialStatusConverter implements AttributeConverter<OfficialStatus, String> {
        public OfficialStatusConverter() {
        }

        @Override
        public String convertToDatabaseColumn(OfficialStatus attribute) {
            return attribute != null ? attribute.getDatabaseValue() : null;
        }

        @Override
        public OfficialStatus convertToEntityAttribute(String dbData) {
            return dbData != null ? OfficialStatus.fromDatabaseValue(dbData) : null;
        }
    }
}