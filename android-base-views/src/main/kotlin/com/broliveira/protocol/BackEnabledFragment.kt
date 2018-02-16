package com.broliveira.protocol

//Protocol to identify BackEnabled Fragments
interface BackEnabledFragment {
  fun onBackPressed(): Boolean
}
