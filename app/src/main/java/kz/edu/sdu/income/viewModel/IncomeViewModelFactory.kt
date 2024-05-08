import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.edu.sdu.income.data.DataBase
import kz.edu.sdu.income.viewModel.IncomeViewModel

class IncomeViewModelFactory(private val dataBase: DataBase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IncomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return IncomeViewModel(dataBase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}