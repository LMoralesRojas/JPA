package JPA.Aplication;

import JPA.Aplication.entidades.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class AplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicationApplication.class, args);
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	try{
		entityManager.getTransaction().begin();

		//Cliente cliente = new Cliente("Pepe", "Sancho",2345678);
		//Domicilio domicilio = new Domicilio("Algarrovo",1200);
		//cliente.setDomicilio(domicilio);
		//domicilio.setCliente(cliente);

		//Metodo de declaracion bidireccional

		Domicilio dom = entityManager.find(Domicilio.class, 1L);
		Cliente cliente = entityManager.find(Cliente.class, 1L);

		Factura factura1 = new Factura();

		factura1.setNumero(12);
		factura1.setFecha("10/08/2020");

		Domicilio domicilio1 = new Domicilio("San Martin", 1222);
		Cliente cliente1 = new Cliente ("Pablo", "Muñoz", 15245778);
		cliente1.setDomicilio(domicilio1);
		domicilio1.setCliente(cliente1);

		factura1.setCliente(cliente1);

		Categoria perecederos = new Categoria("Perecedero");
		Categoria lacteos =  new Categoria("Lacteos");
		Categoria limpieza = new Categoria("Limpieza");

		Articulo art1 =  new Articulo(200, 1000, "Yogurt Ser sabor Frutilla");
		Articulo art2 =  new Articulo(300, 1500, "Detergente Magistral");

		art2.getCategorias().add(perecederos);
		art2.getCategorias().add(lacteos);
		lacteos.getArticulos().add(art1);
		perecederos.getArticulos().add(art1);

		art2.getCategorias().add(limpieza);
		limpieza.getArticulos().add(art2);

		DFactura det1 = new DFactura();

		det1.setArticulo(art1);
		det1.setCantidad(2);
		det1.setSubtotal(40);

		art1.getDFacturas().add(det1);
		factura1.getDetalles().add(det1);
		det1.setFactura(factura1);

		DFactura det2 = new DFactura();

		det2.setArticulo(art2);
		det2.setCantidad(1);
		det2.setSubtotal(80);

		art2.getDFacturas().add(det2);
		factura1.getDetalles().add(det2);
		det2.setFactura(factura1);

		factura1.setTotal(120);

		entityManager.persist(factura1);

		System.out.println("Cliente de domicilio" + dom.getCliente().getDni());
		System.out.println("Domicilio de cliente" + cliente.getDomicilio().getNombreCalle());


		entityManager.persist(cliente);
		entityManager.getTransaction().commit();


	}catch(Exception e){
		entityManager.getTransaction().rollback();
	}
	entityManager.close();
	entityManagerFactory.close();
   }
}
