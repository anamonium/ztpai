package com.project.marimay.service;

import com.project.marimay.dto.request.AddGuestRequest;
import com.project.marimay.models.GuestList;
import com.project.marimay.models.Guests;
import com.project.marimay.repository.GuestListRepository;
import com.project.marimay.repository.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;

@AllArgsConstructor
@Service
public class GuestlistService {

    private GuestListRepository guestListRepository;
    private GuestRepository guestRepository;
    private JwtService jwtService;

    public List<Guests> getGuestList(String token){
        String username = jwtService.extractUsername(token.substring(7));
        GuestList guestList = guestListRepository.findByIdEquals(username).orElse(null);
        return guestRepository.findGuestsByGuestListEquals(guestList);
    }

    public UUID addGuest(String token, AddGuestRequest request){
        String username = jwtService.extractUsername(token.substring(7));
        GuestList guestList = guestListRepository.findByIdEquals(username).orElse(null);

        var guest = Guests.builder()
                .guestList(guestList)
                .name(request.getFirstName())
                .surname(request.getLastName())
                .phone(request.getPhone())
                .status(false)
                .plusOne(false)
                .build();

        guestRepository.save(guest);

        guestList.setInvited(guestList.getInvited() + 1);
        guestListRepository.save(guestList);

        return guest.getId();
    }

    public void changePlusOne(UUID guestId){
        Guests guest = guestRepository.findGuestById(guestId).orElse(null);
        GuestList guestList = guest.getGuestList();

        int invited = guest.getPlusOne() ? -1: 1;
        int accepted = guest.getStatus() ? (guest.getPlusOne() ? -1 : 1) : 0;

        guest.setPlusOne(!guest.getPlusOne());
        guestRepository.save(guest);

        guestList.setInvited(guestList.getInvited() + invited);
        guestList.setAccepted(guestList.getAccepted() + accepted);
        guestListRepository.save(guestList);
    }

    public void changeStatus(UUID guestId){
        Guests guest = guestRepository.findGuestById(guestId).orElse(null);
        GuestList guestList = guest.getGuestList();

        int accepted = guest.getStatus() ? (guest.getPlusOne() ? -2 : -1) : (guest.getPlusOne() ? 2 : 1);

        guest.setStatus(!guest.getStatus());
        guestRepository.save(guest);

        guestList.setAccepted(guestList.getAccepted() + accepted);
        guestListRepository.save(guestList);
    }

    public void deleteGuest(UUID guestId){
        Guests guest = guestRepository.findGuestById(guestId).orElse(null);
        GuestList guestList = guest.getGuestList();

        int accepted = guest.getStatus() ? (guest.getPlusOne() ? -2 : -1) : 0;
        int invited = guest.getPlusOne() ? -2 : -1;

        guestList.setInvited(guestList.getInvited() + invited);
        guestList.setAccepted(guestList.getAccepted() + accepted);
        guestListRepository.save(guestList);

        guestRepository.delete(guest);
    }
}
