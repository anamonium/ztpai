package com.project.marimay.service;

import com.project.marimay.dto.request.AuthenticationRequest;
import com.project.marimay.dto.request.RegisterRequest;
import com.project.marimay.dto.response.AuthenticationResponse;
import com.project.marimay.models.*;
import com.project.marimay.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final WeddingDetailsRepository weddingDetailsRepository;
    private final BudgetRepository budgetRepository;
    private final GuestListRepository guestRepository;
    private final ChecklistRepository checklistRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElse(null);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Users.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        var userDet = UsersDetails.builder()
                .user(user)
                .name(request.getFirstName())
                .surname(request.getLastName())
                .phone(request.getPhone())
                .build();
        userDetailsRepository.save(userDet);

        var weddingDet = WeddingDetails.builder()
                .user(user)
                .build();

        weddingDetailsRepository.save(weddingDet);

        var budget = Budget.builder()
                .weddingDetails(weddingDet)
                .budgetSpend(0.0)
                .build();

        budgetRepository.save(budget);

        var guestlist = GuestList.builder()
                .weddingDetails(weddingDet)
                .accepted(0)
                .invited(0)
                .build();

        guestRepository.save(guestlist);

        var checklist = Checklist.builder()
                .weddingDetails(weddingDet)
                .allSubtask(0)
                .subtaskDone(0)
                .build();

        checklistRepository.save(checklist);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }

    public void savUs(Users u){
        userRepository.save(u);
    }

    public Users getByEm(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

    public void changeWeddingDate(Users user, LocalDate newDate){
        WeddingDetails wd = weddingDetailsRepository.findById(user.getId()).orElse(null);
        wd.setWeddingDate(newDate);
        weddingDetailsRepository.save(wd);
    }

    public void changeBudget(Users user, Double newBudget){
        WeddingDetails wd = weddingDetailsRepository.findById(user.getId()).orElse(null);
        wd.setWeddingBudget(newBudget);
        weddingDetailsRepository.save(wd);
    }
}
