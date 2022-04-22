package com.hea.eztalk;


//import com.example.petstore.domain.Pet;
import com.hea.eztalk.domain.*;

import org.springframework.data.repository.CrudRepository;

public interface AccountServiceRepository extends CrudRepository<Pet, Long>{    // Repository Pattern Interface
  
}
