package id.derysudrajat.easyadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import id.derysudrajat.easyadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.rvMain.apply {
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            adapter = DataAdapter(Dummy.example)
        }
    }
}