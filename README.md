gsan-persistence
==========

Projeto contendo as entidades utilizadas pelo GSAN

Importar para o projeto cliente
------------
Adicione [gsan-persistence](https://github.com/prodigasistemas/gsan-persistence/) como dependência do projeto cliente:

	<dependency>
    	<groupId>br.gov</groupId>
    	<artifactId>gsan-persistence</artifactId>
    	<version>0.1</version>    	
	</dependency>

Como exemplo, temos o projeto [gsan-batch](https://github.com/prodigasistemas/gsan-batch/), contendo EJBs que acessam as entidades do gsan-persistente.

Usando as entidades
------------

Uma vez que as entidades e o persistence unit são importados pelo lib, basta injetar um contexto JPA em um EJB para realizar as transações:

	@Stateless
	public class MeuEJB{

		@PersistenceContext
		private EntityManager entity;
	}
