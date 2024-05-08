    package kz.edu.sdu.income.viewModel

    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.setValue
    import androidx.lifecycle.ViewModel
    import kz.edu.sdu.income.data.DataBase

    class IncomeViewModel(
        private val dataBase : DataBase
    ): ViewModel(){
        var hourlyRate = mutableStateOf("")
        var hoursWorked = mutableStateOf("")
        var foodExpense = mutableStateOf("")
        var overTime = mutableStateOf("")
        var state = mutableStateOf("")
        var federalTax = mutableStateOf("")
        var stateTax = mutableStateOf("")
        var tips = mutableStateOf("")
        var rent = mutableStateOf("")
        var periodOfStay = mutableStateOf("")
        var grossPaycheckPerWeek = mutableStateOf(0.0)
        var calculatedFederalTax = mutableStateOf(0.0)
        var calculatedStateTax = mutableStateOf(0.0)
        var calculatedTipsTax = mutableStateOf(0.0)
        var calculatedNetPaycheckPerWeek = mutableStateOf(0.0)
        var calculatedNetPaycheckOverall = mutableStateOf(0.0)


        fun updateDefaultStateData(selectedState: String){
            dataBase.fillList.find { it.stateName == selectedState}?.let { state ->
                foodExpense.value = state.foodExpense.toString()
                federalTax.value = state.federalTax.toString()
                stateTax.value = state.stateTax.toString()
                tips.value = state.tips.toString()
                rent.value = state.rent.toString()
                periodOfStay.value = state.stayPeriod.toString()
            } ?: run {
                println("No state found with the name $selectedState")
            }
        }

        private val federalTaxBrackets = listOf(
            Pair(9950.0, 0.10),
            Pair(40525.0, 0.12),
            Pair(86375.0, 0.22)
        )

        fun calculateTaxesAndPaycheck() {
            val hrRate = hourlyRate.value.toDoubleOrNull() ?: 0.0
            val hrsWorked = hoursWorked.value.toDoubleOrNull() ?: 0.0
            val foodExp = foodExpense.value.toDoubleOrNull() ?: 0.0
            val overtime = overTime.value.toDoubleOrNull() ?: 0.0
            val tipAmount = tips.value.toDoubleOrNull() ?: 0.0
            val rentAmount = rent.value.toDoubleOrNull() ?: 0.0


            val grossPayWeekly = (hrRate * hrsWorked) + (overtime * hrRate * 1.5)
            grossPaycheckPerWeek.value = grossPayWeekly

            calculatedFederalTax.value = calculateFederalTax(grossPayWeekly)
            calculatedStateTax.value = stateTax.value.toDoubleOrNull()?.let { taxRate ->
                grossPayWeekly * taxRate
            } ?: 0.0

            calculatedTipsTax.value = tipAmount * (stateTax.value.toDoubleOrNull() ?: 0.0)

            val deductions = mapOf(
                "Federal Tax" to calculatedFederalTax.value,
                "State Tax" to calculatedStateTax.value,
                "Rent" to rentAmount,
                "Food Expense" to foodExp,
                "Tips Tax" to calculatedTipsTax.value
            )

            calculatedNetPaycheckPerWeek.value = calculateNetPaycheck(grossPayWeekly, deductions) + tipAmount
            calculatedNetPaycheckOverall.value = calculatedNetPaycheckPerWeek.value * (periodOfStay.value.toInt())
        }

        private fun calculateFederalTax(grossIncome: Double): Double {
            var tax = 0.0
            var remainingIncome = grossIncome
            var previousBracketCap = 0.0
            for ((incomeCap, rate) in federalTaxBrackets) {
                if (remainingIncome <= 0) break
                val taxableIncome = minOf(incomeCap - previousBracketCap, remainingIncome)
                tax += taxableIncome * rate
                remainingIncome -= taxableIncome
                previousBracketCap = incomeCap
            }
            return tax
        }

        private fun calculateNetPaycheck(gross: Double, deductions: Map<String, Double>): Double {
            return deductions.entries.fold(gross) { acc, (key, value) -> acc - value }
        }

        fun resetAllValues() {
            hourlyRate.value = ""
            hoursWorked.value = ""
            foodExpense.value = ""
            overTime.value = ""
            state.value = ""
            federalTax.value = ""
            stateTax.value = ""
            tips.value = ""
            rent.value = ""
            periodOfStay.value = ""
            grossPaycheckPerWeek.value = 0.0
            calculatedFederalTax.value = 0.0
            calculatedStateTax.value = 0.0
            calculatedTipsTax.value = 0.0
            calculatedNetPaycheckPerWeek.value = 0.0
            calculatedNetPaycheckOverall.value = 0.0
            }


        fun updateHourlyRate(newRate: String) {
            hourlyRate.value = newRate
        }

        fun updateHoursWorked(newHours: String) {
            hoursWorked.value = newHours
        }

        fun updateFoodExpense(newExpense: String) {
            foodExpense.value = newExpense
        }

        fun updateGrossPayAmount(newOverTime: String) {
            overTime.value = newOverTime
        }
        fun updateState(newState : String){
            state.value = newState
        }

        fun updateFederalTax(newFederalTax : String){
            federalTax.value = newFederalTax
        }

        fun updateStateTax(newStateTax: String){
            stateTax.value = newStateTax
        }

        fun updateTips(newTips:String){
            tips.value = newTips
        }

        fun updateRent(newRent:String){
            rent.value = newRent
        }

        fun updatePeriodOfStay(newPeriodOfStay:String){
            periodOfStay.value = newPeriodOfStay
        }
    }