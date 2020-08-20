package id.derysudrajat.easyadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EasyAdapter(
    val context: Context,
    val onViewHolderCreated: (view: View) -> Unit,
    val onBindViewHolder: (data: Any?, position: Int) -> Unit
) : RecyclerView.Adapter<EasyAdapter.ViewHolder>() {
    private lateinit var data : MutableList<*>
    private var  layout: Int? = null

    fun setupData(data: MutableList<*>) {
        this.data = data
    }

    fun setupLayout(layout: Int) {
        this.layout = layout
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(this.layout!!, parent, false)
        onViewHolderCreated(view)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBindViewHolder(data, position)
    }

    override fun getItemCount(): Int = data.size
}
