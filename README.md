# LogUtils
A simple log util class for managing android logging with Log.w/d/i/w/e priorities with separate switch flags for each priority.

## 1. Setup
Add below code in your project level build.gradle file.
```groovy
allprojects {
   repositories {
        ...
       	maven { url "https://jitpack.io" }
   }
}
```
Add below code in your app level build.gradle file.

```groovy
implementation 'com.github.alterok:LogUtils:2.0.0'
```
## 2. Usage

#### a) Quick Use
* Kotlin

```kotlin
LogUtils.v("verbose log")
LogUtils.d("debug log")
LogUtils.i("info log")
LogUtils.w("warning log")
LogUtils.e("error log")
```

#### b) Optional but recommended
**[i] setup**

By default, every type of logging i.e. Log.v/d/i/w/e is enabled. If you want to disable any type of log priority or re-enable them, you should call the below code. It is recommended to call this code only once and as early as possible whenever the app starts.
* Kotlin

```kotlin
LogUtils.getInstance()
        .setLogging(BuildConfig.DEBUG)          //enable or disable the entire logging functionality. Default value is true.
        .allowVerbose(true)                     //enable or disable the verbose logging. Default value is true.
        .allowDebug(true)                       //enable or disable the debug logging. Default value is true.
        .allowInfo(true)                        //enable or disable the info logging. Default value is true.
        .allowWarning(true)                     //enable or disable the warning logging. Default value is true.
        .allowError(true)                       //enable or disable the error logging. Default value is true.
        .out()                                  //prints all logging states in the logCat
```

Calling below code with BuildConfig.DEBUG as an argument is recommended as this prevents logging in the release builds.
* Kotlin

```kotlin
LogUtils.getInstance()
        .setLogging(BuildConfig.DEBUG)      //pass your project's BuildConfig.DEBUG flag here
```
**[ii] use**

Logging strings is very simple. Just use the various v, d, i, w, e methods provided. TAG is optional.
* Kotlin

```kotlin
LogUtils.v("verbose log")               //default TAG is LogUtils[VERBOSE]
LogUtils.v(TAG, "verbose log")

LogUtils.d("debug log")                 //default TAG is LogUtils[DEBUG]
LogUtils.d(TAG, "debug log")

LogUtils.i("info log")                  //default TAG is LogUtils[INFO]
LogUtils.i(TAG, "info log")

LogUtils.w("warning log")               //default TAG is LogUtils[WARNING]
LogUtils.w(TAG, "warning log")

LogUtils.e("error log")                 //default TAG is LogUtils[ERROR]
LogUtils.e(TAG, "error log")
```
## License
[MIT](https://choosealicense.com/licenses/mit/)