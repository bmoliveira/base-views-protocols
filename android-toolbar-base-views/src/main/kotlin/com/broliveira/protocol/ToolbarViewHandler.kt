package com.broliveira.protocol

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.broliveira.view.ToolbarEditTextView
import com.broliveira.view.ToolbarView

//Protocol to views that contain operations with a ToolbarView
interface ToolbarViewHandler {
  // This is the resID for the toolbar
  val toolbarViewId: Int?
    get() = null

  // This is by default the activity where the toolbar is inserted
  val activity: AppCompatActivity?
    get() {
      return when (this) {
        this as? AppCompatActivity -> this
        this as? Fragment -> this.getActivity() as? AppCompatActivity
        this as? android.app.Fragment -> this.getActivity() as? AppCompatActivity
        else -> null
      }
    }

  val toolbarView: ToolbarView?
    get() = toolbarViewId?.let { activity?.findViewById(it) }
}