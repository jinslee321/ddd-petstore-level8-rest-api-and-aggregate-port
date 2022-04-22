package com.hea.eztalk;


//import com.example.petstore.domain.*;
import com.hea.eztalk.domain.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@SpringBootApplication
@RestController
public class AccountServiceApplication {

	public static ApplicationContext applicationContext;
	public static void main(String[] args) {

		Pet pet = new Dog();

		System.out.println("energy is " + pet.getEnergy());

		pet.eat();
		System.out.println("energy is " + pet.getEnergy());

		pet.sleep();
		System.out.println("energy is " + pet.getEnergy());

		applicationContext = SpringApplication.run(AccountServiceApplication.class, args);
	}


	


	@Autowired
	AccountServiceRepository accountServiceRepository;



	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/feed")
	public String feed(@PathVariable(value = "petId") Long petId){

		Pet thePet = accountServiceRepository.findById(petId).get();

		thePet.eat();

		accountServiceRepository.save(thePet);

		return "맛있는 거 먹였습니다.";
	}


	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/groom")
	public String groom(@PathVariable(value = "petId") Long petId){
		Pet thePet = accountServiceRepository.findById(petId).get();

		if(thePet instanceof Groomable){
			String message = ((Groomable)thePet).grooming();
			accountServiceRepository.save(thePet);
			return message;
		}

		return "그루밍이 불가능한 Pet 입니다";
	}

	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/groom")
	public String groomCat(@PathVariable(value = "petId") Long petId){
		return groom(petId);
	}


	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/feed")
	public String feedCat(@PathVariable(value = "petId") Long petId){
		return feed(petId);
	}

	@RequestMapping(method = RequestMethod.PUT, path="dogs/{petId}/feed")
	public String feedDog(@PathVariable(value = "petId") Long petId){
		return feed(petId);
	}

}
