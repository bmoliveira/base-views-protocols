package com.broliveira.view.base

import com.broliveira.protocol.ActivityCurrentFragmentFinder
import com.broliveira.protocol.ActivityFragmentBackHandler
import dagger.android.DaggerActivity

abstract class BaseDaggerActivity : DaggerActivity(),
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
