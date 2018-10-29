package access;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Dao <T>{
	protected EntityManager em; //pour gérer les objets
	
	public Dao(){
		//on ne peut pas directement créer un entity manager, il faut une factory
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("quizPU"); 
		//on trouve le nom dans le xml, <persistence-unit name="exoCDI_banqueJPA"....
		em=emf.createEntityManager(); //création de l'entity manager
	}

	public void write(T objetEntite) //utilisation de la généricité (pour récupérer des entités client, banque, compte... etc.
	{
		em.getTransaction().begin(); //debute la transaction, càd verrouille l'enregistrement
		em.persist(objetEntite); //enverra une commande "insert into"
		em.getTransaction().commit();//valide la transaction (enlève le verrou sur l'enregistrement en base)
	}
	
	public void update(T objetEntite)
	{
		em.getTransaction().begin();
		em.merge(objetEntite);
		em.getTransaction().commit();
	}
	
	public void delete(T objetEntite)
	{
		em.getTransaction().begin();
		try {
			T objettrouve=em.merge(objetEntite); //il met à jour l'objet et le retourne
			em.remove(objettrouve); //supprime l'objet de la base
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback(); //erreur, annulation de la transaction
		}
	}
}