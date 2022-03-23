package com.ikbal.springboot.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ikbal.springboot.web.model.Notes;

/*
 * CrudRepository mainly provides CRUD functions while JpaRepository provide some JPA related methods such as flushing the 
 * persistent context, deleting records in a batch. 
 */
		
@Repository
public interface NotesRepository extends CrudRepository<Notes, Long>{
}