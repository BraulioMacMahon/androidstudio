package com.example.initialscreen.createpubpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.initialscreen.data.Repositorio
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class CreatPubViewModel: ViewModel() {
    val repo = Repositorio()

    val userId = FirebaseAuth.getInstance().currentUser!!.uid

    fun adicionarPub(imagem: String, conteudo: String) {
        repo.salvarPost(userId, conteudo, imagem)
    }
}