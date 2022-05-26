package nz.co.kiwibank.architecturedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import nz.co.kiwibank.architecturedemo.databinding.ApplicationActivityBinding

class ApplicationActivity : AppCompatActivity() {

    private lateinit var binding: ApplicationActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ApplicationActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        findNavController(R.id.nav_host_fragment).handleDeepLink(intent)
    }
}