package com.example.appdev2assignment3
import java.util.Date

// This is a data class named 'Task' that represents a task in the application.
data class Task(
    var name: String,   // This is a property that holds the name of the task.
    var dueDate: Date,  // This is a property that holds the due date of the task.
    var imageLink: String = DEFAULT_IMAGE_LINK, // This is the property that holds the url of the task image.
    var isCompleted: Boolean = false  // This is a property that indicates whether the task is completed or not.
) {

    companion object {
        const val DEFAULT_IMAGE_LINK = "https://cdn.pixabay.com/photo/2012/04/10/23/44/question-27106_1280.png"
    }

    // This is a function named 'toggleCompleted' that toggles the 'isCompleted' property.
    // If 'isCompleted' is true, it will be set to false, and vice versa.
    fun toggleCompleted() {
        isCompleted = !isCompleted
    }
}