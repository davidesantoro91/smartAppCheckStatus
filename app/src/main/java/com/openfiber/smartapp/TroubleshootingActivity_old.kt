//package com.openfiber.smartapp
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.widget.*
//import androidx.appcompat.app.AppCompatActivity
//
//class TroubleshootingActivity : AppCompatActivity() {
//    @SuppressLint("SetTextI18n")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_troubleshooting)
//
//        val statusText = findViewById<TextView>(R.id.status_text)
//        statusText.text = "Offline da 7 minuti"
//
//        val restartSwitch = findViewById<Switch>(R.id.switch_restart)
//        val cableSwitch = findViewById<Switch>(R.id.switch_cables)
//        val resetSwitch = findViewById<Switch>(R.id.switch_reset)
//
//        val requestSupport = findViewById<Button>(R.id.request_support_button)
//
//        // Eventuale stringa passata dal QR
//        val qrValue = intent.getStringExtra("qr_value")
//        Toast.makeText(this, "QR ricevuto: $qrValue", Toast.LENGTH_SHORT).show()
//
//        requestSupport.setOnClickListener {
//            val selectedActions = mutableListOf<String>()
//
//            if (restartSwitch.isChecked) selectedActions.add("Riavvio")
//            if (cableSwitch.isChecked) selectedActions.add("Controllo cavi")
//            if (resetSwitch.isChecked) selectedActions.add("Reset router")
//
//            Toast.makeText(this, "Azioni selezionate: $selectedActions", Toast.LENGTH_LONG).show()
//
//            // TODO: invio a sistema ticket/email
//        }
//    }
//}
