package com.EcommerceApplication.Repository;


import com.EcommerceApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
