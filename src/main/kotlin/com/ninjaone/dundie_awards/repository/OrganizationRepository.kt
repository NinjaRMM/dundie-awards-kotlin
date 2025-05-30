package com.ninjaone.dundie_awards.repository

import com.ninjaone.dundie_awards.model.Organization
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrganizationRepository : JpaRepository<Organization, Long>
