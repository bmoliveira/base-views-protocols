object Versions {
  val kotlin = "1.2.21"

  val buildTools = "27.0.3"

  val minSDK = 19

  val targetSDK = 26
  val compileSDK = 26
  val versionCode = 1
  val versionName = "1.0"

  val anko = "0.10.1"

  val supportLib = "27.0.2"

  val broliveiraExtensions = "0.1"
  val broliveiraDisposer = "0.2"
  val broliveiraViewHelper = "0.5"

  val rxJava = "2.1.0"

  val dagger = "2.14.1"

  val junit = "4.12"
  val testRunner = "1.0.1"

  val espressoCore = "3.0.1"
}

object PluginVersions {
  val gradle = "3.1.0-beta3"
  val bintray = "1.7.3"
  val maven = "1.5"
  val dokka = "0.9.15"
}

object AndroidTestDependencies {
  val junit = "junit:junit:${Versions.junit}"
  val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
  val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espressoCore}"
}

object BuildScriptDependencies {
  val gradlePlugin = "com.android.tools.build:gradle:${PluginVersions.gradle}"
  val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
  val bintrayPlugin = "com.jfrog.bintray.gradle:gradle-bintray-plugin:${PluginVersions.bintray}"
  val mavenPlugin = "com.github.dcendents:android-maven-gradle-plugin:${PluginVersions.maven}"
  val dokkaPlugin = "org.jetbrains.dokka:dokka-android-gradle-plugin:${PluginVersions.dokka}"


}

object AndroidDependencies {
  val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
  val supportAppCompatV7 = "com.android.support:appcompat-v7:${Versions.supportLib}"
  val supportV4 = "com.android.support:support-v4:${Versions.supportLib}"

  val supportDesign = "com.android.support:design:${Versions.supportLib}"

  val anko = "org.jetbrains.anko:anko:${Versions.anko}"
  val ankoAppCompatV7 = "org.jetbrains.anko:anko-appcompat-v7:${Versions.anko}"
  val ankoDesign = "org.jetbrains.anko:anko-design:${Versions.anko}"

  val broliveiraExtensions = "com.broliveira:android-extension:${Versions.broliveiraExtensions}@aar"
  val broliveiraDisposer = "com.broliveira:protocol-rx-disposer:${Versions.broliveiraDisposer}@aar"
  val broliveiraViewHelper = "com.broliveira:view-helper:${Versions.broliveiraViewHelper}@aar"
  val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxJava}"
  val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"

  val dagger = "com.google.dagger:dagger:${Versions.dagger}"
  val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
}
