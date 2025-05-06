package com.ninjaone.dundie_awards

import com.ninjaone.dundie_awards.model.Employee
import com.ninjaone.dundie_awards.model.Organization
import com.ninjaone.dundie_awards.repository.EmployeeRepository
import com.ninjaone.dundie_awards.repository.OrganizationRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(
    private val employeeRepository: EmployeeRepository,
    private val organizationRepository: OrganizationRepository,
    private val awardsCache: AwardsCache
) :
    CommandLineRunner {
    override fun run(vararg args: String) {
        // uncomment to reseed data
        // employeeRepository.deleteAll();
        // organizationRepository.deleteAll();

        if (employeeRepository.count() == 0L) {
            val organizationPikashu = Organization("Pikashu")
            organizationRepository.save(organizationPikashu)

            employeeRepository.save(Employee("John", "Doe", organizationPikashu))
            employeeRepository.save(Employee("Jane", "Smith", organizationPikashu))
            employeeRepository.save(Employee("Creed", "Braton", organizationPikashu))

            val organizationSquanchy = Organization("Squanchy")
            organizationRepository.save(organizationSquanchy)

            employeeRepository.save(Employee("Michael", "Scott", organizationSquanchy))
            employeeRepository.save(Employee("Dwight", "Schrute", organizationSquanchy))
            employeeRepository.save(Employee("Jim", "Halpert", organizationSquanchy))
            employeeRepository.save(Employee("Pam", "Beesley", organizationSquanchy))
        }

        val totalAwards = employeeRepository.findAll()
            .sumOf { it.dundieAwards ?: 0 }

        awardsCache.setTotalAwards(totalAwards)
    }
}
