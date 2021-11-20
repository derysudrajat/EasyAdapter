package id.derysudrajat.easyadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import id.derysudrajat.easyadapter.databinding.ItemDataBinding

class DataAdapter(
    listOfData: MutableList<Data>
) : EasyAdapter<Data, ItemDataBinding>(listOfData) {

    override fun create(parent: ViewGroup): ItemDataBinding {
        return ItemDataBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    }

    override fun onBind(binding: ItemDataBinding, data: Data) {
        binding.apply {
            tvName.text = data.name
            tvId.text = data.id
        }
    }
}