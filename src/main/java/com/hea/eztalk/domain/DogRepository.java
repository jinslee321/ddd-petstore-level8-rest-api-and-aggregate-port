package com.hea.eztalk.domain;

import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long>{    // Repository Pattern Interface
  
}