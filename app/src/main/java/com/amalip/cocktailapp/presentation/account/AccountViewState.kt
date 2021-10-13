package com.amalip.cocktailapp.presentation.account

import com.amalip.cocktailapp.core.presentation.BaseViewState
import com.amalip.cocktailapp.domain.model.User

/**
 * Created by Amalip on 10/13/2021.
 */

abstract class AccountViewState : BaseViewState() {

    data class LoggedUser(val user: User) : BaseViewState()

    object UserNotFound : BaseViewState()

}