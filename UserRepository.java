package com.EcommerceApplication.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import com.EcommerceApplication.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Object findByUsername(String username);
   

	
}
