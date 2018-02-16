package com.broliveira.protocol

import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup

//Handler for views that need the FAB
interface FABViewHandler {
  // Default getters of the FAB Button
  val floatingActionButton: FloatingActionButton?
    get() {
      return floatingActionButtonResource?.let { fabResID ->
        when (this) {
          this as? AppCompatActivity -> findViewById(fabResID)
          this as? Fragment -> activity?.findViewById(fabResID)
          this as? android.app.Fragment -> this.activity?.findViewById(fabResID)
          this as? ViewGroup -> findViewById(fabResID)
          else -> null
        }
      }
    }

  // FAB Res ID to be found on viewTree
  val floatingActionButtonResource: Int?
    get() = null

  // Flag to indicate if the view should show or hide the button
  val defaultShouldShowFloatingActionButton: Boolean
    get() = false

  fun updateFloatingActionButton(isToShow: Boolean = defaultShouldShowFloatingActionButton) {
    if (isToShow) {
      floatingActionButtonResource?.let {
        setFloatingActionButtonImage(it)
        floatingActionButton?.show()
      } ?: floatingActionButton?.show()
    } else {
      floatingActionButton?.hide()
    }
  }

  private fun setFloatingActionButtonImage(imageResId: Int) {
    floatingActionButton?.hide(object: FloatingActionButton.OnVisibilityChangedListener() {
      override fun onHidden(fab: FloatingActionButton?) {
        super.onHidden(fab)
        fab?.let {
          fab.setImageDrawable(ContextCompat.getDrawable(fab.context, imageResId))
          fab.show()
        }
      }
    })
  }
}
