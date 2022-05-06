package nz.co.kiwibank.architecturedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nz.co.kiwibank.architecturedemo.databinding.MehActivityBinding
import nz.co.kiwibank.architecturedemo.ui.meh.view.MehFragment

class MehActivity : AppCompatActivity() {

    private lateinit var binding: MehActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MehActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, MehFragment.newInstance())
//                    .commitNow()
//        }
    }
}