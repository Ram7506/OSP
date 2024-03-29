package com.providerService.Repository;

import com.providerService.Model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Long> {

    Provider findByUserName(String username);

}
