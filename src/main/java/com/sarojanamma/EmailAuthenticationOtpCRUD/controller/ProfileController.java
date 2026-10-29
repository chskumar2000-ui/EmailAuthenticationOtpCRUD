package com.sarojanamma.EmailAuthenticationOtpCRUD.controller;

import com.sarojanamma.EmailAuthenticationOtpCRUD.io.ProfileRequest;
import com.sarojanamma.EmailAuthenticationOtpCRUD.io.ProfileResponse;
import com.sarojanamma.EmailAuthenticationOtpCRUD.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProfileController {

      private final ProfileService profileService;

      @PostMapping("/register")
      @ResponseStatus(HttpStatus.CREATED)
      public ProfileResponse register(@Valid @RequestBody ProfileRequest request){
          ProfileResponse response= profileService.createProfile(request);

          return response;
      }
}
