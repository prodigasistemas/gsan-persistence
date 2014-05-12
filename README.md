gsan-persistence
==========

Projeto contendo as entidades utilizadas pelo GSAN

Provider
-------------
Importante destacar que este projeto adota a versão pós 4.0 do Hibernate Core Provider:

	org.hibernate.jpa.HibernatePersistenceProvider

Importar para o projeto cliente
------------
Após o clone, crie a lib do projeto no seu repositório maven:

	mvn install

Em seguida, adicione [gsan-persistence](https://github.com/prodigasistemas/gsan-persistence/) como dependência do projeto cliente:

	<dependency>
    	<groupId>br.gov</groupId>
    	<artifactId>gsan-persistence</artifactId>
    	<version>0.1</version>    	
	</dependency>

Também configure o hibernate core:

	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-core</artifactId>
		<version>4.3.5.Final</version>
	</dependency>

O projeto [gsan-batch](https://github.com/prodigasistemas/gsan-batch/) possui EJBs que acessam as entidades do gsan-persistente.

Usando as entidades
------------

Uma vez que as entidades e o persistence unit são importados pelo lib, basta injetar um contexto JPA em um EJB para realizar as transações:

	@Stateless
	public class MeuEJB{

		@PersistenceContext
		private EntityManager entity;
	}
