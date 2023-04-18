package com.project.marimay.repository;

import com.project.marimay.models.Guests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guests, String> {

    @Query("Select g FROM Guests g where g.idGuestlist = ?1")
    List<Guests> findGuestsByIdGuestlistEquals(
            String idGuestlist
    );

    @Query("Select g FROM Guests g where g.idGuestlist = ?1 and g.status = ?2 and g.plusOne = ?3")
    List<Guests> findGuestsByIdGuestlistEqualsAAndStatusEqualsAAndPlusOneEquals(
            String idGuestlist,
            Boolean status,
            Boolean plusOne
    );

}
