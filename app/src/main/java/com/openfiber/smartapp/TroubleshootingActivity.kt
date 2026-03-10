
package com.openfiber.smartapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class TroubleshootingActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_troubleshooting_ai)

        val statusText = findViewById<TextView>(R.id.status_text)
        statusText.text = "Offline da 7 minuti"

        val restartSwitch = findViewById<Switch>(R.id.switch_restart)
        val cableSwitch = findViewById<Switch>(R.id.switch_cables)
        val resetSwitch = findViewById<Switch>(R.id.switch_reset)

        val btnInfoRestart = findViewById<Button>(R.id.info_ai_restart)
        val btnInfoCables = findViewById<Button>(R.id.info_ai_cables)
        val btnInfoReset = findViewById<Button>(R.id.info_ai_reset)

        val requestSupport = findViewById<Button>(R.id.request_support_button)

        val qrValue = intent.getStringExtra("qr_value")
        Toast.makeText(this, "QR ricevuto: $qrValue", Toast.LENGTH_SHORT).show()

        requestSupport.setOnClickListener {
            val selectedActions = mutableListOf<String>()

            if (restartSwitch.isChecked) selectedActions.add("Riavvio")
            if (cableSwitch.isChecked) selectedActions.add("Controllo cavi")
            if (resetSwitch.isChecked) selectedActions.add("Reset router")

            Toast.makeText(this, "Azioni selezionate: $selectedActions", Toast.LENGTH_LONG).show()
            // TODO: invio a sistema ticket/email
        }

        btnInfoRestart.setOnClickListener {
            showInfoDialog("Riavvia il dispositivo", "1. Scollega il cavo di alimentazione. //" +
                    "2. Attendi 10 secondi. //" +
                    "3. Ricollega il cavo. //" +
                    "4. Attendi che tutti i LED tornino verdi.")
        }

        btnInfoCables.setOnClickListener {
            showInfoDialog("Controlla i cavi", "1. Verifica che tutti i cavi siano ben inseriti. //" +
                    "2. Controlla che non siano danneggiati. //" +
                    "3. Prova a scollegare e ricollegare i connettori.")
        }

        btnInfoReset.setOnClickListener {
            showInfoDialog("Resetta il router", "1. Trova il foro 'RESET' dietro il router. //" +
                    "2. Inserisci uno stuzzicadenti e tienilo premuto per 10 secondi. //" +
                    " 3. Rilascia e attendi il riavvio.")
        }
    }

    private fun showInfoDialog(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}
