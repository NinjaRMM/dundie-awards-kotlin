package com.ninjaone.dundie_awards

import org.springframework.stereotype.Component

@Component
class AwardsCache {

    private var totalAwards: Int = 0

    fun setTotalAwards(totalAwards: Int) {
        this.totalAwards = totalAwards
    }

    fun getTotalAwards(): Int = totalAwards

    fun addOneAward() {
        totalAwards += 1
    }
}
