package com.broliveira.view.base

import android.app.Activity
import com.broliveira.protocol.ActivityCurrentFragmentFinder
import com.broliveira.protocol.ActivityFragmentBackHandler

abstract class BaseActivity: Activity(),
    ActivityCurrentFragmentFinder,
    ActivityFragmentBackHandler {

  // Back handler that checks if the fragments have back enabled
  override fun onBackPressed() {
    if(handleFragmentBackPress()) {
      return
    }

    super.onBackPressed()
    afterSuperBackPressed()
  }

  open fun forcedBack() {
    super.onBackPressed()
  }
}
