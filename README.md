# MVVM Boilerplate

## Introduction

A boilerplate project for Android.

## How to use

**Step 1:**

Download or clone this repo by using the link below:

```
https://gitlab.com/systango/open-source/android-mvvm-boilerplate

```

## Dependencies Used

* Retrofit and Gson converter
* Life-cycle and View model component
* Dragger


## Features

* MVVM : Data Binding
* Generic API structure.
* Generic Folder structure.
* Commonly used functions

## Folder Structure

```

app
|- manifest
    |- AndroidManifest.xml
|- java
    |- com.systango.mvvm
           |- common
                 |- AppUtil
                 |- GlideUtils
           |- dagger
                 |- ActivityComponent
                 |- MovieViewModelModule
           |- data
                 |- datarepository
                       |- MovieDataRepository
                 |- model
                       |- MovieData 
                       |- MovieResponseModel
                 |- network
                       |- ApiCallback
                       |- ApiClient
                       |- ApiInterface
                       |- ApiObserver
                       |- DataRepository
                       |- DataWrapper
                       |- GenericResponse
                 |- viewmodel
                       |- MovieListViewModel
                       |- SplashViewModel
           |- scene
                |- base
                     |- BackHandlerInterface
                     |- BaseActivity
                     |- BaseFragment
             
                |- home
                     |- HomeFragment
                |- splash
                     |- SplashActivity
                     
                     |-MainActivity
        |- com.systango.mvvm
        |- com.systango.mvvm
        
|- java (generated) 
|- res 
    |- drawable
    |- layout
    |- mipmap
    |- values
|- res(generated)  
|- Gradle Scripts


```

## Conclusion

This boilerplate project is based on  Kotlin with MVVM designing pattern. Supported on  android devices.Activity and fragments are managed along with callbacks,proper life cycle of activity and fragment has been managed into it along with API Integration.Also common functions are added into it.
