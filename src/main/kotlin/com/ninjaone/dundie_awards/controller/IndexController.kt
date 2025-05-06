package com.ninjaone.dundie_awards.controller

import com.ninjaone.dundie_awards.AwardsCache
import com.ninjaone.dundie_awards.MessageBroker
import com.ninjaone.dundie_awards.repository.ActivityRepository
import com.ninjaone.dundie_awards.repository.EmployeeRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class IndexController(
    private val employeeRepository: EmployeeRepository,
    private val activityRepository: ActivityRepository,
    private val messageBroker: MessageBroker,
    private val awardsCache: AwardsCache
) {

    @GetMapping
    fun getIndex(model: Model): String {
        model.addAttribute("employees", employeeRepository.findAll())
        model.addAttribute("activities", activityRepository.findAll())
        model.addAttribute("queueMessages", messageBroker.getMessages())
        model.addAttribute("totalDundieAwards", awardsCache.getTotalAwards())
        return "index"
    }
}