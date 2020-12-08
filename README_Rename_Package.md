For example, if you want to change `com.example.app` to `my.awesome.game`, then:

  1. In your **_Project pane_**, click on the little gear icon ( ![gears](https://cloud.githubusercontent.com/assets/4108673/12048363/b1162a16-aeda-11e5-8a37-a447b159d293.png)
 )
  
  ![project pane](https://cloud.githubusercontent.com/assets/4108673/12048252/eaad1a7a-aed8-11e5-9d0b-0dd9993bc5c0.png)

  2. Uncheck / De-select the `Compact Empty Middle Packages` option

  3. Your package directory will now be broken up in individual directories

  4. Individually select each directory you want to rename, and:
    * Right-click it
    * Select `Refactor`
    * Click on `Rename`
    * In the Pop-up dialog, click on `Rename Package` instead of Rename Directory
    * Enter the new name and hit **Refactor**
    * Allow a minute to let Android Studio update all changes
    * _Note: When renaming `com` in Android Studio, it might give a warning. In such case, select **Rename All**_
    
  ![directory](https://cloud.githubusercontent.com/assets/4108673/12048291/86fd2bf4-aed9-11e5-8e76-d97818398a4a.png)

  5. Now open your **_Gradle Build File_** (`build.gradle` - Usually `app` or `mobile`). Update the `applicationId` to your new Package Name and Sync Gradle, if it hasn't already been updated automatically:

  ![gradle](https://cloud.githubusercontent.com/assets/4108673/12048303/b5814f14-aed9-11e5-96fb-ff5b0dea7753.png)

  6. **_Done!_** Anyways, Android Studio needs to make this process a little simpler.


Taken from: http://stackoverflow.com/questions/16804093/android-studio-rename-package
