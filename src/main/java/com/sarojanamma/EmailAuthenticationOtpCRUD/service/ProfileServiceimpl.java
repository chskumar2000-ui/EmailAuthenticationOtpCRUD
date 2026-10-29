package com.sarojanamma.EmailAuthenticationOtpCRUD.service;

import com.sarojanamma.EmailAuthenticationOtpCRUD.entity.UserEntity;
import com.sarojanamma.EmailAuthenticationOtpCRUD.io.ProfileRequest;
import com.sarojanamma.EmailAuthenticationOtpCRUD.io.ProfileResponse;
import com.sarojanamma.EmailAuthenticationOtpCRUD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceimpl implements ProfileService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
       UserEntity newProfile=convertTUseroEntity(request);
        if(!userRepository.existsByEmail(request.getEmail())){
            newProfile=userRepository.save(newProfile);
            return convertToProfileResponse(newProfile);
        }else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Eamil Already exists");
        }

    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
        return ProfileResponse.builder()
                .email(newProfile.getName())
                .name(newProfile.getName())
                .userId(newProfile.getUserId())
                .isAccountVerified(newProfile.getIsAccountVerfied())
                .build();

    }
       //toconvert request object into EntityObject
    private UserEntity convertTUseroEntity(ProfileRequest request) {
        return UserEntity.builder()
                .email(request.getEmail())
                .name(request.getName())
                .userId(UUID.randomUUID().toString())
                .password(passwordEncoder.encode(request.getPassword()))
                .isAccountVerfied(false)
                .restOtpExpireAt(0L)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .resetOtp(null)
                .build();
    }


}
