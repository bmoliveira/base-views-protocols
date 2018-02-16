package com.broliveira.support.view.base

import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import com.broliveira.protocol.FABViewHandler

abstract class BaseFragment: Fragment() {

  @CallSuper
  override fun onResume() {
    super.onResume()
    if (this is FABViewHandler) {
      updateFloatingActionButton()
    }
  }
}
