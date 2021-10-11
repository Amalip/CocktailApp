package com.amalip.cocktailapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

/**
 * Created by Amalip on 10/11/2021.
 */

@Entity
@JsonClass(generateAdapter = true)
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val mail: String = "",
    val img: String = "",
    val token: String = ""
) {
}