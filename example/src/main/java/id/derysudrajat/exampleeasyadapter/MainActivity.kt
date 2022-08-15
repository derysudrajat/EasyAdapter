package id.derysudrajat.exampleeasyadapter

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import id.derysudrajat.exampleeasyadapter.databinding.ActivityMainBinding
import id.derysudrajat.exampleeasyadapter.fragment.IndexAdapterFragment
import id.derysudrajat.exampleeasyadapter.fragment.MultiAddAdapterFragment
import id.derysudrajat.exampleeasyadapter.fragment.SimpleAdapterFragment
import id.derysudrajat.exampleeasyadapter.fragment.SimpleMultiAdapterFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    private val listFragment = listOf(
        SimpleAdapterFragment(),
        IndexAdapterFragment(),
        SimpleMultiAdapterFragment(),
        MultiAddAdapterFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        intent.extras?.getInt(ADAPTER_EXTRA, 0)?.let {
            supportActionBar?.apply {
                title = listOf(
                    getString(R.string.simple_adapter),
                    getString(R.string.adapter_with_index),
                    getString(R.string.multi_adapter_with_items),
                    getString(R.string.multi_adapter_with_add_adapter),
                )[it]
                setDisplayHomeAsUpEnabled(true)
            }
            supportFragmentManager.beginTransaction()
                .replace(mainBinding.root.id, listFragment[it])
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val ADAPTER_EXTRA = "adapter_extra"
    }

}