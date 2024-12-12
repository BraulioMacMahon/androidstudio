package com.example.initialscreen.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class Repositorio {

    private val database = FirebaseDatabase.getInstance()
    private val myRef = database.getReference("Braulio")

    fun salvarPost(userId: String, conteudo: String, imagem: String) {
        myRef
            .child(userId)
            .push()
            .setValue(PubItem(conteudo = conteudo, imagem = imagem))

    }

    fun getPubs(userId: String): Flow<List<PubItem>> {
        return callbackFlow {
            val listener = myRef.child(userId).addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val pubItems = snapshot.children.mapNotNull {
                        PubItem(
                            conteudo = it.child("conteudo").value.toString(),
                            imagem = it.child("imagem").value.toString(),
                        )
                    }
                    trySend(pubItems)
                }

                override fun onCancelled(error: DatabaseError) {
                    close(error.toException())
                }
            })
            awaitClose {
                myRef.removeEventListener(listener)
            }
        }
    }

}