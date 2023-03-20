package com.providerService.Service;

import com.providerService.Model.Provider;

import java.util.Optional;
import java.util.Set;

public interface ProviderService {

    public Provider add(Provider provider);

    Optional<Provider> getUserById(long providerId);

    String updateUserById(Provider newProvider,long providerId);
}
