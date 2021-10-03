# Weather Forecast applies Clean Architecture

## Benefits of Clean Architecture

1. Separation of code in different layers with assigned responsibilities making it easier for further modification.

2. High level of abstraction.

3. Loose coupling between the code.

4. Testing of code is painless.

Clean Architecture guides us to write clean code that follows the SOLID programming principle. It helps us easier to maintain, scale, and test the application.

## This project contains 3 layers: Presentation, Domain, Data

![Application flow](https://miro.medium.com/max/875/1*a-AUcEVdyRJhIepo9JyJBw.png)


**Presentation layer**: Would include both domain and data layer and is android specific which executes the UI logic. The presentation layer provides the UI implementation of the application. It is the dumb layer which only performs instruction with no logic in it. This layer internally implements architecture like MVC, MVP, MVVM, MVI etc. This is the layer where everything connects.

**Domain layer**: Would execute business logic which is independent of any layer and is just a pure Kotlin package with no Android specific dependency. This will be the most generic layer of the three. It will connect the presentation layer with the data layer. This is the layer where app-related business logic will be executed.

**Data layer**: Would dispense the required data for the application to the domain layer by implementing interface exposed by the domain. This layer is responsible for providing the data required by the application. Data layer should be designed such data it can be re-used by any application without modification in their presentation logic.


## Folder structure, Libraries

### Presentation

- **Base** contains base classes such as BaseActivity, BaseViewModel, BaseAdapter,...

- **Common** contains common classes such as State, ViewModelFactory, Contants,...

- **DI** contains dependency injection classes that use Hilt library

- **Feature** contains all features of the application. It has views, models, viewmodels that call to usecases in Domain layer

- **Mapper** contains mapper classes that support to map objects between Domain and Presentation

### Domain

- **DI** contains dependency injection classes that use Hilt library

- **Entity** contains all of entities

- **Repository** contains interfaces that will be implemented in Data layer

- **UseCase** contains usecases that will be called by ViewModels in Presentation layer

### Data

- **API** contains api define classes that use Retrofit, Okhttp3

- **DB** contains database classes that use Room

- **DI** contains dependency injection classes that use Hilt library

- **Entity** contains all of entities

- **Mapper** contains mapper classes that support to map objects between Data layer and Domain layer

- **Repository** contains the implementations of interfaces in Domain layer


### Checklist

1. Programming language: Kotlin is required, Java is optional ⭐

2. Design app's architecture (suggest MVVM) ⭐

3. Apply LiveData mechanism ⭐

4. UI should be looks like in the attachment ⭐

5. Write UnitTests ⭐

6. Acceptance Tests

7. Exception handling ⭐

8. Caching handling ⭐

9. Secure Android app from:

    a. Decompile APK ⭐

    b. Rooted device ⭐

    c. Data transmission via network ⭐

    d. Encryption for sensitive information ⭐

10. Accessibility for Disability Supports:

    a. Talkback: Use a screen reader

    b. Scaling Text: Display size and font size: To change the size of items on your screen, adjust the display size or font size ⭐

11. Entity relationship diagram for the database and solution diagrams for the components, infrastructure design if any ⭐

12. Readme file includes:

    a. Brief explanation for the software development principles, patterns & practices being applied ⭐

    b. Brief explanation for the code folder structure and the key Java/Kotlin libraries and frameworks being used ⭐

    c. All the required steps in order to get the application run on local computer

    d. Checklist of items the candidate has done. ⭐


