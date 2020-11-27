package com.example.prova01__16_11_2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.prova01__16_11_2020.Sobremesas
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buscaDados()
    }

    private fun buscaDados() {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.obterSobremesas()?.enqueue(object : Callback<List<Sobremesas>> {
            override fun onResponse(call: Call<List<Sobremesas>?>?, response: Response<List<Sobremesas>?>?) {
                val lista = response?.body();
                if (lista != null) {
                    for (sobremesa in lista) {
                    }

                    textDescricao1.text = lista?.get(0).descricao
                    textDescricao2.text = lista?.get(1).descricao
                    textDescricao3.text = lista?.get(2).descricao

                    textValor1.text = lista?.get(0).valor
                    textValor2.text = lista?.get(1).valor
                    textValor3.text = lista?.get(2).valor

                }
            }

            override fun onFailure(call: Call<List<Sobremesas>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n"+t?.message.toString())
            }
        })
    }

}