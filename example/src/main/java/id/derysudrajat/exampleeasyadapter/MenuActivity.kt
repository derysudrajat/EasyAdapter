package id.derysudrajat.exampleeasyadapter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.derysudrajat.exampleeasyadapter.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSimple.setOnClickListener { goToSample(0) }
        binding.btnIndex.setOnClickListener { goToSample(1) }
        binding.btnItems.setOnClickListener { goToSample(2) }
        binding.btnAdd.setOnClickListener { goToSample(3) }
    }

    private fun goToSample(index: Int) {
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                putExtra(MainActivity.ADAPTER_EXTRA, index)
            }
        )
    }
}