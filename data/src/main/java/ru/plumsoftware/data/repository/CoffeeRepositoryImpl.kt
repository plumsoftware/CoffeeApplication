package ru.plumsoftware.data.repository

import android.content.Context
import ru.plumsoftware.data.models.Coffee
import ru.plumsoftware.coffee.R as C
import ru.plumsoftware.data.models.Ingredient
import ru.plumsoftware.domain.models.CoffeeModel
import ru.plumsoftware.domain.repositories.CoffeeRepository

class CoffeeRepositoryImpl(private val context: Context) : CoffeeRepository {
    override fun getAllIngredients(): List<Ingredient> {

        val array = context.resources.getStringArray(C.array.ingredients)
        val list = mutableListOf<Ingredient>()

        for (i in array.indices step 1) {
            list.add(
                i, Ingredient(
                    id = i,
                    name = array[i],
                    iconId = 0
                )
            )
        }

        return list.toList()
    }

    override fun getAllDrinks(): List<CoffeeModel> {
        val allIngredients = getAllIngredients()
        val coffeeNames = context.resources.getStringArray(C.array.coffee_names)
        val roastingLevels = context.resources.getStringArray(C.array.roasting_levels)
        val descriptions = context.resources.getStringArray(C.array.descriptions)

        val list = mutableListOf<CoffeeModel>()

        list.add(
            Coffee(
                id = 0,
                name = coffeeNames[0],
                ageRating = 14,
                imageResId = C.drawable.cappuchino_classic,
                type = context.getString(C.string.cappuccino),
                isLiked = 0,
                roastingLevel = roastingLevels[1],
                description = descriptions[0],
                ingredients = listOf(
                    allIngredients[0],
                    allIngredients[1],
                    allIngredients[2],
                    allIngredients[3],
                    allIngredients[4],
                )
            )
        )

        return list
    }
}