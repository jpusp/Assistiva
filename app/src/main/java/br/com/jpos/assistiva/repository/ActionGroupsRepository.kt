package br.com.jpos.assistiva.repository

import br.com.jpos.assistiva.R
import br.com.jpos.assistiva.entities.GroupActionModel

class ActionGroupsRepository {

    fun getGroups(): List<GroupActionModel> {
        return listOf(
            GroupActionModel(10, "Eu estou...", R.drawable.estou),
            GroupActionModel(11, "Me sinto...", R.drawable.mesinto),
            GroupActionModel(12, "Eu quero...", R.drawable.quero),
            GroupActionModel(13, "Quero falar", R.drawable.querofalar),
            GroupActionModel(14, "Quero perguntar", R.drawable.queroperguntar),
            GroupActionModel(15, "Higiene", R.drawable.higiene)
        )
    }
}