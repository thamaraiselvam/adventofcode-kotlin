package _2019

/*
Day 1: The Tyranny of the Rocket Equation
 */

class RocketEquation {

    fun totalRequiredFuel(masses: IntArray, additionalFuel: Boolean = false): Int {
        if(masses.isEmpty()){
            return 0
        }

        var totalRequiredFuel = 0

        for(mass in masses){
            totalRequiredFuel += if(additionalFuel) additionalFuel(mass) else requiredFuel(mass)
        }

        return totalRequiredFuel
    }

    private fun additionalFuel(mass: Int): Int {
        var additionalFuelRequired = 0
        var tmpMass = mass
        while (true) {
            val fuel = requiredFuel(tmpMass)
            if (fuel < 0) {
                break
            }
            additionalFuelRequired += fuel
            tmpMass = fuel
        }
        return additionalFuelRequired
    }

    private fun requiredFuel(mass: Int): Int {
        return (mass / 3) - 2
    }

}