package com.example.initialscreen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.initialscreen.data.Repositorio
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class HomeViewModel: ViewModel() {
    val repo = Repositorio()

    val userId = FirebaseAuth.getInstance().currentUser!!.uid

    val pubs = repo.getPubs(userId)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            emptyList()
        )
}