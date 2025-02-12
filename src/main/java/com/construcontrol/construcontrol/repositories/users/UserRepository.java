package com.construcontrol.construcontrol.repositories.users;

import com.construcontrol.construcontrol.model.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Query("SELECT u FROM User u WHERE u.email LIKE%:email%")
  UserDetails findByEmail(@Param("email") String email);

}
