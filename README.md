# LogUtils
A simple log util class for managing android logging with Log.w/d/i/w/e priorities with separate switch flags for each priority.

## 1. Setup
[![](https://jitpack.io/v/alterok/LogUtils.svg)](https://jitpack.io/#alterok/LogUtils)

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
implementation 'com.github.alterok:LogUtils:2.0.1'
```
## 2. Usage
* Normal Logging
```kotlin
LogUtils.v(TAG, "verbose log")               //TAG is optional; default TAG is LogUtils[VERBOSE]
LogUtils.d(TAG, "debug log")                 //TAG is optional; default TAG is LogUtils[DEBUG]
LogUtils.i(TAG, "info log")                  //TAG is optional; default TAG is LogUtils[INFO]
LogUtils.w(TAG, "warning log")               //TAG is optional; default TAG is LogUtils[WARNING]
LogUtils.e(TAG, "error log")                 //TAG is optional; default TAG is LogUtils[ERROR]
```

* Using Extension Functions(usable on any Nullable Object)
```kotlin
obj.toLog()                                  //default TAG is LogUtils[VERBOSE]
obj.toDebugLog()                             //default TAG is LogUtils[DEBUG]
obj.toInfoLog()                              //default TAG is LogUtils[INFO]
obj.toWarningLog()                           //default TAG is LogUtils[WARNING]
obj.toErrorLog()                             //default TAG is LogUtils[ERROR]
```

## 3. Optional but recommended
By default, every type of logging i.e. Log.v/d/i/w/e is enabled. If you want to disable any type of log priority or re-enable them, you should call the below code. It is recommended to call this code only once and as early as possible whenever the app starts.

```kotlin
LogUtils.getInstance()
        .setLogging(BuildConfig.DEBUG)          //enable or disable the entire logging functionality. Default value is true.
        .allowVerbose(true)                     //enable or disable the verbose logging. Default value is true.
        .allowDebug(true)                       //enable or disable the debug logging. Default value is true.
        .allowInfo(true)                        //enable or disable the info logging. Default value is true.
        .allowWarning(true)                     //enable or disable the warning logging. Default value is true.
        .allowError(true)                       //enable or disable the error logging. Default value is true.
        .toLogcat()                             //prints all logging states in the logCat
```

NOTE: Calling setLogging() with BuildConfig.DEBUG as an argument is highly recommended as this prevents logging in the release builds.

## License
[MIT](https://choosealicense.com/licenses/mit/)
