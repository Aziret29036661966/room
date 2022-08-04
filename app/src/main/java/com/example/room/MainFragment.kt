package com.example.room

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.room.databinding.FragmentMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainFragment : Fragment() {

    private var resultToString = ""

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onNumberClick()
        return binding.root
    }

    private fun onNumberClick(){
        binding.btnOne.setOnClickListener{
            textFields("1")
        }
        binding.btNTwo.setOnClickListener{
            textFields("2")
        }
        binding.btnThree.setOnClickListener{
            textFields("3")
        }
        binding.btnFour.setOnClickListener{
            textFields("4")
        }
        binding.btnFive.setOnClickListener{
            textFields("5")
        }
        binding.btnSix.setOnClickListener{
            textFields("6")
        }
        binding.btnSeven.setOnClickListener{
            textFields("7")
        }
        binding.btnEight.setOnClickListener{
            textFields("8")
        }
        binding.btnNine.setOnClickListener{
            textFields("9")
        }
        binding.btnZero.setOnClickListener{
            textFields("0")
        }
        binding.btnMinus.setOnClickListener{
            textFields("-")
        }
        binding.btnPlus.setOnClickListener{
            textFields("+")
        }
        binding.btnMultiply.setOnClickListener{
            textFields("*")
        }
        binding.btnDivision.setOnClickListener{
            textFields("/")
        }
        binding.btnClear.setOnClickListener{
            binding.tvResult.text = ""

        }
        binding.btnEqual.setOnClickListener{
            try {
val ex = ExpressionBuilder(binding.tvResult.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toULong()
                if(result == longRes.toDouble())
                    binding.tvResult.text = longRes.toString()
                else
                    binding.tvResult.text = result.toString()
            }catch (e:Exception){
Log.d("iwn", "govno: ${e.message}")
            }
        }
        binding.btnPoint.setOnClickListener{
            textFields(".")
        }
        binding.plusMinus.setOnClickListener{
            plusMinus()
        }
        binding.btnPercent.setOnClickListener{
            textFields("%")
        }
    }
    private fun textFields(string: String) {
        binding.tvResult.append(string)
    }
    private fun plusMinus() {
            if (binding.tvResult.text.toString().contains("-")) {
                binding.tvResult.text = "" + binding.tvResult.text.toString().replace("-", "")
            } else {
                binding.tvResult.text = "-" + binding.tvResult.text.toString().replace("+", "")
            }
        }
}


