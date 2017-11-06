package com.instrumentisto.timebot.repository;

import com.instrumentisto.timebot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for user's repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Searches {@link User} in repository by ID.
     *
     * @param apiId apiId by which need to search user.
     * @return {@link User} value.
     */
    User findByApiId(String apiId);
}
