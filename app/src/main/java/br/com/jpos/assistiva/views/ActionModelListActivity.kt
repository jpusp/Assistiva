package br.com.jpos.assistiva.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import br.com.jpos.assistiva.R
import br.com.jpos.assistiva.entities.ActionModel
import br.com.jpos.assistiva.entities.GroupActionModel
import br.com.jpos.assistiva.repository.ActionsRepository
import kotlinx.android.synthetic.main.activity_action_model_list.*
import java.util.*

class ActionModelListActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_model_list)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        textToSpeech = TextToSpeech(this, this)
        textToSpeech?.setSpeechRate(0.5F)

        rvActionModelList.layoutManager = GridLayoutManager(this, 2)
        rvActionModelList.setHasFixedSize(true)

        var group: GroupActionModel? = null
        intent?.let {
            group = it.getSerializableExtra("group") as GroupActionModel?
        }

        group?.let {
            supportActionBar?.title = it.title
            val actionsList = ActionsRepository().actionsGroupMap[it.id]
            if (actionsList != null) showActionsList(actionsList)
        }
    }

    private fun showActionsList(actionsList: List<ActionModel>) {
        val adapter = ActionsAdapter(actionsList, ::onItemClick, this)
        rvActionModelList.adapter = adapter
    }

    private fun onItemClick(actionModel: ActionModel) {
        textToSpeech?.apply {
            if (isSpeaking) {
                stop()
            }

            textToSpeech?.speak(actionModel.title, TextToSpeech.QUEUE_FLUSH, null, actionModel.title)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            if (item.itemId == android.R.id.home ) finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech?.language = Locale.getDefault()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech?.apply {
            stop()
            shutdown()
        }
    }
}
