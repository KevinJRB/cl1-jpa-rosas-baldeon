package pe.edu.I202210236.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202210236.domain.Country;
import jakarta.persistence.Query;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mundo");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Buscar el país por su código
        String countryCode = "IMR";  // Código del país a eliminar
        Country imaginaryCountry = em.find(Country.class, countryCode);

        if (imaginaryCountry != null) {
            // Eliminar los registros dependientes en la tabla countrylanguage
            Query query = em.createQuery("DELETE FROM Countrylanguage cl WHERE cl.country.code = :countryCode");
            query.setParameter("countryCode", countryCode);
            int deletedCount = query.executeUpdate();
            System.out.println("Se eliminaron " + deletedCount + " registros de CountryLanguage.");

            // Eliminar el país
            em.remove(imaginaryCountry);
            System.out.println("País imaginario y sus registros dependientes eliminados correctamente.");
        } else {
            System.out.println("El país imaginario no existe.");
        }

        // Confirmar la transacción
        em.getTransaction().commit();

        // Cerrar el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
    }
}