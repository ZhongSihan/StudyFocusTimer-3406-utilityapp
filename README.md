# Study Focus Timer

## App Overview

Study Focus Timer is a utility-style Android mobile application developed for CP3406 Mobile Computing Assessment 1.

The app helps students manage focused study sessions by providing a simple countdown timer, session status, break duration information, and adjustable timer settings.

## Purpose

The purpose of this app is to support students in managing study time more effectively. It provides quick at-a-glance information such as the remaining focus time, current session status, break duration, and motivational message.

## Implemented Features

- Main screen showing a study countdown timer
- Start button to begin a focus session
- Reset button to return the timer to the selected focus duration
- Progress indicator showing timer progress
- Settings screen for adjusting focus duration
- Settings screen for adjusting break duration
- Toggle option for showing or hiding the motivational message
- Current setup summary shown on the settings screen
- Jetpack Compose user interface
- GitHub version control with regular commits
- Daily focus quote loaded from the ZenQuotes API
- Retrofit networking for external API requests
- Repository pattern for separating data access from the user interface
- FocusViewModel for managing quote loading state and error handling
- Manual dependency injection using AppContainer
- ZenQuotes attribution link
  
## Screens

### Main Screen

The main screen displays the focus timer, progress indicator, current session status, break duration, motivational message, daily focus quote section, and action buttons. The user can request a new motivational quote through the ZenQuotes API.

### Settings Screen

The settings screen allows the user to adjust the focus duration, break duration, and motivational message option. These settings update the content shown on the main screen.

## Assessment Information

Subject: CP3406 Mobile Computing  
Assessment 1: Utility App  
App Type: Utility App  
Student: Zhong Sihan

## Development Tools

- Android Studio
- Kotlin
- Jetpack Compose
- GitHub

## Testing Note

The app interface was checked using Jetpack Compose Preview in Android Studio. Emulator testing could not be completed because there was no available target device in the current development environment. The Retrofit API integration, timer button interactions, and screen switching logic were implemented in the source code but could not be fully verified through runtime testing.

## App Architecture

The app follows a simple layered architecture:

- `MainActivity.kt` and composable functions display the user interface.
- `FocusViewModel.kt` manages quote loading state and error messages.
- `QuoteRepository.kt` handles access to quote data.
- `QuoteApiService.kt` defines the Retrofit API request.
- `AppContainer.kt` creates and provides dependencies using manual dependency injection.
