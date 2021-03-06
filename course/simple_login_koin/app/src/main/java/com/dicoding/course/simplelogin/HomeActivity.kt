package com.dicoding.course.simplelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dicoding.course.core.UserRepository
import com.dicoding.course.simplelogin.databinding.ActivityHomeBinding
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvWelcome.text = "Welcome ${userRepository.getUser()}"

        binding.btnLogout.setOnClickListener {
            userRepository.logoutUser()
            moveToMainActivity()
        }

        binding.fab.setOnClickListener {
            try {
                installChatModule()
            }catch (e: Exception){
                Toast.makeText(this, "Module not found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun installChatModule(){
        val splitManager = SplitInstallManagerFactory.create(this)
        val moduleChat = "chat"
        if (splitManager.installedModules.contains(moduleChat)){
            moveChatActivity()
            Toast.makeText(this, "Open module", Toast.LENGTH_SHORT).show()
        } else{
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleChat)
                .build()
            splitManager.startInstall(request)
                .addOnSuccessListener {
                    Toast.makeText(this, "Success installing module", Toast.LENGTH_SHORT).show()
                    moveChatActivity()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error installing module", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun moveChatActivity(){
        startActivity(Intent(this, Class.forName("com.dicoding.course.simplelogin.chat.ChatActivity")))
    }
}