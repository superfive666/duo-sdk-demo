package com.example.demo.service;

import io.github.superfive666.duosdk.annotation.DuoSecured;
import io.github.superfive666.duosdk.auth.DuoSecurity;
import io.github.superfive666.duosdk.error.DuoInvalidArgumentException;
import io.github.superfive666.duosdk.error.DuoNetworkException;
import io.github.superfive666.duosdk.error.DuoRejectedException;
import io.github.superfive666.duosdk.error.DuoTimeoutException;
import io.github.superfive666.duosdk.params.DuoAuthenticationMode;
import io.github.superfive666.duosdk.params.request.Auth;
import io.github.superfive666.duosdk.params.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyService {
    private final DuoSecurity duoSecurity;

    public void testAutoWired(Auth auth, String value) {
        try {
            AuthResponse response = duoSecurity.auth(auth);
        } catch (DuoInvalidArgumentException ex) {
            log.error("DUO invalid argument", ex);
        } catch (DuoTimeoutException ex) {
            log.error("DUO timeout", ex);
        } catch (DuoRejectedException ex) {
            log.error("DUO rejected", ex);
        } catch (DuoNetworkException ex) {
            log.error("DUO Network error", ex);
        }

        log.info("Operations after the DUO is approved - {}", value);
    }

    @DuoSecured(type = "就是看看中文可不可以", mode = DuoAuthenticationMode.PUSH)
    public void testAnnotation(Auth auth, String value) {
        log.info("Operations after the DUO is approved - {}", value);
    }

    @DuoSecured
    public void testAnnotation2(Auth auth, String value) {
        log.info("Operations after the DUO is approved - {}", value);
    }
}
