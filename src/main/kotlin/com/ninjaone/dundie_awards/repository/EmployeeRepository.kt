package com.ninjaone.dundie_awards.repository

import com.ninjaone.dundie_awards.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long>
