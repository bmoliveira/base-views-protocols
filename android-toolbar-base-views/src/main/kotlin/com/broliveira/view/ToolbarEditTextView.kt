package com.broliveira.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.broliveira.protocol.ToolbarViewType
import org.jetbrains.anko.linearLayout

open class ToolbarEditTextView(context: Context, attrs: AttributeSet?): ToolbarView(context, attrs) {

  private val toolbarEditTextContainer: LinearLayout = LinearLayout(context, attrs)

  val editTextView: EditText = EditText(context, attrs)

  val toolbarLayoutParams: LayoutParams? = toolbar.layoutParams as LayoutParams

  init {
    buildView()
    customizeEditText()
    customizeLinearLayout()
  }

  fun customizeEditText() {
    toolbarEditTextContainer.layoutParams =
        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
  }

  fun customizeLinearLayout() {
    toolbarEditTextContainer.layoutParams =
        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
  }

  final override fun buildView() {
    super.buildView()
    linearLayout().addView(editTextView)
    toolbar.addView(linearLayout())
  }

  override fun requestLayout() {
    super.requestLayout()
    toolbar.requestLayout()
  }

  fun updateStatus(type: ToolbarViewType) {
    when (type) {
      ToolbarViewType.TEXT -> {
        toolbarEditTextContainer.visibility = View.GONE
        editTextText = null
        title = lastTitle
        subtitle = lastSubtitle
      }
      ToolbarViewType.EDIT_TEXT -> {
        toolbarEditTextContainer.visibility = View.VISIBLE
        editTextView.requestFocus()
      }
    }
  }

  var editTextText: String?
    get() = editTextView.text?.toString()
    set(value) {
      editTextView.setText(value)
      editTextView.setSelection(value?.length ?: 0)
    }

  private var lastTitle: CharSequence? = toolbar.title
  var title: CharSequence?
    get() = toolbar.title
    set(value) {
      lastTitle = value
      toolbar.title = value
    }

  private var lastSubtitle: CharSequence? = toolbar.subtitle
  var subtitle: CharSequence?
    get() = toolbar.subtitle?.toString()
    set(value) {
      lastSubtitle = value
      toolbar.subtitle = value
    }
}