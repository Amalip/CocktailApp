package com.amalip.cocktailapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.amalip.cocktailapp.domain.model.Cocktail

/**
 * Created by Amalip on 10/5/2021.
 */

@Dao
interface CocktailDao {

    @Query("SELECT * FROM Cocktail WHERE name LIKE :filter")
    fun getCocktailsByName(filter: String): List<Cocktail>

    @Insert(onConflict = REPLACE)
    fun saveCocktails(cocktails: List<Cocktail>): List<Long>

    @Update
    fun updateCocktail(cocktail: Cocktail): Int

}