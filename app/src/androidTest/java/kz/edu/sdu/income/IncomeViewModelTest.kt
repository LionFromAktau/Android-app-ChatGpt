//package kz.edu.sdu.income
//
//import androidx.test.espresso.matcher.ViewMatchers.assertThat
//import kz.edu.sdu.income.data.DataBase
//import kz.edu.sdu.income.viewModel.IncomeViewModel
//import org.junit.Before
//import org.junit.Test
//
//
//class IncomeViewModelTest {
//    @Mock
//    private val mockDataBase: DataBase? = null
//
//    private var viewModel: IncomeViewModel? = null
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        viewModel = IncomeViewModel(mockDataBase!!)
//    }
//
//    @Test
//    fun calculateTaxesAndPaycheck_correctCalculations() {
//        // Setup
//        viewModel!!.updateHourlyRate("20")
//        viewModel!!.updateHoursWorked("40")
//        viewModel!!.updateFoodExpense("50")
//        viewModel!!.updateGrossPayAmount("10") // Overtime hours
//        viewModel!!.updateStateTax("0.05") // 5% state tax
//        viewModel!!.updateFederalTax("0") // Simplification for the test
//        viewModel!!.updateTips("100")
//        viewModel!!.updateRent("300")
//        viewModel!!.updatePeriodOfStay("1") // 1 week
//
//        // Action
//        viewModel!!.calculateTaxesAndPaycheck()
//
//        // Verify
//        val expectedGrossPayWeekly = (20 * 40) + (10 * 20 * 1.5)
//        val expectedStateTax = expectedGrossPayWeekly * 0.05
//        val expectedNetPaycheck =
//            expectedGrossPayWeekly - (expectedStateTax + 50 + 300) + 100 // Rent + Food expense deducted, Tips added
//
//        // Using Truth for assertions
//        assertThat(viewModel!!.calculatedNetPaycheckPerWeek.value).isWithin(0.01)
//            .of(expectedNetPaycheck)
//    }
//}