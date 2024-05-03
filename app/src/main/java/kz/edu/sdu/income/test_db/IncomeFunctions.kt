package kz.edu.sdu.income.test_db

import kz.edu.sdu.income.data.DataBase

fun calculateFederalTax(grossIncome: Double): Double {
    val brackets = listOf(
        Pair(9950.0, 0.10), // Up to $9,950 at 10%
        Pair(40525.0, 0.12), // Up to $40,525 at 12%
        Pair(86375.0, 0.22)  // More brackets as necessary
    )
    var remainingIncome = grossIncome
    var tax = 0.0
    var previousBracketCap = 0.0

    for (bracket in brackets) {
        if (remainingIncome <= 0) break
        val taxableAtThisBracket = minOf(bracket.first - previousBracketCap, remainingIncome)
        tax += taxableAtThisBracket * bracket.second
        remainingIncome -= taxableAtThisBracket
        previousBracketCap = bracket.first
    }

    return tax
}

fun calculateNetPaycheck(gross: Double, deductions: Map<String, Double>): Double {
    return deductions.entries.fold(gross) { acc, deduction -> acc - deduction.value }
}

fun getStateInformation(stateName: String) {
    val dataBase = DataBase().fillList

    dataBase.find { it.stateName == stateName }?.let { state ->
        val grossPayWeekly = state.hourlyRate * state.hoursWorkedPerWeek
        val grossPayTotal = grossPayWeekly * state.stayPeriod

        val federalTaxWeekly = calculateFederalTax(grossPayWeekly)

        val deductionsWeekly = mapOf(
            "Federal Tax" to federalTaxWeekly,
            "State Tax" to state.stateTax * grossPayWeekly, // Assuming stateTax is a percentage
            "Rent" to state.rent,
            "Food Expense" to state.foodExpense,
            "Tips Tax" to state.tips * state.tipsTax // Assuming tips are per week
        )

        val netPaycheckWeekly = calculateNetPaycheck(grossPayWeekly, deductionsWeekly)
        val netPaycheckWeeklyWithTips = calculateNetPaycheck(grossPayWeekly, deductionsWeekly) + state.tips - deductionsWeekly["Tips Tax"]!!
        val netPaycheckTotal = netPaycheckWeekly * state.stayPeriod
        val netPaycheckTotalWithTips = netPaycheckWeeklyWithTips * state.stayPeriod

        println("State: ${state.stateName}")
        println("Gross Pay Total: $grossPayTotal")
        println("")
        println("Gross Pay per Week: $grossPayWeekly")
        println("-----------------------------------")
        println("Federal Tax per week : ${deductionsWeekly["Federal Tax"]}")
        println("-----------------------------------")
        println("State Tax per week : ${deductionsWeekly["State Tax"]}")
        println("-----------------------------------")
        println("Rent : ${deductionsWeekly["Rent"]}")
        println("-----------------------------------")
        println("Food Expense : ${deductionsWeekly["Food Expense"]}")
        println("-----------------------------------")
        println("Tips Tax : ${deductionsWeekly["Tips Tax"]}")
        println("-----------------------------------")
        println("Net Paycheck per Week: $netPaycheckWeekly")
        println("-----------------------------------")
        println("Net Paycheck per Week with Tips: $netPaycheckWeeklyWithTips")
        println("-----------------------------------")
        println("Net Paycheck Overall : $netPaycheckTotal")
        println("-----------------------------------")
        println("Net Paycheck Overall with Tips: $netPaycheckTotalWithTips")
    } ?: println("No state found with the name $stateName")
}

fun main() {
    getStateInformation("Massachusetts")
}

