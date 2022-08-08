package com.example.room.ui.fragment.main

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.room.R
import com.example.room.SUCCESSFULLY
import com.example.room.databinding.FragmentMainBinding
import com.example.room.model.entity.History
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class MainFragment : Fragment() {

    private var firstNumber by Delegates.notNull<Double>()

    private lateinit var viewModel: ViewModel
    var date: String = SimpleDateFormat(
        "dd.MM HH:mm",
        Locale.getDefault()
    ).format(Date())

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        onNumberClick()
        openMoreVert()
        setStartTrans()
        return binding.root
    }

    private fun openMoreVert() {
        binding.imgMoreVert.setOnClickListener { openCont()
        binding.imgMoreVert
            .animate()
            .rotation(90f)
            .setDuration(300)
            .start()

        }
    }

    private fun openCont() {
        binding.containerForMyCustomView.animate().scaleX(1f).setDuration(400).start()
        binding.containerForMyCustomView.animate().scaleY(1f).setDuration(400)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animator: Animator) {}
                override fun onAnimationEnd(animator: Animator) {
                    binding.imgHistory.visibility = View.VISIBLE
                    binding.imgHistory.setOnClickListener { v ->  findNavController().navigate(R.id.secondFragment) }
                }

                override fun onAnimationCancel(animator: Animator) {}
                override fun onAnimationRepeat(animator: Animator) {}
            }).start()
    }

    private fun setStartTrans() {
        binding.containerForMyCustomView.scaleX = 0f
        binding.containerForMyCustomView.scaleY = 0f
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
        binding.btnPoint.setOnClickListener{
            textFields(".")
        }
        binding.plusMinus.setOnClickListener{
            plusMinus()
        }
        binding.btnPercent.setOnClickListener{
            textFields("%")
        }
        binding.btnEqual.setOnClickListener{
            try {
                val ex = ExpressionBuilder(binding.tvResult.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toULong()
                if(result == longRes.toDouble()) {
                    binding.tvResult.text = longRes.toString()
                    val text = binding.tvResult.text
                        val history = History(0, text.toString(), date)
                        viewModel.addResultToNextFragment(history)
                        Toast.makeText(requireActivity(), SUCCESSFULLY, Toast.LENGTH_SHORT).show()
                }
                else
                    binding.tvResult.text = result.toString()
            }catch (e:Exception){
                Log.d("iwn", "govno: ${e.message}")
            }
        }
    }

    private fun textFields(string: String) {
        binding.tvResult.append(string)
    }
    private fun plusMinus() {
            if (binding.tvResult.text.toString().contains("-")) {
                binding.tvResult.text = binding.tvResult.text.toString().replace("-", "")
            } else {
                val text = "-${binding.tvResult.text.toString().replace(" + ", "")}"
                binding.tvResult.text = text
            }
        }
}


