//package com.conferencemgmt.conference_management.repository;
//
//import com.conferencemgmt.conference_management.dto.ProgrammeDTO;
//import com.conferencemgmt.conference_management.model.Programme;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//
//public interface ProgrammeRepository  extends JpaRepository<Programme, Long> {
//
//}
package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {
}
