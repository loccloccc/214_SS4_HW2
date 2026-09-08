package com.exaple.appointmentservice.repository;


import com.exaple.appointmentservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApppointmentRepository extends JpaRepository<Appointment,Long> {
}
