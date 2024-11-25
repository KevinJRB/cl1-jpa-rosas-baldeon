package pe.edu.I202210236.utiles;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202210236.domain.Country;
import pe.edu.I202210236.domain.City;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mundo");
        EntityManager em = emf.createEntityManager();

        // Buscar el país por su código
        Country peru = em.find(Country.class, "PER");

        if (peru != null) {
            System.out.println("Ciudades peruanas con población > 700k:");
            peru.getCities().stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> System.out.println(" - " + city.getName()));
        } else {
            System.out.println("El país con código 'PER' no existe.");
        }

        em.close();
        emf.close();
    }
}
