# NTSA CLONE ANDROID APPLICATION

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/MichaelOdera/ntsa-sample-app)

### EXPLANATION

Ntsa Clone Application is an android application, mobile-ready, both offline and online stored, That is able to perform all the clone actions of the ntsa android application.

  - Allows for sharing of the application
  - Allows foir the rating of the Application
  - Allows for the registration of a user to the ecitizen portal and the kplc power shortage page

# Features!

  - The application mainly employs the use of MVC framework
  - The application is made mainly using Java


Other features:
  - The application employes the use of material design especially for the drawer layout and FAB icon
  - The view is represented using the xml files
  - The images displayed comprise of the drawable android native icons and png downloaded images
  

#### Main Contributor
[Michael Ochieng' Odera](https://michaeloderaportfolio.imfast.io/)

> The overriding design goal for NTSA clone application
> was to ensure that the main aspects of the 
> original application, are not only catured,
> but funtionally they are improved, and feature-wise,
> the application should exemplify a mastery of
> the very actions that the core modules were supposed to
> implement.

It is prudent to say that since the application is employing the use of the ntsa native website, some features in the main website need a lot of fine tuning which may call upon the respective developers to handle the issues on their side before further features can be deemed usable.

### Tech

The main dependecnies used and technology are:

* [ Java ] - All modules are written using Java 1.8
* [XML] - This was used to show the main activity views
* [png images] - This were used as the main format of images in the application.
* [Buutterknife] - This was used to bind views in activities

### Installation

NTSA app requires an android application with an SDK of version number not less than 21.

Add dependencies in the build.gradle file in the module.app section before running the app on android studio.

```sh
app debug
app run
```

For production environments...

```sh
 build APKs
 deploy app on play store
```

### Plugins

NTSA application needs to be run with an emultaor or on a compatible android platform. For emulators,
installtion of emulators with a minimum Android version being 4.44 Kitkat and API > 21 is required.

| Dependencies | README |
| ------ | ------ |
| Jakewarton | [com.jakewharton:butterknife:10.2.1]
| JakeWarton | [com.jakewharton:butterknife-compiler:10.2.1]
| Material Design | [com.google.android.material:material:1.1.0]
| AppCompat-Version | [androidx.appcompat:appcompat:1.3.0-alpha01]
| Legacy Support | [androidx.legacy:legacy-support-v4:1.0.0]
| JUNIT Testing | [junit:junit:4.13]


### Development

Want to contribute? Great!

You can contact me through this [link](https://github.com/MichaelOdera/ntsa-sample-app/issues)


#### Building for source
For production release:
```sh
 git clone origin dev then run in your local machine
```
Generating APKs  for distribution:
```sh
run 'Buld APKS' from the menu on the Android Studio
```



#### AppsEnjoy App Store

See [NTSA APP](https://appsenjoy.com/download/d7a01f9d802741835212a1c5c8a5cd6b.html)


### Todos

 - Write MORE Tests
 - Add Night Mode

License
----

[MIT](LICENSE)