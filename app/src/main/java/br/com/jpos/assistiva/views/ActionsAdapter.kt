package br.com.jpos.assistiva.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.jpos.assistiva.R
import br.com.jpos.assistiva.entities.ActionModel
import kotlinx.android.synthetic.main.action_model_group.view.*

class ActionsAdapter(private val actionModelList: List<ActionModel>,
                     private val onClickListener: (ActionModel) -> Unit,
                     private val context: Context
) : RecyclerView.Adapter<ActionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.action_model_group, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(actionModelList[position])
    }

    override fun getItemCount() = actionModelList.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivAction = itemView.image_group
        val title = itemView.tvGroupTitle
        val rootContainer = itemView.root_container

        fun bind(actionModel: ActionModel) {
            ivAction.setImageResource(actionModel.resImgId)
            title.text = actionModel.title
            rootContainer.setOnClickListener { onClickListener(actionModel) }
        }
    }
}