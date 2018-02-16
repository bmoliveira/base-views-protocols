package com.broliveira.protocol

interface ActivityFragmentBackHandler {

  /**
   * Code to run after the back is pressed.
   */
  fun afterSuperBackPressed() {}

  /**
   * Try to find the current active view and check if it handles the back.
   *
   * @return true if back was handled.
   */
  fun handleFragmentBackPress(): Boolean {
    return when (this) {
      this as? ActivityCurrentFragmentFinder -> handleActivityBack(this)
      else -> false
    }
  }

  /**
   * Try to find the current fragment, or support fragment and check if it handles the back.
   *
   * @return true if back was handled
   */
  private fun handleActivityBack(currentFragmentHandler: ActivityCurrentFragmentFinder): Boolean {
    val currentFragment = currentFragmentHandler.currentFragment
    val currentSupportFragment = currentFragmentHandler.currentSupportFragment

    val handledCurrentFragmentBack = (currentFragment != null && currentFragment is BackEnabledFragment && currentFragment.onBackPressed())
    val handledCurrentSupportFragmentBack = (currentSupportFragment != null && currentSupportFragment is BackEnabledFragment && currentSupportFragment.onBackPressed())

    return handledCurrentFragmentBack || handledCurrentSupportFragmentBack
  }
}
