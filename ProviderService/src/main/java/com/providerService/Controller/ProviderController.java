package com.providerService.Controller;

import com.providerService.Model.Provider;
import com.providerService.Service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProviderController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private ProviderService providerService;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "This is Test Method";
    }


    // To register Provider
    @PostMapping("/sign")
    public ResponseEntity<Provider> saveProvider(@RequestBody Provider provider) {
        try {
            providerService.add(provider);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Exception --> " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // To update the provider by ID
    @PutMapping("/updateProviderById/{providerId}")
    public ResponseEntity<String> updateProvider(@RequestBody Provider provider, @PathVariable("providerId") long providerId) {
        try {
            String msg = providerService.updateUserById(provider, providerId);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

