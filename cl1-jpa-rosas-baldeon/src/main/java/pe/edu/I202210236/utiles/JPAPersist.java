package pe.edu.I202210236.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202210236.domain.*;

import java.util.HashSet;
import java.util.Set;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mundo");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Crear el país imaginario
        Country imaginaryCountry = new Country(
                "IMR",
                "Imaginaria",
                Country.Continent.ASIA,
                "Surreal Region",
                12345.67,
                (short) 2024,  // Asegúrate de que el año sea tipo Short
                5000000,
                85.5,
                100000.0,
                120000.0,
                "Imaginense",
                "Monarquía Surrealista",
                "Rey Atlántico",
                1,  // Usar un ID numérico para la capital, si es necesario
                "IM"
        );

        // Crear ciudades (usando el constructor adecuado para City)
        City city1 = new City("Ciudad Fantasía", imaginaryCountry, "Distrito Alpha", 1000000);
        City city2 = new City("Ciudad Sueños", imaginaryCountry, "Distrito Beta", 750000);
        City city3 = new City("Ciudad Imaginación", imaginaryCountry, "Distrito Gamma", 500000);

        // Asignar las ciudades al país (si la relación en Country está definida correctamente)
        Set<City> cities = new HashSet<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        imaginaryCountry.setCities(cities);  // Asegúrate de que este método esté disponible en la clase Country

        // Crear lenguajes nativos
        Countrylanguage lang1 = new Countrylanguage(imaginaryCountry, "Surrealés", Countrylanguage.OfficialStatus.TRUE, 70.0);
        Countrylanguage lang2 = new Countrylanguage(imaginaryCountry, "Fantásico", Countrylanguage.OfficialStatus.FALSE, 30.0);

        // Persistir entidades
        em.persist(imaginaryCountry);  // Persistir el país
        em.persist(city1);  // Persistir las ciudades
        em.persist(city2);
        em.persist(city3);
        em.persist(lang1);  // Persistir los lenguajes
        em.persist(lang2);

        // Confirmar la transacción
        em.getTransaction().commit();

        // Cerrar el EntityManager y EntityManagerFactory
        em.close();
        emf.close();

        System.out.println("País imaginario, sus ciudades y lenguajes se han registrado correctamente.");
    }
}