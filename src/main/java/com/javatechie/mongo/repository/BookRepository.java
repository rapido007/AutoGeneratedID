package com.javatechie.mongo.repository;

import com.javatechie.mongo.entity.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Seller,Integer> {
}
