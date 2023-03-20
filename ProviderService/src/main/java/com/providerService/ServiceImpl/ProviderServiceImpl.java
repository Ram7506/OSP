package com.providerService.ServiceImpl;

import com.providerService.Repository.ProviderRepository;
import com.providerService.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.providerService.Model.Provider;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {


    @Autowired
    private ProviderRepository providerRepository;


    @Override
    public Provider add(Provider provider) {
        return this.providerRepository.save(provider);
    }

    @Override
    public Optional<Provider> getUserById(long providerId) {
        return providerRepository.findById(providerId);
    }

    @Override
    public String updateUserById(Provider provider, long providerId) {

        Optional<Provider> oldProvider = getUserById(providerId);

        if (oldProvider.isPresent() && oldProvider.get().getProviderId() == providerId) {
            Provider newProvider = oldProvider.get();
            newProvider.setPassword(provider.getPassword());
            newProvider.setEmail(provider.getEmail());
            newProvider.setAddress(provider.getAddress());
            newProvider.setPhoneNo(provider.getPhoneNo());
            newProvider.setRole(provider.getRole());
            newProvider.setProviderName(provider.getProviderName());
            newProvider.setUserName(provider.getUserName());
            providerRepository.save(newProvider);
            return "Provider Updated....";
        }
        else
            return "Something went wrong...!!!";
    }
}
