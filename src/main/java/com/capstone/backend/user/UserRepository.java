package com.capstone.backend.user;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByEmail( String email);

    @Query(value = "{ 'email' : ?0 }", fields = "{ 'name' : 1, '_id' : 0 }")
    String findNameByEmail(String email);
}
