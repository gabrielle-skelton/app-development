# Multiple Activities

[Download Sample](https://drive.google.com/file/d/1tZbFbv9sdQ_nRbTTQrXC3xvVFMz5xNbk/view?usp=sharing)

## Set Up Your Project
For this project, you will be creating an application that uses intents, listeners and multiple activities to navigate between 3 different screens.

Let's get started by setting up the project's resources. 

1. **Create a New Project**.
    - `Activity`: Empty Activity
    - `Language`: Java

2. **Insert resources.** 
   - In **strings.xml**, define text for the previous/next buttons and each page. 
    
    ``` xml
    <string name="previous">Previous</string>
    <string name="next">Next</string>
    <string name="pageOne">Page 1</string>
    <string name="pageTwo">Page 2</string>
    <string name="pageThree">Page 3</string>
    ```
  - In **colors.xml**, define a grey to dim unclickable buttons. 
    ``` xml
    <color name = "grey">#808080</color>
    ```
    
4. **Insert widgets**.
    In our main layout, we will need to insert the following widgets: 
        
    - Insert a **textView** with the following attributes:
        - `id`: pageOne
        - `layout_constraintStart_toStartOf`: parent (0dp)
        - `layout_constraintEnd_toEndOf`: parent (0dp)
        - `layout_constraintTop_toTopOf`: parent (50dp)
        - `text`: @string/pageOne
        - `textSize`: 30sp
        
    - Insert a **Button** with the following attributes:
        - `id`: nextButtonOne.
        - `layout_constraintStart_toStartOf`: parent (50dp)
        - `layout_constraintBottom_toBottomOf`: parent (50dp)
        - `text`: @string/next
    
    - Insert a **Button** with the following attributes:
        - `id`: previousButtonOne
        - `layout_constraintEnd_toEndOf`: parent (50dp)
        - `layout_constraintBottom_toBottomOf`: parent (50dp)
        - `text`: @string/previous
        - `backgroundTint`: @color/grey

## Insert New Activities
This project will use **MainActivity** for the first page of the application. You'll need to add new activities for each additional page.

1. At the top of Android Studio, select `File` &rarr; `New` &rarr; `Activity` &rarr; `EmptyActivity`. You can name this activity: **PageTwo**.
2. Open **activity_main.xml**. At the top right, above the **Attributes** window, select `Code`. 
3. Copy all of the code from **activity_main.xml**. 
4. Open **activity_page_two.xml**. At the top right, above the **Attributes** window, select `Code`.
5. Paste the code that you copied from **activity_main.xml**.
6. In the `Code` window, change `tools:context` to `.PageTwo`.
7. Now, you change the `id` and `text` attribute values accordingly. 
8. Remove the `backgroundTint` from **previousButtonTwo**.
9. Repeat **Steps 1 through 7** for **Page Three**. 
10. In **activity_page_three.xml**, set the `backgroundTint` of **nextButtonThree** to `@color/grey` and remove the `backgroundTint` from **previousButtonThree**.

## Final Touches

Now that the page layouts are completed, you can begin working on the Java. At this point, it can be helpful to close the **.xml** tabs for easier navigation between the Java files. 

We'll work in the **MainActivity.java** file first. 

1. You will need 2 imports to get started: 

``` java
import android.widget.Button;
import android.content.Intent;
```

2. Now, inside the `onCreate()` method, define a variable for the next button. 

``` java
Button nextButton = findViewById(R.id.nextButtonOne);
```

3. Create a listener for the button to open **Page Two** when clicked.

``` java
nextButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, PageTwo.class);
        startActivity(intent);
    });
```

Before continuing, pause here to check your program by running the emulator. At this point, when you select **Next**, your application should open **Page Two**. 

Now, we can begin working in **PageTwo.java**. 

1. First, add the following 2 imports: 

``` java
import android.widget.Button;
import android.content.Intent;
import android.view.View;
```

2. Inside the `onCreate()` method, define a variable for each button. 

``` java
Button previousButton = findViewById(R.id.previousButtonTwo);
Button nextButton = findViewById(R.id.nextButtonTwo);
```
 
3. Create a listener for the previous button and add an intent that will open the **MainActivity** or **Page One**.

``` java
previousButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(PageTwo.this, MainActivity.class);
        startActivity(intent);
    }
});
```

4. Create a listener for the next button and add an intent that will open **Page Three**. 

``` java
nextButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(PageTwo.this, PageThree.class);
        startActivity(intent);
    }
});
```

Finally, we can add some code to **PageThree.java**.
1. First, add the following 2 imports: 

``` java
import android.widget.Button;
import android.content.Intent;
import android.view.View;
```

2. Inside the `onCreate()` method, define a variable for each button. 

``` java
Button previousButton = findViewById(R.id.previousButtonThree);
```
 
3. Create a listener for the previous button and add an intent that will open the **Page Two**.

``` java
previousButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(PageThree.this, PageTwo.class);
        startActivity(intent);
    }
});
```

Great work, you've completed the application! Run the Emulator to ensure that everything is working properly. You should be able to navigate through all 3 pages that we created. 
