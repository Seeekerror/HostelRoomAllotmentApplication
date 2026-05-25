package com.HostelRoomAllotmentApplication.repository;

import com.HostelRoomAllotmentApplication.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}