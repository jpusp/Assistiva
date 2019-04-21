package br.com.jpos.assistiva.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.jpos.assistiva.R
import br.com.jpos.assistiva.entities.GroupActionModel
import br.com.jpos.assistiva.repository.ActionGroupsRepository
import kotlinx.android.synthetic.main.action_model_group.view.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textToSpeech = TextToSpeech(this, this)
        textToSpeech?.setSpeechRate(0.5F)
        val containers = mutableListOf(
            container1, container2, container3, container4, container5, container6
        )

        ActionGroupsRepository().getGroups().asSequence()
            .forEachIndexed {index, actionModel ->
                val view = LayoutInflater.from(this).inflate(R.layout.action_model_group, containers[index])
                val rootContainer = view.root_container
                rootContainer.tag = actionModel
                rootContainer.setOnClickListener { onItemClick(it) }
                val ivImageGroup = view.findViewById<ImageView>(R.id.image_group)
                ivImageGroup.setImageResource(actionModel.resImgId)

                val tvGroupTitle = view.findViewById<TextView>(R.id.tvGroupTitle)
                tvGroupTitle.text = actionModel.title
            }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val ttsLang = textToSpeech?.setLanguage (Locale.getDefault())
        }
    }

    private fun onItemClick(view: View) {
        val actionModel = view.tag as GroupActionModel?
        actionModel?.let {

            textToSpeech?.speak(actionModel.title, TextToSpeech.QUEUE_FLUSH, null, actionModel.title)
            val intent = Intent(this, ActionModelListActivity::class.java)
            intent.putExtra("group", it)
            startActivity(intent)
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
