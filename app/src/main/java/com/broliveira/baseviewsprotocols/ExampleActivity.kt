package com.broliveira.baseviewsprotocols

import android.os.Bundle
import com.broliveira.protocol.ToolbarEditTextViewHandler
import com.broliveira.protocol.ToolbarViewType
import com.broliveira.support.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_example.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class ExampleActivity : BaseActivity(), ToolbarEditTextViewHandler {

  override val toolbarViewId: Int?
    get() = R.id.toolbarView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_example)


    toggleButton.onClick {
      when (toolbarEditTextView?.currentState) {
        ToolbarViewType.EDIT_TEXT -> toolbarEditTextView?.updateStatus(ToolbarViewType.TEXT)
        ToolbarViewType.TEXT -> toolbarEditTextView?.updateStatus(ToolbarViewType.EDIT_TEXT)
      }
    }
  }
}
