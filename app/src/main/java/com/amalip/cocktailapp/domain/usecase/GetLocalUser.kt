package com.amalip.cocktailapp.domain.usecase

import com.amalip.cocktailapp.core.exception.Failure
import com.amalip.cocktailapp.core.functional.Either
import com.amalip.cocktailapp.core.interactor.UseCase
import com.amalip.cocktailapp.core.plataform.AuthManager
import com.amalip.cocktailapp.domain.model.User
import javax.inject.Inject

/**
 * Created by Amalip on 10/13/2021.
 */

class GetLocalUser @Inject constructor(private val authManager: AuthManager) :
    UseCase<User, UseCase.None>() {

    override suspend fun run(params: None): Either<Failure, User> {
        val result = authManager.user

        return result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }

}