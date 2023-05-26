package com.javatechie.mongo;

import com.javatechie.mongo.entity.Seller;
import com.javatechie.mongo.repository.BookRepository;
import com.javatechie.mongo.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.javatechie.mongo.entity.Seller.*;

@SpringBootApplication
@RestController
public class MongoAutoSequenceExampleApplication {

	@Autowired
	private BookRepository repository;

	@Autowired
	private SequenceGeneratorService service;

	@PostMapping("/save")
	public Seller save(@RequestBody Seller seller){
		//generate sequence
		seller.setId(service.getSequenceNumber(SEQUENCE_NAME));
		return repository.save(seller);
	}

	@GetMapping("/sellers")
	public List<Seller> getAllSellers(){
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(MongoAutoSequenceExampleApplication.class, args);
	}

}
