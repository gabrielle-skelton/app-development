[Download Sample](https://drive.google.com/file/d/1xuu1bbjmEFRa6QSc03K89jQPv6JWVdow/view?usp=sharing)

## Set Up Your Project
Our project will use images, buttons, and text to display a profile page. 

Let's get started by setting up the resources for this project. 

1. **Create a New Project**.
    - `Activity`: Empty Activity
    - `Language`: Java

2. **Insert resources in *strings.xml***. 
    
    ``` xml
    <string name = "user_name">Cody Stream</string>
    <string name = "log_out">Log Out</string>
    <string name = "bannerContDesc">Profile Banner Image</string>
    <string name = "profileContDesc">Profile Picture</string>
    <string name = "settingContDesc">Settings Icon</string>
    ```
    
3. **Insert widgets in *activity_main.xml***.
    ++**Hint:**++ You can use the search bar at the top of the Attributes window to find a specific attribute.
        
    In the main layout, you will need the following widgets:
    - Delete the default **TextView** widget. 
    - Insert an **imageView** with the following attributes:
    
        You can select `backgrounds/scenic` as a temporary source. 
        - `id`: banner_image
        - `layout_constraintStart_toStartOf`: parent
        - `layout_constraintEnd_toEndOf`: parent
        - `layout_constraintTop_toTopOf`: parent`
        - `layout_height`: 200dp
        - `contentDescription`: @string/bannerContDesc

    - Insert an **imageView** with the following attributes:
    
        You can select `avatars` as a temporary source.
        - `id`: profile_picture
        - `layout_constraintStart_toStartOf`: parent
        - `layout_constraintEnd_toEndOf`: parent
        - `layout_constraintTop_toTopOf`: parent
        - `contentDescription`: @string/profileContDesc
        
        Use the **Constraint Widget** to set the top margin to `100dp`. 
        
    - Insert a **textView** with the following attributes:
        - `id`: user_name
        - `layout_constraintStart_toStartOf`: parent
        - `layout_constraintEnd_toEndOf`: parent
        - `layout_constraintTop_toBottomOf`: @id/profile_picture
        - `text`: @string/user_name
        - `textColor`: @color/white
        - `textSize`: 30sp
        - `textStyle`: bold
        
        Use the **Constraint Widget** to set the top margin to `20dp`.
        
    - Insert a **Button** with the following attributes:
        - `id`: logout_btn
        - `layout_constraintStart_toStartOf`: parent
        - `layout_constraintEnd_toEndOf`: parent
        - `layout_constraintBottom_toBottomOf`: parent
        - `text`: @string/log_out
        - `backgroundTint`: `@color/white`
        - `textColor`: `@android:color/black`.
        
        Use the **Constraint Widget** to set the bottom margin to `50dp`. 

4. Lastly, change the `background` of **ConstraintLayout** to `@android:color/holo_blue_dark`.
    
---

### Import a Drawable Resource
Take a moment to find and download an image from a free image site. This will be the profile picture for your application. 

For example, we'll use a free picture that was downloaded from [unsplash.com](https://https://unsplash.com/):

![](https://hackmd.io/_uploads/HJlcQnAW9.jpg =250x)

Now that you've found and downloaded an image, let's import it into our project. 

Each drawable resource **must** have a file name with *all* lowercase letters. For example, a file named `Myimage.png` cannot be imported because it contains a capital `M`. Before you begin attempting to import your image, make sure that it is named appropriately. 

Once you have a correct file name:
1. Open the **Resource Manager**. 
2. Click the plus sign `+` &rarr; `Import Drawables`.
3. Find your image &rarr; `Next`. 
4. Click `Import`. 

Now, you should see your image file inside of `res/drawable/`.

Let's access this resource inside of our imageView widget to display the picture on our application. 

1. Set the `srcCompat` attribute of **profile_picture** to: `@drawable/filename.png`. 
    ++**Note:**++ filename.png refers to the name of your downloaded image. 
2. Set the `layout_height` of **profile_picture** to `130dp`. 

---

## Create an Image Asset
For most applications, you will need to incorporate icons as visual cues for certain functions. Instead of importing each icon, you can simply create an **Image Asset** using a preset icon library. Let's walk through an example:

1. Insert an imageView widget. 
2. In the **Pick a Resource** window, select `+` &rarr; `Image Asset`.
3. Select `Clip Art` as the `Asset Type`. 
4. Choose the **settings** icon from the `Clip Art` box. 
5. Rename the asset `settings`. 
6. Change the icon's color to **white** or **#FFFFFF** with the color wheel beside `Color`.
7. Click `Next` &rarr; `Finish`.
8. Select `settings_foreground` &rarr; `Ok`. 
9. Finally, revise each attribute of the imageView to the following values:
    - `id`: settings_icon
    - `layout_width`: 50dp
    - `layout_height` : 50dp
    - `layout_constraintEnd_toEndOf`: parent
    - `layout_constraintTop_toTopOf`: @id/user_name
    - `contentDescription`: @string/settingContDesc

Now, we need to allow our project to use the icon. 
1. In **Project**, open the **Gradle Scripts** dropdown menu. 
2. Open the **build.gradle (app)** file. 
3. Insert the following line inside **android { }**:   
    `android.defaultConfig.vectorDrawables.useSupportLibrary = true`
4. You will see the following message pop up at the top of your window: 
    ![](https://hackmd.io/_uploads/B1mey_R-c.png)    
    Select `Sync Now`.

---

## Customize Your Profile Page
Now, you can customize the layout of your profile page. 

1. Import a drawable resource for **banner_image**.
2. Add an `imageView` widget to your profile page that uses an **image asset** as its source. 
3. Add an additional `textView` widget under your name to display more information about yourself.

++**Note**++: Make sure that all of your widgets are horizontally and vertically constrained.

You can use the following layout as a reference: 

![](https://hackmd.io/_uploads/r1QN16AZc.png =200x)

Great job! Now you can display images on your future applications. 
