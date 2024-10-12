package com.arash.altafi.myapplication1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arash.altafi.myapplication1.data.model.ResponseUsers
import com.arash.altafi.myapplication1.data.repository.UserRepository
import com.arash.altafi.myapplication1.utils.BaseViewModel
import com.arash.altafi.myapplication1.utils.ext.toFavoriteUserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : BaseViewModel() {

    private val _users = MutableLiveData<List<ResponseUsers>>()
    val users: LiveData<List<ResponseUsers>>
        get() = _users

    private val _selectedUser = MutableLiveData<ResponseUsers>()
    val selectedUser: LiveData<ResponseUsers>
        get() = _selectedUser

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    private val _liveError = MutableLiveData<Boolean>()
    val liveError: LiveData<Boolean>
        get() = _liveError

    private val _liveLoading = MutableLiveData<Boolean>()
    val liveLoading: LiveData<Boolean>
        get() = _liveLoading

    fun fetchUsers() = callApi(
        networkCall = repository.getUsers(),
        liveResult = _users,
        liveError = _liveError,
        liveLoading = _liveLoading
    )

    fun fetchUserDetails(id: Int) = callApi(
        networkCall = repository.getUserDetails(id),
        liveResult = _selectedUser,
        liveError = _liveError,
        liveLoading = _liveLoading
    )

    fun toggleFavorite(user: ResponseUsers) {
        val favoriteUser = user.toFavoriteUserEntity()
        return callDatabase(
            databaseCall = if (_isFavorite.value == true) {
                _isFavorite.postValue(false)
                repository.removeFavorite(favoriteUser)
            } else {
                _isFavorite.postValue(true)
                repository.addFavorite(favoriteUser)
            },
        )
    }

    fun checkFavorite(id: Int) = callDatabase(
        databaseCall = repository.isFavorite(id),
        liveResult = _isFavorite,
        liveError = _liveError,
        liveLoading = _liveLoading
    )
}