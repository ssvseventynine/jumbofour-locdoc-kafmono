package com.sidhant.jumbofour.repository;

// This import is now required because they are in different packages!
import com.sidhant.jumbofour.model.LocDocMessage; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocDocMessageRepository extends JpaRepository<LocDocMessage, Long> {
}