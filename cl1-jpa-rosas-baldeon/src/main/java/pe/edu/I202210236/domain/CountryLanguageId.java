package pe.edu.I202210236.domain;
import java.io.Serializable;
public class CountryLanguageId implements Serializable {
    private String country; // Este es el código del país
    private String language;

    // Constructor vacío
    public CountryLanguageId() {}

    public CountryLanguageId(String country, String language) {
        this.country = country;
        this.language = language;
    }
    // Getters y Setters
    public String getCountryCode() {
        return country;
    }
    public void setCountryCode(String countryCode) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    // equals y hashCode para comparar los Ids correctamente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return country.equals(that.country) && language.equals(that.language);
    }

    @Override
    public int hashCode() {
        return country.hashCode() + language.hashCode();
    }
}