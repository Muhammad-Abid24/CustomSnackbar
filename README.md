# CustomSnackbar

A lightweight Android utility library for creating highly customizable Material Design Snackbars with ease.

## Features

- Simple, static API for quick Snackbar integration
- Customizable text size, colors, and background
- Support for action buttons with click listeners
- Support for Intent-based navigation via action buttons
- Flexible duration options (SHORT, LONG, INDEFINITE, or custom milliseconds)
- Support for both color values and resource IDs
- Multi-line message support
- Custom action button styling with background colors

## Installation

Copy the `CustomSnackbar.java` file to your project:

```
app/src/main/java/com/Custom/Snackbar/CustomSnackbar.java
```

## Dependencies

Add the Material Design dependency to your `app/build.gradle`:

```gradle
implementation 'com.google.android.material:material:<version>'
```

## Basic Usage

### 1. Simple Snackbar (Default Styling)

```java
// Show snackbar with default green background
CustomSnackbar.showSnackbar(this, "Hello, World!");
```

### 2. Snackbar with Custom Duration

```java
// Using predefined constants
CustomSnackbar.showSnackbarWithDuration(this, "Loading...", Snackbar.LENGTH_LONG);

// Using custom duration (milliseconds)
CustomSnackbar.showSnackbarWithDuration(this, "Processing...", 5000);
```

### 3. Snackbar with Custom Text Size

```java
CustomSnackbar.showSnackbarWithTextSize(this, "Large text!", 20);
```

### 4. Snackbar with Custom Text Size and Color

```java
CustomSnackbar.showSnackbarWithTextSize(
    this,
    "Custom colors!",
    18,
    Color.WHITE  // Text color
);
```

### 5. Full Customization with Color Values

```java
CustomSnackbar.showSnackbarWithColor(
    this,
    "Fully customized!",
    16,                    // Text size
    Color.WHITE,           // Text color
    0xFF2196F3,            // Background color (blue)
    Snackbar.LENGTH_LONG   // Duration
);
```

### 6. Full Customization with Resource IDs

```java
CustomSnackbar.showSnackbarWithResources(
    this,
    "Using resources!",
    16,                    // Text size
    R.color.text_primary,  // Text color resource
    R.color.bg_accent,     // Background color resource
    Snackbar.LENGTH_SHORT  // Duration
);
```

## Action Button Examples

### 1. Simple Action Button (Default Styling)

```java
CustomSnackbar.showSnackbarWithAction(
    this,
    "Undo deleted item",
    "UNDO",
    new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Handle undo action
            restoreItem();
        }
    }
);
```

### 2. Action Button with Custom Colors

```java
CustomSnackbar.showSnackbarWithAction(
    this,
    "Connection failed",
    16,                    // Text size
    Color.WHITE,           // Text color
    0xFFF44336,            // Background color (red)
    0xFFFFFFFF,            // Action text color (white)
    "RETRY",
    new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Handle retry
            retryConnection();
        }
    },
    Snackbar.LENGTH_INDEFINITE
);
```

### 3. Action Button with Background Color

```java
CustomSnackbar.showSnackbarWithAction(
    this,
    "Message saved",
    16,
    Color.WHITE,
    0xFF4CAF50,            // Snackbar background (green)
    0xFFFFFFFF,            // Action text color
    0xFF2196F3,            // Action button background (blue)
    "VIEW",
    new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Handle view action
            openMessage();
        }
    },
    Snackbar.LENGTH_LONG
);
```

### 4. Action Button with Intent Navigation

```java
// Navigate to another activity when action is clicked
CustomSnackbar.showSnackbarWithAction(
    this,
    "Download complete!",
    "OPEN",
    DownloadActivity.class
);
```

### 5. Action Button with Full Customization and Intent

```java
CustomSnackbar.showSnackbarWithAction(
    this,
    "Profile updated!",
    16,                    // Text size
    Color.WHITE,           // Text color
    0xFF9C27B0,            // Background color (purple)
    0xFFFFFFFF,            // Action text color
    "VIEW PROFILE",
    ProfileActivity.class,
    Snackbar.LENGTH_LONG
);
```

### 6. Using Resources for Action Button

```java
CustomSnackbar.showSnackbarWithActionResources(
    this,
    "Settings saved!",
    16,
    R.color.text_primary,
    R.color.bg_success,
    R.color.action_text,
    "OK",
    new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Dismiss or handle
        }
    },
    Snackbar.LENGTH_SHORT
);
```

## Default Values

| Property | Default Value |
|----------|---------------|
| Text Size | 17sp |
| Text Color | Black (`0xFF000000`) |
| Background Color | Green (`0xFF4CAF50`) |
| Duration | `Snackbar.LENGTH_SHORT` |

## Method Reference

### Basic Snackbar Methods

| Method | Description |
|--------|-------------|
| `showSnackbar()` | Show with default styling |
| `showSnackbarWithDuration()` | Show with custom duration |
| `showSnackbarWithTextSize()` | Show with custom text size |
| `showSnackbarWithColor()` | Show with color values |
| `showSnackbarWithResources()` | Show with resource IDs |

### Action Button Methods

| Method | Description |
|--------|-------------|
| `showSnackbarWithAction()` | With OnClickListener |
| `showSnackbarWithAction()` | With Intent navigation |
| `showSnackbarWithActionResources()` | With resource IDs |

## Duration Options

- `Snackbar.LENGTH_SHORT` - ~2 seconds
- `Snackbar.LENGTH_LONG` - ~3.5 seconds
- `Snackbar.LENGTH_INDEFINITE` - Until dismissed or action clicked
- Custom duration in milliseconds (e.g., `5000` for 5 seconds)

## Color Formats

```java
// Using Color class constants
Color.BLACK
Color.WHITE
Color.RED

// Using ARGB hex values
0xFF000000  // Black (Opaque)
0xFF4CAF50  // Green (Opaque)
0x80FF0000  // Red (50% transparent)

// Using resource IDs
R.color.primary
R.color.background
R.color.text_secondary
```

## Complete Example Activity

```java
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.Custom.Snackbar.CustomSnackbar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSimple).setOnClickListener(v -> {
            CustomSnackbar.showSnackbar(this, "Simple Snackbar!");
        });

        findViewById(R.id.btnError).setOnClickListener(v -> {
            CustomSnackbar.showSnackbarWithColor(
                this,
                "Error occurred!",
                16,
                Color.WHITE,
                0xFFF44336,
                Snackbar.LENGTH_LONG
            );
        });

        findViewById(R.id.btnAction).setOnClickListener(v -> {
            CustomSnackbar.showSnackbarWithAction(
                this,
                "Item deleted",
                "UNDO",
                0xFF2196F3,
                view -> {
                    // Undo action
                    CustomSnackbar.showSnackbar(this, "Item restored!");
                }
            );
        });

        findViewById(R.id.btnNavigation).setOnClickListener(v -> {
            CustomSnackbar.showSnackbarWithAction(
                this,
                "New message received!",
                "READ",
                MessagesActivity.class
            );
        });
    }
}
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

```
MIT License

Copyright (c) 2026 Muhammad Abid

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Author

**Muhammad Abid Misbahuddin**
