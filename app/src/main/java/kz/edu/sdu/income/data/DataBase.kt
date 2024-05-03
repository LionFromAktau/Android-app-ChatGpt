package kz.edu.sdu.income.data

import kz.edu.sdu.income.model.State

class DataBase{
    val fillList = arrayListOf(
        State(
            stateId = 1,
            stateName = "Alabama",
            stateTax = 0.05, // Average state income tax rate
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.02,
            hourlyRate = 12.0,
            rent = 200.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 2,
            stateName = "Alaska",
            stateTax = 0.0, // No state income tax
            federalTax = 0.22,
            foodExpense = 100.0,
            tipsTax = 0.0,
            hourlyRate = 15.0,
            rent = 100.0,
            stayPeriod = 12,
            tips = 60.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 3,
            stateName = "Arizona",
            stateTax = 0.045,
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.03,
            hourlyRate = 12.5,
            rent = 195.0,
            stayPeriod = 12,
            tips = 45.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 4,
            stateName = "Arkansas",
            stateTax = 0.059, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.03,
            hourlyRate = 12.0,
            rent = 80.0,
            stayPeriod = 12,
            tips = 40.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 5,
            stateName = "California",
            stateTax = 0.09, // Simplified average state income tax rate
            federalTax = 0.24,
            foodExpense = 100.0,
            tipsTax = 0.04,
            hourlyRate = 14.0,
            rent = 325.0,
            stayPeriod = 12,
            tips = 100.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 6,
            stateName = "Colorado",
            stateTax = 0.0463, // Flat income tax rate
            federalTax = 0.22,
            foodExpense = 80.0,
            tipsTax = 0.04,
            hourlyRate = 12.5,
            rent = 250.0,
            stayPeriod = 12,
            tips = 70.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 7,
            stateName = "Connecticut",
            stateTax = 0.05, // Average state income tax rate
            federalTax = 0.22,
            foodExpense = 90.0,
            tipsTax = 0.04,
            hourlyRate = 13.0,
            rent = 275.0,
            stayPeriod = 12,
            tips = 75.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 8,
            stateName = "Delaware",
            stateTax = 0.057, // Average state income tax rate
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.04,
            hourlyRate = 12.0,
            rent = 220.0,
            stayPeriod = 12,
            tips = 60.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 9,
            stateName = "Florida",
            stateTax = 0.0, // No state income tax
            federalTax = 0.22,
            foodExpense = 80.0,
            tipsTax = 0.04,
            hourlyRate = 10.0,
            rent = 300.0,
            stayPeriod = 12,
            tips = 90.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 10,
            stateName = "Georgia",
            stateTax = 0.0575, // Average state income tax rate
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.04,
            hourlyRate = 11.0,
            rent = 225.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 11,
            stateName = "Hawaii",
            stateTax = 0.08, // High income tax rate due to progressive scale
            federalTax = 0.22,
            foodExpense = 120.0,
            tipsTax = 0.04,
            hourlyRate = 15.0,
            rent = 350.0,
            stayPeriod = 12,
            tips = 100.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 12,
            stateName = "Idaho",
            stateTax = 0.071, // Average state income tax rate
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.02,
            hourlyRate = 11.0,
            rent = 200.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 13,
            stateName = "Illinois",
            stateTax = 0.0495, // Flat income tax rate
            federalTax = 0.22,
            foodExpense = 80.0,
            tipsTax = 0.03,
            hourlyRate = 12.0,
            rent = 250.0,
            stayPeriod = 12,
            tips = 60.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 14,
            stateName = "Indiana",
            stateTax = 0.0323, // Flat state income tax rate
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.03,
            hourlyRate = 11.5,
            rent = 225.0,
            stayPeriod = 12,
            tips = 55.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 15,
            stateName = "Iowa",
            stateTax = 0.0846, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.03,
            hourlyRate = 11.0,
            rent = 200.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 16,
            stateName = "Kansas",
            stateTax = 0.0525, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.03,
            hourlyRate = 11.0,
            rent = 190.0,
            stayPeriod = 12,
            tips = 45.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 17,
            stateName = "Kentucky",
            stateTax = 0.05, // Flat state income tax rate
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.03,
            hourlyRate = 10.5,
            rent = 180.0,
            stayPeriod = 12,
            tips = 40.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 18,
            stateName = "Louisiana",
            stateTax = 0.06, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 80.0,
            tipsTax = 0.05,
            hourlyRate = 10.0,
            rent = 210.0,
            stayPeriod = 12,
            tips = 60.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 19,
            stateName = "Maine",
            stateTax = 0.0715, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 85.0,
            tipsTax = 0.03,
            hourlyRate = 12.0,
            rent = 250.0,
            stayPeriod = 12,
            tips = 70.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 20,
            stateName = "Maryland",
            stateTax = 0.0575, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 90.0,
            tipsTax = 0.04,
            hourlyRate = 13.0,
            rent = 280.0,
            stayPeriod = 12,
            tips = 80.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 21,
            stateName = "Massachusetts",
            stateTax = 0.05, // Flat income tax rate
            federalTax = 0.24,
            foodExpense = 0.0,
            tipsTax = 0.04,
            hourlyRate = 15.0,
            rent = 150.0,
            stayPeriod = 12,
            tips = 100.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 22,
            stateName = "Michigan",
            stateTax = 0.0425, // Flat income tax rate
            federalTax = 0.22,
            foodExpense = 80.0,
            tipsTax = 0.04,
            hourlyRate = 12.0,
            rent = 220.0,
            stayPeriod = 12,
            tips = 65.0,
            hoursWorkedPerWeek = 40
        ),

        State(
            stateId = 23,
            stateName = "Minnesota",
            stateTax = 0.0785, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 85.0,
            tipsTax = 0.04,
            hourlyRate = 12.5,
            rent = 240.0,
            stayPeriod = 12,
            tips = 70.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 24,
            stateName = "Mississippi",
            stateTax = 0.05, // Flat state income tax rate
            federalTax = 0.22,
            foodExpense = 65.0,
            tipsTax = 0.04,
            hourlyRate = 9.0,
            rent = 175.0,
            stayPeriod = 12,
            tips = 45.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 25,
            stateName = "Missouri",
            stateTax = 0.055, // Progressive tax rate
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.03,
            hourlyRate = 11.0,
            rent = 210.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 26,
            stateName = "Montana",
            stateTax = 0.069, // Progressive tax rate
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.0,
            hourlyRate = 10.5,
            rent = 200.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 27,
            stateName = "Nebraska",
            stateTax = 0.0684, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.03,
            hourlyRate = 11.0,
            rent = 200.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 28,
            stateName = "Nevada",
            stateTax = 0.0, // No state income tax
            federalTax = 0.22,
            foodExpense = 85.0,
            tipsTax = 0.0,
            hourlyRate = 10.0,
            rent = 300.0,
            stayPeriod = 12,
            tips = 100.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 29,
            stateName = "New Hampshire",
            stateTax = 0.0, // No state income tax
            federalTax = 0.22,
            foodExpense = 80.0,
            tipsTax = 0.0,
            hourlyRate = 12.0,
            rent = 250.0,
            stayPeriod = 12,
            tips = 60.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 30,
            stateName = "New Jersey",
            stateTax = 0.0897, // Progressive tax rate, average taken
            federalTax = 0.24,
            foodExpense = 90.0,
            tipsTax = 0.04,
            hourlyRate = 12.0,
            rent = 310.0,
            stayPeriod = 12,
            tips = 80.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 31,
            stateName = "New Mexico",
            stateTax = 0.0490, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.03,
            hourlyRate = 11.0,
            rent = 180.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 32,
            stateName = "New York",
            stateTax = 0.0685, // Progressive tax rate, average taken
            federalTax = 0.24,
            foodExpense = 120.0,
            tipsTax = 0.045,
            hourlyRate = 15.0,
            rent = 400.0,
            stayPeriod = 12,
            tips = 150.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 33,
            stateName = "North Carolina",
            stateTax = 0.0525, // Flat state income tax rate
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.03,
            hourlyRate = 11.5,
            rent = 225.0,
            stayPeriod = 12,
            tips = 60.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 34,
            stateName = "North Dakota",
            stateTax = 0.0227, // Flat state income tax rate
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.02,
            hourlyRate = 11.0,
            rent = 200.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 35,
            stateName = "Ohio",
            stateTax = 0.0333, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.03,
            hourlyRate = 11.5,
            rent = 220.0,
            stayPeriod = 12,
            tips = 55.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 36,
            stateName = "Oklahoma",
            stateTax = 0.05, // Progressive tax rate, average taken
            federalTax = 0.22,
            foodExpense = 65.0,
            tipsTax = 0.03,
            hourlyRate = 10.5,
            rent = 190.0,
            stayPeriod = 12,
            tips = 40.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 37,
            stateName = "Oregon",
            stateTax = 0.099, // Progressive tax rate, among the highest
            federalTax = 0.22,
            foodExpense = 85.0,
            tipsTax = 0.0,
            hourlyRate = 12.5,
            rent = 300.0,
            stayPeriod = 12,
            tips = 75.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 38,
            stateName = "Pennsylvania",
            stateTax = 0.0307, // Flat state income tax rate
            federalTax = 0.22,
            foodExpense = 80.0,
            tipsTax = 0.03,
            hourlyRate = 12.0,
            rent = 225.0,
            stayPeriod = 12,
            tips = 60.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 39,
            stateName = "Rhode Island",
            stateTax = 0.0599, // Progressive tax rate
            federalTax = 0.22,
            foodExpense = 85.0,
            tipsTax = 0.04,
            hourlyRate = 12.5,
            rent = 250.0,
            stayPeriod = 12,
            tips = 65.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 40,
            stateName = "South Carolina",
            stateTax = 0.07, // Progressive tax rate
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.03,
            hourlyRate = 11.0,
            rent = 210.0,
            stayPeriod = 12,
            tips = 55.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 41,
            stateName = "South Dakota",
            stateTax = 0.0, // No state income tax
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.0,
            hourlyRate = 10.5,
            rent = 190.0,
            stayPeriod = 12,
            tips = 40.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 42,
            stateName = "Tennessee",
            stateTax = 0.0, // No state income tax
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.0,
            hourlyRate = 10.0,
            rent = 220.0,
            stayPeriod = 12,
            tips = 60.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 43,
            stateName = "Texas",
            stateTax = 0.0, // No state income tax
            federalTax = 0.22,
            foodExpense = 80.0,
            tipsTax = 0.0,
            hourlyRate = 11.0,
            rent = 250.0,
            stayPeriod = 12,
            tips = 70.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 44,
            stateName = "Utah",
            stateTax = 0.0495, // Flat state income tax rate
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.03,
            hourlyRate = 11.5,
            rent = 200.0,
            stayPeriod = 12,
            tips = 50.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 45,
            stateName = "Vermont",
            stateTax = 0.0875, // Progressive tax rate
            federalTax = 0.22,
            foodExpense = 85.0,
            tipsTax = 0.04,
            hourlyRate = 12.0,
            rent = 250.0,
            stayPeriod = 12,
            tips = 65.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 46,
            stateName = "Virginia",
            stateTax = 0.0575, // Progressive tax rate
            federalTax = 0.22,
            foodExpense = 80.0,
            tipsTax = 0.03,
            hourlyRate = 12.0,
            rent = 240.0,
            stayPeriod = 12,
            tips = 70.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 47,
            stateName = "Washington",
            stateTax = 0.0, // No state income tax
            federalTax = 0.22,
            foodExpense = 90.0,
            tipsTax = 0.0,
            hourlyRate = 13.5,
            rent = 300.0,
            stayPeriod = 12,
            tips = 100.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 48,
            stateName = "West Virginia",
            stateTax = 0.065, // Progressive tax rate
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.03,
            hourlyRate = 10.5,
            rent = 180.0,
            stayPeriod = 12,
            tips = 45.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 49,
            stateName = "Wisconsin",
            stateTax = 0.0765, // Progressive tax rate
            federalTax = 0.22,
            foodExpense = 75.0,
            tipsTax = 0.03,
            hourlyRate = 11.0,
            rent = 220.0,
            stayPeriod = 12,
            tips = 55.0,
            hoursWorkedPerWeek = 40
        ),
        State(
            stateId = 50,
            stateName = "Wyoming",
            stateTax = 0.0, // No state income tax
            federalTax = 0.22,
            foodExpense = 70.0,
            tipsTax = 0.0,
            hourlyRate = 10.0,
            rent = 190.0,
            stayPeriod = 12,
            tips = 40.0,
            hoursWorkedPerWeek = 40
        )
    )
}