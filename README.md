# Appettider
From Swedish "Öppettider", an app to quickly access your favorite places' opening times. 

Built to practice Android development and try out Jetpack Compose.

## Features

### V0 (fully offline)
- [ ] show the list of places stored in the local database in the main activity
- [ ] show place details in a secondary activity
  - name
  - address
  - opening times
  - notes
- [ ] add, edit and remove opening times for a given place
- [ ] search local database

### V1
- [ ] query [Google APIs](https://developers.google.com/maps/documentation/places/web-service/details) and/or similar (YELP, Facebook...) to get and update opening times automatically
- [ ] optionally use GPS to order search results by distance from current position

### Future features
- [ ] show a place's current status already in the list (open until/closed until/permanently closed)
- [ ] highlight current day when showing a place's details
- [ ] favorites (show only those on startup)
- [ ] (customizable) categories (to be used e.g. when searching)

## Prototype
![Prototype](prototype.jpg)

## Persistence
Data is stored in a local SQLite database using [Room](https://developer.android.com/training/data-storage/room/).
The database consists of a single table of `Place`s, with the following attributes:
- `name: String` (primary key)
- `address: String`
- `opening_times: Map<Weekday, String>` where `Weekday` is an enumeration type and the opening time is, for simplicity, represented as a string, for instance `"10:00-19:00"`
- `notes: String`

## Learning

### Things I'm consolidating
- Kotlin syntax
- [Data classes](https://kotlinlang.org/docs/data-classes.html) in Kotlin
- [Kotlin collections](https://kotlinlang.org/docs/collections-overview.html)
- [Room persistence library](https://developer.android.com/training/data-storage/room/)

## Things I'm learning from scratch
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Enumeration types](https://kotlinlang.org/docs/enum-classes.html) in Kotlin
