package com.broliveira.view.base

import android.app.Fragment
import android.support.annotation.CallSuper
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
