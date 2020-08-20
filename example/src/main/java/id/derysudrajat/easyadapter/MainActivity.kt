package id.derysudrajat.easyadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import id.derysudrajat.easyadapter.databinding.ActivityMainBinding
import id.derysudrajat.easyadapter.databinding.ItemDataBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var itemBinding: ItemDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val mAdapter = EasyAdapter(this,
            onBindViewHolder = {data, _ ->
                val mData = data as Data.Items
                itemBinding.apply {
                    tvName.text = mData.name
                    tvId.text = mData.id
                }
            },
            onViewHolderCreated = { view ->
                itemBinding = ItemDataBinding.bind(view)
            }
        ).apply {
            setupData(Data.example)
            setupLayout(R.layout.item_data)
        }

        mainBinding.rvMain.apply {
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = mAdapter
        }
    }
}