## Try This: Set Up Your Project
Let's get started by setting up a project for today's lesson.

Our project will allow the user to swipe between different tabs. Each tab will contain information about your favorite animal. 
1. **Create a new project.**
   For this lesson, your project will need the following settings: 
    - `Activity`: Empty Activity
    - `Name`: Lesson6TabLayout
    - `Save location`: ./Desktop/Unit1Projects/Lesson6TabLayout
    - `Language`: Java 
2. **Insert resources.**
    Before we get started, your project will need the following resources:

    
    `drawables`:
    Import a drawable of your favorite animal. Remember, the file name of your image needs to be all *lowercase*. For this example, we'll use an elephant. 
    
    ![elephant](https://user-images.githubusercontent.com/103130916/162013899-3aefa8d4-1281-4823-9d2f-ff936fbcba60.jpeg)
    
    `strings.xml:` We'll need a title for each of our tabs, general information about your favorite animal, and a list of facts about your favorite animal. 
    ``` xml
    <string name="app_name">Elephant 101</string>

    <!-- TAB TITLES -->
    <string name="general">General</string>
    <string name="fun_facts">Fun Facts</string>
    <string name="gallery">Gallery</string>

    <!-- FRAGMENT CONTENT -->
    <string name = "generalInfo">
        Elephants are the largest land mammals on earth and have distinctly massive bodies, large ears, and long trunks.
    </string>

    <string name = "factList">
        1. Elephants are the world\'s largest land animal. \n
        2. They have around 150,000 muscles in their trunk. \n
        3. Elephant tusks are enlarged incisor teeth. \n
        4. Elephant calves are able to stand within 20 minutes of birth. \n
        5. Wild elephants can live for up to 60-70 years.
    </string>
    ```
    
    `colors.xml`
    Without deleting the default colors, choose a tab color and a background color for your project. For this example, we'll choose a forest green color for our tabs and a light brown color for our background:
    ``` xml
    <color name = "tabColor">#228B22</color>
    <color name = "backgroundColor">#C4A484</color>
    ```
    
    `themes.xml`
    To change the title tab of your application, open the **themes.xml** file. 
    
    Then, you can replace:
    ``` xml
    <item name="colorPrimary">@color/purple_500</item>
    ```
    with: 
    ``` xml
    <item name="colorPrimary">@color/tabColor</item>
    ```
3. Download [CustomAdapter.java](https://drive.google.com/file/d/1SWeWj3ochg7Yt4kQVSQYXPgkgLXgeA0a/view?usp=sharing). 
    Then, insert it into the `./java` folder of your project. 
    **Note:** Don't change any of the code in this file!

---

### Try This: Insert a Tab Layout
Let's try adding a **Tab Layout** widget to our **activity_main** layout. 
1. Add the **Tab Layout** widget from the *Container* category in your Palette window with the following attributes:
    -  `id`: tabLayout
    -  `tabIndicatorColor`: @color/tabColor
    -  `tabTextColor`: @color/tabColor
    -  `layout_constraintStart_toStartOf`: parent
    -  `layout_constraintEnd_toEndOf`: parent
    -  `layout_constraintTop_toTopOf`: parent
2. You'll notice that your tab layout will automatically contain 3 tab items. All we need to do here is revise the attributes for each item: 
    
    `tabItem`
    - `id`: general
    - `text`: @string/general 
    
    `tabItem`
    - `id`: fun_facts
    - `text`: @string/fun_facts
    
    `tabItem`
    - `id`: gallery
    - `text`: @string/gallery
    
---

### Try This: Insert 3 Fragments
We have 3 tabs on our layout. Therefore, we will need 3 fragments. 
1. Select `File` &rarr; `New` &rarr; `Fragment` &rarr; `Fragment (Blank)`. 
2. The `Fragment Name` will be **GeneralFragment**.
3. You can delete everything in **GeneralFragment.java**, except for the `onCreateView()` method:
    ``` java
    package com.example.lesson6tablayout;
    import ...;
    public class GeneralFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_general, container, false);
        }
    }
    ```
4. Repeat **Steps 1-3** for 2 more fragments. They will be named **GalleryFragment** and **FactsFragment**. 

---

### Try This: Insert a View Pager
Add a **ViewPager2** widget to **activity_main.xml**. 
Make sure that the widget goes *outside* of the tab layout.
 
It will need the following attributes: 
* `id`: viewPager
* `background`: @color/backgroundColor
* `layout_constraintStart_toStartOf`: parent
* `layout_constraintEnd_toEndOf`: parent
* `layout_constraintTop_toTopOf`: parent
* `layout_constraintBottom_toBottomOf`: parent

---

## Project: My Favorite Animal
Now that we have all of the resources that we need, let's put it all together!

First, we'll need to add some widgets to the layouts for each of our fragments. 
1. In **fragment_general.xml**,
    insert a TextView widget with the following attributes:
    * `text`: @string/generalInfo
    * `textSize`: 18sp
    * `textAlignment`: center
    * `gravity`: center
    
2. In **fragment_gallery.xml**,
    insert an ImageView widget with the following attributes:
    * `layout_gravity`: center
    * `srcCompat`: drawable/favoriteanimal
    
    **Note:** *favoriteanimal* refers to the file name of the drawable that you imported of your favorite animal. 
    
3. In **fragment_facts.xml**,
    insert a TextView widget with the following attributes:
    * `text`: @string/factList
    * `textSize`: 18sp

---

Next, let's connect our view pager to our tab layout. We'll be working in **MainActivity.java**:
1. **Add Imports.**
    ``` java
    import com.google.android.material.tabs.TabLayout;
    import androidx.viewpager2.widget.ViewPager2;
    import androidx.fragment.app.FragmentManager;
    ```
2. ***Outside* onCreate(), define the variables.**
    ``` java
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    ```
3. ***Inside* onCreate(), assign the variables.**
    ``` java
    tabLayout = findViewById(R.id.tabLayout);
    viewPager = findViewById(R.id.viewPager);
    ```
5. **Define a fragment manager.**
    ``` java
    FragmentManager fm = getSupportFragmentManager();
    ```
4. **Create an object of the CustomAdapter class.**
    ``` java
    CustomAdapter customAdapter = new CustomAdapter(fm, getLifecycle());
    ```
6. **Set the view pager's adapter.**
    ``` java
    viewPager.setAdapter(customAdapter);
    ```
---

Lastly, we'll need to set a listener for the tabs in our layout. 
1. **Add a tab listener to your tab layout.**
    ``` java
    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });
    ```

Great job, you've completed the application!

