package com.ikbal.springboot.web.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ikbal.springboot.web.model.User;

/*
The Data Access Object (DAO) pattern is a structural pattern that allows us to isolate
the application/business layer from the persistence layer (usually a relational database
but could be any other persistence mechanism) using an abstract API.
The API hides from the application all the complexity of performing CRUD operations in the underlying storage mechanism.*/

/*
 The CrudRepository provides sophisticated CRUD functionality for the entity class that is being managed.
1 Saves the given entity.
2 Returns the entity identified by the given id.
3 Returns all entities.
4 Returns the number of entities.
5 Deletes the given entity.
6 Indicates whether an entity with the given id exists.

*/
/*Spring Data JPA provides repository support for the Java Persistence API (JPA).
It eases development of applications that need to access JPA data sources.
The goal of the Spring Data repository abstraction is to significantly
reduce the amount of boilerplate code required to implement data access layers for various persistence stores.
The central interface in the Spring Data repository abstraction is Repository.
 It takes the domain class to manage as well as the ID type of the domain class as type arguments.
  This interface acts primarily as a marker interface to capture the types to work with and to help you to
  discover interfaces that extend this one. The CrudRepository interface provides sophisticated CRUD functionality
  for the entity class that is being managed.
*/
public interface UserRepository extends CrudRepository<User, Long>{

	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
}
