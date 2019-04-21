package br.com.jpos.assistiva.repository

import br.com.jpos.assistiva.R
import br.com.jpos.assistiva.entities.ActionModel

class ActionsRepository {
    
    val actionsGroupMap = mapOf(
        10 to buildSensationModels(),
        11 to buildMoodModels(),
        12 to buildNeedsActionModels(),
        13 to buildSpeakModels(),
        14 to buildQuestionModels(),
        15 to buildHygieneModels()
    )
    
    fun buildSensationModels(): List<ActionModel> {
        return listOf(
            ActionModel("Com dor", R.drawable.dor),
            ActionModel("Com fome", R.drawable.fome),
            ActionModel("Com sede", R.drawable.sede),
            ActionModel("Com frio", R.drawable.frio),
            ActionModel("Com calor", R.drawable.calor),
            ActionModel("Com sono", R.drawable.dormir)
        )
    }

    fun buildMoodModels(): List<ActionModel> {
        return listOf(
            ActionModel("Feliz", R.drawable.feliz),
            ActionModel("Triste", R.drawable.triste),
            ActionModel("Bravo", R.drawable.bravo),
            ActionModel("Cansado", R.drawable.cansado)
        )
    }

    fun buildNeedsActionModels(): List<ActionModel> {
        return listOf(
            ActionModel("Comer", R.drawable.fome),
            ActionModel("Beber", R.drawable.beber),
            ActionModel("Ir ao banheiro", R.drawable.banheiro2),
            ActionModel("Levantar", R.drawable.levantar ),
            ActionModel("Sentar", R.drawable.sentar),
            ActionModel("Deitar", R.drawable.deitar),
            ActionModel("Assistir TV", R.drawable.assistirtv),
            ActionModel("Brincar", R.drawable.brincar),
            ActionModel("Dormir", R.drawable.dormir),
            ActionModel("Passear", R.drawable.passear)
        )
    }

    fun buildQuestionModels(): List<ActionModel> {
        return listOf(
            ActionModel("Onde está papai?", R.drawable.papai),
            ActionModel("Onde está mamãe?", R.drawable.mamae),
            ActionModel("Onde está vovô?", R.drawable.grandfather),
            ActionModel("Onde está vovó?", R.drawable.grandmother),
            ActionModel("Já é dia?", R.drawable.dia),
            ActionModel("Já é noite?", R.drawable.noite)
        )
    }

    fun buildSpeakModels(): List<ActionModel> {
        return listOf(
            ActionModel("Papai", R.drawable.papai),
            ActionModel("Mamãe", R.drawable.mamae),
            ActionModel("Vovô", R.drawable.grandfather),
            ActionModel("Vovó", R.drawable.grandmother),
            ActionModel("Irmão", R.drawable.irma),
            ActionModel("Irmã", R.drawable.irmao)
        )
    }

    fun buildHygieneModels(): List<ActionModel> {
        return listOf(
            ActionModel("Tomar banho", R.drawable.banho),
            ActionModel("Lavar a mão", R.drawable.lavarmao),
            ActionModel("Escovar os dentes", R.drawable.escovardente)
        )
    }
}