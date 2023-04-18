package com.project.marimay.repository;

import com.project.marimay.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    @Query(value = "select wedding_date, b.budget_letf, b.beggining_budget, c.subtask_done, " +
            "c.all_subtask, gl.invited, gl.accepted  from wedding_details " +
            "join budget b on wedding_details.id_wedding_details = b.id_budget " +
            "join checklist c on wedding_details.id_wedding_details = c.id_checklist " +
            "join guest_list gl on wedding_details.id_wedding_details = gl.id_guest_list " +
            "where wedding_details.id_wedding_details = ?1", nativeQuery = true)
    Object[] getWeddingDetails(String id);

}
