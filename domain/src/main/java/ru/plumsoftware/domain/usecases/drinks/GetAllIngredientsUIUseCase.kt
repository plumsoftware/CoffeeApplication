package ru.plumsoftware.domain.usecases.drinks

import ru.plumsoftware.domain.models.IngredientModel
import ru.plumsoftware.domain.repositories.CoffeeRepository

class GetAllIngredientsUIUseCase (private val coffeeRepository: CoffeeRepository) {
    fun execute(): List<IngredientModel> {
        return coffeeRepository.getAllIngredientsUI()
    }
}