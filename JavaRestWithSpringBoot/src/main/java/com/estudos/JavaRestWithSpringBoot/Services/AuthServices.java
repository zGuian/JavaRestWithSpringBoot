package com.estudos.JavaRestWithSpringBoot.Services;

import com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.Security.AccountCredentialsVO;
import com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.Security.TokenVO;
import com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.UserVO;
import com.estudos.JavaRestWithSpringBoot.Mapper.DozerMapper;
import com.estudos.JavaRestWithSpringBoot.Models.User;
import com.estudos.JavaRestWithSpringBoot.Repository.UserRepository;
import com.estudos.JavaRestWithSpringBoot.Security.Jwt.JwtTokenProvider;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class AuthServices {
    private final Logger logger = Logger.getLogger(AuthServices.class.getName());

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public TokenVO signIn(AccountCredentialsVO data) {
        try {
            var username = data.getUserName();
            var password = data.getPassword();
            var user = userRepository.findByUserName(username);

            if (user == null) {
                throw new BadCredentialsException("Username: " + data.getUserName() + " not found!");
            }

            var dataPassword = user.getPassword();
            if (!passwordEncoder.matches(password, dataPassword)) {
                throw new BadCredentialsException("Invalid username/password supplied!");
            }

            var roles = user.getRoles();
            var tokenResponse = tokenProvider.createAccessToken(username, roles);
            logger.info("Criou token");
            return tokenResponse;
        } catch (Exception e) {
            logger.info("Caiu no catch");
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }

    public TokenVO refreshToken(String username, String refreshToken) {
        var user = userRepository.findByUserName(username);
        if (user == null) {
            throw new BadCredentialsException("Username: " + username + " not found!");
        }
        return tokenProvider.refreshToken(refreshToken);
    }

    public void register(UserVO userVO) {
        var passwordEncrypted = encryptedPassword(userVO.getPassword());
        var userEncrypted = new UserVO(userVO.getUsername(), passwordEncrypted, userVO.getFullName());
        var user = DozerMapper.parseObject(userEncrypted, User.class);
        userRepository.save(user);
    }

    private String encryptedPassword(String password) {
        var pbkdf2Encoder = new Pbkdf2PasswordEncoder("", 8, 185000,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("pbkdf2", pbkdf2Encoder);

        var passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
        return passwordEncoder.encode(password);
    }
}
