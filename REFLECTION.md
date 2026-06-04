# Self-Reflection

## Overview

For CP3406 Assessment 1, I developed a utility-style Android application called Study Focus Timer. The purpose of the app is to help students manage focused study sessions by providing a countdown timer, progress indicator, session status, break duration information, and adjustable settings.

This project helped me practise Android development using Kotlin and Jetpack Compose. I focused on creating a simple utility app that provides useful at-a-glance information instead of adding too many unnecessary features.

## Meaningful Experiences

One meaningful experience during this project was setting up the Android Studio project correctly. At first, I had an issue with the package name because Android application package names cannot contain invalid characters. Fixing this helped me understand that Android projects have strict naming rules and that small setup mistakes can stop a project from being created properly.

Another meaningful experience was using GitHub throughout development. I created a repository, pushed the Android Studio project, updated the README, and made regular commits after each important feature. This helped me understand why version control is important in software development. Instead of uploading everything at the end, I could show clear progress from the initial project setup to the completed utility app.

I also learned how to use Jetpack Compose to build the user interface. At the beginning, the app only displayed the default Android greeting. I gradually changed it into a proper utility app screen with a title, timer display, session status, progress indicator, buttons, and a settings option. This helped me understand how Compose components such as Column, Row, Card, Spacer, Text, Button, OutlinedButton, Switch, and FilterChip can be combined to create a mobile interface.

A challenge I experienced was updating the Preview after changing the MainScreen function. When I added new parameters such as isFocusing, onStartClick, onResetClick, and remainingSeconds, the Preview function showed errors because it still used the old version of MainScreen. Fixing this helped me understand that preview composables must also be updated when the main composable function changes.

The most important coding challenge was implementing the countdown timer. I had to store the remaining time as state and update it every second. Using LaunchedEffect and delay helped me understand how timed behaviour can be connected to Compose state. I also needed to reset the timer correctly when the user pressed Reset or changed the focus duration in Settings.

## Android Coding Understanding

This project improved my understanding of several Android and Kotlin concepts. I learned that Jetpack Compose uses a declarative UI approach. Instead of manually refreshing the screen, the interface updates automatically when state values change. For example, when remainingSeconds changes, the displayed timer text updates from 25:00 to the next time value.

I also learned that state management is important in Compose. Values such as currentScreen, focusDuration, breakDuration, showMotivationalMessage, isFocusing, and remainingSeconds control what the user sees. The settings screen changes these values, and the main screen reacts to those changes.

Separating the app into different composable functions also made the code easier to manage. The MainScreen function focuses on displaying the timer, while the SettingsScreen function focuses on user preferences. Passing data and callback functions into these composables made the app easier to extend and debug.

## Reflection on Utility App Design

I designed the app around one clear daily-life activity: managing study focus time. The main screen provides quick at-a-glance information, including the remaining focus time, progress indicator, session status, break duration, and motivational message. This matches the purpose of a utility app because the user can quickly understand the current session without navigating through many screens.

The settings screen improves the usefulness of the app because different students may prefer different study session lengths. The user can choose different focus durations and break durations, and they can also decide whether to show or hide the motivational message.

## What I Would Improve Next

If I had more time, I would improve the app by adding persistent settings so that the selected focus duration and break duration remain saved after the app is closed. I would also add a notification or sound when the focus session finishes. Another improvement would be to add better visual design, icons, and accessibility improvements such as clearer contrast, larger touch targets, and better support for different screen sizes.

Overall, this project helped me understand the basic process of building a utility app in Android Studio using Kotlin and Jetpack Compose. It also helped me practise state management, screen switching, timer logic, Preview debugging, and GitHub version control.
