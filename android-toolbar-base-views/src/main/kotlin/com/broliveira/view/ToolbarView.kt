package com.broliveira.view

import android.content.Context
import android.support.annotation.CallSuper
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import org.jetbrains.anko.layoutInflater

open class ToolbarView @JvmOverloads constructor(
    context: Context,
    val attrs: AttributeSet? = null,
    toolbar: Toolbar? = null
):  AppBarLayout(context, attrs) {

  constructor(
      context: Context,
      attrs: AttributeSet? = null,
      toolbarResId: Int): this(context, attrs, context.layoutInflater.inflate(toolbarResId, null) as? Toolbar)


  val toolbar: Toolbar = toolbar ?: Toolbar(context, attrs)

  init {
    buildView()
    customizeToolbar(this.toolbar)
  }

  open fun customizeToolbar(toolbar: Toolbar) {}

  @CallSuper
  protected open fun buildView() {
    this.addView(toolbar)
  }
}
