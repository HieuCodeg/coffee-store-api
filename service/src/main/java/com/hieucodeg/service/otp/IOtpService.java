package com.hieucodeg.service.otp;


import com.hieucodeg.domain.entity.Otp;
import com.hieucodeg.service.IGeneralService;

import java.util.Optional;


public interface IOtpService extends IGeneralService<Otp> {

    Optional<Otp> getOtpByUserId(Long userId);

    Otp getByCode(String code);

    void softDelete(Long otpId);
}
