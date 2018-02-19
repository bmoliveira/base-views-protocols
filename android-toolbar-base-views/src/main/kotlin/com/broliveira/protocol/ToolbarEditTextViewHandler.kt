package com.broliveira.protocol

import com.broliveira.view.ToolbarEditTextView

//Protocol to views that contain operations with a ToolbarView with edit text
interface ToolbarEditTextViewHandler: ToolbarViewHandler {
  val toolbarEditTextView: ToolbarEditTextView?
    get() = toolbarViewId?.let { activity?.findViewById(it) }
}
