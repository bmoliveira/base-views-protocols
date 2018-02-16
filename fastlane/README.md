fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
## Android
### android test
```
fastlane android test
```
Runs all the tests
### android deploy_android_base_views
```
fastlane android deploy_android_base_views
```
Deploy android-base-views to bintray
### android deploy_rx_android_base_views
```
fastlane android deploy_rx_android_base_views
```
Deploy rx-android-base-views to bintray
### android deploy_dagger_android_base_views
```
fastlane android deploy_dagger_android_base_views
```
Deploy dagger-android-base-views to bintray
### android deploy_rx_dagger_android_base_views
```
fastlane android deploy_rx_dagger_android_base_views
```
Deploy rx-dagger-android-base-views to bintray
### android deploy
```
fastlane android deploy
```
Deploy all libs to bintray

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
