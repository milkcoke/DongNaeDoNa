package com.example.dongnaedona.donationlist

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dongnaedona.R
import kotlinx.android.synthetic.main.fragment_delete_check_dialog.*

class DeleteCheckDialogFragment : DialogFragment() {
    private lateinit var deleteChecklistener : DeleteCheckListener
    private var customView: View? = null

    private var donationItemName = ""

    interface DeleteCheckListener {
        fun onDialogPositiveClick(dialog: DialogFragment, donationItemName :String)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        donationItemName = arguments?.getString("GOODS_NAME")!!

        return activity?.let{
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            customView = inflater.inflate(R.layout.fragment_delete_check_dialog, null)
            builder.setView(customView)
            builder.setTitle("삭제 확인")
//                .setIcon(resources.getDrawable(R.drawable.main_logo, context!!.theme))
                    .setMessage("$donationItemName 기부를 취소하시겠어요?")
            val dialog = builder.create()
//            커스터마이징 끝 return은 커스터마이징 된 dialog
            dialog
//           if builder fails to create Activity ->  Elvis Operator null check
        } ?: throw IllegalStateException("Activity Can't be null")

    }

    override fun onResume() {
        val width = resources.getDimensionPixelSize(R.dimen.dialog_fragment_width)
        val height = resources.getDimensionPixelSize(R.dimen.dialog_fragment_height)
        dialog?.window?.setLayout(width, height)
        super.onResume()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            deleteChecklistener = context as DeleteCheckListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() + "must implement NameCheckListener"))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return customView
    }

    //onCreateView에서 넘겨준 customView를 넘겨받음.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        delete_yes_button.setOnClickListener {
            deleteChecklistener.onDialogPositiveClick(this, donationItemName)
        }
        delete_no_button.setOnClickListener {
            deleteChecklistener.onDialogNegativeClick(this)
        }

    }
    override fun onDestroyView() {
        customView = null
        Log.i("onDestroyView", "this is dialog destroyed!!! without memory leak")
        super.onDestroyView()
    }

}