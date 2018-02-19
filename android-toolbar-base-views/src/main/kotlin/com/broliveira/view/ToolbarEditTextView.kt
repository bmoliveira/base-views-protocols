package com.broliveira.view

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import com.broliveira.protocol.ToolbarViewType
import com.broliveira.view.base.toolbar.R
import org.jetbrains.anko.layoutInflater

// TODO: Add clear button to reset text
open class ToolbarEditTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    mToolbar: Toolbar? = null,
    mEditText: EditText? = null):  ToolbarView(context, attrs, mToolbar) {

  constructor(
      context: Context,
      attrs: AttributeSet? = null,
      toolbarResId: Int): this(context, attrs, context.layoutInflater.inflate(toolbarResId, null) as? Toolbar)

  private val editTextFromResID: EditText? by lazy {
    getResourceID(R.styleable.ToolbarView_editTextLayoutId, attrs, context)
        ?.let { context.layoutInflater.inflate(it, null) as? EditText }
  }

  private val toolbarEditTextContainer: LinearLayout by lazy {
    LinearLayout(context, attrs).apply {
      layoutParams = Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT)
      isFocusable = true
    }
  }

  var currentState = ToolbarViewType.TEXT

  private var lastTitle: CharSequence?

  private var lastSubtitle: CharSequence? = this.toolbar.subtitle

  val toolbarEditText: EditText by lazy {
    val editText = mEditText ?: editTextFromResID ?: EditText(context, attrs)
    editText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    editText
  }

  val toolbarLayoutParams: AppBarLayout.LayoutParams? by lazy { toolbar.layoutParams as? AppBarLayout.LayoutParams }

  init {
    buildView()
    this.lastTitle = toolbar.title
    this.lastSubtitle = toolbar.subtitle

    customizeEditText(toolbarEditText)
    customizeLinearLayout(toolbarEditTextContainer)

    updateStatus(currentState)
  }

  open fun customizeEditText(editText: EditText) {}

  open fun customizeLinearLayout(linearLayout: LinearLayout) {}

  private fun buildView() {
    toolbarEditTextContainer.addView(toolbarEditText)
    toolbar.addView(toolbarEditTextContainer)
  }

  override fun requestLayout() {
    super.requestLayout()
    try { toolbar.requestLayout() } catch (ignored: Exception) {}
  }

  fun updateStatus(type: ToolbarViewType) {
    currentState = type
    when (type) {
      ToolbarViewType.TEXT -> {
        toolbarEditTextContainer.visibility = View.GONE
        title = lastTitle
        subtitle = lastSubtitle
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.hideSoftInputFromWindow(toolbarEditText.windowToken, InputMethodManager.SHOW_IMPLICIT)
      }
      ToolbarViewType.EDIT_TEXT -> {
        toolbarEditTextContainer.visibility = View.VISIBLE
        toolbarEditText.requestFocus()
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.showSoftInput(toolbarEditText, InputMethodManager.SHOW_IMPLICIT)
      }
    }
  }

  var editTextText: String?
    get() = toolbarEditText.text?.toString()
    set(value) {
      toolbarEditText.setText(value)
      toolbarEditText.setSelection(value?.length ?: 0)
    }

  var title: CharSequence?
    get() = toolbar.title
    set(value) {
      lastTitle = value
      toolbar.title = value
    }

  var subtitle: CharSequence?
    get() = toolbar.subtitle?.toString()
    set(value) {
      lastSubtitle = value
      toolbar.subtitle = value
    }
}