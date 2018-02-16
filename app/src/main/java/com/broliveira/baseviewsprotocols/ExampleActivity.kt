package com.broliveira.baseviewsprotocols

import android.os.Bundle
import com.broliveira.protocol.ToolbarViewHandler
import com.broliveira.support.view.base.BaseActivity

class ExampleActivity : BaseActivity(), ToolbarViewHandler {

  override val toolbarViewId: Int?
    get() = R.id.toolbar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_example)
  }
}
