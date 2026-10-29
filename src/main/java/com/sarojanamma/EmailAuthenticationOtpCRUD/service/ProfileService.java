package com.sarojanamma.EmailAuthenticationOtpCRUD.service;

import com.sarojanamma.EmailAuthenticationOtpCRUD.io.ProfileRequest;
import com.sarojanamma.EmailAuthenticationOtpCRUD.io.ProfileResponse;

public interface ProfileService {

     ProfileResponse createProfile(ProfileRequest request);

}
