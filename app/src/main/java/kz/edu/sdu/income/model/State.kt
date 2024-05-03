package kz.edu.sdu.income.model

data class State(
    val stateId: Int,
    val stateName: String,
    val stateTax: Double,
    val federalTax: Double,
    val foodExpense: Double,
    val tipsTax : Double,
    val hourlyRate: Double,
    val rent: Double,
    val stayPeriod: Int,
    val tips: Double,
    val hoursWorkedPerWeek: Int
)
