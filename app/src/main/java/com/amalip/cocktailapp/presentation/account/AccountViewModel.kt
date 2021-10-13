package com.amalip.cocktailapp.presentation.account

import com.amalip.cocktailapp.core.exception.Failure
import com.amalip.cocktailapp.core.interactor.UseCase
import com.amalip.cocktailapp.core.presentation.BaseViewModel
import com.amalip.cocktailapp.domain.usecase.GetLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class AccountViewModel @Inject constructor(private val getLocalUser: GetLocalUser) :
    BaseViewModel() {

    fun getLocalUser() {
        getLocalUser(UseCase.None()) {
            it.fold(::userNotFound) {
                state.value = AccountViewState.LoggedUser(it)

                true
            }
        }
    }

    private fun userNotFound(failure: Failure) {
        state.value = AccountViewState.UserNotFound
        handleFailure(failure)
    }

}