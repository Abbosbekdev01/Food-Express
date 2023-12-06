package uz.crud.foodexpressapplication.screens.restaurant.feedback

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.crud.foodexpressapplication.R
import uz.crud.foodexpressapplication.databinding.FragmentFeedbackBinding

class FeedbackFragment : BottomSheetDialogFragment() {

    private val binding by lazy { FragmentFeedbackBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FeedbackFragment
    }
}