package com.project.marimay.repository;

import com.project.marimay.models.GuestList;
import com.project.marimay.models.Guests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GuestRepository extends JpaRepository<Guests, String> {

    @Query("Select g from Guests g where g.guestList= ?1")
    List<Guests> findGuestsByGuestListEquals(
            GuestList guestList
    );

    @Query("select g from Guests g where g.id = ?1")
    Optional<Guests> findGuestById(UUID id);

}
