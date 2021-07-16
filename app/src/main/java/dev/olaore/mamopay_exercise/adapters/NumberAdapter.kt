package dev.olaore.mamopay_exercise.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.olaore.mamopay_exercise.R
import dev.olaore.mamopay_exercise.listeners.OnItemClickedListener

class NumberAdapter(
    private val ctx: Context,
    private val values: List<String>,
    private val interaction: OnItemClickedListener
) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_amount_input, parent, false)
        return NumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val value = values[position]
        holder.bind(value)
    }

    override fun getItemCount() = values.size

    inner class NumberViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {

        private val valueTextView: TextView = view.findViewById(R.id.value_text)
        private val backspace: ImageView = view.findViewById(R.id.value_backspace)
        private var isBackspace = false

        init {
            itemView.setOnClickListener {
                if (!isBackspace) {
                    interaction.onNumberClicked(valueTextView.text.toString())
                } else {
                    interaction.onBackspaceClicked()
                }
            }

            itemView.setOnLongClickListener {
                if (isBackspace) {
                    interaction.onBackspacePressed()
                }
                true
            }
        }

        fun bind(value: String) {
            this.isBackspace = adapterPosition == (values.size - 1)
            valueTextView.visibility = if (isBackspace) View.GONE else View.VISIBLE
            backspace.visibility = if (isBackspace) View.VISIBLE else View.GONE

            if (!this.isBackspace) {
                valueTextView.text = value
            }
        }

    }

}