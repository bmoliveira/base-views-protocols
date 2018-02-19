package com.broliveira.view

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import com.broliveira.view.base.toolbar.R
import com.broliveira.view.helper.AttributeGetter
import org.jetbrains.anko.layoutInflater

open class ToolbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    mToolbar: Toolbar? = null
):  AppBarLayout(context, attrs), AttributeGetter {

  override val defaultStyleable: IntArray? = R.styleable.ToolbarView

  constructor(
      context: Context,
      attrs: AttributeSet? = null,
      toolbarResId: Int): this(context, attrs, context.layoutInflater.inflate(toolbarResId, null) as? Toolbar)

  private val toolbarFromResID: Toolbar? = getResourceID(R.styleable.ToolbarView_toolbarLayoutId, attrs, context)
      ?.let { context.layoutInflater.inflate(it, null) as? Toolbar }

  val toolbar: Toolbar by lazy { mToolbar ?: toolbarFromResID ?: Toolbar(context, attrs) }

  init {
    buildView()
    customizeToolbar(toolbar)
  }

  open fun customizeToolbar(toolbar: Toolbar) {}

  private fun buildView() {
    this.addView(toolbar)
  }
}
