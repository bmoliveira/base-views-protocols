package com.broliveira.view.base

import android.support.annotation.CallSuper
import com.broliveira.protocol.FABViewHandler
import dagger.android.DaggerFragment

abstract class BaseDaggerFragment: DaggerFragment() {

  @CallSuper
  override fun onResume() {
    super.onResume()
    if (this is FABViewHandler) {
      updateFloatingActionButton()
    }
  }
}

