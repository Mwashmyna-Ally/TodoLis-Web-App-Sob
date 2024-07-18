package com.mwashmyner.mwashmyner.repository;

import com.mwashmyner.mwashmyner.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
